package Domain.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Documents implements Entity {
    private Integer documentCode;
    private Date date;
    private String supplierCode;
    private String recipientCode;
    private Integer codeOfStuff;
    private Integer codeOfProduct;
    private Integer docTypeCode;
    private Integer valueOfProduct;
    private Integer count;

    public Documents(Integer documentCode, Date date, String supplierCode, String recipientCode, Integer codeOfStuff, Integer codeOfProduct, Integer docTypeCode, Integer valueOfProduct, Integer count) {
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

    public Documents() {
    }

    public final static ArrayList<String> LIST_OF_ATTRIBUTES = new ArrayList<>(Arrays.asList(
            "documentCode", "date", "supplierCode", "recipientCode", "codeOfStuff", "CodeOfProduct", "docTypeCode", "valueOfProduct", "count"
    ));

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

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getRecipientCode() {
        return recipientCode;
    }

    public void setRecipientCode(String recipientCode) {
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

    @Override
    public Integer getCountOfParams() {
        return LIST_OF_ATTRIBUTES.size();
    }

    @Override
    public ArrayList<String> getListOfAttributes() {
        return LIST_OF_ATTRIBUTES;
    }

    @Override
    public Entity setParams(ArrayList<String> params) {
        try{
            this.documentCode = Integer.parseInt(params.get(0));
            this.date = Date.valueOf(params.get(1));
            if (params.get(2) != null){
            this.supplierCode = params.get(2);}
            if (params.get(3) != null){
            this.recipientCode = params.get(3);}
            this.codeOfStuff = Integer.parseInt(params.get(4));
            this.codeOfProduct = Integer.parseInt(params.get(5));
            this.docTypeCode = Integer.parseInt(params.get(6));
            this.valueOfProduct = Integer.parseInt(params.get(7));
            this.count = Integer.parseInt(params.get(8));

        }catch (NumberFormatException | NullPointerException e){
            System.out.println(e.getMessage());
        }
        return this;
    }

    @Override
    public Integer getPrimaryKey() {
        return this.documentCode;
    }
}
