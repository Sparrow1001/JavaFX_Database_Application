package Domain.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Suppliers implements Entity {

    private int supplierCode;
    private String companyName;
    private String address;
    private String inn;

    public Suppliers(int supplierCode, String companyName, String address, String inn) {
        this.supplierCode = supplierCode;
        this.companyName = companyName;
        this.address = address;
        this.inn = inn;
    }

    public Suppliers() {
    }

    public final static ArrayList<String> LIST_OF_ATTRIBUTES = new ArrayList<>(Arrays.asList(
            "supplierCode", "companyName", "address", "inn"
    ));

    public int getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(int supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
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
        this.supplierCode = Integer.parseInt(params.get(0));
        this.companyName = params.get(1);
        this.address = params.get(2);
        this.inn = params.get(3);

        return this;
    }

    @Override
    public Integer getPrimaryKey() {
        return this.supplierCode;
    }
}
