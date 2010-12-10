import java.util.Random;

/**
 *
 * @author dmitryigoshin
 */
public class localPlayer extends Player {
	localPlayer(Map defaultMap)
    {
        super(defaultMap);
        name = "Computer";
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
