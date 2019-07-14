package com.sarc.service;

import java.io.IOException;
import java.sql.Blob;

public interface ConvertingService {
    Blob convertFileContentToBlob(String filePath) throws IOException;
}
