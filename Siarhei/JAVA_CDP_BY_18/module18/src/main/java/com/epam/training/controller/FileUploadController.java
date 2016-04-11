package com.epam.training.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/fileFunctional")
@Controller
public class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        if (!file.isEmpty()) {

            try {

                byte[] fileBytes = file.getBytes();
                String rootPath = System.getProperty("catalina.home");
                logger.info("Server rootPath: " + rootPath);
                logger.info("Server rootPath: " + file.getOriginalFilename());
                logger.info("Server rootPath: " + file.getContentType());

                File newFile = new File(rootPath + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
                stream.write(fileBytes);
                stream.close();

                logger.info("File is saved under: " + rootPath + File.separator + file.getOriginalFilename());
                request.setAttribute("success", "file upload success");
                return new ModelAndView("uploadingForm");

            } catch (Exception e) {
                logger.error("Problem with uploading file", e);
                request.setAttribute("error", e.getMessage());
                return new ModelAndView("uploadingForm");
            }
        } else {
            logger.error("file empty");
            request.setAttribute("error", "fileEmpty");
            return new ModelAndView("uploadingForm");
        }
    }

    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    public void downloadFile(String fileName, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String rootPath = System.getProperty("catalina.home");
        ServletContext context = request.getServletContext();
        String fullPath = rootPath + File.separator + fileName;
        logger.info("FullPath:" + fullPath);

        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        logger.info("MIME type: " + mimeType);

        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[100000];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();

    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getUploadingForm() {
        return "uploadingForm";
    }
}