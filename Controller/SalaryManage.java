package Controller;

import Interface.ActionSalary;
import Model.*;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SalaryManage implements ActionSalary<Salary, WorkingHours> {

    @Override
    public Object add(ArrayList<Salary> list) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean edit(ArrayList<Salary> list) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(ArrayList<Salary> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Salary ID: ");
        String SalaryID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSalaryID().equals(SalaryID)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void show(ArrayList<Salary> list) {
        if (list.size() == 0) {
            System.out.println("No data");
        } else {
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "ID", "Employee ID",
                    "Employee Name", "Start Date", "End Date", "Day Off", "Total Days");
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "---------", "--------------",
                    "-----------------", "---------------------", "---------", "--------", "---------");
            for (int i = 0; i < list.size(); i++) {
                // Calculate working days
                Date startDate = list.get(i).workingHoursID.getStartDate();
                Date endDate = list.get(i).workingHoursID.getEndDate();
                long days = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
                long getTotalDays = days - list.get(i).workingHoursID.getDayOff();
                System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", list.get(i).getSalaryID(),
                        list.get(i).workingHoursID.getEmp().getEmpID(),
                        list.get(i).workingHoursID.getEmp().getEmpName(), list.get(i).workingHoursID.getStartDate(),
                        list.get(i).workingHoursID.getEndDate(), list.get(i).workingHoursID.getDayOff(), getTotalDays);
            }
        }

    }

    @Override
    public void search(ArrayList<Salary> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Working ID: ");
        String workingID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {

            Date startDate = list.get(i).workingHoursID.getStartDate();
            Date endDate = list.get(i).workingHoursID.getEndDate();
            long days = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
            long getTotalDays = days - list.get(i).workingHoursID.getDayOff();

            if (list.get(i).workingHoursID.getWorkingHoursID().equals(workingID)) {
                System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "ID", "Employee ID",
                        "Employee Name", "Start Date", "End Date", "Day Off", "Total Days");
                System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", list.get(i).getSalaryID(),
                        list.get(i).workingHoursID.getEmp().getEmpID(),
                        list.get(i).workingHoursID.getEmp().getEmpName(), list.get(i).workingHoursID.getStartDate(),
                        list.get(i).workingHoursID.getEndDate(), list.get(i).workingHoursID.getDayOff(),
                        getTotalDays);
            }
        }
    }

    @Override
    public boolean checkID(ArrayList<Salary> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSalaryID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Salary add(ArrayList<Salary> list, ArrayList<WorkingHours> list2) {
        Scanner sc = new Scanner(System.in);
        Salary salary = new Salary();
        System.out.println("Enter Salary ID: ");
        String salaryID = sc.nextLine();
        while (checkID(list, salaryID)) {
            System.out.println("Salary ID is Invalid! Please Enter Salary ID again: ");
            salaryID = sc.nextLine();
        }
        while (salaryID.contains(" ") || salaryID.equals("")) {
            System.out.println("[SOS]   *Please don't enter space! Please Enter Salary ID again* ");
            salaryID = sc.nextLine();
        }
        salary.setSalaryID(salaryID);
        System.out.println("Enter Working ID: ");
        String workingID = sc.nextLine();
        boolean check = true;
        while (check) {
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i).getWorkingHoursID().equals(workingID)) {
                    salary.setWorkingHoursID(list2.get(i));
                    check = false;
                }
            }
            if (check) {
                System.out.println("Working ID is Invalid! Please Enter Working ID again: ");
                workingID = sc.nextLine();
            }
        }
        System.out.println("Enter Date Of Receip (dd/MM/yyyy): ");
        String localDate = sc.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date timereceip = null;
        try {
            timereceip = format.parse(localDate);
        } catch (Exception e) {
            System.out.println("Invalid Date Format");
        }
        salary.setDoReceip(timereceip);
        return salary;
    }

    @Override
    public boolean edit(ArrayList<Salary> list, ArrayList<WorkingHours> list2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Salary ID: ");
        String salaryID = sc.nextLine();
        while (!checkID(list, salaryID)) {
            System.out.println("Salary ID is Invalid! Please Enter Salary ID again: ");
            salaryID = sc.nextLine();
        }
        while (salaryID.contains(" ") || salaryID.equals("")) {
            System.out.println("[SOS]   *Please don't enter space! Please Enter Salary ID again* ");
            salaryID = sc.nextLine();
        }
        System.out.println("Enter Working ID: ");
        String workingID = sc.nextLine();
        boolean check = true;
        while (check) {
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i).getWorkingHoursID().equals(workingID)) {
                    list.get(i).setWorkingHoursID(list2.get(i));
                    check = false;
                }
            }
            if (check) {
                System.out.println("Working ID is Invalid! Please Enter Working ID again: ");
                workingID = sc.nextLine();
            }
        }
        System.out.println("Enter Date Of Receip (dd/MM/yyyy): ");
        String localDate = sc.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date timereceip = null;
        try {
            timereceip = format.parse(localDate);
        } catch (Exception e) {
            System.out.println("Invalid Date Format");

        }
        list.get(0).setDoReceip(timereceip);
        return true;
    }

}
