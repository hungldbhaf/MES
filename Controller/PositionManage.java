package Controller;

import Interface.Action;
import Model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PositionManage implements Action<Position> {

    @Override
    public Position add(ArrayList<Position> list) {
        Position pos = new Position();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter position ID: ");
        String posID = sc.nextLine();
        while (checkID(list, posID)) {
            System.out.println("Position ID is invalid! Please Enter Position ID again: ");
            posID = sc.nextLine();
        }

        while (posID.contains(" ") || posID.equals("")) {
            System.out.println("[SOS]   *Please don't enter space! Please Enter Position ID again* ");
            posID = sc.nextLine();
        }

        pos.setPosID(posID);
        System.out.println("Enter position name: ");
        String posName = sc.nextLine();
        pos.setPosName(posName);
        System.out.println("Enter position bonus: ");
        Double posBonus = sc.nextDouble();
        pos.setPosBonus(posBonus);
        return pos;
    }

    @Override
    public boolean edit(ArrayList<Position> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter position ID: ");
        String posID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPosID().equals(posID)) {
                System.out.println("Enter position name: ");
                String posName = sc.nextLine();
                System.out.println("Enter position bonus: ");
                Double posBonus = sc.nextDouble();
                list.get(i).setPosName(posName);
                list.get(i).setPosBonus(posBonus);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(ArrayList<Position> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter position ID: ");
        String posID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPosID().equals(posID)) {
                System.out.println("Do you want to delete this position? (Y/N)");
                String choice = sc.nextLine();
                if (choice.equals("Y")) {
                    list.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void show(ArrayList<Position> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Position ID: " + list.get(i).getPosID());
            System.out.println("Position name: " + list.get(i).getPosName());
            System.out.println("Position bonus: " + list.get(i).getPosBonus());
        }
    }

    @Override
    public void search(ArrayList<Position> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter position ID: ");
        String posID = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPosID().equals(posID)) {
                System.out.println("Position ID: " + list.get(i).getPosID());
                System.out.println("Position name: " + list.get(i).getPosName());
                System.out.println("Position bonus: " + list.get(i).getPosBonus());
            }
        }
    }

    @Override
    public boolean checkID(ArrayList<Position> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPosID().equals(id)) {
                return true;
            }
        }
        return false;
    }

}
