import java.util.List;

public class Signer {

    String signerId;
    List<Document> documents;

    public Signer(String signerId, List<Document> documents) {
        this.signerId = signerId;
        this.documents = documents;
    }

    public String getSignerId() {
        return signerId;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void setSignerId(String signerId) {
        this.signerId = signerId;
    }
}
