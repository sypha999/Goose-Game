package main;

import game_activites.Dice;
import game_activites.Player;
import game_activites.Rules;
import game_controller.Controls;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GooseApp {

    public static void main(String[] args) {
        Rules rules = new Rules();
        Dice dice = new Dice();
        Controls controls = new Controls();

        controls.startGame();

        Scanner scanner  = new Scanner(System.in);
        boolean found_winner = false;


        while (!found_winner) {

           String player_input = scanner.nextLine().stripIndent();
           String [] input = player_input.split(" ");

            if(input[0].equalsIgnoreCase( "quit"))
                   found_winner = true;

            else if(input[0].equalsIgnoreCase( "print"))
                   rules.printInstructions();

            else if(input[0].equalsIgnoreCase("add"))
                   controls.addPlayer(input[1]);

            else if(input[0].equalsIgnoreCase("move"))
                   controls.movePlayer(input[1], dice.roll());

            else System.out.println("Invalid entry");




        }
    }

}
