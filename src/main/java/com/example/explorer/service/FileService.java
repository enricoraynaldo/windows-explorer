package com.example.explorer.service;

import com.example.explorer.domain.File;
import com.example.explorer.repository.FileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> getFilesInFolder(Long folderId) {
        return fileRepository.findByFolderId(folderId);
    }
}
