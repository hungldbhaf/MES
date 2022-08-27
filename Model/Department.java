package Model;

public class Department {
    public String depID;
    public String depName;
    public double depSalary;

    public Department() {

    }

    public Department(String depID, String depName, double depSalary) {
        this.depID = depID;
        this.depName = depName;
        this.depSalary = depSalary;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public double getDepSalary() {
        return depSalary;
    }

    public void setDepSalary(double depSalary) {
        this.depSalary = depSalary;
    }

}
