package com.sarc.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sarc.bean.Company;
import com.sarc.bean.Sub_Company;
import com.sarc.config.StageManager;
import com.sarc.service.*;
import com.sarc.view.FxmlView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class ForgetPasswordController implements Initializable {

    @FXML
    private AnchorPane recoverypane;
    @FXML
    private JFXTextField txtrecoveryphone;
    @FXML
    private JFXTextField txtsecorecode;
    @FXML
    private Pane emailpane;
    @FXML
    private Pane codepane;
    @FXML
    private Pane passwordpane;
    @FXML
    private JFXPasswordField txtnewpass;
    @FXML
    private JFXPasswordField txtconfirmpass;
    @FXML
    private JFXButton btnrecoveryfinish;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private AlertService alertService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CheckingService checkingService;

    @Autowired
    private Sub_CompanyService sub_companyService;

    @Lazy
    @Autowired
    private StageManager stageManager;

    private String secure = "null";
    private String email = "null";
    private Sub_Company subCompany;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


    @FXML
    private void btnresetpass(MouseEvent event) {

            this.secure = emailService.sendEmail(getRecoveryEmail());

            if(this.secure.equals("null")){

            }else{
                codepane.setVisible(true);
                emailpane.setVisible(false);
            }

    }

    private String getRecoveryPhone() {
        return txtrecoveryphone.getText();
    }

    private String getRecoveryEmail() {
        List<Sub_Company> sub_companyList = sub_companyService.findAll();

        for (Sub_Company sub_company : sub_companyList) {
            if(sub_company.getSubcompany_phone().equals(getRecoveryPhone())){
                this.subCompany =sub_company;
                this.email = sub_company.getHeadcompany_map().getHeadcompany_email();
                break;
            }
        }
        if(this.email.equals("null")){
            alertService.validationAlert("Phone Number",false);
        }
        return this.email;
    }

    private String getNewPassword() {
        return txtnewpass.getText();
    }

    private String getConfirmPassword() {
        return txtconfirmpass.getText();
    }


    private String getSecureCode() {
        return txtsecorecode.getText();
    }

    @FXML
    private void btnnextstep(MouseEvent event) {

        if(checkingService.checkPassword(getSecureCode(),this.secure)){
            System.out.println("Compare");
            passwordpane.setVisible(true);
            codepane.setVisible(false);
        }else{
            System.out.println("Not Compare : " + this.secure);
            System.out.println("Your Code is : " + getSecureCode());
            txtsecorecode.setText("");
        }

    }

    @FXML
    private void btnfinish(MouseEvent event) {

        if(!checkingService.checkPassword(getNewPassword(), getConfirmPassword())){
            txtconfirmpass.setText("");
        }else{
            subCompany.setSubcompany_password(getNewPassword());

            sub_companyService.update(subCompany);
            alertService.updateAlert(subCompany);

            System.out.println("Reset Password Successfully");
            stageManager.switchScene(FxmlView.LOGIN);

        }
    }

    @FXML
    private void btnbackemail(MouseEvent event) {
        emailpane.setVisible(false);
        stageManager.switchScene(FxmlView.LOGIN);
    }

    @FXML
    private void btnbackcode(MouseEvent event) {
        codepane.setVisible(false);
        emailpane.setVisible(true);
    }

    @FXML
    private void btnbackpassword(MouseEvent event) {
        passwordpane.setVisible(false);
        codepane.setVisible(true);
    }





}
