package Model;

public class Admin {
    private String adminID;
    private String adminName;
    private String adminEmail;
    private int adminPhone;
    private String adminRole;

    public Admin(String adminID, String adminName, String adminEmail, int adminPhone, String adminRole) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPhone = adminPhone;
        this.adminRole = adminRole;
    }

    @Override
    public String toString() {
        return "Support 24/7:" +
                "\n Admin ID      : " + adminID +
                "\n Admin Name    : " + adminName +
                "\n Admin Email   : " + adminEmail +
                "\n Admin Phone   : " + adminPhone +
                "\n Admin Role    : " + adminRole +
                "\n Please Contact With Manage To Support !   " +
                '\n';
    }

    public String getAdminID() {
        return adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

}
