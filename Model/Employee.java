package Model;

public class Employee {
    public String empID;
    public String empName;
    public String empEmail;
    private Department dep;
    private Position pos;


    public Employee() {
        super();
    }

    public Employee(String empID, String empName, String empEmail, Department dep, Position pos) {
        this.empID = empID;
        this.empName = empName;
        this.empEmail = empEmail;
        this.dep = dep;
        this.pos = pos;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        // Không chọn khoảng trắng

        this.empID = empID;

    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }
}




