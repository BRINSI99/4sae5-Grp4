package tn.esprit.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploader {
	
		public static final String uploadingDir = System.getProperty("user.dir") + "/uploadingDir/";

		@RequestMapping("/")
		public String uploading(Model model)
		{
			File file = new File(uploadingDir);
			model.addAttribute("files", file.listFiles());
			return "uploading";
		}

		@RequestMapping(value = "/", method = RequestMethod.POST)
		public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles)
				throws IOException
		{
			for (MultipartFile uploadedFile : uploadingFiles)
			{
				File file = new File(uploadingDir + uploadedFile.getOriginalFilename());
				uploadedFile.transferTo(file);
			}

			return "redirect:/";
		}

}
