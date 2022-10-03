package game_controller;

import game_activites.Player;
import game_activites.Rules;

import java.util.ArrayList;
import java.util.List;

public class Controls {

    //class controls the game activities

    Rules rules = new Rules();

    //A list to store all active players
    //Using this list as the database
    public List<Player> active_players = new ArrayList<>();
    List<String> added_players = new ArrayList<>();

    public void addPlayer(String name) {

        //Check if player already exists
        if (added_players.contains(name.toLowerCase())) {
            System.out.println(name + ": Already an existing player.");
        }

        //Create new player if player does not exist
        else {
            Player player = new Player(name, 0, false);
            active_players.add(player);
            added_players.add(name);
            System.out.print("Players: ");
            for(int i=0; i<added_players.size(); i++){

                String named = added_players.get(i).substring(0,1).toUpperCase()+added_players.get(i).substring(1);
                if(i==added_players.size()-1){
                    System.out.print(named +".");
                }
                else{
                System.out.print(named +", ");}
            }
            System.out.println("\n");
        }

    }


    public void movePlayer(String player_name, int[] roll) {

        Player player;
        Player player1;
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

            //Pranked player
            player1 = rules.prankCheck(active_players,sum, player.getPosition());

            //Check if player wins
            if(player.getPosition()+sum >=63){
                player = rules.victory(player,roll);
            }

            //player hits the bridge
            else if (player.getPosition() + sum == 6) {

                //check for prank
                if (player1.getPosition()>=0){

                    //get index of pranked player
                    int index1 = active_players.indexOf(player1);

                    //perform prank
                    Player pranked_player = rules.prank(player,player1,roll).get(1);

                    //overwrite pranked player in database
                    active_players.add(index1,pranked_player);
                }

                //else player hits bridge

                else player = rules.bridge(player, roll);

            }

            //player hits a goose number
            else if (rules.numbers.contains(player.getPosition() + sum)) {

                //check for prank
                if (player1.getPosition()>=0){

                    //get index of pranked player
                    int index1 = active_players.indexOf(player1);

                    //perform prank
                    Player pranked_player = rules.prank(player,player1,roll).get(1);

                    //overwrite pranked player in database
                    active_players.add(index1,pranked_player);
                }

                //player hits goose
               else player = rules.goose(player, roll);

            }

            //player moves

            //check for prank
            else {
                if (player1.getPosition()>=0){

                    //get index of pranked player
                    int index1 = active_players.indexOf(player1);

                    //perform prank
                    Player pranked_player = rules.prank(player,player1,roll).get(1);

                    //overwrite pranked player in database
                    active_players.add(index1,pranked_player);
                }
                //player moves normally
                else{
                String name = player.getName().substring(0,1).toUpperCase()+player.getName().substring(1);
                int position = player.getPosition();
                int next_position = player.getPosition() + sum;

                System.out.println(name + " rolls " + roll[0] + "," + roll[1] + ". " + name + " moves from " + position + " to " + next_position);

                //Player moves normally
                player.setPosition(next_position);}

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
