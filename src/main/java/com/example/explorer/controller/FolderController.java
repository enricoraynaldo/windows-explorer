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
@RequestMapping("/api/v1/folders")
public class FolderController {

    private final FolderService folderService;
    private final FileService fileService;

    public FolderController(FolderService folderService, FileService fileService) {
        this.folderService = folderService;
        this.fileService = fileService;
    }

    @GetMapping
    public ResponseEntity<List<Folder>> getRootFolders() {
        return ResponseEntity.ok(folderService.getRootFolders());
    }

    @GetMapping("/{id}/subfolders")
    public ResponseEntity<List<Folder>> getSubfolders(@PathVariable Long id) {
        return ResponseEntity.ok(folderService.getSubfolders(id));
    }

    @GetMapping("/{id}/files")
    public ResponseEntity<List<File>> getFiles(@PathVariable Long id) {
        return ResponseEntity.ok(fileService.getFilesInFolder(id));
    }
}
