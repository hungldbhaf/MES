package Interface;

import Model.Admin;

public interface AdminBuilder {
    AdminBuilder setID(String adminID);

    AdminBuilder setName(String adminName);

    AdminBuilder setEmail(String adminEmail);

    AdminBuilder setPhone(int adminPhone);

    AdminBuilder setRole(String adminRole);

    Admin build();

}
