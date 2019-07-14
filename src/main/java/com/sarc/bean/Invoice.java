package com.sarc.bean;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name="Invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_no_id", nullable = false)
    private int invoice_no_id;

    private String itemSerial;
    private String invoice_no;
    private Blob invoice_pdf;
    private Blob invoice_image;



    public Invoice() {
        super();
    }

    public Invoice(String invoice_no, String itemSerial, Blob invoice_pdf, Blob invoice_image, Set<Main_Table> main_table_invoice) {
        super();
        this.invoice_no = invoice_no;
        this.itemSerial = itemSerial;
        this.invoice_pdf = invoice_pdf;
        this.invoice_image = invoice_image;
    }

    public String getItemSerial() {
        return itemSerial;
    }

    public void setItemSerial(String itemSerial) {
        this.itemSerial = itemSerial;
    }

    public int getInvoice_no_id() {
        return invoice_no_id;
    }

    public void setInvoice_no_id(int invoice_no_id) {
        this.invoice_no_id = invoice_no_id;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    public Blob getInvoice_pdf() {
        return invoice_pdf;
    }

    public void setInvoice_pdf(Blob invoice_pdf) {
        this.invoice_pdf = invoice_pdf;
    }

    public Blob getInvoice_image() {
        return invoice_image;
    }

    public void setInvoice_image(Blob invoice_image) {
        this.invoice_image = invoice_image;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "invoice_no_id=" + invoice_no_id +
                ", invoice_no='" + invoice_no + '\'' +
                ", invoice_pdf=" + invoice_pdf +
                ", invoice_image=" + invoice_image +
                '}';
    }
}
