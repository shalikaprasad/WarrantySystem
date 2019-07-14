package com.sarc.service.impl;

import com.sarc.bean.SingerItems;
import com.sarc.service.SingerItemService;
import com.sarc.service.UpdatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.*;

@Service
public class UpdatingServiceImpl implements UpdatingService {

    private String serialNumber;
    private SingerItems singerItems;
    private byte[] pdfData;
    private byte[] pngData;

    @Autowired
    private SingerItemService singerItemService;

    public void setInvoice(String serial, SingerItems singerItems) throws IOException
    {
        this.serialNumber = serial;
        this.singerItems = singerItems;

        setPdfData();
        setPngData();

        singerItems.setInvoice_pdf(getPdfData());
        singerItems.setInvoice_image(getPngData());

        singerItemService.save(singerItems);

    }


    private void setPdfData() throws IOException {
        File pdfFile = new File("C:\\WarrantySystem\\Invoice_PDF\\" + this.serialNumber + ".pdf");
        byte[] pdfData = new byte[(int) pdfFile.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(pdfFile));
        dis.readFully(pdfData);  // read from file into byte[] array
        dis.close();

        this.pdfData = pdfData;
    }

    private void setPngData() throws FileNotFoundException {
        File pngFile = new File("C:\\WarrantySystem\\Invoice_Image\\" + this.serialNumber + ".png");
        byte[] bytePngFile = new byte[(int) pngFile.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(pngFile);
            //convert file into array of bytes
            fileInputStream.read(bytePngFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.pngData = bytePngFile;
    }

    private byte[] getPdfData(){
        return this.pdfData;
    }

    private byte[] getPngData(){
        return this.pngData;
    }

    private SingerItems getSingerItems(){
        return this.singerItems;
    }

}
