package com.atguigu.springmvc.handlers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadHandler {

	@RequestMapping("/testUpload")
	public String testUpload(@RequestParam String desc, MultipartFile file) throws IOException{
		
		System.out.println("desc="+desc);
		
		System.out.println("InputStream="+file.getInputStream());
		System.out.println("OriginalFilename="+file.getOriginalFilename());
		System.out.println("Size="+file.getSize());
		
		System.out.println("ContentType="+file.getContentType());
		
		return "success";
	}
	
}
