package diegodemo.backendapi.dto;

public class ContactResponseDto {
    Integer contactId;
    String firstName;
    String lastName;
    String username;
    String email;
    String dateOfBirth;
    String seed;

    public ContactResponseDto() {
    }

    public ContactResponseDto(Integer contactId, String firstName, String lastName, String username, String email, String dateOfBirth, String seed) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.seed = seed;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }
}
