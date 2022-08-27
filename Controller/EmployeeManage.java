package Controller;
import Interface.ActionEmp;
import Model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManage implements ActionEmp<Employee, Department, Position> {
    @Override
    public Employee add(ArrayList<Employee> list, ArrayList<Department> list2, ArrayList<Position> list3) {
        Employee emp = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        String empID = sc.nextLine();
        while (checkID(list, empID)) {
            System.out.println("Employee ID is Invalid! Please Enter Employee ID again: ");
            empID = sc.nextLine();
        }
        while (empID.contains(" ") || empID.equals("")) {
            System.out.println("[SOS]   *Please don't enter space! Please Enter Employee ID again* ");
            empID = sc.nextLine();
        }
        emp.setEmpID(empID);
        System.out.println("Enter Employee Name: ");
        String empName = sc.nextLine();
        emp.setEmpName(empName);
        System.out.println("Enter Employee Email: ");
        String empEmail = sc.nextLine();
        emp.setEmpEmail(empEmail);
        System.out.println("Enter Department ID: ");
        sc = new Scanner(System.in);
        String depID = sc.nextLine();
        int countdep = 0;
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getDepID().equals(depID)) {
                emp.setDep(list2.get(i));

            } else {
                countdep++;
            }
        }
        if (countdep == list2.size()) {
            System.out.println("Not found!");
        }

        System.out.println("Enter Position ID: ");
        String posID = sc.nextLine();
        int countpos = 0;
        for (int i = 0; i < list3.size(); i++) {
            if (list3.get(i).getPosID().equals(posID)) {
                emp.setPos(list3.get(i));

            } else {
                countpos++;
            }
        }
        if (countpos == list3.size()) {
            System.out.println("Not found!");
        }
        return emp;
    }

    @Override
    public boolean edit(ArrayList<Employee> list, ArrayList<Department> list2, ArrayList<Position> list3) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        String empID = sc.nextLine();
        int count = 0;
        System.out.println("_________________________________");
        System.out.println("|       Choose function:        |");
        System.out.println("|_______________________________|");
        System.out.println("|   [1] Edit Employee Name      |");
        System.out.println("|   [2] Edit Employee Email     |");
        System.out.println("|   [4] Edit Department         |");
        System.out.println("|   [5] Edit Position           |");
        System.out.println("|   [6] Exit                    |");
        System.out.println("|_______________________________|");
        int choose = sc.nextInt();
        for (int i = 0; i < list.size(); i++) {
            sc = new Scanner(System.in);
            if (list.get(i).getEmpID().equals(empID)) {
                switch (choose) {
                    case 1:
                        System.out.println("Enter Employee Name: ");
                        String empName = sc.nextLine();
                        list.get(i).setEmpName(empName);
                        break;
                    case 2:
                        System.out.println("Enter Employee Email: ");
                        String empEmail = sc.nextLine();
                        list.get(i).setEmpEmail(empEmail);
                        break;
                    case 4:
                        System.out.println("Enter Department ID: ");
                        String depID = sc.nextLine();
                        int countdep = 0;
                        for (int j = 0; j < list2.size(); j++) {
                            if (list2.get(j).getDepID().equals(depID)) {
                                list.get(i).setDep(list2.get(j));

                                
                            } else {
                                countdep++;
                            }
                        }
                        if (countdep == list2.size()) {
                            System.out.println("Not found!");
                        }
                        break;
                    case 5:
                        System.out.println("Enter Position ID: ");
                        String posID = sc.nextLine();
                        int countpos = 0;
                        for (int j = 0; j < list3.size(); j++) {
                            if (list3.get(j).getPosID().equals(posID)) {
                                list.get(i).setPos(list3.get(j));
                            } else {
                                countpos++;
                            }
                        }
                        if (countpos == list3.size()) {
                            System.out.println("Not found!");
                        }
                        break;
                    default:
                        System.out.println("Invalid!");
                        break;
                }
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Not found!");
        }
        return true;
    }

    @Override
    public boolean delete(ArrayList<Employee> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        String empID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmpID().equals(empID)) {
                list.remove(i);
                return true;
            }
        }
        System.out.println("Not found!");
        return true;
    }

    @Override
    public void show(ArrayList<Employee> list) {
        System.out.printf("|%-10s|%-20s|%-30s|%-30s|%-30s|%n", "ID", "Name", "Email",
                "Department", "Position");
        System.out.printf("|%-10s|%-20s|%-30s|%-30s|%-30s|%n", "_________", "_______________", "_________________",
                "_________________", "_____________________", "__________________");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("|%-10s|%-20s|%-30s|%-30s|%-30s|%n", list.get(i).getEmpID(),
                    list.get(i).getEmpName(), list.get(i).getEmpEmail(),
                    list.get(i).getDep().getDepName(), list.get(i).getPos().getPosName());
        }
    }

    @Override
    public void search(ArrayList<Employee> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        String empID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmpID().equals(empID)) {
                System.out.printf("|%-10s|%-20s|%-20s|%-10s|%-10s|%n", "ID", "Name", "Email",
                        "Department", "Position");
                System.out.printf("|%-10s|%-20s|%-20s|%-10s|%-10s|%n", list.get(i).getEmpID(),
                        list.get(i).getEmpName(), list.get(i).getEmpEmail(),
                        list.get(i).getDep().getDepName(), list.get(i).getPos().getPosName());
            }
        }
    }

    @Override
    public boolean checkID(ArrayList<Employee> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmpID().equals(id)) {
                return true;
            }
        }
        return false;
    }

















    @Override
    public Object add(ArrayList<Employee> list) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean edit(ArrayList<Employee> list) {
        // TODO Auto-generated method stub
        return false;
    }

}
