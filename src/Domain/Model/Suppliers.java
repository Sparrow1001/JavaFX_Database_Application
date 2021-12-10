package Domain.Model;

public class Suppliers {

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
}
