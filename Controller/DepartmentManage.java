package Controller;

import Interface.Action;
import Model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentManage implements Action<Department> {
    @Override
    public Department add(ArrayList<Department> list) {
        Department dep = new Department();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Department ID: ");
        String depID = sc.nextLine();
        while (checkID(list, depID)) {
            System.out.println("Department ID is invalid! Please Enter Department ID again: ");
            depID = sc.nextLine();
        }

        while (depID.contains(" ") || depID.equals("")) {
            System.out.println("[SOS]   *Please don't enter space! Please Enter Department ID again* ");
            depID = sc.nextLine();
        }

        dep.setDepID(depID);
        System.out.println("Enter Department name: ");
        String depName = sc.nextLine();
        dep.setDepName(depName);
        System.out.println("Enter Department salary: ");
        Double depSalary = sc.nextDouble();
        dep.setDepSalary(depSalary);
        return dep;
    }

    @Override
    public boolean edit(ArrayList<Department> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter department ID: ");
        String depID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDepID().equals(depID)) {
                System.out.println("Enter department name: ");
                String depName = sc.nextLine();
                System.out.println("Enter department salary: ");
                Double depSalary = sc.nextDouble();
                list.get(i).setDepName(depName);
                list.get(i).setDepSalary(depSalary);
                return true;
            }
        }
        System.out.println("Not found!");
        return false;
    }

    @Override
    public boolean delete(ArrayList<Department> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter department ID: ");
        String depID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDepID().equals(depID)) {
                System.out.println("Do you want to delete this department? (Y/N)");
                String choice = sc.nextLine();
                if (choice.equals("Y")) {
                    list.remove(i);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void show(ArrayList<Department> list) {
        System.out.printf("|%-10s|%-20s|%-20s|%n", "ID", "Name", "Salary");
        if (list.size() == 0) {
            System.out.println("Empty!");
        } else {
            for (int i = 0; i < list.size(); i++) {
                // System.out.println("|\t"+list.get(i).getDepID()+"\t\t|\t\t"+list.get(i).getDepName()+"\t\t|\t\t"+list.get(i).getDepSalary()+"\t\t|");
                System.out.printf("|%-10s|%-20s|%-20s|%n", list.get(i).getDepID(), list.get(i).getDepName(),
                        list.get(i).getDepSalary());
            }
        }

    }

    @Override
    public void search(ArrayList<Department> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter department ID: ");
        String depID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDepID().equals(depID)) {
                System.out.printf("|%-10s|%-20s|%-20s|%n", "ID", "Name", "Salary");
                System.out.printf("|%-10s|%-20s|%-20s|%n", list.get(i).getDepID(), list.get(i).getDepName(),
                        list.get(i).getDepSalary());
                return;
            }
        }
    }

    public ArrayList<Department> getList() {
        return null;
    }

    @Override
    public boolean checkID(ArrayList<Department> list, String depID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDepID().equals(depID)) {
                return true;
            }
        }
        return false;
    }

}
