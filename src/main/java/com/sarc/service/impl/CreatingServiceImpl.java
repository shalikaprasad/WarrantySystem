package com.sarc.service.impl;

import com.sarc.bean.Head_Company;
import com.sarc.bean.SingerItems;
import com.sarc.service.CreatingService;
import com.sarc.service.SingerItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Service
public class CreatingServiceImpl implements CreatingService {

    @Autowired
    private SingerItemService singerItemService;


    @Override
    public void downloadAll() throws IOException, SQLException {

        createMainDir();
        new File("C:\\WarrantySystem\\Invoice_PDF").mkdirs();
        new File("C:\\WarrantySystem\\Invoice_Image").mkdirs();
        new File("C:\\WarrantySystem\\QRCodes").mkdirs();

        byte b[], b1[], b2[];

        List<SingerItems> itemsList = singerItemService.findAll();
        for (SingerItems singerItems : itemsList) {
            String serialNo = singerItems.getSerialNumber();
            Blob qrBlob = singerItems.getQrCode();
            byte[] invoiceImageByte = singerItems.getInvoice_image();
            byte[] invoicePdfByte = singerItems.getInvoice_pdf();

            if (qrBlob != null) {
                File file1 = new File("C:\\WarrantySystem\\QRCodes\\" + serialNo + ".png");
                FileOutputStream fos = new FileOutputStream(file1);
                b = qrBlob.getBytes(1, (int) qrBlob.length());
                fos.write(b);
            }

            if (invoiceImageByte != null) {
                File file2 = new File("C:\\WarrantySystem\\Invoice_Image\\" + serialNo + ".png");
                FileOutputStream fos1 = new FileOutputStream(file2);
                fos1.write(invoiceImageByte);
            }

            if (invoicePdfByte != null) {
                File file2 = new File("C:\\WarrantySystem\\Invoice_PDF\\" + serialNo + ".pdf");
                FileOutputStream fos2 = new FileOutputStream(file2);
                fos2.write(invoicePdfByte);
            }
        }

    }

    private void createMainDir(){
        File mainDir = new File("C:\\WarrantySystem");
        if(mainDir.exists()){
            new File("C:\\WarrantySystem").mkdirs();
        }
    }

    @Override
    public String saveLogo(Head_Company company) throws SQLException, IOException {
        createMainDir();
        new File("C:\\WarrantySystem\\Logo").mkdirs();
        File logofile = new File("C:\\WarrantySystem\\Logo\\" + company.getHeadcompany_name() + ".png");
        FileOutputStream foslogo = new FileOutputStream(logofile);

        Blob logoBlob = company.getHeadcompany_logo();
        byte bytefile[] = logoBlob.getBytes(1, (int) logoBlob.length());
        foslogo.write(bytefile);

        return logofile.getPath();
    }

}
