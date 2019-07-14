package com.sarc.controller;

import com.google.zxing.NotFoundException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sarc.bean.SingerItems;
import com.sarc.bean.TemporaryData;
import com.sarc.config.StageManager;
import com.sarc.generic.ListService;
import com.sarc.service.*;
import com.sarc.view.FxmlView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class HomeUIController implements Initializable {

    @FXML
    private JFXButton btnnewcustomer;
    @FXML
    private HBox Homepane;
    @FXML
    private Pane pane;
    @FXML
    private Pane homepane;
    @FXML
    private Pane viewtablepane;
    @FXML
    private JFXButton btnnewitem;
    @FXML
    private Pane verifypane;

    @FXML
    private JFXComboBox<String> listitem;
    private JFXComboBox<String> listbrand;
    private JFXTextField txtsearch;
    @FXML
    private JFXTextField allitem;
    @FXML
    private JFXTextField solditem;
    @FXML
    private JFXTextField notsolditem;
    private JFXComboBox<String> listfield;
    @FXML
    private Label lblnamev;
    @FXML
    private Label lblidv;
    @FXML
    private Label lbladdressv;
    @FXML
    private Label lblmobile;
    @FXML
    private Label lblbuyv;
    @FXML
    private Label lbltypev;
    @FXML
    private Label lblbrandv;
    @FXML
    private Label lblwarhardv;
    @FXML
    private Label lblwarsoftv;
    @FXML
    private Label lblserialv;
    @FXML
    private Label lblusev;
    @FXML
    private Label lblamountv;
    @FXML
    private Label lblpayamount;
    @FXML
    private Label lblprofit;
    @FXML
    private ImageView imgqrcode;
    @FXML
    private JFXTextField txtpath;
    @FXML
    private PieChart piechart_itemno;
    @FXML
    private PieChart piechart_sold;
    @FXML
    private NumberAxis profit_y;
    @FXML
    private CategoryAxis time_x;
    @FXML
    private BarChart<?, ?> barchart_profit;

    @FXML
    private TableView<SingerItems> table_view;

    @FXML
    private TableColumn<SingerItems, Integer> table_id;

    @FXML
    private TableColumn<SingerItems, String> table_serial;

    @FXML
    private TableColumn<SingerItems, String> table_itemname;

    @FXML
    private TableColumn<SingerItems, String> table_brandname;

    @FXML
    private TableColumn<SingerItems, String> table_warrantyhard;

    @FXML
    private TableColumn<SingerItems, String> table_warrantysoft;

    @FXML
    private TableColumn<SingerItems, String> table_customer;

    @FXML
    private TableColumn<SingerItems, Date> table_dbuy;

    @FXML
    private TableColumn<SingerItems, String> table_phone;

    @FXML
    private TableColumn<SingerItems, String> table_paymethod;

    @FXML
    private TableColumn<SingerItems, Double> table_dpayment;

    @FXML
    private TableColumn<SingerItems, Double> table_mpayment;

    @FXML
    private TableColumn<SingerItems, Double> table_payamount;

    @FXML
    private TableColumn<SingerItems, String> table_sold;

    @FXML
    private TableColumn<SingerItems, Integer> table_repair;


    @Autowired
    private TemporaryDataService temporaryDataService;

    @Autowired
    private CreatingService creatingService;

    @Autowired
    private OpenPathService openPathService;

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private SingerItemService singerItemService;

    @Autowired
    private GoogleDriveService googleDriveService;

    @Autowired
    private AlertService alertService;

    @Lazy
    @Autowired
    private StageManager stageManager;

    private ObservableList<SingerItems> itemList = FXCollections.observableArrayList();

    private XYChart.Series series1 = new XYChart.Series();

    private String folderid;
    private String serial_no;


    private int lap_sold = 0;
    private int phone_sold = 0;
    private int keyboard_sold = 0;
    private int mouse_sold = 0;
    private int pen_sold = 0;

    private int allItemNumber = 0;
    private int allSoldItemNumber = 0;
    private int notSoldItemNumber = 0;

    private double lap_profit = 0;
    private double phone_profit = 0;
    private double keyboard_profit = 0;
    private double mouse_profit = 0;
    private double pen_profit = 0;

    private double lap_all = 0;
    private double phone_all  = 0;
    private double keyboard_all  = 0;
    private double mouse_all  = 0;
    private double pen_all  = 0;

    private SingerItems singerItems;
    private double all_profit = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        setAllItemsNumber();
        setOwnItems();
        setAllSoldItem();
        setNotSoldItem();
        setallProfit();

        ObservableList<PieChart.Data> pieChart_allItem = FXCollections.observableArrayList(
                new PieChart.Data("Laptops",this.lap_all),
                new PieChart.Data("Phone",this.phone_all),
                new PieChart.Data("Keyboard",this.keyboard_all),
                new PieChart.Data("Mouse",this.mouse_all),
                new PieChart.Data("Pen Drive",this.pen_all)
        );
        ObservableList<PieChart.Data> pieChart_soldItem = FXCollections.observableArrayList(
                new PieChart.Data("Laptops",this.lap_sold),
                new PieChart.Data("Phone",this.phone_sold),
                new PieChart.Data("Keyboard",this.keyboard_sold),
                new PieChart.Data("Mouse",this.mouse_sold),
                new PieChart.Data("Pen Drive",this.pen_sold)
        );

        piechart_itemno.setData(pieChart_allItem);
        piechart_itemno.setStartAngle(90);

        piechart_sold.setData(pieChart_soldItem);
        piechart_sold.setStartAngle(90);

        series1.getData().add(new XYChart.Data("Laptops",this.lap_profit));
        series1.getData().add(new XYChart.Data("Phone", this.phone_profit));
        series1.getData().add(new XYChart.Data("Keyboard", this.keyboard_profit));
        series1.getData().add(new XYChart.Data("Mouse", this.mouse_profit));
        series1.getData().add(new XYChart.Data("Pen Drive", this.pen_profit));

        barchart_profit.getData().add(series1);
    }


    @FXML
    private void btnnewcus(MouseEvent event) {
            Homepane.setVisible(Boolean.FALSE);
            stageManager.switchScene(FxmlView.CUSTOMER);
    }

    @FXML
    private void btnnewitem(MouseEvent event) {

        Homepane.setVisible(Boolean.FALSE);
        stageManager.switchScene(FxmlView.INPUT);
    }

    @FXML
    private void btnviewtable(MouseEvent event) {

        homepane.setVisible(false);
        verifypane.setVisible(false);
        viewtablepane.setVisible(true);

        table_view.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        setColumnProperties();
        loadItemDetail();

        allitem.setText(String.valueOf(getAllItemsNumber()));
        solditem.setText(String.valueOf(getAllSoldItem()));
        notsolditem.setText(String.valueOf(getNotSoldItem()));
    }

    private void setColumnProperties(){

        table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_serial.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        table_itemname.setCellValueFactory(new PropertyValueFactory<>("itemTypeName"));
        table_brandname.setCellValueFactory(new PropertyValueFactory<>("itemBrandName"));
        table_warrantyhard.setCellValueFactory(new PropertyValueFactory<>("warrantyHardware"));
        table_warrantysoft.setCellValueFactory(new PropertyValueFactory<>("warrantySoftware"));
        table_customer.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        table_dbuy.setCellValueFactory(new PropertyValueFactory<>("dateBuy"));
        table_phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        table_paymethod.setCellValueFactory(new PropertyValueFactory<>("payMethod"));
        table_dpayment.setCellValueFactory(new PropertyValueFactory<>("downPayment"));
        table_mpayment.setCellValueFactory(new PropertyValueFactory<>("monthlyPayment"));
        table_payamount.setCellValueFactory(new PropertyValueFactory<>("payableAmount"));
        table_sold.setCellValueFactory(new PropertyValueFactory<>("sold"));
        table_repair.setCellValueFactory(new PropertyValueFactory<>("repair"));

    }
    private void loadItemDetail(){

        itemList.clear();
        itemList.addAll(singerItemService.findAll());
        table_view.setItems(itemList);

    }
    @FXML
    private void btnsummerry(MouseEvent event) {
        homepane.setVisible(true);
        verifypane.setVisible(false);
        viewtablepane.setVisible(false);
    }

    @FXML
    private void btncheckvalidity(MouseEvent event) {
        homepane.setVisible(false);
        verifypane.setVisible(true);
        viewtablepane.setVisible(false);
    }


    @FXML
    private void btnscanqrv(MouseEvent event) throws IOException, NotFoundException {

        //set Serial Number
        setSerialNumberText(getSerialNumber(getPath()));

        //Connect DB Class
        this.singerItems = getSingerItems();

        //set QR Code Image
        setQRImage();

        //set Label
        lblnamev.setText(getCustomerName(singerItems));
        lblidv.setText(getCustomerId(singerItems));
        lbladdressv.setText(getCustomerAddress(singerItems));
        lblmobile.setText(getCustomerPhone(singerItems));
        lblbuyv.setText(getCustomerDate(singerItems));
        lbltypev.setText(getItemTypeName(singerItems));
        lblbrandv.setText(getItemBrandName(singerItems));
        lblamountv.setText(Float.toString(getAmount(singerItems)));
        lblpayamount.setText(Float.toString(getCustomerPayAmount(singerItems)));
        lblwarhardv.setText(getWarrantyHardware(singerItems));
        lblwarsoftv.setText(getWarrantySoftware(singerItems));
        lblusev.setText(getRepair(singerItems));

    }

    private SingerItems getSingerItems(){ return singerItemService.findBySerialNumber(getSerialNumber()); }

    private String getCustomerEmail(SingerItems singerItems) { return singerItems.getCusEmail(); }

    private String getCustomerPhone(SingerItems singerItems) { return singerItems.getPhoneNumber(); }

    private String getCustomerName(SingerItems singerItems) { return singerItems.getCustomerName(); }

    private String getCustomerId(SingerItems singerItems) { return singerItems.getCustomerId(); }

    private String getCustomerAddress(SingerItems singerItems) { return singerItems.getCustomerAddress(); }

    private String getCustomerPayMethod(SingerItems singerItems) { return singerItems.getPayMethod(); }

    private float getCustomerDownPay(SingerItems singerItems) { return (float) singerItems.getDownPayment(); }

    private float getCustomerMonthlyPay(SingerItems singerItems) { return (float) singerItems.getMonthlyPayment(); }

    private float getCustomerPayAmount(SingerItems singerItems) { return (float) singerItems.getPayableAmount(); }

    private float getAmount(SingerItems singerItems) { return (float) singerItems.getAmount(); }

    private String getSoldChecking(SingerItems singerItems) { return singerItems.getSold(); }

    private String getCustomerDate(SingerItems singerItems) { return singerItems.getDateBuy().toString(); }

    private String getItemTypeName(SingerItems singerItems) { return singerItems.getItemTypeName(); }

    private String getItemBrandName(SingerItems singerItems) { return singerItems.getItemBrandName(); }

    private String getWarrantyHardware(SingerItems singerItems) { return singerItems.getWarrantyHardware(); }

    private String getWarrantySoftware(SingerItems singerItems) { return singerItems.getWarrantySoftware(); }

    private String getRepair(SingerItems singerItems) { return String.valueOf(singerItems.getRepair()); }

    private String getSerialNumber() { return this.serial_no; }

    private void setRepair(SingerItems singerItems){
        singerItems.setRepair(Integer.parseInt(getRepair(singerItems)) + 1);
    }

    @FXML
    private void btnusev(MouseEvent event) {
        setRepair(this.singerItems);
        singerItemService.save(this.singerItems);
        alertService.saveAlert();
    }

    @FXML
    private void btncancelv(MouseEvent event) {
        homepane.setVisible(true);
        verifypane.setVisible(false);
    }

    @FXML
    private void btnpath(MouseEvent event) throws IOException {
        String qrCodePath = openPathService.openPathDefault();
        txtpath.setText(qrCodePath);
    }

    @FXML
    private void btndownloadqr(MouseEvent event) throws IOException, SQLException {
        creatingService.downloadAll();
        createDriveFolder();
    }

    private void setAllItemsNumber(){
        this.allItemNumber = singerItemService.findAll().size();
    }

    private int getAllItemsNumber(){
        return this.allItemNumber;
    }

    private void setOwnItems(){
        List<SingerItems> itemListsold = singerItemService.findAll();
        for(SingerItems items : itemListsold){
            setOwnAllSoldItemsNumber(items);
            setOwnAllItemNumber(items);
        }
    }

    private void setOwnAllSoldItemsNumber(SingerItems items){

        double profit = items.getAmount() - items.getBuyAmount();

        if(items.getSold().equals("YES") && items.getItemBrandName().equals("Laptop")){
            this.lap_sold++;
            this.lap_profit += profit;
        }else if(items.getSold().equals("YES") && items.getItemBrandName().equals("Phone")){
            this.phone_sold++;
            this.phone_profit += profit;
        }else if(items.getSold().equals("YES") && items.getItemBrandName().equals("Keybourd")){
            this.keyboard_sold++;
            this.keyboard_profit += profit;
        }else if(items.getSold().equals("YES") && items.getItemBrandName().equals("Mouse")){
            this.mouse_sold++;
            this.mouse_profit += profit;
        }else if(items.getSold().equals("YES") && items.getItemBrandName().equals("Pen_Drive")){
            this.pen_sold++;
            this.pen_profit += profit;
        }
    }

    private void setallProfit(){
        this.all_profit = this.lap_profit + this.phone_profit +  this.keyboard_profit + this.keyboard_profit + this.mouse_profit + this.pen_profit;
        lblprofit.setText(String.valueOf(this.all_profit));
    }

    private double getallProfit() {
        return this.all_profit;
    }

    private void setOwnAllItemNumber(SingerItems items){

        switch (items.getItemBrandName()) {
            case "Laptop":
                this.lap_all++;
                break;
            case "Phone":
                this.phone_all++;
                break;
            case "Keybourd":
                this.keyboard_all++;
                break;
            case "Mouse":
                this.mouse_all++;
                break;
            case "Pen_Drive":
                this.pen_all++;
                break;
        }

    }

    private void setAllSoldItem(){
        this.allSoldItemNumber =  this.lap_sold + this.phone_sold + this.keyboard_sold + this.mouse_sold + this.pen_sold;
    }

    private int getAllSoldItem(){
        return this.allSoldItemNumber;
    }

    private void setNotSoldItem(){
        this.notSoldItemNumber = getAllItemsNumber() - getAllSoldItem();
    }

    private int getNotSoldItem(){
        return this.notSoldItemNumber;
    }


    private String getPath(){
        return txtpath.getText();
    }

    private String getSerialNumber(String path) throws IOException, NotFoundException {
        qrCodeService.readerQRCodePath(path);
        return qrCodeService.getSerialNumber();
    }

    private void setSerialNumberText(String serial_no) {
        lblserialv.setText(serial_no);
        this.serial_no = serial_no;
    }

    private void setQRImage() {
        Image image = new Image(getFile(getPath()).toURI().toString());
        imgqrcode.setImage(image);
    }

    private File getFile(String path) {
        return new File(getPath());
    }

    private void createDriveFolder() throws IOException {
        // Create a Google Root Folder
        com.google.api.services.drive.model.File folder1 = googleDriveService.createGoogleFolder(null, "WarrantySystem");
        this.folderid = folder1.getId();
    }

    private String getFolderId(){
        return this.folderid;
    }

 }
