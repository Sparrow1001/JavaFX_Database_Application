package Domain.Model;

import java.sql.Date;

public class Stuff {

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
}
