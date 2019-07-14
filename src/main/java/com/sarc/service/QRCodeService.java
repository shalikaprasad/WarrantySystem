package com.sarc.service;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRCodeService {
    void generateQRCode(String qrCodeData) throws IOException, WriterException;
    void readerQRCodePath(String filePath) throws IOException, NotFoundException;
    String getSerialNumber();
}

