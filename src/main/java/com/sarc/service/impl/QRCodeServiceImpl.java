package com.sarc.service.impl;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sarc.service.QRCodeService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class QRCodeServiceImpl implements QRCodeService {

    private String serialNumber;

    public void generateQRCode(String qrCodeData) throws IOException, WriterException {

        String filePath = "C:\\WarrantySystem\\QRCodes\\" + qrCodeData + ".png";
        String charset = "UTF-8"; // or "ISO-8859-1"
        Map hintMap = new HashMap();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
        openQRCode(filePath);

        System.out.println("QR Code image created successfully!");

    }

    private void createQRCode(String qrCodeData, String filePath, String charset, Map hintMap, int qrCodeheight, int qrCodewidth)
            throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
    }

    public void readerQRCodePath(String filePath) throws IOException, NotFoundException {

        String charset = "UTF-8"; // or "ISO-8859-1"
        Map hintMap = new HashMap();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);


        this.serialNumber = readQRCode(filePath, charset, hintMap);
        System.out.println("Data read from QR Code: " + this.serialNumber );

    }

    public String getSerialNumber(){
        return this.serialNumber;
    }


    private String readQRCode(String filePath, String charset, Map hintMap) throws IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                        ImageIO.read(new FileInputStream(filePath)))));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap,
                hintMap);
        return qrCodeResult.getText();
    }

    private void openQRCode(String filePath){
        try
        {
            ImageIO.read(new File(filePath));
        }
        catch (IOException e)
        {
            //String workingDir = System.getProperty("user.dir");
            //System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }
    }

}
