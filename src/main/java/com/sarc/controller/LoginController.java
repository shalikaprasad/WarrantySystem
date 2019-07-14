package com.sarc.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sarc.bean.*;
import com.sarc.config.StageManager;
import com.sarc.generic.ListBranchService;
import com.sarc.generic.ListService;
import com.sarc.service.*;
import com.sarc.service.impl.AlertServiceImpl;
import com.sarc.view.FxmlView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Sarc
 * @since 24-03-2019
 */

@Controller
public class LoginController implements Initializable{

	@FXML
	private Pane content_area;
	@FXML
	private Pane register_area;
	@FXML
	private JFXButton btn_login;
	@FXML
	private AnchorPane loginpane;
	@FXML
	private PasswordField txtpass1sign;
	@FXML
	private JFXButton btnsign;
	@FXML
	private JFXTextField txtloaction;
	@FXML
	private JFXTextField txtbranchaddress;
	@FXML
	private JFXTextField txtphone;
	@FXML
	private JFXTextField txtcompanyweb;
	@FXML
	private JFXTextField txtphonelogin;
	@FXML
	private JFXPasswordField txtpasslogin;
	@FXML
	private PasswordField txtpass2sign;


	@FXML
	private Button btnchechcompany;
	@FXML
	private JFXTextField txtcompany;
	@FXML
	private JFXComboBox<String> txtbranch;
	@FXML
	private CheckBox checkmain_company_id;
	@FXML
	private JFXTextField txtcompany_emailsign;
	@FXML
	private JFXTextField txtcompanyaddress;

	@FXML
	private ImageView companylogo;

	@FXML
	private Pane main_companypane;
	@FXML
	private Pane branch_pane;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CheckingService checkingService;

	@Autowired
	private SingerItemService singerItemService;

	@Autowired
	private TemporaryDataService temporaryDataService;

	@Autowired
	private OpenPathService openPathService;

	@Autowired
	private Head_CompanyService head_companyService;

	@Autowired
	private BranchService branchService;

    @Autowired
    private ConvertingService convertingService;

	@Autowired
	private CreatingService creatingService;

	@Autowired
	private Sub_CompanyService sub_companyService;

	@Lazy
	@Autowired
	private StageManager stageManager;

	public String email1;
	private static int count = 0;
	private String logoPath;
	private boolean check_inputvalidity = false;
	private String company_email;
	private int subcompany_branchid;
	private String subcompany_branchname, subcompany_address, head_web, phone;

	AlertService alertService = new AlertServiceImpl();
	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	@FXML
	public void login(ActionEvent event) throws IOException {


		if(sub_companyService.authenticate(getLoginPhone(), getLoginPassword())){
			System.out.println("SignUp Successfully");

			alertService.logAlert("Logging", true);
			saveTemporaryData();
			stageManager.switchScene(FxmlView.HOME);

		}else if(count > 3){
			System.out.println("SignUp Denied");
		}
		else{
			alertService.logAlert("Logging", false);
			count++;
			System.out.println("SignIn Fail");
		}

	}

	private void saveTemporaryData() {
		List<Sub_Company> sub_companyList = sub_companyService.findAll();

		for (Sub_Company sub_company : sub_companyList) {
			if (!getPhone().equals(sub_company.getSubcompany_phone())) {
				this.phone = sub_company.getSubcompany_phone();
				this.company_email = sub_company.getHeadcompany_map().getHeadcompany_email();
				this.subcompany_branchid = sub_company.getSubcompany_branch_map().getSubcompany_branch_id();
				this.subcompany_branchname = sub_company.getSubcompany_branch_map().getSubcompany_branch_name();
				this.subcompany_address = sub_company.getSubcompany_address();
				this.head_web = sub_company.getHeadcompany_map().getHeadcompany_web();
				break;
			}
		}
		long millis=System.currentTimeMillis();
		Date date = new Date(millis);

		TemporaryData temporaryData = new TemporaryData(1,this.phone,this.company_email,this.subcompany_branchid,this.subcompany_branchname, this.subcompany_address, this.head_web, date);
		temporaryDataService.saveOrUpdate(temporaryData);
	}

