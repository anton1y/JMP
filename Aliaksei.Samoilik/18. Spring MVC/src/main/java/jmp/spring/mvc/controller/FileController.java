package jmp.spring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jmp.spring.core.services.FileService;

@RequestMapping(value = "/files")
@Controller
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file, ModelMap model) {

        if (!file.isEmpty() && fileService.checkExtention(file.getOriginalFilename(), "pdf")) {
            fileService.uploadFile(file);
            logger.info("File is saved under: " + file.getOriginalFilename());
            model.addAttribute("message", "file upload success");

        } else {
            logger.error("file is empty or not PDF");
            model.addAttribute("message", "file is empty or not PDF");
        }

        model.addAttribute("files", fileService.getFiles());
        return "files";
    }

    @RequestMapping(value = "/download/{file_name}", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource getFile(@PathVariable("file_name") String fileName) {
        return new FileSystemResource(fileService.getFileFor(fileName));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUploadingForm(ModelMap model) {
        model.addAttribute("files", fileService.getFiles());
        return "files";
    }
}