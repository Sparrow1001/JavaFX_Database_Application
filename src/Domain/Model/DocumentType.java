package Domain.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class DocumentType implements Entity {

    private int typeCode;
    private String typeOfDocument;

    public DocumentType(int typeCode, String typeOfDocument) {
        this.typeCode = typeCode;
        this.typeOfDocument = typeOfDocument;
    }

    public DocumentType() {
    }

    public final static ArrayList<String> LIST_OF_ATTRIBUTES = new ArrayList<>(Arrays.asList(
            "typeCode", "typeOfDocument"
    ));

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeOfDocument() {
        return typeOfDocument;
    }

    public void setTypeOfDocument(String typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
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
        this.typeCode = Integer.parseInt(params.get(0));
        this.typeOfDocument = params.get(1);

        return this;
    }

    @Override
    public Integer getPrimaryKey() {
        return this.typeCode;
    }
}
