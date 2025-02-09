package com.example.explorer.service;

import com.example.explorer.domain.Folder;
import com.example.explorer.repository.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {

    private final FolderRepository folderRepository;

    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public List<Folder> getRootFolders() {
        return folderRepository.findByParentId(null);
    }

    public List<Folder> getSubfolders(Long folderId) {
        return folderRepository.findByParentId(folderId);
    }
}
