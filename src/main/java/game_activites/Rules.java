package game_activites;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rules {

    //Goose numbers
    Integer [] nums = {5,9,14,18,23,27};

    //Adding Goose numbers to a List
    public List<Integer> numbers = Arrays.asList(nums);

    public Player bridge(Player player, int [] roll){
        //Initializing the players name to a Variable
        String name = player.getName().substring(0,1).toUpperCase()+player.getName().substring(1);

        //player reaches bridge, player jumps to 12
        System.out.println(name + " rolls " +roll[0]+ "," +roll[1]+". "+name+" moves from "+player.getPosition()+" to The Bridge. "+name+" jumps to 12." );

        //sets players position to 12
        player.setPosition(12);
        return player;
    }

    public Player goose(Player player, int [] roll){

        int sum = roll[0] + roll[1];

        //Initializing  players name to a variable
        String name = player.getName().substring(0,1).toUpperCase()+player.getName().substring(1);
        //initializing current position to a variable
        int position = player.getPosition();

        //initializing next position to a variable
        int next_position = player.getPosition() + sum;

        //player hits the Goose
        System.out.print(name + " rolls " +roll[0]+ "," +roll[1]+". "+name+" moves from "+position+" to " +next_position+" The Goose.");

        //set players position to new position
        player.setPosition(next_position);

        System.out.print(name+" moves again and goes to "+(player.getPosition()+sum));

        //set player position to new position
        player.setPosition(player.getPosition()+sum);

        //Reoccurring Goose
        if(numbers.contains(player.getPosition())){
            while( numbers.contains(player.getPosition())){

                //player hits Goose again
                System.out.print(" The Goose. "+name+" moves again and goes to "+(player.getPosition()+sum));

                //set new player position
                player.setPosition(player.getPosition() + sum);
            }}
        //giving indentation
        System.out.println("\n");
        return player;
    }

    public Player victory(Player player, int [] roll){


        //Initializing the players name to a Variable
        String name = player.getName().substring(0,1).toUpperCase()+player.getName().substring(1);
        //initializing current position to a variable
        int position = player.getPosition();


        if(perfectWin(player,roll[0]+roll[1])){
            //set status of winner to true
            player.setWinner(true);

            System.out.println( name+" rolls "+roll[0]+","+roll[1]+". "+name+" moves from "+position+" to 63 "+name+" wins");
            //game ends
            System.exit(0);
            return player;
        }
        else {
            player.setPosition(61);
            System.out.println(name+" rolls "+roll[0]+","+roll[1]+". "+name+" bounces! "+name+" returns to 61");
            return player;
        }
    }

    public Boolean perfectWin(Player player, int sum){
        if(player.getPosition()+sum ==63){ return true;}
        return false;
    }



    public void prank (Player player1, Player player2, int roll){

        int player1_old_position = player1.getPosition() - roll;
        int player2_position = player2.getPosition();

        player1.setPosition(player2_position);
        player2.setPosition(player1_old_position);
    }


    public void printInstructions(){

        System.out.println( "Instructions / rules of the game \n" +
                "* To move player type 'move player_name' eg move Arinze (Assuming Arinze is a player on the game) \n" +
                "* To add player type 'add player_name' eg add Arinze (automatically adds Arinze to the game) \n" +
                "* To reprint the rules at point in the game, type 'print rules'\n"+
                "* Type 'quit game' to automatically end the game at anytime\n");
    }



}
