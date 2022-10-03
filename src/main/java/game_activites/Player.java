package game_activites;

import lombok.Data;

@Data
public class Player {

    //class of players, holds name, position and winning condition
    private String name;
    private int position;
    private boolean winner;

    public Player(String name, int position, boolean winner) {
        this.name = name;
        this.position = position;
        this.winner = winner;
    }

}
