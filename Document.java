import java.util.List;

public class Document {

    String documentId;
    List<Signer> signers;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public List<Signer> getSigners() {
        return signers;
    }

    public void setSigners(List<Signer> signers) {
        this.signers = signers;
    }

    public Document(String documentId, List<Signer> signers) {
        this.documentId = documentId;
        this.signers = signers;
    }
}
