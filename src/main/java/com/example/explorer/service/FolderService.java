package com.example.explorer.service;

import com.example.explorer.domain.File;
import com.example.explorer.domain.Folder;
import com.example.explorer.repository.FileRepository;
import com.example.explorer.repository.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {

    private final FolderRepository folderRepository;
    private final FileRepository fileRepository; // Make sure this exists

    public FolderService(FolderRepository folderRepository, FileRepository fileRepository) {
        this.folderRepository = folderRepository;
        this.fileRepository = fileRepository;
    }

    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    public Folder getFolderWithDetails(Long id) {
        return folderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Folder not found"));
    }

    // ✅ NEW: Fetch files for a folder
    public List<File> getFilesByFolder(Long folderId) {
        return fileRepository.findByFolderId(folderId);
    }
}
