package game_activites;
import java.security.SecureRandom;

public class Dice {

    public int [] roll(){
        int [] rolls = new int[2];

        //get dice rolls
        rolls[0] = getrandom();
        rolls[1] = getrandom();
        return rolls;
    }

    //get random numbers for dice roll
    public  static int getrandom(){
        SecureRandom random = new SecureRandom();
        int num = 0;
        while(num <= 0)
        {
            num = random.nextInt(7);
        }
        return num;
    }
}
