/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Random;

/**
 *
 * @author dmitryigoshin
 */
public class Medium extends Player {
    Medium(Map defaultMap)
    {
        super(defaultMap);
        name = "Medium";
    }

    @Override
    Shot getNextMove(Map enemyMap, Shot lastShot)
    {
        Random myRandomizer = new Random();
        int x, y;
        do {
        x = Math.abs(myRandomizer.nextInt() % enemyMap.getHeight());
        y = Math.abs(myRandomizer.nextInt() % enemyMap.getWidth());
        } while (enemyMap.getCell(x, y) != 0);
        Shot move = new Shot(x, y);
        return move;
    }


}
