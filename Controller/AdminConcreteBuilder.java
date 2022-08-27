package Controller;

import Interface.*;
import Model.Admin;

public class AdminConcreteBuilder implements AdminBuilder {
    private String adminID;
    private String adminName;
    private String adminEmail;
    private int adminPhone;
    private String adminRole;

    @Override
    public AdminConcreteBuilder setID(String adminID) {
        this.adminID = adminID;
        return this;
    }

    @Override
    public AdminConcreteBuilder setName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    @Override
    public AdminConcreteBuilder setEmail(String adminEmail) {
        this.adminEmail = adminEmail;
        return this;
    }

    @Override
    public AdminBuilder setPhone(int adminPhone) {
        this.adminPhone = adminPhone;
        return this;
    }

    @Override
    public AdminBuilder setRole(String adminRole) {
        this.adminRole = adminRole;
        return this;
    }

    @Override
    public Admin build() {
        Admin adminsys = new Admin(adminID, adminName, adminEmail, adminPhone, adminRole);
        validateUserObject(adminsys);
        return adminsys;
    }

    private void validateUserObject(Admin adminsys) {

    }

}
