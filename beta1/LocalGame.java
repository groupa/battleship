import java.util.ArrayList;
import java.util.Random;


public class LocalGame {
	private int difficulty;
	ScreenDisplayer screendisplayer;
	boolean turn;
	Player player1, player2;
	Map map1, map2;
	Shot lastshot1, lastshot2;
	public ArrayList<Ship> ships = new ArrayList<Ship>();
	public boolean [] ships_Flag= new boolean [101];
	
	LocalGame() {
		difficulty = 0;
	}
	LocalGame(ScreenDisplayer _screendisplayer, int _difficulty) {
		difficulty = _difficulty;
		screendisplayer = _screendisplayer;
		turn = true;
		start();
	}
	
	void start() 
	{
		map1 = fillMap(new Map(10, 10));
		map2 = fillMap(new Map(10, 10));
		switch (difficulty)
		{
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
	
		
		
			
	
	}
	
	void move(int index) {
		if (turn == true) {
			//System.out.println("MOVE: " + index);
			Shot shot = new Shot ((int)(index / 10), index % 10);
			lastshot1 = shot;
			if ((map2.getCell(shot.getX(), shot.getY()) > 0) && (map2.getCell(shot.getX(), shot.getY()) < 4)) 
			{
				turn = true;
			}
			else 
			{
				if (map2.getCell(shot.getX(), shot.getY()) == 4) {
					screendisplayer.hitShot(index, 2);
					map2.setCell(shot.getX(), shot.getY(), 2);
					turn = true;
				}
				else
				{
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
			index = shot.getX() * 10 + shot.getY();
			System.out.println("AI MOVE: " + index);
			lastshot2 = shot;
			if ((map1.getCell(shot.getX(), shot.getY()) > 0) && (map1.getCell(shot.getX(), shot.getY()) < 4)) 
			{
				turn = false;
			}
			else 
			{
				if (map1.getCell(shot.getX(), shot.getY()) == 4) {
					screendisplayer.hitShot(index, 1);
					map1.setCell(shot.getX(), shot.getY(), 2);
					turn = false;
				}
				else
				{
					screendisplayer.missShot(index, 1);
					map1.setCell(shot.getX(), shot.getY(), 1);
					turn = true;
				}
			}
			updateGraphics();
		}
		
	}
	
	
	
	void updateGraphics() {
		for (int f=0; f<15 ; f++) {
			screendisplayer.updateGraphics();
		}
	}
	
	Map fillMap(Map map) {
		Map resultMap = new Map(map.getWidth(), map.getHeight());
		for (int i = 0; i < map.getWidth(); i++) 
		{
			for (int j = 0; j < map.getWidth(); j++)
			{
				resultMap.setCell(i, j, 10);
			}
		}
		return resultMap;
	}
	
	
	
	
	}
	
	

