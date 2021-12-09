package Domain.Model;

public class Recipients {

    private int recipientCode;
    private String companyName;
    private String address;
    private String inn;

    public Recipients(int recipientCode, String companyName, String address, String inn) {
        this.recipientCode = recipientCode;
        this.companyName = companyName;
        this.address = address;
        this.inn = inn;
    }

    public int getRecipientCode() {
        return recipientCode;
    }

    public void setRecipientCode(int recipientCode) {
        this.recipientCode = recipientCode;
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
