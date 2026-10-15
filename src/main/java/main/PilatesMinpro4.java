package main;

import java.util.Scanner;

import Service.Service;
import controller.MenuController;

public class PilatesMinpro4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Service service = new Service(scanner);

        MenuController menuController =
                new MenuController(service, scanner);

        menuController.jalankanProgram();

        scanner.close();
    }
}