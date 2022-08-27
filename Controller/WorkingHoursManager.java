package Controller;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import Interface.*;
import Model.*;

public class WorkingHoursManager implements ActionWorkingHours<WorkingHours, Employee> {

    @Override
    public Object add(ArrayList<WorkingHours> list) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean edit(ArrayList<WorkingHours> list) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(ArrayList<WorkingHours> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Working Hours ID: ");
        String WorkingHoursID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWorkingHoursID().equals(WorkingHoursID)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void show(ArrayList<WorkingHours> list) {
        if (list.size() == 0) {
            System.out.println("No data");
        } else {
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "ID", "Employee ID",
                    "Employee Name", "Start Date", "End Date", "Day Off", "Total Days");
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "---------", "--------------",
                    "-----------------", "---------------------", "---------", "--------", "---------");
            for (int i = 0; i < list.size(); i++) {
                // Calculate working days
                Date startDate = list.get(i).getStartDate();
                Date endDate = list.get(i).getEndDate();
                long days = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
                long getTotalDays = days - list.get(i).getDayOff();
                System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", list.get(i).getWorkingHoursID(),
                        list.get(i).getEmp().getEmpID(), list.get(i).getEmp().getEmpName(), list.get(i).getStartDate(),
                        list.get(i).getEndDate(), list.get(i).getDayOff(), getTotalDays);
            }
        }
    }

    @Override
    public void search(ArrayList<WorkingHours> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        String empID = sc.nextLine();
        if (checkID(list, empID)) {
            System.out.println("Not found!");
        } else {
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "ID", "Employee ID",
                    "Employee Name", "Start Date", "End Date", "Day Off", "Total Days");
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "---------", "------------------",
                    "-----------------", "------------------------------", "------------------------------", "--------",
                    "---------");
            for (int i = 0; i < list.size(); i++) {
                // Calculate working days
                Date startDate = list.get(i).getStartDate();
                Date endDate = list.get(i).getEndDate();
                long days = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
                long getTotalDays = days - list.get(i).getDayOff();
                System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", list.get(i).getWorkingHoursID(),
                        list.get(i).getEmp().getEmpID(), list.get(i).getEmp().getEmpName(), list.get(i).getStartDate(),
                        list.get(i).getEndDate(), list.get(i).getDayOff(), getTotalDays);
            }
        }
    }

    @Override
    public boolean checkID(ArrayList<WorkingHours> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWorkingHoursID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public WorkingHours add(ArrayList<WorkingHours> list, ArrayList<Employee> list2) {
        WorkingHours wh = new WorkingHours();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Working Hours ID: ");
        String whID = sc.nextLine();
        while (checkID(list, whID)) {
            System.out.println("Working Hours ID is Invalid! Please Enter Working Hours ID again: ");
            whID = sc.nextLine();
        }
        while (whID.contains(" ") || whID.equals("")) {
            System.out.println("[SOS]   *Please don't enter space! Please Enter Working Hours ID again* ");
            whID = sc.nextLine();
        }
        wh.setWorkingHoursID(whID);
        System.out.println("Enter Employee ID: ");
        String empID = sc.nextLine();
        int countwh = 0;
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getEmpID().equals(empID)) {
                wh.setEmp(list2.get(i));
            } else {
                countwh++;
            }
        }

        if (countwh == 0) {
            System.out.println("Employee ID is Invalid! Please Enter Employee ID again: ");
            empID = sc.nextLine();
            while (checkID(list, empID)) {
                System.out.println("Employee ID is Invalid! Please Enter Employee ID again: ");
                empID = sc.nextLine();
            }
            while (empID.contains(" ") || empID.equals("")) {
                System.out.println("[SOS]   *Please don't enter space! Please Enter Employee ID again* ");
                empID = sc.nextLine();
            }
        }
        System.out.println("Enter Working Hours Start Date (dd/MM/yyyy): ");
        String whStartDate = sc.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date startTime = null;
        try {
            startTime = format.parse(whStartDate);
        } catch (Exception e) {
            System.out.println("Invalid Date Format");
        }
        wh.setStartDate(startTime);
        System.out.println("Enter Working Hours End Date (dd/MM/yyyy): ");
        String whEndDate = sc.nextLine();
        Date endTime = null;
        try {
            endTime = format.parse(whEndDate);
            // End Date must be greater than Start Date
            if (endTime.compareTo(startTime) < 1) {
                System.out.println("End Date must be greater than Start Date");
                whEndDate = sc.nextLine();
                endTime = format.parse(whEndDate);
            }

        } catch (Exception e) {
            System.out.println("Invalid Date Format");
        }
        wh.setEndDate(endTime);
        System.out.println("Enter Working Hours Day Off: ");
        int whDayOff = sc.nextInt();
        wh.setDayOff(whDayOff);
        return wh;
    }

    @Override
    public boolean edit(ArrayList<WorkingHours> list, ArrayList<Employee> list2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Working Hours ID: ");
        String whID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWorkingHoursID().equals(whID)) {
                System.out.println("Enter Employee ID: ");
                String empID = sc.nextLine();
                int countwh = 0;
                for (int j = 0; j < list2.size(); j++) {
                    if (list2.get(j).getEmpID().equals(empID)) {
                        list.get(i).setEmp(list2.get(j));
                    } else {
                        countwh++;
                    }
                }
                if (countwh == 0) {
                    System.out.println("Employee ID is Invalid! Please Enter Employee ID again: ");
                    empID = sc.nextLine();
                    while (checkID(list, empID)) {
                        System.out.println("Employee ID is Invalid! Please Enter Employee ID again: ");
                        empID = sc.nextLine();
                    }
                    while (empID.contains(" ") || empID.equals("")) {
                        System.out.println("[SOS]   *Please don't enter space! Please Enter Employee ID again* ");
                        empID = sc.nextLine();
                    }
                }
                System.out.println("Enter Working Hours Start Date (dd/MM/yyyy): ");
                String whStartDate = sc.nextLine();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date startTime = null;
                try {
                    startTime = format.parse(whStartDate);
                } catch (Exception e) {
                    System.out.println("Invalid Date Format");
                }
                list.get(i).setStartDate(startTime);
                System.out.println("Enter Working Hours End Date (dd/MM/yyyy): ");
                String whEndDate = sc.nextLine();
                Date endTime = null;
                try {
                    endTime = format.parse(whEndDate);
                } catch (Exception e) {
                    System.out.println("Invalid Date Format");
                }
                list.get(i).setEndDate(endTime);
                System.out.println("Enter Working Hours Day Off: ");
                int whDayOff = sc.nextInt();
                list.get(i).setDayOff(whDayOff);
                return true;
            }
        }

        return false;
    }

}
