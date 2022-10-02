package game_controller;

import game_activites.Player;
import game_activites.Rules;

import java.util.ArrayList;
import java.util.List;

public class Controls {

    Rules rules = new Rules();

    //A list to store all active players
    //Using this list as the database
    List<Player> active_players = new ArrayList<>();

    public void addPlayer(String name) {

        //Check if player already exists
        if (active_players.contains(name.toLowerCase())) {
            System.out.println(name + ": Already an existing player.");
        }

        //Create new player if player does not exist
        else {
            Player player = new Player(name, 0, false);
            active_players.add(player);
            System.out.print("Players: ");
            for(Player play:active_players){
                System.out.print(play.getName().substring(0,1).toUpperCase()+play.getName().substring(1)+", ".replace(",",""));
            }
            System.out.println("\n");
        }

    }


    public void movePlayer(String player_name, int[] roll) {

        Player player;
        int index;
        int sum = roll[0] + roll[1];

        //finding player from database
        List<Player> find_player = active_players.stream()
                .filter(e -> e.getName().equalsIgnoreCase(player_name))
                .toList();

        if (find_player.isEmpty()) System.out.println(player_name + " is not an active player");

         else {
            //getting player details
            player = find_player.get(0);
            //getting index of player
            index = active_players.indexOf(player);

            //Check if player wins
            if(player.getPosition()+sum >=63){
                player = rules.victory(player,roll);
            }

            //player hits the bridge
            else if (player.getPosition() + sum == 6) {
               player = rules.bridge(player, roll);
            }

            //player hits a goose number
            else if (rules.numbers.contains(player.getPosition() + sum)) {
               player = rules.goose(player, roll);
            }

            //player moves
            else {
                System.out.println(player.getName().substring(0,1).toUpperCase()+player.getName().substring(1) + " rolls " + roll[0] + "," + roll[1] + ". " + player.getName().substring(0,1).toUpperCase()+player.getName().substring(1) + " moves from " + player.getPosition() + " to " + (player.getPosition() + sum));
                player.setPosition(player.getPosition() + sum);
            }

            //overwriting player in active_index database
            active_players.add(index, player);

         }


    }


    public void startGame() {
        System.out.println("""
                   _|_|_|                                                     _|_|_|                                        \s
                 _|           _|_|       _|_|       _|_|_|     _|_|         _|           _|_|_|   _|_|_|  _|_|       _|_|   \s
                 _|  _|_|   _|    _|   _|    _|   _|_|       _|_|_|_|       _|  _|_|   _|    _|   _|    _|    _|   _|_|_|_| \s
                 _|    _|   _|    _|   _|    _|       _|_|   _|             _|    _|   _|    _|   _|    _|    _|   _|       \s
                   _|_|_|     _|_|       _|_|     _|_|_|       _|_|_|         _|_|_|     _|_|_|   _|    _|    _|     _|_|_| \s
                                                                                                                            \s
                                                                                                                            \s
                Inspired by an original game by Matteo Vaccari\s
                """);


        rules.printInstructions();

    }
}
