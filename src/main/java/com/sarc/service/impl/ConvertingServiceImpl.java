package com.sarc.service.impl;

import com.sarc.service.ConvertingService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Service
public class ConvertingServiceImpl implements ConvertingService {

    @Override
    public Blob convertFileContentToBlob(String filePath) throws IOException {
        byte[] fileContent;
        Blob blobImage = null;
        try {
            fileContent = FileUtils.readFileToByteArray(new File(filePath));
            blobImage = new SerialBlob(fileContent);
        } catch (IOException e) {
            throw new IOException("Unable to convert file to byte array. " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blobImage;
    }
}
