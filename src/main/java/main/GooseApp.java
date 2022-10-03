package main;

import game_activites.Dice;
import game_activites.Rules;
import game_controller.Controls;
import java.util.Scanner;

public class GooseApp {

    //Main class starts the game

    public static void main(String[] args) {
        Rules rules = new Rules();
        Dice dice = new Dice();
        Controls controls = new Controls();

        //Game starts
        controls.startGame();

        Scanner scanner  = new Scanner(System.in);
        boolean found_winner = false;


        while (!found_winner) {

           String player_input = scanner.nextLine();


           //splits players input to an array
           String [] input = player_input.split(" ");

            //switch statement controls activites of the game
           switch(input[0]) {

               case ("quit"):
                   found_winner = true;
                   break;

               case("print"):
                   rules.printInstructions();
                   break;

               case("add"):
                   try{controls.addPlayer(input[1]);}
                   catch (IndexOutOfBoundsException e){
                      System.out.println("You can't add an empty player");
                   }
                   break;

               case("move"):
                   try{controls.movePlayer(input[1], dice.roll());}
                   catch (IndexOutOfBoundsException e){
                       System.out.println("Please include an active player's name with the move command");
                   }
                   break;

               default:
                   System.out.println("Invalid entry");
                   break;



           }


        }
    }

}
