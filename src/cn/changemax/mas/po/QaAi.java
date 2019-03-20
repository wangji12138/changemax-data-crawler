package cn.changemax.mas.po;

public class QaAi extends QaAiKey {
    private String qaId;

    private Integer code;

    public String getQaId() {
        return qaId;
    }

    public void setQaId(String qaId) {
        this.qaId = qaId == null ? null : qaId.trim();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}