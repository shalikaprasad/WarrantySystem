package com.sarc.service;

import com.google.api.services.drive.model.File;

import java.io.IOException;
import java.util.List;

public interface GoogleDriveService {

    File createGoogleFile(String googleFolderIdParent, String contentType, String customFileName, java.io.File uploadFile) throws IOException;
    File createGoogleFolder(String folderIdParent, String folderName) throws IOException;
    List<File> getGoogleRootFoldersByName(String subFolderName) throws IOException;

}
