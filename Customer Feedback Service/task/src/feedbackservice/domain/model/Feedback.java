package feedbackservice.domain.model;

public class Feedback {
    private String id;
    private Integer rating;
    private String feedback;
    private String customer;
    private String product;
    private String vendor;

    public Feedback(String id, Integer rating, String feedback, String customer, String product, String vendor) {
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

    public void setId(String id) {
        this.id = id;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public void setProduct(String product) {}
    public void setVendor(String vendor) {}

    @Override
    public String toString() {
        return "Feedback{" +
                "id='" + id + '\'' +
                ", rating=" + rating +
                ", feedback='" + feedback + '\'' +
                ", customer='" + customer + '\'' +
                ", product='" + product + '\'' +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
