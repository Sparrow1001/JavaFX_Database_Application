package Domain.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Products implements Entity {

    private int productCode;
    private String productName;
    private String additionalInfo;
    private int valueOfProduct;

    public Products(int productCode, String productName, String additionalInfo, int valueOfProduct) {
        this.productCode = productCode;
        this.productName = productName;
        this.additionalInfo = additionalInfo;
        this.valueOfProduct = valueOfProduct;
    }

    public Products() {
    }

    public final static ArrayList<String> LIST_OF_ATTRIBUTES = new ArrayList<>(Arrays.asList(
            "productCode", "productName", "additionalInfo", "valueOfProduct"
    ));

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public int getValueOfProduct() {
        return valueOfProduct;
    }

    public void setValueOfProduct(int valueOfProduct) {
        this.valueOfProduct = valueOfProduct;
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
        this.productCode = Integer.parseInt(params.get(0));
        this.productName = params.get(1);
        this.additionalInfo = params.get(2);
        this.valueOfProduct = Integer.parseInt(params.get(3));
        return this;
    }

    @Override
    public Integer getPrimaryKey() {
        return this.productCode;
    }
}
