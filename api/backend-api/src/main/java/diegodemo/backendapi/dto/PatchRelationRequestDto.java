package diegodemo.backendapi.dto;

public class PatchRelationRequestDto {
    String acquaintanceDate;

    public PatchRelationRequestDto() {
    }

    public PatchRelationRequestDto(String acquaintanceDate) {
        this.acquaintanceDate = acquaintanceDate;
    }

    public String getAcquaintanceDate() {
        return acquaintanceDate;
    }

    public void setAcquaintanceDate(String acquaintanceDate) {
        this.acquaintanceDate = acquaintanceDate;
    }
}
