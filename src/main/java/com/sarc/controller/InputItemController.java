package com.sarc.controller;

import com.google.zxing.WriterException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sarc.bean.*;
import com.sarc.config.StageManager;
import com.sarc.generic.ListService;
import com.sarc.service.*;
import com.sarc.view.FxmlView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import static java.lang.Float.parseFloat;

//import org.apache.commons.io.FileUtils;

@Controller
public class InputItemController implements Initializable {

    private ObservableList<String> listtype = new ListService().getListtype();
    private ObservableList<String> brandtype_lap = new ListService().getBrandtype_lap();
    private ObservableList<String> brandtype_phone = new ListService().getBrandtype_phone();
    private ObservableList<String> brandtype_Keybourd = new ListService().getBrandtype_Keybourd();
    private ObservableList<String> brandtype_Mouse = new ListService().getBrandtype_Mouse();
    private ObservableList<String> brandtype_Pen = new ListService().getBrandtype_Pen();

    private ObservableList<String> listhardware = new ListService().getListhardware();
    private ObservableList<String> listsoftware = new ListService().getListsoftware();
    @FXML
    private JFXComboBox<String> servicewar;
    @FXML
    private JFXComboBox<String> hardwarewar;

    @FXML
    private Pane namebox;
    @FXML
    private Pane brandbox;
    @FXML
    private Pane serialbox;
    @FXML
    private Pane supplierbox;
    @FXML
    private Pane warrantybox;
    @FXML
    private Pane buyamountbox;
    @FXML
    private Pane sellamountbox;

    @FXML
    private JFXButton btnWarranty;
    @FXML
    private AnchorPane newItemPane;
    @FXML
    private JFXComboBox<String> brandtype;
    @FXML
    private JFXComboBox<String> typename;

    @FXML
    private JFXTextField serialid;

    @FXML
    private JFXTextField txtbuyamount;
    @FXML
    private JFXTextField txtsupplierName;
    @FXML
    private JFXTextField txtsupplier_phone;
    @FXML
    private JFXTextField txtsupplier_address;

    @FXML
    private JFXTextField txtdiscount;
    @FXML
    private JFXTextField txtsellamount;
    @FXML
    private JFXTextField txtdownpay;
    @FXML
    private JFXTextField txtmonthpay;
    @FXML
    private JFXTextField txtinterest;


    @Autowired
    private CompanyService companyService;

    @Autowired
    private AlertService alertService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CheckingService checkingService;

    @Autowired
    private SingerItemService singerItemService;

    @Autowired
    private SelectiveService selectiveService;

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private TemporaryDataService temporaryDataService;

    @Autowired
    private ConvertingService convertingService;

    @Autowired
    private Item_CategoryService item_categoryService;

    @Autowired
    private Item_BrandService item_brandService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private Item_Sell_AmountService item_sell_amountService;

    @Autowired
    private ItemService itemService;

    @Lazy
    @Autowired
    private StageManager stageManager;

    private int branchId;
    private String branchName;
    private String serialNumber;


    private Item_Brand item_brand_table;
    private Item_Category item_category_table;
    private Item_Sell_Amount item_sell_amount_table;
    private Supplier supplier_table;

    private boolean checkSupplier = false;
    private boolean checkSellAmount = false;
    private boolean checkCategory = false;
    private boolean checkBrand = false;

