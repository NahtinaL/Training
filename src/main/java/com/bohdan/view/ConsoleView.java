package com.bohdan.view;

import com.bohdan.Controllers.Controller;
import com.bohdan.Controllers.ControllerImpl;
import com.bohdan.services.Anagram;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {
    private Controller controller;
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public ConsoleView() {
        controller = new ControllerImpl();
        menu = new LinkedHashMap<>();
        menu.put("1", " 1 - Make Anagram");
        menu.put("2", " 2 - Not implemented");
        menu.put("3", " 3 - Not implemented");
        menu.put("4", " 4 - not implemented");
        menu.put("Q", " Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::pressButton1);
        methodsMenu.put("2", this::pressButton2);
        methodsMenu.put("3", this::pressButton3);
        methodsMenu.put("4", this::pressButton4);
    }

    private void pressButton1() {
        System.out.println("Please enter the sentence and press Enter");
        String inputSentence = input.nextLine();
        Anagram anagram = new Anagram();
        System.out.println(anagram.make(inputSentence));
    }

    private void pressButton2(){
        System.out.println("button 2 selected");
    }

    private void pressButton3(){
        System.out.println("button 3 selected");
    }

    private void pressButton4(){
        System.out.println("button 4 selected");
    }

    public void displayMenu(){
        System.out.println("\n MENU");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void showMenu(){
        String keyMenu;
        do {
            displayMenu();
            System.out.println("Please chose menu point");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println("menu point does not exist");
            }
        } while (!keyMenu.equals("Q"));
    }

}
