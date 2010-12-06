/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship;

import java.util.Random;

/**
 *
 * @author dmitryigoshin
 */
public class ComputerPlayer extends Player {
    ComputerPlayer(Map defaultMap)
    {
        super(defaultMap);
        name = "Computer";
    }

    @Override
    Shot getNextMove(Map enemyMap, Shot lastShot)
    {
        Random myRandomizer = new Random();
        int x = Math.abs(myRandomizer.nextInt() % enemyMap.getHeight());
        int y = Math.abs(myRandomizer.nextInt() % enemyMap.getWidth());
        Shot move = new Shot(x, y);
        return move;
    }

    @Override
    void placeShips()
    {
        Random myRandomizer = new Random();
        int x, y;
        for (int i = 0; i < 2; i ++)
        {
         x = Math.abs(myRandomizer.nextInt() % playermap.getHeight());
         y = Math.abs(myRandomizer.nextInt() % playermap.getWidth());
         playermap.setCell(x, y, 1);
        }

    }

}
