package com.sarc.bean;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

/**
 * @author Sarc
 * @since 24-03-2019
 */

@Entity
@Table(name="singer_items")
public class SingerItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private int id;

	@Column(name = "Branch_ID", nullable = false)
	private int branchId;

	@Column(name = "Branch_Name")
	private String branchName;

	@Column(name = "Serial_Number")
	private String serialNumber;

	@Column(name = "ItemType_ID")
	private String itemTypeId;

	@Column(name = "ItemType_Name")
	private String itemTypeName;

	@Column(name = "ItemBrand_ID")
	private String itemBrandId;

	@Column(name = "ItemBrand_Name")
	private String 	itemBrandName;

	@Column(name = "Amount")
	private double amount;

	@Column(name = "Buy_Amount")
	private double buyAmount;

	@Column(name = "Warranty_Hardware")
	private String warrantyHardware;

	@Column(name = "Warranty_Software")
	private String warrantySoftware;

	@Column(name = "Customer_ID")
	private String customerId;

	@Column(name = "Customer_Name")
	private String customerName;

	@Column(name = "Cus_Email")
	private String cusEmail;

	@Column(name = "Customer_Address")
	private String customerAddress;

	@Column(name = "Phone_Number")
	private String phoneNumber;

	@Column(name = "Pay_Method")
	private String payMethod;

	@Column(name = "Date_buy")
	private Date dateBuy;

	@Column(name = "Down_Payment")
	private double downPayment;

	@Column(name = "Monthly_Payment")
	private double monthlyPayment;

	@Column(name = "Payable_Amount")
	private double payableAmount;

	@Column(name = "Expire")
	private String 	expire;

	@Column(name = "Sold")
	private String sold;

	@Column(name = "Repair")
	private int repair;

	@Column(name = "QRCode")
	private Blob qrCode;

	@Column(name = "Invoice_Image")
	private byte[] invoice_image;

	@Column(name = "Invoice_Pdf")
	private byte[] invoice_pdf;

	@Column(name = "Invoice_No")
	private String invoiceNo;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(String itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public String getItemBrandId() {
		return itemBrandId;
	}

	public void setItemBrandId(String itemBrandId) {
		this.itemBrandId = itemBrandId;
	}

	public String getItemBrandName() {
		return itemBrandName;
	}

	public void setItemBrandName(String itemBrandName) { this.itemBrandName = itemBrandName; }

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(double buyAmount) {
		this.buyAmount = buyAmount;
	}

	public String getWarrantyHardware() {
		return warrantyHardware;
	}

	public void setWarrantyHardware(String warrantyHardware) {
		this.warrantyHardware = warrantyHardware;
	}

	public String getWarrantySoftware() {
		return warrantySoftware;
	}

	public void setWarrantySoftware(String warrantySoftware) {
		this.warrantySoftware = warrantySoftware;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public Date getDateBuy() {
		return dateBuy;
	}

	public void setDateBuy(Date dateBuy) {
		this.dateBuy = dateBuy;
	}

	public double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public double getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}

	public String getExpire() { return expire; }

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public String getSold() {
		return sold;
	}

	public void setSold(String sold) {
		this.sold = sold;
	}

	public int getRepair() {
		return repair;
	}

	public void setRepair(int repair) {
		this.repair = repair;
	}

	public Blob getQrCode() {
		return qrCode;
	}

	public void setQrCode(Blob qrCode) {
		this.qrCode = qrCode;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public byte[] getInvoice_image() {
		return invoice_image;
	}

	public void setInvoice_image(byte[] invoice_image) {
		this.invoice_image = invoice_image;
	}

	public byte[] getInvoice_pdf() {
		return invoice_pdf;
	}

	public void setInvoice_pdf(byte[] invoice_pdf) {
		this.invoice_pdf = invoice_pdf;
	}

	@Override
	public String toString() {
		return "SingerItems{" +
				"id=" + id +
				", branchId=" + branchId +
				", branchName='" + branchName + '\'' +
				", serialNumber='" + serialNumber + '\'' +
				", itemTypeId='" + itemTypeId + '\'' +
				", itemTypeName='" + itemTypeName + '\'' +
				", itemBrandId='" + itemBrandId + '\'' +
				", itemBrandName='" + itemBrandName + '\'' +
				", amount=" + amount +
				", buyAmount=" + buyAmount +
				", warrantyHardware='" + warrantyHardware + '\'' +
				", warrantySoftware='" + warrantySoftware + '\'' +
				", customerId='" + customerId + '\'' +
				", customerName='" + customerName + '\'' +
				", cusEmail='" + cusEmail + '\'' +
				", customerAddress='" + customerAddress + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", payMethod='" + payMethod + '\'' +
				", dateBuy=" + dateBuy +
				", downPayment=" + downPayment +
				", monthlyPayment=" + monthlyPayment +
				", payableAmount=" + payableAmount +
				", expire='" + expire + '\'' +
				", sold='" + sold + '\'' +
				", repair=" + repair +
				", qrCode=" + qrCode +
				", invoiceNo='" + invoiceNo + '\'' +
				'}';
	}
}
