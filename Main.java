import java.util.*;

class Main {

public static void main (String[] args) {

	Map enemyMap = new Map(10,10);
	Map checkeredMap;
	ComputerShot computerShot = new ComputerShot ();
	Shot lastShot = new Shot (5,5);

	/**Test a shot: */
	checkeredMap = computerShot.shotCheckerSteps(enemyMap);
	checkeredMap.setCell(5,0,0);
	computerShot.checkForPreviousHits(checkeredMap, lastShot);

}
}
