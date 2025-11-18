package feedbackservice.infrastructure.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feedback")
public class FeedbackDocument {
    @Id
    private String id;
    private Integer rating;
    private String feedback;
    private String customer;
    private String product;
    private String vendor;

    public FeedbackDocument(String id, Integer rating, String feedback, String customer, String product, String vendor) {
        this.id = id;
        this.rating = rating;
        this.feedback = feedback;
        this.customer = customer;
        this.product = product;
        this.vendor = vendor;
    }

    public String getId() {
        return id;
    }
    public Integer getRating() {
        return rating;
    }
    public String getFeedback() {
        return feedback;
    }
    public String getCustomer() {
        return customer;
    }
    public String getProduct() {
        return product;
    }
    public String getVendor() {
        return vendor;
    }
}
