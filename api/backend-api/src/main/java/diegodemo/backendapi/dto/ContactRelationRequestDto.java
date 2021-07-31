package diegodemo.backendapi.dto;

public class ContactRelationRequestDto {
    String contactUsername;
    String requestUsername;
    String relation;
    String acquaintanceDate;

    public ContactRelationRequestDto() {
    }

    public ContactRelationRequestDto(String contactUsername, String requestUsername, String relation, String acquaintanceDate) {
        this.contactUsername = contactUsername;
        this.requestUsername = requestUsername;
        this.relation = relation;
        this.acquaintanceDate = acquaintanceDate;
    }

    public String getContactUsername() {
        return contactUsername;
    }

    public void setContactUsername(String contactUsername) {
        this.contactUsername = contactUsername;
    }

    public String getRequestUsername() {
        return requestUsername;
    }

    public void setRequestUsername(String requestUsername) {
        this.requestUsername = requestUsername;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getAcquaintanceDate() {
        return acquaintanceDate;
    }

    public void setAcquaintanceDate(String acquaintanceDate) {
        this.acquaintanceDate = acquaintanceDate;
    }

    @Override
    public String toString() {
        return "ContactRelationRequestDto{" +
                "contactUsername='" + contactUsername + '\'' +
                ", requestUsername='" + requestUsername + '\'' +
                ", relation='" + relation + '\'' +
                ", acquaintanceDate='" + acquaintanceDate + '\'' +
                '}';
    }
}
