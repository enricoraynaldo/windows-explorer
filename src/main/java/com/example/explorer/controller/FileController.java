package com.example.explorer.controller;

import com.example.explorer.domain.File;
import com.example.explorer.service.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/folder/{folderId}")
    public List<File> getFilesByFolder(@PathVariable Long folderId) {
        return fileService.getFilesByFolder(folderId);
    }
}
