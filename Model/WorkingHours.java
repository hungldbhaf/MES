package Model;

import java.util.Date;

public class WorkingHours {
    public String workingHoursID;
    public Employee emp;
    public Date startDate;
    public Date endDate;
    public long dayOff;

    public WorkingHours() {
    }

    public WorkingHours(String workingHoursID, Employee emp, Date startDate, Date endDate, long dayOff) {
        this.workingHoursID = workingHoursID;
        this.emp = emp;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayOff = dayOff;
    }

    public String getWorkingHoursID() {
        return workingHoursID;
    }

    public void setWorkingHoursID(String workingHoursID) {
        this.workingHoursID = workingHoursID;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

}
