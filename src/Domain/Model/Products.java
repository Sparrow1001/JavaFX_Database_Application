package Domain.Model;

public class Products {

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
}
