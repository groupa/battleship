import java.util.ArrayList;
import java.util.Random;

public class OnlineGame {
	private int difficulty;
	ScreenDisplayer screendisplayer;
	boolean turn;
	Player player1, player2;
	Map map1, map2;
	Shot lastshot1, lastshot2;
	public ArrayList<Ship> ships = new ArrayList<Ship>();
	public boolean[] ships_Flag = new boolean[101];

	OnlineGame() {
		difficulty = 0;
	}

	OnlineGame(ScreenDisplayer _screendisplayer, int _difficulty) {
		difficulty = _difficulty;
		screendisplayer = _screendisplayer;
		turn = true;
		lastshot1 = new Shot(randomizer(10), randomizer(10));
		lastshot2 = new Shot(randomizer(10), randomizer(10));
		start();
	}

	void start() {
		map1 = fillMap(new Map(10, 10));
		map2 = fillMap(new Map(10, 10));
		switch (difficulty) {
		case 0:
			player2 = new Easy(map2);
			break;
		case 1:
			player2 = new Medium(map2);
			break;
		case 2:
			player2 = new Hard(map2);
			break;
		}

		ArrayList<Ship> myShips = new ArrayList<Ship>();
		ArrayList<Ship> enemyShips = new ArrayList<Ship>();

		myShips = locateShips(map1);
		map1 = placeShipsOnMap(myShips, map1);
		
		enemyShips = locateShips(map2);
		map2 = placeShipsOnMap(enemyShips, map2);
		
		
		System.out.println("Ship summary: ");
		for (int j = 4; j > -1; j--) {
			screendisplayer.setShipOrientation(myShips.get(j).Indexes, 5 - j,
					myShips.get(j).horVar, 1);
			for (int i = 0; i < myShips.get(j).Indexes.size(); i++) {
				System.out.print(myShips.get(j).Indexes.get(i) + " ");
			}
		}
		//try {
		//Thread.currentThread().sleep(2000);
		//} catch (Exception ex) {};
		for (int j = 4; j > -1; j--) {
			screendisplayer.setShipOrientation(enemyShips.get(j).Indexes, 5 - j,
					enemyShips.get(j).horVar, 2);
			for (int i = 0; i < enemyShips.get(j).Indexes.size(); i++) {
				System.out.print(enemyShips.get(j).Indexes.get(i) + " ");
			}
		}

		// System.out.println("LAST SHIP: " + myShips.get(myShips.size() -
		// 1).Indexes.get(0) + myShips.get(myShips.size() - 1).Indexes.get(1));
		System.out.println("Map1: ");
		map1.PrintOut();
		System.out.println("-----------------------------------");
		System.out.println("Map2: ");
		map2.PrintOut();
		System.out.println("-----------------------------------");
		
	}

	ArrayList<Ship> locateShips(Map map) {
		ArrayList<Ship> result = new ArrayList<Ship>();
		int[] length = { 2, 3, 3, 4, 5 };

		for (int i = 5; i > 0; i--) {

			boolean isLocated = false;
			while (!isLocated) {
				Ship newShip = new Ship(randomizer(99), length[i - 1],
						randomizer(2));
				System.out.print("NEW SHIP: ");
				for (int j = 0; j < newShip.Indexes.size(); j++) {
					System.out.print(newShip.Indexes.get(j) + " ");
				}
				System.out.println();
				if (!detectShipsCollision(newShip, map)) {
					isLocated = true;
					result.add(newShip);
					for (int j = 0; j < newShip.Indexes.size(); j++) {
						int x = newShip.Indexes.get(j) % 10;
						int y = (int) newShip.Indexes.get(j) / 10;
						map.setCell(x, y, 4);
					}
				}
			}
		}
		return result;
	}
	
