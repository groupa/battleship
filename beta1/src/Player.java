/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dmitryigoshin
 */
public class Player {

    String name;
    private int cells = 10;
    Map playermap;
    Boolean LastShotSucceed;

    Player()
    {
       
    }

    Player(Map defaultMap)
    {
        playermap = defaultMap;
    }

    Map getMap()
    {
        return playermap;
    }

    void placeShips()
    {


    }

    Shot getNextMove(Map enemyMap, Shot lastShot)
    {
        int x = 0;
        int y = 0;
        Shot move = new Shot(x, y);
        return move;
    }

    Boolean Hit(Shot shot)
    {
        if (playermap.getCell(shot.X, shot.Y) == 1)
        {
            playermap.setCell(shot.X, shot.Y, -1);
            cells--;
            return true;
        }
        else
        {
             playermap.setCell(shot.X, shot.Y, 2);
            return false;
        }
    }

    String getName()
    {
        return name;
    }

    Boolean hasMoreShips()
    {
        if (cells > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
