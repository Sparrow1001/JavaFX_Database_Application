package Domain.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Positions implements Entity {

    private int positionCode;
    private String positionName;

    public Positions(int positionCode, String positionName) {
        this.positionCode = positionCode;
        this.positionName = positionName;
    }

    public Positions() {
    }

    public final static ArrayList<String> LIST_OF_ATTRIBUTES = new ArrayList<>(Arrays.asList(
            "positionCode", "positionName"
    ));

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
        this.positionCode = Integer.parseInt(params.get(0));
        this.positionName = params.get(1);
        return this;
    }

    @Override
    public Integer getPrimaryKey() {
        return this.positionCode;
    }
}