	Map placeShipsOnMap(ArrayList<Ship> ships, Map map) {
		Map result = new Map(map.getWidth(), map.getHeight());
		result = fillMap(result);
		for (Ship s: ships) {
			for (int j = 0; j < s.Indexes.size(); j++) {
				int x = s.Indexes.get(j) % 10;
				int y = (int) s.Indexes.get(j) / 10;
				result.setCell(x, y, 4);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param maximumRandom
	 * @return integer
	 * 
	 *         a method to make a random number between 0 - maximumRandom (by
	 *         Amir Almasi)
	 */
	public int randomizer(int maximumRandom) {
		int RandomNumber;
		Random myRandomizer = new Random();
		RandomNumber = Math.abs(myRandomizer.nextInt() % maximumRandom);
		return RandomNumber;

	}

	boolean detectShipsCollision(Ship ship, Map map) {
		// if (ship.horVar == 1) {
		// if (ship.Indexes.get(0) % 10 != ship.Indexes.get(ship.Indexes.size()
		// - 1) % 10 )
		// }
		if (ship.horVar != 1) {
			if ((int) ship.Indexes.get(0) / 10 != (int) ship.Indexes
					.get(ship.Indexes.size() - 1) / 10) {
				return true;
			}
		}

		for (int i = 0; i < ship.length; i++) {

			int x = ship.Indexes.get(i) % 10;
			int y = (int) ship.Indexes.get(i) / 10;
			System.out.println("Index: " + ship.Indexes.get(i) + " x = " + x
					+ " y =  " + y);
			if (!(isCorrectIndex(map, x, y))) {
				System.out.println("COLLISION!!! Indexes: x = "
						+ (int) (ship.Indexes.get(i)) % 10 + " y = "
						+ ship.Indexes.get(i) / 10);
				return true;
			}
			if (!isAroundSpaceEmpty(map, x, y)) {
				System.out.println("COLLISION!!! Indexes: x = "
						+ (int) (ship.Indexes.get(i)) % 10 + " y = "
						+ ship.Indexes.get(i) / 10);
				return true;
			}
		}
		return false;
	}

	boolean isCorrectIndex(Map map, int x, int y) {

		if (!((x >= 0) && (x < map.getWidth()))) {
			return false;
		}
		if (!((y >= 0) && (y < map.getHeight()))) {
			return false;
		}
		System.out.println("Index OK: x = " + x + " y = " + y);
		return true;
	}

	boolean isAroundSpaceEmpty(Map map, int x, int y) {
		System.out.println("Indexes: x = " + x + " y = " + y);
		if (map.getCell(x, y) != 10) {
			return false;
		}
		if ((x > 0) && (map.getCell(x - 1, y) != 10)) {
			return false;
		}
		if ((x < map.getWidth() - 1) && (map.getCell(x + 1, y) != 10)) {
			return false;
		}
		if ((y > 0) && (map.getCell(x, y - 1) != 10)) {
			return false;
		}
		if ((y < map.getHeight() - 1) && (map.getCell(x, y + 1) != 10)) {
			return false;
		}
		return true;
	}

	void move(int index) {
		if (turn == true) {
			// System.out.println("MOVE: " + index);

			int x = index % 10;
			int y = (int)index / 10;
			Shot shot = new Shot(x, y);
			lastshot1 = shot;
			if ((map2.getCell(shot.getX(), shot.getY()) > 0)
					&& (map2.getCell(shot.getX(), shot.getY()) < 4)) {
				turn = true;
			} else {
				if (map2.getCell(shot.getX(), shot.getY()) == 4) {
					screendisplayer.hitShot(index, 2);
					map2.setCell(shot.getX(), shot.getY(), 2);
					turn = true;
				} else {
					screendisplayer.missShot(index, 2);
					map2.setCell(shot.getX(), shot.getY(), 1);
					updateGraphics();
					turn = false;
				}
			}
			updateGraphics();
		}
		if (turn == false) {

			Shot shot = player2.getNextMove(map1, lastshot2);
			index = shot.getY() * 10 + shot.getX();
			System.out.println("AI MOVE: " + index);
			System.out.println("WHERE MAP IS " + map1.getCell(shot.getX(), shot.getY()));
			
			lastshot2 = shot;
			if ((map1.getCell(shot.getX(), shot.getY()) > 0)
					&& (map1.getCell(shot.getX(), shot.getY()) < 4)) {
				turn = false;
				System.out.println("AI MOVE: " + index);
				System.out.println("WHERE MAP IS " + map1.getCell(shot.getX(), shot.getY()));
			} else {
				if (map1.getCell(shot.getX(), shot.getY()) == 4) {
					screendisplayer.hitShot(index, 1);
					map1.setCell(shot.getX(), shot.getY(), 2);
					
					turn = false;
				} else {
					screendisplayer.missShot(index, 1);
					map1.setCell(shot.getX(), shot.getY(), 1);
					turn = true;
				}
			}
			updateGraphics();
		}

	}

	void updateGraphics() {
		for (int f = 0; f < 15; f++) {
			screendisplayer.updateGraphics();
		}
	}

	Map fillMap(Map map) {
		Map resultMap = new Map(map.getWidth(), map.getHeight());
		for (int i = 0; i < map.getWidth(); i++) {
			for (int j = 0; j < map.getWidth(); j++) {
				resultMap.setCell(i, j, 10);
			}
		}
		return resultMap;
	}

}
