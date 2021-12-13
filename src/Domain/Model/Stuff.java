package Domain.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Stuff implements Entity {

    private int stuffCode;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String address;
    private int positionCode;
    private String phone;

    public Stuff(int stuffCode, String firstName, String lastName, Date birthday, String address, int positionCode, String phone) {
        this.stuffCode = stuffCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.positionCode = positionCode;
        this.phone = phone;
    }

    public Stuff() {
    }

    public final static ArrayList<String> LIST_OF_ATTRIBUTES = new ArrayList<>(Arrays.asList(
            "stuffCode", "firstName", "lastName", "birthday", "address", "positionCode", "phone"
    ));

    public int getStuffCode() {
        return stuffCode;
    }

    public void setStuffCode(int stuffCode) {
        this.stuffCode = stuffCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(int positionCode) {
        this.positionCode = positionCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        this.stuffCode = Integer.parseInt(params.get(0));
        this.firstName = params.get(1);
        this.lastName = params.get(2);
        this.birthday = Date.valueOf(params.get(3));
        this.address = params.get(4);
        this.positionCode = Integer.parseInt(params.get(5));
        this.phone = params.get(6);
        return this;
    }

    @Override
    public Integer getPrimaryKey() {
        return this.positionCode;
    }
}
