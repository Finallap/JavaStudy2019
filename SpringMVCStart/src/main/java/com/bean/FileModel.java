package com.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * @description: FileModel
 * @date: 2020/4/27 17:33
 * @author: Finallap
 * @version: 1.0
 */
public class FileModel {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
