package tn.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.spring.entities.DatabaseFile;
import tn.spring.services.DatabaseFileService;

 

@RestController
public class FileUploadController {

    @Autowired
    private DatabaseFileService fileStorageService;

    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file)  {
    	DatabaseFile fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName.getFileName())
                .toUriString();
		return null;
  

 
    }

   // @PostMapping("/uploadMultipleFiles")
    //public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
      //   return Arrays.asList(files)
        //        .stream()
          //      .map(file -> uploadFile(file))
            //    .collect(Collectors.toList());
    //}
    
}
