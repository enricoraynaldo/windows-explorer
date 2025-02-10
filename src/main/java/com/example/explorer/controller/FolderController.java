package com.example.explorer.controller;

import com.example.explorer.domain.File;
import com.example.explorer.domain.Folder;
import com.example.explorer.service.FileService;
import com.example.explorer.service.FolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/folders")
public class FolderController {

    private final FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @GetMapping
    public List<Folder> getAllFolders() {
        return folderService.getAllFolders();
    }

    @GetMapping("/{id}")
    public Folder getFolderWithDetails(@PathVariable Long id) {
        return folderService.getFolderWithDetails(id);
    }

    @GetMapping("/{id}/files")
    public List<File> getFilesByFolder(@PathVariable Long id) {
        return folderService.getFilesByFolder(id);
    }
}
