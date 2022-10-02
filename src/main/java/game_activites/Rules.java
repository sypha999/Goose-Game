package game_activites;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rules {

    Integer [] nums = {5,9,14,18,23,27};
    public List<Integer> numbers = Arrays.asList(nums);

    public Player bridge(Player player, int [] roll){
        System.out.println(player.getName().substring(0,1).toUpperCase()+player.getName().substring(1) + " rolls " +roll[0]+ "," +roll[1]+". "+player.getName().substring(0,1).toUpperCase()+player.getName().substring(1)+" moves from "+player.getPosition()+" to The Bridge. "+player.getName().substring(0,1).toUpperCase()+player.getName().substring(1)+" jumps to 12." );
        player.setPosition(12);
        return player;
    }

    public Player goose(Player player, int [] roll){

         //A list to store all goose numbers

         int sum = roll[0] + roll[1];
        System.out.print(player.getName().substring(0,1).toUpperCase()+player.getName().substring(1) + " rolls " +roll[0]+ "," +roll[1]+". "+player.getName().substring(0,1).toUpperCase()+player.getName().substring(1)+" moves from "+player.getPosition()+" to " +(player.getPosition()+sum)+" The Goose.");

        //set players position to new position
        player.setPosition(player.getPosition()+sum);

        System.out.print(player.getName().substring(0,1).toUpperCase()+player.getName().substring(1)+" moves again and goes to "+(player.getPosition()+sum));

        //set player position to new position
        player.setPosition(player.getPosition()+sum);

        if(numbers.contains(player.getPosition())){
            while( numbers.contains(player.getPosition())){

                System.out.print(" The Goose. "+player.getName().substring(0,1).toUpperCase()+player.getName().substring(1)+" moves again and goes to "+(player.getPosition()+sum));
                //set new player position
                player.setPosition(player.getPosition() + sum);
            }}
        System.out.println("\n");
        return player;
    }

    public Player victory(Player player, int [] roll){

        if(perfectWin(player,roll[0]+roll[1])){
            player.setWinner(true);
            System.out.println( player.getName().substring(0,1).toUpperCase()+player.getName().substring(1)+" rolls "+roll[0]+","+roll[1]+". "+player.getName().substring(0,1).toUpperCase()+player.getName().substring(1)+" moves from "+player.getPosition()+" to 63 "+player.getName().substring(0,1).toUpperCase()+player.getName().substring(1)+" wins");
            System.exit(0);
            return player;
        }
        else {
            player.setPosition(61);
            System.out.println(player.getName().substring(0,1).toUpperCase()+player.getName().substring(1)+" rolls "+roll[0]+","+roll[1]+". "+player.getName().substring(0,1).toUpperCase()+player.getName().substring(1)+" bounces! "+player.getName().substring(0,1).toUpperCase()+player.getName().substring(1)+" returns to 61");
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
