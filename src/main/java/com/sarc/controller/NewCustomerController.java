package com.sarc.controller;

import com.google.zxing.NotFoundException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sarc.bean.*;
import com.sarc.config.StageManager;
import com.sarc.generic.ListItemService;
import com.sarc.service.*;
import com.sarc.view.FxmlView;
import com.twilio.sdk.TwilioRestException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;


@Controller
public class NewCustomerController implements Initializable {

    @FXML
    private AnchorPane inputPane;

    @FXML
    private Pane qrcodepane;
    @FXML
    private JFXTextField txtpath;
    @FXML
    private ImageView imgqr;
    @FXML
    private Label txtitemserial;
    @FXML
    private Label txtitemtype;
    @FXML
    private Label txtitemamount;
    @FXML
    private Label txtitemdiscount;
    @FXML
    private Label txtitemhardware;
    @FXML
    private Label txtitemsoftware;


    @FXML
    private Pane checkoutpane;
    @FXML
    private AnchorPane customerPane;
    @FXML
    private TableView<ListItemService> itemTableView;
    @FXML
    private TableColumn<ListItemService, Integer> colItemId;
    @FXML
    private TableColumn<ListItemService, String> colItemName;
    @FXML
    private TableColumn<ListItemService, String> colSerialNumber;
    @FXML
    private TableColumn<ListItemService, Double> colDiscount;
    @FXML
    private TableColumn<ListItemService, Double> colAmount;
    @FXML
    private TableColumn<ListItemService, Double> colpayedAmount;
    @FXML
    private TableColumn<ListItemService, Boolean> colHire;
    @FXML
    private Label txtTotalAmount;
    @FXML
    private MenuItem deleteItem;
    @FXML
    private TextField txtPayedAmount;



    @FXML
    private Pane customerpane;
    @FXML
    private JFXTextField txtcusid;
    @FXML
    private JFXTextField txtcusname;
    @FXML
    private JFXTextField txtcusaddress;
    @FXML
    private JFXTextField txtcusemail;
    @FXML
    private JFXTextField txtcusphone;


    @FXML
    private Pane paymentpane;
    @FXML
    private JFXTextField lableCash;
    @FXML
    private Label lableTotalAmount;
    @FXML
    private Label lablePayableAmount;
    @FXML
    private RadioButton radioSms;
    @FXML
    private RadioButton radioEmail;
    @FXML
    private RadioButton radioSmsEmail;


    @FXML
    private Pane cardpane;
    @FXML
    private RadioButton radioVisa;
    @FXML
    private RadioButton radioMaster;
    @FXML
    private RadioButton radioEzCash;
    @FXML
    private RadioButton radioAmerican;
    @FXML
    private RadioButton radioVishwa;
    @FXML
    private JFXTextField txtcardNumber;
    @FXML
    private JFXTextField txtcardName;
    @FXML
    private JFXTextField txtcardExpireDate;
    @FXML
    private JFXTextField txtcardSecurityCode;
    @FXML
    private JFXTextField txtcardAmount;


    @FXML
    private ToggleGroup cardgroup;

    @FXML
    private ToggleGroup sendgroup;


    @Autowired
    private SmsService smsService;

    @Autowired
    private SingerItemService singerItemService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private GoogleDriveService googleDriveService;

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private OpenPathService openPathService;

    @Autowired
    private TemporaryDataService temporaryDataService;

    @Autowired
    private AlertService alertService;

    @Autowired
    private UpdatingService updatingService;

    @Autowired
    private ItemService itemService;
    @Autowired
    private Item_CategoryService item_categoryService;
    @Autowired
    private Item_BrandService item_brandService;
    @Autowired
    private Item_Sell_AmountService item_sell_amountService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private Main_TableService mainTableService;
    @Autowired
    private TemporaryItemService temporaryItemService;
    @Autowired
    private TemporaryCustomerService temporaryCustomerService;

    @Lazy
    @Autowired
    private StageManager stageManager;

    private Customer customer_table;

    private boolean checkCustomer = false;
    private int customerid;
    private String serialNumber;

    private String itemType;
    private String itemBrand;
    private double itemAmount;
    private double itemDiscount;
    private String itemHardware;
    private String itemSoftware;

    private String cardMethod = "cash";
    private boolean addcardSuccess = false;

