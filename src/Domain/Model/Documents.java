package Domain.Model;

import java.sql.Date;

public class Documents {
    private int documentCode;
    private Date date;
    private int supplierCode;
    private int recipientCode;
    private int codeOfStuff;
    private int codeOfProduct;
    private int docTypeCode;
    private int valueOfProduct;
    private int count;

    public Documents(int documentCode, Date date, int supplierCode, int recipientCode, int codeOfStuff, int codeOfProduct, int docTypeCode, int valueOfProduct, int count) {
        this.documentCode = documentCode;
        this.date = date;
        this.supplierCode = supplierCode;
        this.recipientCode = recipientCode;
        this.codeOfStuff = codeOfStuff;
        this.codeOfProduct = codeOfProduct;
        this.docTypeCode = docTypeCode;
        this.valueOfProduct = valueOfProduct;
        this.count = count;
    }

    public int getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(int documentCode) {
        this.documentCode = documentCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(int supplierCode) {
        this.supplierCode = supplierCode;
    }

    public int getRecipientCode() {
        return recipientCode;
    }

    public void setRecipientCode(int recipientCode) {
        this.recipientCode = recipientCode;
    }

    public int getCodeOfStuff() {
        return codeOfStuff;
    }

    public void setCodeOfStuff(int codeOfStuff) {
        this.codeOfStuff = codeOfStuff;
    }

    public int getCodeOfProduct() {
        return codeOfProduct;
    }

    public void setCodeOfProduct(int codeOfProduct) {
        this.codeOfProduct = codeOfProduct;
    }

    public int getDocTypeCode() {
        return docTypeCode;
    }

    public void setDocTypeCode(int docTypeCode) {
        this.docTypeCode = docTypeCode;
    }

    public int getValueOfProduct() {
        return valueOfProduct;
    }

    public void setValueOfProduct(int valueOfProduct) {
        this.valueOfProduct = valueOfProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
