package Domain.Model;

public class DocumentType {

    private int typeCode;
    private int typeOfDocument;

    public DocumentType(int typeCode, int typeOfDocument) {
        this.typeCode = typeCode;
        this.typeOfDocument = typeOfDocument;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public int getTypeOfDocument() {
        return typeOfDocument;
    }

    public void setTypeOfDocument(int typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
    }
}
