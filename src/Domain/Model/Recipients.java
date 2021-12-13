package Domain.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Recipients implements Entity {

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

    public Recipients() {
    }

    public final static ArrayList<String> LIST_OF_ATTRIBUTES = new ArrayList<>(Arrays.asList(
            "recipientCode", "companyName", "address", "inn"
    ));

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
        this.recipientCode = Integer.parseInt(params.get(0));
        this.companyName = params.get(1);
        this.address = params.get(2);
        this.inn = params.get(3);

        return this;
    }

    @Override
    public Integer getPrimaryKey() {
        return this.recipientCode;
    }
}
