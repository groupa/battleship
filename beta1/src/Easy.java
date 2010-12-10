/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Random;

/**
 *
 * @author dmitryigoshin
 */
public class Easy extends Player {
    Easy(Map defaultMap)
    {
        super(defaultMap);
        name = "Easy";
    }

    @Override
    Shot getNextMove(Map enemyMap, Shot lastShot)
    {
        Random myRandomizer = new Random();
        int x, y;
        do {
        x = Math.abs(myRandomizer.nextInt() % enemyMap.getHeight());
        y = Math.abs(myRandomizer.nextInt() % enemyMap.getWidth());
        } while (enemyMap.getCell(x, y) != 10);
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
