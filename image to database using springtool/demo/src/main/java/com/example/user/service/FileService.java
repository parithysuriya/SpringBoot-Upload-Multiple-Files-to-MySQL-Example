package com.example.user.service;

import java.util.List;
import com.example.user.modal.FileModal;

public interface FileService {
	List<FileModal> getAllFiles();
    void saveAllFilesList(List<FileModal> fileList);
}
