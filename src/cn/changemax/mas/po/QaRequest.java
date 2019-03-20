package cn.changemax.mas.po;

public class QaRequest {
    private String qaRequestId;

    private String qaRequestUserId;

    private String textId;

    public String getQaRequestId() {
        return qaRequestId;
    }

    public void setQaRequestId(String qaRequestId) {
        this.qaRequestId = qaRequestId == null ? null : qaRequestId.trim();
    }

    public String getQaRequestUserId() {
        return qaRequestUserId;
    }

    public void setQaRequestUserId(String qaRequestUserId) {
        this.qaRequestUserId = qaRequestUserId == null ? null : qaRequestUserId.trim();
    }

    public String getTextId() {
        return textId;
    }

    public void setTextId(String textId) {
        this.textId = textId == null ? null : textId.trim();
    }
}