	private String getLoginPassword() {
		return txtpasslogin.getText().trim();
	}

	public String getLoginPhone() {
		return txtphonelogin.getText().trim();
	}


	@FXML
	public void setCompanyLogo(MouseEvent mouseEvent) {
		companylogo.setOnMouseClicked((MouseEvent event) -> {
			String imagepath = null;
			try {
				imagepath = openPathService.openPathDefault();
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.logoPath = imagepath;
			if(!this.logoPath.isEmpty()){
				File file = new File(imagepath);
				Image image = new Image(file.toURI().toString());
				companylogo.setImage(image);
			}

		});
	}
	@FXML
	private void forgetpass(MouseEvent event) throws IOException {
		loginpane.setVisible(Boolean.FALSE);
		stageManager.switchScene(FxmlView.FORGET);
	}

	@FXML
	public void signup(ActionEvent event) throws IOException {

		boolean check_mainCompany = checkmain_company_id.isSelected();

		checkingService.checking(
				getCompanyName(),
				getEmail(),
				getPhone(),
				getPassword1(),
				getPassword2());

		if(check_mainCompany){
			saveMainCompany();
		}
		else {
            saveBranchCompany();
		}
		}


	private void saveMainCompany() throws IOException {
		checkingService.checkingCompany(
				getCompanyAddress(),
				getWeb(),
				getLogoPath()
		);

		try {
			this.check_inputvalidity = checkingService.inputValidation() && checkingService.inputValidationCompany();
		}catch (NullPointerException e){
			checkingService.checkAll();
		}
		if(this.check_inputvalidity) {
			Head_Company head_company = new Head_Company();
			head_company.setHeadcompany_name(getCompanyName());
			head_company.setHeadcompany_address(getCompanyAddress());
			head_company.setHeadcompany_phone(getPhone());
			head_company.setHeadcompany_web(getWeb());
			head_company.setHeadcompany_email(getEmail());
			head_company.setHeadcompany_password(getPassword1());
			head_company.setHeadcompany_logo(getCompanyLogo());

			head_companyService.save(head_company);
			System.out.println("Head Company saved successfully!!");

			alertService.saveAlert();
			clearFields();

			content_area.setVisible(true);
			register_area.setVisible(false);
			System.out.println("Successful save DB");
		}else {
			System.out.println("Cannot save DB");
		}
	}

	private void saveBranchCompany(){
		checkingService.checkingBranch(
				getBranchAddress(),
				getBranchName()
		);

		try {
			this.check_inputvalidity = checkingService.inputValidation() && checkingService.inputValidationBranch();
		}catch (NullPointerException e){
			checkingService.checkAll();
		}
		if(this.check_inputvalidity) {

            Sub_Company sub_company = new Sub_Company();
            sub_company.setSubcompany_address(getBranchAddress());
            sub_company.setSubcompany_password(getPassword1());
            sub_company.setSubcompany_phone(getPhone());


		    if(!getCompanyName().isEmpty()){
                //Head_Company head_company = head_companyService.findByCompanyName(getCompanyName());
                List<Head_Company> head_companyList =head_companyService.findAll();

                for(Head_Company head_company : head_companyList){

                    if(getCompanyName().equals(head_company.getHeadcompany_name())){
						Branch branch = returnBranch();
						sub_company.setSubcompany_branch_map(branch);
                    	sub_company.setHeadcompany_map(head_company);
						Set<Sub_Company> sub_companySet = new HashSet();
                    	sub_companySet.add(sub_company);
                    	head_company.setSub_companie_head(sub_companySet);
                    	head_companyService.save(head_company);
                    	System.out.println("save headcompany side");
                    }
                }
            }

			alertService.saveAlert();
			clearFields();

			content_area.setVisible(true);
			register_area.setVisible(false);
			System.out.println("Successful save DB");
		}else {
			System.out.println("Cannot save DB");
		}
	}

	private Branch returnBranch(){
		Branch branch = new Branch();
		branch.setSubcompany_branch_name(getBranchName());
		return branch;
	}
	private void clearFields() {
		txtcompany.setText(null);
		txtcompany_emailsign.setText(null);
		txtpass1sign.setText(null);
		txtpass2sign.setText(null);
		txtcompanyaddress.setText(null);
		txtbranchaddress.setText(null);
		txtphone.setText(null);
		txtcompanyweb.setText(null);
	}

	private String getCompanyName() { return txtcompany.getText(); }

	private void setCompanyName(Head_Company head_company) {
		txtcompany_emailsign.setText(head_company.getHeadcompany_email());
	}

	private String getBranchName() {
		return txtbranch.getValue();
	}

	private void settBranchName(String head_company) {
		ObservableList<String> listbranch = new ListBranchService().getBranch(head_company);
		txtbranch.setItems(listbranch);
	}

	private String getEmail() { return txtcompany_emailsign.getText(); }

	private String getPassword1() {
		return txtpass1sign.getText();
	}

	private String getPassword2() {
		return txtpass2sign.getText();
	}

	private String getBranchAddress() {
		return txtbranchaddress.getText();
	}

	private String getCompanyAddress() {
		return txtcompanyaddress.getText();
	}

	private void setCompanyAddress(Head_Company head_company) {
		txtcompanyaddress.setText(head_company.getHeadcompany_address());
	}

	private String getPhone() {
		return txtphone.getText();
	}

	private String getWeb() {
		return txtcompanyweb.getText();
	}

	private void setWeb(Head_Company head_company) {
		txtcompanyweb.setText(head_company.getHeadcompany_web());
	}

	private Blob getCompanyLogo() throws IOException {
		return convertingService.convertFileContentToBlob(getLogoPath());
	}

	private void setCompanyLogo(Head_Company head_company) throws IOException, SQLException {
		this.logoPath = creatingService.saveLogo(head_company);
		if(!this.logoPath.isEmpty()){
			File file = new File(this.logoPath);
			Image image = new Image(file.toURI().toString());
			companylogo.setImage(image);
		}
	}

	private String getLogoPath() {
		return this.logoPath;
	}

	@FXML
	public void sendEmail(MouseEvent event){
		this.email1 = txtphone.getText();

	}

	@FXML
	private void back(MouseEvent event) {
		content_area.setVisible(true);
		register_area.setVisible(false);
	}

	@FXML
	private void signuplink(MouseEvent event) {
		content_area.setVisible(false);
		register_area.setVisible(true);
	}

	@FXML
	private void checkMainCompany(MouseEvent event) {

		if(checkmain_company_id.isSelected()){
			companylogo.setDisable(false);
			txtbranch.setDisable(true);
			txtbranchaddress.setDisable(true);
			main_companypane.setDisable(false);

		}else{
			companylogo.setDisable(true);
			txtbranch.setDisable(false);
			main_companypane.setDisable(true);
			txtbranchaddress.setDisable(false);

		}
	}

	@FXML
	private void companyValidationButton(MouseEvent event) throws IOException, SQLException {
		boolean btncheck_company = false;

		List<Head_Company> head_companyList = head_companyService.findAll();

		for (Head_Company head_company : head_companyList){
			if(getCompanyName().equals(head_company.getHeadcompany_name())){
				settBranchName(head_company.getHeadcompany_name());
				setCompanyName(head_company);
				setCompanyAddress(head_company);
				setWeb(head_company);
				setCompanyLogo(head_company);
				btncheck_company = true;
				break;
			}
		}
		if(!btncheck_company){
			alertService.newAlert("Head Company","Please Click checkbox and SignUp your Main Company");
		}
	}
}


