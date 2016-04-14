package jmp.spring.core.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jmp.spring.exception.FileException;

@Service
public class FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    private static final String EXTERNAL_FOLDER = "d:/temp/files";

    public void uploadFile(MultipartFile file) {
        logger.info("Server rootPath: " + EXTERNAL_FOLDER);

        try {
            File newFile = new File(
                    EXTERNAL_FOLDER + File.separator + file.getOriginalFilename().replaceAll("\\.", "_"));
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
            stream.write(file.getBytes());
            stream.close();
        } catch (IOException e) {
            throw new FileException("File download error");
        }

        logger.info("File is saved under: " + EXTERNAL_FOLDER + File.separator + file.getOriginalFilename());
    }

    public List<String> getFiles() {
        try {
            return Files.walk(Paths.get(EXTERNAL_FOLDER)).filter(Files::isRegularFile).map(Path::toFile)
                    .map(File::getName).collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
    }

    public File getFileFor(String fileName) {
        return new File(EXTERNAL_FOLDER + File.separator + fileName);
    }

    public boolean checkExtention(String fileName, String ext) {
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        return ext.equalsIgnoreCase(extension);
    }
}