    private Item itemTable;
    private int id_num = 0;
    private SingerItems singerItems;
    private double itemTotalPrice = 0;
    private boolean hire_method;

    private String sharablelink, folderid;

    private Map<String, Double> itemlist = new HashMap<String, Double>();
    ArrayList<ListItemService> listItemServiceArrayList;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void btnpath(MouseEvent event) throws IOException {
        String qrCodePath = openPathService.openPathDefault();
        txtpath.setText(qrCodePath);
    }

    @FXML
    private void btnscanqr(MouseEvent event) throws IOException, NotFoundException {

        if(!getFilePath().isEmpty()){
            setQRCodePath();
            setSerialNumber(qrCodeService.getSerialNumber());
            setImage();
            setItems(getSerialNumber());
            txtitemtype.setText(getItemType());
            txtitemamount.setText(String.valueOf(getItemAmount()));
            txtitemdiscount.setText(String.valueOf(getItemDiscount()));
            txtitemhardware.setText(getItemHardware());
            txtitemsoftware.setText(getItemSoftware());
        }

    }

    private String getFilePath() {
        if(txtpath.getText().isEmpty()){
            alertService.getDefaultAlert("Information Dialog","Please Select a File");
            return null;
        }else {
            return txtpath.getText();
        }
    }

    private void setQRCodePath() throws IOException, NotFoundException { qrCodeService.readerQRCodePath(getFilePath()); }

    private void setSerialNumber (String serialNumber){
        this.serialNumber = serialNumber;
        txtitemserial.setText(this.serialNumber);
    }

    private void setImage() {
        File file = new File("C:\\WarrantySystem\\QRCodes\\" + getSerialNumber() + ".png");
        Image image = new Image(file.toURI().toString());
        imgqr.setImage(image);
    }

    private String getSerialNumber() { return this.serialNumber; }

    private void setItems(String serialNumber){

        List<Item> itemList = itemService.findAll();
        for (Item item : itemList){
            if(serialNumber.equals(item.getItem_serial_number())){

                getItem_CategoryType(item.getItem_category_id());
                getItem_setAmount(item.getItem_sell_amount_id());
                getItem_setItem_Brand(item.getItem_brand_id());

                setItemType(this.itemType);

                setItemAmount(this.itemAmount);
                setItemBrand(this.itemBrand);
                setItemDiscount(item.getItem_discounts());
                setItemHardware(item.getItem_warranty_hardware());
                setItemSoftware(item.getItem_warranty_software());
                this.itemTable = item;
                break;
            }
        }

    }

    private void getItem_CategoryType(int id) {
        List<Item_Category> item_categoriesList = item_categoryService.findAll();

        for (Item_Category item_category : item_categoriesList){
            if(id == item_category.getItem_category_id()){
                this.itemType = item_category.getItem_category_name();
                break;
            }

        }
    }

    private void getItem_setAmount(int id) {
        List<Item_Sell_Amount> item_sell_amounts = item_sell_amountService.findAll();

        for (Item_Sell_Amount item_sell_amount : item_sell_amounts){
            if(id == item_sell_amount.getItem_sell_amount_id()){
                this.itemAmount = item_sell_amount.getItem_sell_amount_value();
                break;
            }
        }
    }

    private void getItem_setItem_Brand(int id) {
        List<Item_Brand> item_brands = item_brandService.findAll();

        for (Item_Brand item_brand : item_brands){
            if(id == item_brand.getItem_brand_id()){
                this.itemBrand = item_brand.getItem_brand_name();
                break;
            }
        }
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public double getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }

