package game_activites;


import game_controller.Controls;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rules {

    //class controls the game rules

    Controls controls;
    //Goose numbers
    Integer [] nums = {5,9,14,18,23,27};

    //Adding Goose numbers to a List
    public List<Integer> numbers = Arrays.asList(nums);

    //Bridge
    public Player bridge(Player player, int [] roll){
        //Initializing the players name to a Variable
        String name = player.getName().substring(0,1).toUpperCase()+player.getName().substring(1);

        //player reaches bridge, player jumps to 12
        System.out.println(name + " rolls " +roll[0]+ "," +roll[1]+". "+name+" moves from "+player.getPosition()+" to The Bridge. "+name+" jumps to 12." );

        //sets players position to 12
        player.setPosition(12);
        return player;
    }

    //Goose
    public Player goose(Player player, int [] roll){

        int sum = roll[0] + roll[1];

        //Initializing  players name to a variable
        String name = player.getName().substring(0,1).toUpperCase()+player.getName().substring(1);
        //initializing current position to a variable
        int position = player.getPosition();

        //initializing next position to a variable
        int next_position = player.getPosition() + sum;

        //player hits the Goose
        System.out.print(name + " rolls " +roll[0]+ "," +roll[1]+". "+name+" moves from "+position+" to " +next_position+" The Goose. ");

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

    //Victory
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

    //Check if win is perfect
    public Boolean perfectWin(Player player, int sum){
        if(player.getPosition()+sum ==63){ return true;}
        return false;
    }

    //Prank
    public List<Player> prank (Player player,Player player1, int [] roll){

        //perform prank activities
        int sum= roll[0]+roll[1];
        if (player1.getPosition()>=0){
            String name1 = player.getName().substring(0,1).toUpperCase()+player.getName().substring(1);
            String name2 = player1.getName().substring(0,1).toUpperCase()+player1.getName().substring(1);
            int position = player.getPosition()+sum;
            int rev_position = player.getPosition();

            System.out.println(name1+" rolls "+roll[0]+","+roll[1]+". "+name1+" moves from "+player.getPosition()+" to " +position+". On "+position+" there is "+name2+", who returns to "+rev_position);
            player.setPosition(position);
            player1.setPosition(rev_position);
        }
        else return null;

        return new ArrayList<>(Arrays.asList(player, player1));
    }

    //check if prank occurs
    public Player prankCheck (List<Player> players,int sum, int position){

        //assign a dummy player to avoid null pointer exception
         Player a = new Player("dummy29006",-1,false) ;
        for (Player player : players) {
            if (player.getPosition() == position + sum) {
                //updates dummy player object if prank exists
                a = player;
                break;
            }
        }
        //returns pranked player
        return a;
    }

    //instructions to game
    public void printInstructions(){

        System.out.println( "Instructions / rules of the game \n" +
                "* To move player type 'move player_name' eg move Arinze (Assuming Arinze is a player on the game) \n" +
                "* To add player type 'add player_name' eg add Arinze (automatically adds Arinze to the game) \n" +
                "* To reprint the rules at point in the game, type 'print rules'\n"+
                "* Type 'quit game' to automatically end the game at anytime\n");
    }



}
