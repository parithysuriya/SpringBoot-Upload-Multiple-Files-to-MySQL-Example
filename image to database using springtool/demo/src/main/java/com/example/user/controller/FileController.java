package com.example.user.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;								
import org.springframework.stereotype.Controller;																																																																																				
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.user.modal.FileModal;
import com.example.user.service.FileServiceImplementation;

@Controller
public class FileController {
	@Autowired
    FileServiceImplementation fileServiceImplementation;
 
    // @GetMapping annotation for
    // mapping HTTP GET requests onto
    // specific handler methods. */
    @GetMapping("/")
    public String getData() {
        return "File";
    }
   
    // @PostMapping annotation maps HTTP POST
    // requests onto specific handler methods
    @PostMapping("/")
    public String uploadMultipartFile(@RequestParam("files") MultipartFile[] files, Model modal) {
    try {
        // Declare empty list for collect the files data
        // which will come from UI
        List<FileModal> fileList = new ArrayList<FileModal>();
        for (MultipartFile file : files) {
            String fileContentType = file.getContentType();
            byte[] sourceFileContent = file.getBytes();
            String fileName = file.getOriginalFilename();
            FileModal fileModal = new FileModal(fileName, sourceFileContent, fileContentType);
             
            // Adding file into fileList
            fileList.add(fileModal);
            }
       
            // Saving all the list item into database
            fileServiceImplementation.saveAllFilesList(fileList);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        // Send file list to View using modal class   
        // fileServiceImplementation.getAllFiles() used to
        // fetch all file list from DB
        modal.addAttribute("allFiles", fileServiceImplementation.getAllFiles());
       
        return "FileList";
    }
}