    private int item_category_id;
    private int item_brand_id;
    private int item_sell_amount_id;
    private int supplier_id;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        typename.setItems(listtype);
        hardwarewar.setItems(listhardware);
        servicewar.setItems(listsoftware);
        setBranchId();
    }



    @FXML
    private void btnwarranty(ActionEvent event) throws IOException, WriterException {

        getSavedIItemCategory();
        getSavedIItemBrand();
        getSavedSupplier();
        getSavedItemSellAmount();

        setItem_CategoryId();
        setItem_BrandId();
        setSerialNumber(getBranchId(), getItem_CategoryId(),getBrandTypeId(),getSerialId());
        qrCodeService.generateQRCode(getSerialNumber());


        Item item = new Item();
        item.setItem_serial_number(getSerialNumber());
        item.setItem_category_id(this.item_category_id);
        item.setItem_brand_id(this.item_brand_id);
        item.setItem_buy_amount(getBuyAmount());
        item.setItem_sell_amount_id(this.item_sell_amount_id);
        item.setItem_discounts(getDiscount());
        item.setSupplier_id(this.supplier_id);
        item.setItem_warranty_hardware(getHardwareWarranty());
        item.setItem_warranty_software(getSoftwareWarranty());
        item.setItem_qrcode(getQRCodeImage());
        item.setItem_sold(false);
        item.setItem_expire(false);
        //item.setItem_repair(0);

        itemService.save(item);

        alertService.saveAlert();

        newItemPane.setVisible(false);
        stageManager.switchScene(FxmlView.HOME);
    }

    private void setSerialNumber(int branch_id, int item_category_id, int item_brand_id, String serialid){

        this.serialNumber = branch_id + "0" + item_category_id + "0" + item_brand_id + "0" + serialid;
    }

    private String getSerialNumber(){
        return this.serialNumber;
    }

    private void setBranchId() {
        TemporaryData temporaryData = temporaryDataService.getDataById(1);
        this.branchId = temporaryData.getBranchId();
        this.branchName = temporaryData.getBranchName();
    }

    private int getBranchId() {
        return this.branchId;
    }

    private String getBranchName() {
        return this.branchName;
    }

    private String getSerialId() {
        return serialid.getText();
    }

    private String getItem_CategoryName() {
        return typename.getValue();
    }

    private String getBrandTypeName() {
        return brandtype.getValue();
    }

    private void setItem_BrandId() {
        List<Item_Brand> item_brandList = item_brandService.findAll();

        for (Item_Brand item_brand : item_brandList){
            if(getBrandTypeName().equals(item_brand.getItem_brand_name())){
                this.item_brand_id = item_brand.getItem_brand_id();
                break;
            }
        }
    }

    private void setItem_CategoryId() {
        List<Item_Category> item_categoriesList = item_categoryService.findAll();

        for (Item_Category item_category : item_categoriesList){
            if(getItem_CategoryName().equals(item_category.getItem_category_name())){
                this.item_category_id = item_category.getItem_category_id();
                break;
            }
        }
    }

    private int getItem_CategoryId(){
        return this.item_category_id;
    }

    private int getBrandTypeId() {
        return this.item_brand_id;
    }

    private double getDiscount() {
        return parseFloat(txtdiscount.getText());
    }

    private String getHardwareWarranty() {
        return hardwarewar.getValue();
    }

    private String getSoftwareWarranty() {
        return servicewar.getValue();
    }

    private double getBuyAmount() {
        return parseFloat(txtbuyamount.getText());
    }

    private Blob getQRCodeImage() throws IOException {
        String filePath = "C:\\WarrantySystem\\QRCodes\\" + getSerialNumber() + ".png";
        return convertingService.convertFileContentToBlob(filePath);
    }

    private String getSupplierName() {
        return txtsupplierName.getText();
    }

    private String getSupplierPhone() {
        return txtsupplier_phone.getText();
    }

    private String getSupplierAddress() {
        return txtsupplier_address.getText();
    }

    private void setSupplierName(String supplierName) {
        txtsupplierName.setText(supplierName);
    }

    private void setSupplierPhone(String supplier_phone) {
        txtsupplier_phone.setText(supplier_phone);
    }

    private void setSupplierAddress(String supplier_address) { txtsupplier_address.setText(supplier_address); }


    private String getSellamount() {
        return txtsellamount.getText();
    }

    private String getDownpay() {
        return txtdownpay.getText();
    }

    private String getMonthpay() {
        return txtmonthpay.getText();
    }

    private String getInterest() {
        return txtinterest.getText();
    }

    private void setSellamount(double sellamount) {
        txtsellamount.setText(String.valueOf(sellamount));
    }

    private void setDownpay(double downpay) {
        txtdownpay.setText(String.valueOf(downpay));
    }

    private void setMonthpay(double monthpay) { txtmonthpay.setText(String.valueOf(monthpay)); }

    private void setInterest(double interest) { txtinterest.setText(String.valueOf(interest)); }


    @FXML
    private void btnname(ActionEvent event) {

        String type = null;
        setBrand(type);

        namebox.setVisible(false);
        brandbox.setVisible(true);
    }

    @FXML
    private void btnbackModel(MouseEvent event) {
        brandbox.setVisible(false);
        namebox.setVisible(true);
    }

    @FXML
    private void btnModel(MouseEvent event) {
        brandbox.setVisible(false);
        serialbox.setVisible(true);
    }

    @FXML
    private void btnbackserial(MouseEvent event) {
        brandbox.setVisible(true);
        serialbox.setVisible(false);
    }


    @FXML
    private void btnserial(MouseEvent event) {
        serialbox.setVisible(false);
        supplierbox.setVisible(true);
    }

    @FXML
    private void btnbacksupplier(MouseEvent event) {
        serialbox.setVisible(true);
        supplierbox.setVisible(false);
    }


    @FXML
    private void btnsupplier(MouseEvent event) {
        supplierbox.setVisible(false);
        buyamountbox.setVisible(true);
    }

    @FXML
    private void btnbackbuyamount(MouseEvent event) {
        buyamountbox.setVisible(false);
        supplierbox.setVisible(true);
    }

    @FXML
    private void btnbuyamount(MouseEvent event) {
        buyamountbox.setVisible(false);
        sellamountbox.setVisible(true);
    }

    @FXML
    private void btnsellamount(MouseEvent event) {
        sellamountbox.setVisible(false);
        warrantybox.setVisible(true);
    }

    @FXML
    private void btnbacksellamount(MouseEvent event) {

        sellamountbox.setVisible(false);
        buyamountbox.setVisible(true);
    }

    @FXML
    private void btnchecksupplier(MouseEvent event) {

        List<Supplier> supplierList = supplierService.findAll();
        for (Supplier supplier : supplierList){
            if(getSupplierName().equals(supplier.getSupplier_name())){
                setSupplierName(supplier.getSupplier_name());
                setSupplierPhone(supplier.getSupplier_phone());
                setSupplierAddress(supplier.getSupplier_address());
                this.supplier_table = supplier;
                this.checkSupplier = true;
                this.supplier_id = supplier.getSupplier_id();

                break;
            }
        }
        if(!checkSupplier){
            alertService.getDefaultAlert("Warning","Please Add new Supplier");
        }

    }

    @FXML
    private void btnchecksell(MouseEvent event) {

        List<Item_Sell_Amount> item_sell_amountList = item_sell_amountService.findAll();
        for (Item_Sell_Amount item_sell_amount : item_sell_amountList){
            int item_sell_amount_int =(int)item_sell_amount.getItem_sell_amount_value();
            String item_sell_amount_string = Integer.toString(item_sell_amount_int);
            if(getSellamount().equals(item_sell_amount_string)){
                setDownpay(item_sell_amount.getItem_down_payment());
                setMonthpay(item_sell_amount.getItem_monthly_payment());
                setInterest(item_sell_amount.getItem_interes());
                this.item_sell_amount_table = item_sell_amount;
                this.item_sell_amount_id = item_sell_amount.getItem_sell_amount_id();
                this.checkSellAmount = true;
                break;
            }
        }
        if(!checkSellAmount){
            alertService.getDefaultAlert("Warning","Please Add new Sell Amount");
        }

    }

    private Supplier getSavedSupplier(){
        if(this.checkSupplier){
            return this.supplier_table;
        }else {
            Supplier supplier = new Supplier();
            supplier.setSupplier_name(getSupplierName());
            supplier.setSupplier_phone(getSupplierPhone());
            supplier.setSupplier_address(getSupplierAddress());
            supplierService.save(supplier);
            this.supplier_id = supplier.getSupplier_id();
            return supplier;
        }
    }

    private Item_Sell_Amount getSavedItemSellAmount(){
        if(this.checkSellAmount){
            return this.item_sell_amount_table;
        }else {
            Item_Sell_Amount item_sell_amount = new Item_Sell_Amount();
            item_sell_amount.setItem_sell_amount_value(Double.parseDouble(getSellamount()));
            item_sell_amount.setItem_down_payment(Double.parseDouble(getDownpay()));
            item_sell_amount.setItem_monthly_payment(Double.parseDouble(getMonthpay()));
            item_sell_amount.setItem_interes(Double.parseDouble(getInterest()));
            item_sell_amountService.save(item_sell_amount);
            this.item_sell_amount_id = item_sell_amount.getItem_sell_amount_id();
            return item_sell_amount;
        }
    }

    private void checkItemBrand(){

        List<Item_Brand> item_brandList = item_brandService.findAll();
        for (Item_Brand item_brand : item_brandList){
            if(getBrandTypeName().equals(item_brand.getItem_brand_name())){
                this.item_brand_table = item_brand;
                this.checkBrand = true;
                this.item_brand_id = item_brand.getItem_brand_id();
                break;
            }
        }
    }

    private Item_Brand getSavedIItemBrand(){
        checkItemBrand();
        if(this.checkBrand){
            return this.item_brand_table;
        }else {
            Item_Brand item_brand = new Item_Brand();
            item_brand.setItem_brand_name(getBrandTypeName());
            item_brandService.save(item_brand);
            this.item_brand_id = item_brand.getItem_brand_id();
            return item_brand;
        }
    }

    private void checkItemCategory(){

        List<Item_Category> item_categoryList = item_categoryService.findAll();
        for (Item_Category category : item_categoryList){
            if(getItem_CategoryName().equals(category.getItem_category_name())){
                this.item_category_table = category;
                this.checkCategory = true;
                this.item_category_id = category.getItem_category_id();
                break;
            }
        }
    }

    private Item_Category getSavedIItemCategory(){
        checkItemCategory();
        if(this.checkCategory){
            return this.item_category_table;
        }else {
            Item_Category item_category = new Item_Category();
            item_category.setItem_category_name(getItem_CategoryName());
            item_categoryService.save(item_category);
            this.item_category_id = item_category.getItem_category_id();
            return item_category;
        }
    }




    private void setBrand(String type) {
        type = typename.getValue();
        switch (type) {
            case "Laptop":
                brandtype.setItems(brandtype_lap);
                break;
            case "Phone":
                brandtype.setItems(brandtype_phone);
                break;
            case "Keybourd":
                brandtype.setItems(brandtype_Keybourd);
                break;
            case "Mouse":
                brandtype.setItems(brandtype_Mouse);
                break;
            case "Pen_Drive":
                brandtype.setItems(brandtype_Pen);
                break;
            default:
                break;
        }

    }
}
