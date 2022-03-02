package tn.esprit.spring.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.Repository.ImageRepository;
import tn.esprit.spring.entity.Image;


@RequestMapping("/check")
public class ImageController {
	
	@Autowired
   ImageRepository imageRepository;

	//http://localhost:8089/SpringMVC/check/upload
    @PostMapping("/upload")
    public Image uplaodImage(@RequestParam("myFile") MultipartFile file) throws IOException {

        Image img = new Image(file.getOriginalFilename(),file.getContentType(),file.getBytes() );


        final Image savedImage = imageRepository.save(img);


        System.out.println("Image saved");


        return savedImage;


    }

}
