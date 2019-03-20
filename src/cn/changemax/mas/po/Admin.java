package cn.changemax.mas.po;

public class Admin {
    private Integer adminId;

    private String adminUsername;

    private String adminPassword;

    private String seniorAdmin;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername == null ? null : adminUsername.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getSeniorAdmin() {
        return seniorAdmin;
    }

    public void setSeniorAdmin(String seniorAdmin) {
        this.seniorAdmin = seniorAdmin == null ? null : seniorAdmin.trim();
    }
}