package Domain.Model;

public class Positions {

    private int positionCode;
    private String positionName;

    public Positions(int positionCode, String positionName) {
        this.positionCode = positionCode;
        this.positionName = positionName;
    }

    public int getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(int positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
