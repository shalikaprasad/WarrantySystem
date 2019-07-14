package com.sarc.service.impl;

import com.sarc.service.AlertService;
import com.sarc.service.OpenPathService;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class OpenPathServiceImpl implements OpenPathService {

    @Autowired
    private AlertService alertService;
    //private Desktop desktop = Desktop.getDesktop();
    private File file;
    private String path = null;

//    @Override
//    public String openPath(String path) throws IOException {
//        this.path = path;
//        file = new File(path);
//        try {
//            desktop.open(file);
//            return file.getPath();
//        } catch (IllegalArgumentException iae) {
//            System.out.println("File Not Found");
//            return path;
//        }
//    }

    @Override
    public String openPathDefault() throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ALL files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open file dialog
        this.file = fileChooser.showOpenDialog(null);

        if(file != null) {
            this.path = this.file.getPath();
            System.out.println(this.path);
            return this.path;
        }
        else
        {
            alertService.getDefaultAlert("Information Dialog","Please Select a File");
            return null;

        }
    }




}
