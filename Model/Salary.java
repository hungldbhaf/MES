package Model;

import java.util.Date;

public class Salary {
    public String SalaryID;
    public WorkingHours workingHoursID;
    public Date DoReceip;

    public Salary() {

    }

    public Salary(String SalaryID, WorkingHours workingHoursID, Date DoReceip) {
        this.SalaryID = SalaryID;
        this.workingHoursID = workingHoursID;
        this.DoReceip = DoReceip;
    }

    public String getSalaryID() {
        return SalaryID;
    }

    public void setSalaryID(String SalaryID) {
        this.SalaryID = SalaryID;
    }

    public WorkingHours getWorkingHoursID() {
        return workingHoursID;
    }

    public void setWorkingHoursID(WorkingHours workingHoursID) {
        this.workingHoursID = workingHoursID;
    }

    public Date getDoReceip() {
        return DoReceip;
    }

    public void setDoReceip(Date DoReceip) {
        this.DoReceip = DoReceip;
    }

}
