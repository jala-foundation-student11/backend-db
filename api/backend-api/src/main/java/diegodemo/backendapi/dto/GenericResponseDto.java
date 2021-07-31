package diegodemo.backendapi.dto;

public class GenericResponseDto {
    String httpStatus;
    String message;

    public GenericResponseDto() {
    }

    public GenericResponseDto(String httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
