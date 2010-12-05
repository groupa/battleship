import java.util.*;

class Main {

public static void main (String[] args) {

	Map enemyMap = new Map(10,10);
	Map checkeredMap;
	ComputerShot computerShot = new ComputerShot ();
	checkeredMap = computerShot.shotCheckerSteps(enemyMap);
}
}