    public double getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(double itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public String getItemHardware() {
        return itemHardware;
    }

    public void setItemHardware(String itemHardware) {
        this.itemHardware = itemHardware;
    }

    public String getItemSoftware() {
        return itemSoftware;
    }

    public void setItemSoftware(String itemSoftware) {
        this.itemSoftware = itemSoftware;
    }



    @FXML
    private void btnbackShoppingCart(MouseEvent event) {
        checkoutpane.setVisible(false);
        qrcodepane.setVisible(true);
    }

    @FXML
    private void btnremoveRows(MouseEvent event) {
        itemTableView.getItems().removeAll(itemTableView.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void btnAddPayedAmount(MouseEvent event) {
        Double amount = Double.valueOf(txtPayedAmount.getText());
        System.out.println("PayedAmount" + amount);
        //itemTableView.setEditable(true);
//        ListItemService listItem = new ListItemService(amount);
//
//        itemTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        setColumnProperties();
//        itemTableView.getItems().add(listItem);
        System.out.println("Index : "+itemTableView.getSelectionModel().getSelectedIndex());
        itemTableView.getItems().get(itemTableView.getSelectionModel().getSelectedIndex()).setItemPayedAmount(amount);
        itemTableView.refresh();
    }

    @FXML
    private void deleteItem(ActionEvent event){



//        List<User> users = userTable.getSelectionModel().getSelectedItems();
//
//        Alert alert = new Alert(AlertType.CONFIRMATION);
//        alert.setTitle("Confirmation Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("Are you sure you want to delete selected?");
//        Optional<ButtonType> action = alert.showAndWait();
//
//        if(action.get() == ButtonType.OK) userService.deleteInBatch(users);
//
//        loadUserDetails();
    }


    @FXML
    private void btnAddtoCart(MouseEvent event) {

        this.listItemServiceArrayList = new ArrayList<>();
        ListItemService listItem = new ListItemService(getSerialNumber(),getItemType(),getItemBrand(), "H:" + getItemHardware() + " S:"  + getItemSoftware(), getItemAmount(),0.00,getItemDiscount());

        itemTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        setColumnProperties();
        itemTableView.getItems().add(listItem);

        ListItemService listItemService = new ListItemService();


        for(int i = 0 ; i < itemTableView.getItems().size() ; i++){
            listItemService = itemTableView.getItems().get(i);
            listItemService.setHire(true);
            this.listItemServiceArrayList.add(listItemService);
            this.itemlist.put(listItemService.getSerialNumber(), listItemService.getItemAmount());
            this.itemTotalPrice = this.itemTotalPrice + listItemService.getItemAmount();
        }

        this.txtTotalAmount.setText(String.valueOf(this.itemTotalPrice));

        qrcodepane.setVisible(false);
        checkoutpane.setVisible(true);

    }

    private void setColumnProperties() {
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemType"));
        colSerialNumber.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("itemAmount"));
        colpayedAmount.setCellValueFactory(new PropertyValueFactory<>("itemPayedAmount"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("itemDiscount"));
        colHire.setCellValueFactory(new PropertyValueFactory<>("itemHire"));
    }

    @FXML
    private void btnnextShoppingCart(MouseEvent event) {

        checkoutpane.setVisible(false);
        customerpane.setVisible(true);
    }

    @FXML
    private void btnCheckCustomer(MouseEvent event) {

        List<Customer> customerList = customerService.findAll();
        for (Customer customer : customerList){
            if(getCustomerID().equals(customer.getCustomer_identity_number())){
                setCustomerName(customer.getCustomer_name());
                setCustomerAddress(customer.getCustomer_address());
                setCustomerEmail(customer.getCustomer_emai());
                setCustomerPhone(customer.getCustomer_phone());

                this.customer_table = customer;
                this.checkCustomer = true;
                this.customerid = customer.getCustomer_id();

                break;
            }
        }
        if(!checkCustomer){
            alertService.getDefaultAlert("Warning","Please Add new Customer");
        }

    }

    @FXML
    private void btnSaveCustomer(MouseEvent event) {

        if(!this.checkCustomer){
            Customer customer = new Customer();
            customer.setCustomer_identity_number(getCustomerID());
            customer.setCustomer_name(getCustomerName());
            customer.setCustomer_address(getCustomerAddress());
            customer.setCustomer_emai(getCustomerEmail());
            customer.setCustomer_phone(getCustomerPhone());

            customerService.save(customer);
        }

        lableTotalAmount.setText(String.valueOf(this.itemTotalPrice));

        alertService.saveAlert();
        customerpane.setVisible(false);
        paymentpane.setVisible(true);
    }

    @FXML
    private void btnAddPayment(MouseEvent event) {
        if(radioVisa.isSelected()){
                this.cardMethod = "visa";
        }else if(radioMaster.isSelected()){
            this.cardMethod = "marster";
        }else if(radioAmerican.isSelected()){
            this.cardMethod = "american";
        }else if(radioEzCash.isSelected()){
            this.cardMethod = "ezCash";
        }else if(radioVishwa.isSelected()){
            this.cardMethod = "vishwa";
        }else{
            this.cardMethod = "cash";
        }

        if(checkCardValidity())
        {
            addcardSuccess = true;
            setLablePayableAmount(txtcardAmount.getText());

            cardpane.setVisible(false);
            paymentpane.setVisible(true);
        }else {
            alertService.getDefaultAlert("Warning","Please Enter Valid Card");
        }

    }

    private boolean checkCardValidity() {
        return validationService.creditcard(getCardName(), getCardNumber(), getCardExpireDate(), getCardSecurityCode());
    }

    private void setLablePayableAmount(String payableAmount){
        lablePayableAmount.setText(payableAmount);
    }

    private String getCardName(){
        return txtcardName.getText();
    }

    private String getCardNumber(){
        return txtcardNumber.getText();
    }

    private String getCardExpireDate(){
        return txtcardExpireDate.getText();
    }

    private String getCardSecurityCode(){
        return txtcardSecurityCode.getText();
    }

    @FXML
    private void btnCreditCard(MouseEvent event) {
        paymentpane.setVisible(false);
        cardpane.setVisible(true);
    }

    @FXML
    private void btnAddAmount(MouseEvent event) {
        if(!addcardSuccess){
            lablePayableAmount.setText(lableCash.getText());
        }

        try {
            createRootFolder("WarrantySystem");

        } catch (IOException e) {
            e.printStackTrace();
        }


        TemporaryCustomer temporaryCustomer = new TemporaryCustomer();
        temporaryCustomer.setCus_name(getCustomerName());
        temporaryCustomer.setCus_id(getCustomerID()+ "V");
        temporaryCustomer.setCus_address(getCustomerAddress());
        temporaryCustomer.setCus_phone(getCustomerPhone());
        temporaryCustomer.setCus_pay_method(this.cardMethod);

        temporaryCustomerService.saveOrUpdate(temporaryCustomer);

        TemporaryItem temporaryItem;
        for(ListItemService arrayList_item : this.listItemServiceArrayList){
            temporaryItem = new TemporaryItem();

            if((float)arrayList_item.getItemPayedAmount() == 0){
                temporaryItem.setPayed_amount((float) arrayList_item.getItemAmount());
            }else {
                temporaryItem.setPayed_amount((float) arrayList_item.getItemPayedAmount());
            }

            try {
                uploadFile("C://WarrantySystem/QRCodes/" + arrayList_item.getSerialNumber() + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }

            temporaryItem.setItem_serial(String.valueOf(arrayList_item.getSerialNumber()));
            temporaryItem.setItem_brand(arrayList_item.getItemBrand());
            temporaryItem.setItem_type(arrayList_item.getItemType());
            temporaryItem.setTotal_amount((float) arrayList_item.getItemAmount());
            temporaryItem.setItem_warranty(arrayList_item.getItemWarranty());

            temporaryItemService.save(temporaryItem);
        }




    }

    @FXML
    private void btnConfirmPayment(MouseEvent event) {

        Date date = new Date();

        Main_Table main_table;


        String serial = this.listItemServiceArrayList.get(0).getSerialNumber();

        for(ListItemService arrayList : this.listItemServiceArrayList){
            main_table = new Main_Table();

            if((float)arrayList.getItemPayedAmount() == 0){
                main_table.setCustomer_payed_amount(arrayList.getItemPayedAmount());
            }else {
                main_table.setCustomer_payed_amount(arrayList.getItemPayedAmount());
            }

            main_table.setCustomer_date_buy(date);
            main_table.setCustomer_hire(String.valueOf(arrayList.isHire()));
            main_table.setCustomer_id_number(getCustomerID());

            main_table.setItem_serial(String.valueOf(arrayList.getSerialNumber()));
            main_table.setSub_company_name(getSubCompanyName());
            main_table.setInvoice_id(serial);
            main_table.setCustomer_pay_method(this.cardMethod);

            mainTableService.save(main_table);
        }

        alertService.saveAlert();


        getCompanyEmail();

        try {
        if(radioSms.isSelected()){
            smsService.sendSms(this.sharablelink, getCustomerPhone(), getCustomerName());

        }else if(radioEmail.isSelected()){

                emailService.sendEmailImage(getCustomerEmail(), serial);

        }else if(radioSmsEmail.isSelected()){
            emailService.sendEmailImage(getCustomerEmail(), serial);
            smsService.sendSms(this.sharablelink, getCustomerPhone(), getCustomerName());
        }

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (TwilioRestException e) {
            e.printStackTrace();
        }


        List<TemporaryItem> items = temporaryItemService.findAll();
        for(TemporaryItem item : items){
            temporaryItemService.delete(item);
        }

        List<TemporaryCustomer> customers = temporaryCustomerService.findAll();
        for(TemporaryCustomer customer : customers){
            temporaryCustomerService.delete(customer);
        }

        customerPane.setVisible(false);
        stageManager.switchScene(FxmlView.HOME);
    }

    private String getSubCompanyName(){
        TemporaryData temporaryData  = temporaryDataService.getDataById(1);
        return temporaryData.getBranchName();
    }

    private String getCustomerID() {
        return txtcusid.getText();
    }

    private String getCustomerName() {
        return txtcusname.getText();
    }

    private String getCustomerAddress() {
        return txtcusaddress.getText();
    }

    private String getCustomerEmail() {
        return txtcusemail.getText();
    }

    private String getCustomerPhone() {
        return txtcusphone.getText();
    }


    private void setCustomerName(String cusnme) {
         txtcusname.setText(cusnme);
    }

    private void setCustomerAddress(String cusaddress) {
        txtcusaddress.setText(cusaddress);
    }

    private void setCustomerEmail(String cusemail) {
        txtcusemail.setText(cusemail);
    }

    private void setCustomerPhone(String cusphone) {
        txtcusphone.setText(cusphone);
    }

    private Float getPayedAmount() {
        return Float.valueOf(lablePayableAmount.getText());
    }


//    @FXML
//    private void btnsentdata(MouseEvent event) throws MessagingException, InterruptedException, TwilioRestException, IOException {
//
//        getCompanyEmail();
//
//        this.varcusemail = cusemail.getText();
//        this.varcusphone = cusphone.getText();
//        this.varcusname = cusname.getText();
//        System.out.println("serial : " + getSerialNumber());
//        System.out.println(this.varcusemail + getSerialNumber());
//        System.out.println(this.sharablelink+this.varcusphone+this.varcusname);
//        TimeUnit.SECONDS.sleep(5);
//
//        updatingService.setInvoice(getSerialNumber(),getSingerItems());
//        checkUserSelection(this.checkemail.isSelected(), this.checksms.isSelected(), getCustomerEmail(), getSerialNumber(), getSharableLink(), getCustomerPhone(), getCustomerName());
//
//        inputPane.setVisible(Boolean.FALSE);
//        stageManager.switchScene(FxmlView.HOME);
//
//    }

//    @FXML
//    private void btnnextstep(MouseEvent event) {
//        panecheckitem.setVisible(false);
//        panename.setVisible(true);
//    }
//
//    @FXML
//    private void btnbackcname(MouseEvent event) {
//        panecheckitem.setVisible(true);
//        panename.setVisible(false);
//    }
//
//
//    @FXML
//    private void btnname(MouseEvent event) {
//        panename.setVisible(false);
//        paneid.setVisible(true);
//    }
//
//    @FXML
//    private void btnbackcid(MouseEvent event) {
//        panename.setVisible(true);
//        paneid.setVisible(false);
//    }
//
//    @FXML
//    private void btnpayamount(MouseEvent event){
//        //panepayamount.setVisible(false);
//        //sendpane.setVisible(true);
//
//        //Connect DB Class
//        this.singerItems = getSingerItems();
//
//        this.singerItems.setCustomerName(getCustomerName());
//        this.singerItems.setCustomerId(getCustomerId());
//        this.singerItems.setCusEmail(getCustomerEmail());
//        this.singerItems.setCustomerAddress(getCustomerAddress());
//        this.singerItems.setPhoneNumber(getCustomerPhone());
//        this.singerItems.setDateBuy(getCustomerDate());
//        this.singerItems.setPayMethod(getCustomerPayMethod());
//        this.singerItems.setDownPayment(getCustomerDownPay());
//        this.singerItems.setMonthlyPayment(getCustomerMonthlyPay());
//        this.singerItems.setCustomerId(getCustomerId());
//        this.singerItems.setPayableAmount(getCustomerPayAmount());
//        this.singerItems.setSold(getSoldChecking());
//        this.singerItems.setInvoiceNo(getInvoiceNumber());
//
//        singerItemService.save(this.singerItems);
//
//        alertService.saveAlert();
//        alertService.showValueAlert(getSerialNumber(), false);
//
//    }


//
//    @FXML
//    private void btnrefresh(MouseEvent event) throws IOException {
//
//        setInvoiceImageView();
//        createRootFolder("WarrantySystem");
//        uploadFile("C://WarrantySystem/QRCodes/" + getSerialNumber() + ".png");
//
//    }
//
    public String getCompanyEmail(){
        return temporaryDataService.getDataById(1).getEmail();

    }

    private void setInvoiceImageView(){
        File file1 = new File("C:\\WarrantySystem\\Invoice_Image\\" + getSerialNumber() + ".png");
        Image invoiceImg = new Image(file1.toURI().toString());
        //invoiceimageview.setImage(invoiceImg);
    }

    private void createRootFolder(String folderName) throws IOException {

        List<com.google.api.services.drive.model.File> rootGoogleFolders = googleDriveService.getGoogleRootFoldersByName(folderName);
        for (com.google.api.services.drive.model.File folder : rootGoogleFolders) {
            System.out.println("Folder ID: " + folder.getId() + " --- Name: " + folder.getName());
            this.folderid = folder.getId();
        }
        System.out.println(this.folderid);
        System.out.println("Done!");
    }

    private void uploadFile(String path) throws IOException {
        File uploadFile = new File(path);
        com.google.api.services.drive.model.File googleFile = googleDriveService.createGoogleFile(this.folderid, "image/png",getSerialNumber() + ".png", uploadFile);

        System.out.println("Upload QR Code file!");

        this.sharablelink = googleFile.getWebViewLink();
        System.out.println("WebContentLink: " + googleFile.getWebContentLink());
        System.out.println("WebViewLink: " + this.sharablelink);

        System.out.println("Done!");
    }

    private String getSharableLink(){
        return this.sharablelink;
    }


//
//
//
//
//
//    private void checkUserSelection(boolean checkEmail, boolean checkSMS, String email, String serial, String sharableLink, String phone, String name) throws TwilioRestException, MessagingException {
//        if(checkEmail && checkSMS){
//            emailService.sendEmailImage(email, serial);
//            smsService.sendSms(sharableLink, phone, name);
//        } else if(checkEmail) {
//            emailService.sendEmailImage(email, serial);
//        }else if(checkSMS) {
//            emailService.sendEmailImage(email, serial);
//        }else{
//            System.out.println("Nothing Select");
//        }
//    }

//    private SingerItems getSingerItems(){
//        return singerItemService.findBySerialNumber(getSerialNumber());
//    }
//
//    private String getCustomerEmail() {
//        return cusemail.getText();
//    }
//
//    private String getCustomerPhone() {
//        return cusphone.getText();
//    }
//
//    private String getCustomerName() {
//        return cusname.getText();
//    }
//
//    private String getCustomerId() {
//        return cusid.getText();
//    }
//
//    private String getCustomerAddress() {
//        return cusaddress.getText();
//    }
//
//    private String getCustomerPayMethod() {
//        return cuspaymethod.getValue();
//    }
//
//    private float getCustomerDownPay() { return Float.parseFloat(cusdownpay.getText()); }
//
//    private float getCustomerMonthlyPay() { return Float.parseFloat(cusmonthly.getText()); }
//
//    private float getCustomerPayAmount() { return Float.parseFloat(payamount.getText()); }
//
//    private String getSoldChecking() { return "YES"; }
//
//    private Date getCustomerDate() {
//        return Date.valueOf(cusbuy.getValue());
//    }




//
//    private String getInvoiceNumber() { return this.serialNumber; }
//
//    private boolean getCheckEmail(){
//        return this.checkemail.isSelected();
//    }
//
//    private boolean getCheckSMS(){
//        return this.checksms.isSelected();
//    }

}


