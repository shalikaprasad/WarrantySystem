package com.sarc.service.impl;

import com.sarc.bean.Company;
import com.sarc.bean.Sub_Company;
import com.sarc.service.AlertService;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlertServiceImpl implements AlertService {


    @Override
    public void saveAlert() {
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Saved successfully.");
        alert1.setHeaderText(null);
        alert1.setContentText("The company/Item Database Table is Updated.");
        alert1.showAndWait();
    }

    @Override
    public void logAlert(String topic, boolean check) {
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);

        if(check){
            alert1.setTitle(topic);
            alert1.setHeaderText(null);
            alert1.setContentText("Welcome !!! " + topic + " Successfully.");
            alert1.showAndWait();
        }else {
            alert1.setTitle(topic + " Fail.");
            alert1.setHeaderText(null);
            alert1.setContentText("Try Again.");
            alert1.showAndWait();
        }

    }


    @Override
    public void updateAlert(Sub_Company sub_company) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Company updated successfully.");
        alert.setHeaderText(null);
        alert.setContentText("The user " + sub_company.getHeadcompany_map().getHeadcompany_name() + " " + sub_company.getSubcompany_branch_map().getSubcompany_branch_name() + " has been updated.");
        alert.showAndWait();
    }

    @Override
    public void validationAlert(String field, boolean empty) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("ValidationServiceImpl Error");
        alert.setHeaderText(null);
        if (field.equals("Branch Name")) alert.setContentText("Please Select " + field);
        else {
            if (empty) alert.setContentText("Please Enter " + field);
            else if(field.equals("Pass"))alert.setContentText("Passwords anr not match");
            else alert.setContentText("Please Enter Valid " + field);
        }
        alert.showAndWait();
    }

    @Override
    public void newAlert(String field, String method) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Create New");
        alert.setHeaderText(null);
        alert.setContentText("Please Create New " + field + "\nMethod : " + method);

        alert.showAndWait();
    }

    @Override
    public void showValueAlert(String value, boolean editable) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Serial Number");
        alert.setHeaderText("Please Open WarrantyPrint Application\n Then Please Copy & Paste this Serial Number in Text Area.");
        alert.setContentText("Serial Number :");

        TextArea textArea = new TextArea(value);
        textArea.setEditable(false);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setExpandableContent(expContent);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @Override
    public void getDefaultAlert(String title, String body){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(body);
        /*alert.setContentText("You didn't select a file!");*/
        alert.showAndWait();
    }



}