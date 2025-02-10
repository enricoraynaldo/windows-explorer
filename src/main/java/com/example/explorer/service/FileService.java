package com.example.explorer.service;

import com.example.explorer.domain.File;
import com.example.explorer.repository.FileRepository;
import com.example.explorer.repository.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;
    private final FolderRepository folderRepository;

    public FileService(FileRepository fileRepository, FolderRepository folderRepository) {
        this.fileRepository = fileRepository;
        this.folderRepository = folderRepository;
    }

    public List<File> getFilesByFolder(Long folderId) {
        return fileRepository.findByFolderId(folderId);
    }
}
