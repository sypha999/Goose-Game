package game_controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import game_activites.Player;

import java.util.List;

import org.junit.Ignore;

import org.junit.Test;

public class ControlsTest {

    @Test
    public void testAddPlayer() {
        Controls controls = new Controls();
        controls.addPlayer("Arinze");
        List<Player> playerList = controls.active_players;
        assertEquals(1, playerList.size());
        List<String> stringList = controls.added_players;
        assertEquals(1, stringList.size());
        assertEquals("Arinze", stringList.get(0));
        Player getResult = playerList.get(0);
        assertEquals("Arinze", getResult.getName());
        assertFalse(getResult.isWinner());
        assertEquals(0, getResult.getPosition());
    }

    /**
     * Method under test: {@link Controls#addPlayer(String)}
     */
    @Test
    public void testAddPlayer2() {
        Controls controls = new Controls();
        controls.addPlayer("Anthony");
        controls.addPlayer("Val");
        List<Player> playerList = controls.active_players;
        assertEquals(2, playerList.size());
        List<String> stringList = controls.added_players;
        assertEquals(2, stringList.size());
        assertEquals("Anthony", stringList.get(0));
        assertEquals("Val", stringList.get(1));
        Player getResult = playerList.get(1);
        assertFalse(getResult.isWinner());
        assertEquals(0, getResult.getPosition());
        assertEquals("Val", getResult.getName());
    }

    @Test
    public void testAddPlayer4() {
        Controls controls = new Controls();
        controls.addPlayer("Chidinma");
        controls.addPlayer("victor");
        assertEquals(2, controls.active_players.size());
        assertEquals(2, controls.added_players.size());
    }

    @Test
    public void testMovePlayer() {
        Controls controls = new Controls();
        controls.addPlayer("Arinze");
        controls.movePlayer("Arinze", new int[]{1, 1,});
        assertEquals(2,controls.active_players.get(0).getPosition());
    }


    @Test
    public void testMovePlayer2() {
        Controls controls = new Controls();
        controls.addPlayer("Tobi");
        controls.movePlayer("Tobi", new int[]{2, 4,});
        //Test for Bridge
        assertEquals(12,controls.active_players.get(0).getPosition());
    }

    /**
     * Method under test: {@link Controls#movePlayer(String, int[])}
     */
    @Test
    public void testMovePlayer3() {
        Controls controls = new Controls();
        controls.addPlayer("Rex");
        controls.movePlayer("Rex", new int[]{1, 4,});
        //Test for Goose
        assertEquals(10,controls.active_players.get(0).getPosition());
    }


    @Test
    public void testMovePlayer4() {
        Controls controls = new Controls();
        controls.addPlayer("Ben");
        controls.movePlayer("Ben", new int[]{6, 3,});
        //test for reoccuring goose
        assertEquals(36,controls.active_players.get(0).getPosition());
    }

}

