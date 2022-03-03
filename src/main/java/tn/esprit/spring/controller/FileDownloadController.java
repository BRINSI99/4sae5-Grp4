package tn.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.spring.entities.DatabaseFile;
import tn.spring.repository.CorbeilleRepository;
import tn.spring.services.DatabaseFileService;

 

@RestController
public class FileDownloadController {

    @Autowired
    private DatabaseFileService fileStorageService;
    @Autowired
    private CorbeilleRepository CorbeilleRepo;
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        DatabaseFile databaseFile = fileStorageService.getFile(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
                .body(new ByteArrayResource(databaseFile.getData()));
    }
    @DeleteMapping("/delete/{idClaim}")
	@ResponseBody
	public void removeClaim(@PathVariable("idClaim") String id,@PathVariable MultipartFile file) throws IOException {
    	fileStorageService.corbeilleFile(file, id);
	}
    /* ajout par id corbeille */
    @GetMapping("/AjouterToFile/{idClaim}")
  	@ResponseBody
  	public void recupClaim(@PathVariable("idClaim") String id,@PathVariable MultipartFile file) throws IOException {
      	fileStorageService.corbeilleToFile(file, id);
  	}
}
