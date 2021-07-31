package diegodemo.backendapi.dto;

public class RelationResponseDto {
    Integer relationId;
    String requestUsername;
    Integer requestUserId;
    String targetUsername;
    Integer targetUserId;

    public RelationResponseDto() {
    }

    public RelationResponseDto(Integer relationId, String requestUsername, Integer requestUserId, String targetUsername, Integer targetUserId) {
        this.relationId = relationId;
        this.requestUsername = requestUsername;
        this.requestUserId = requestUserId;
        this.targetUsername = targetUsername;
        this.targetUserId = targetUserId;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public String getRequestUsername() {
        return requestUsername;
    }

    public void setRequestUsername(String requestUsername) {
        this.requestUsername = requestUsername;
    }

    public Integer getRequestUserId() {
        return requestUserId;
    }

    public void setRequestUserId(Integer requestUserId) {
        this.requestUserId = requestUserId;
    }

    public String getTargetUsername() {
        return targetUsername;
    }

    public void setTargetUsername(String targetUsername) {
        this.targetUsername = targetUsername;
    }

    public Integer getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(Integer targetUserId) {
        this.targetUserId = targetUserId;
    }
}
