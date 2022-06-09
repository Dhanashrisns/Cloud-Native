package com.cloudnative.OTT.controller;

import com.cloudnative.OTT.domain.UploadFileResponse;
import com.cloudnative.OTT.jpa.entity.MovieDetails;
import com.cloudnative.OTT.jpa.repository.MovieDetailRepository;
import com.cloudnative.OTT.service.DBFileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileController {
  @Autowired
  private DBFileStorageService dbFileStorageService;

  @PostMapping("/uploadFile")
  public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
    MovieDetails dbFile = dbFileStorageService.storeFile(file);

    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/downloadFile/")
        .path(dbFile.getId().toString())
        .toUriString();

    return new UploadFileResponse(fileDownloadUri);
  }

}
