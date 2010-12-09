import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Amir Almasi
 * 
 */
public class AI {
	private ArrayList<Integer> shotPositions = new ArrayList<Integer>();
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	private ScreenDisplayer screendisplay ;
	private int side = 0 ; // a variable to shot the left side if it is 0, right side if it is 1, up side if it is 2, down side if it is 3
	private int index ;		// a shot index on the screen 
	private int keep ;		// to keep the Shot index for the next times to start from to again
	private boolean repeated =false;	// a checker variable not to shot the shot cell again
	public AI (){
		showScreen();
		setships(2);
		setships(3);
		setships(3);
		setships(4);
		setships(5);

		/**
		 * starting the game 
		 */
		startGame();
		side=0;
	}
	/**
	 *  a method to make a object from Gui 
	 */
	public void showScreen (){
		screendisplay = new ScreenDisplayer();
		screendisplay.displayCurrentScreen();
	}
	/**
	 * 
	 * @param maximumRandom
	 * 	to make a random number between 0 - maximumRandom
	 * @return integer
	 * 	random integer number between 0 - maximumRandom
	 * 
	 */
	public int randomizer(int maximumRandom){
		int RandomNumber;
		Random myRandomizer = new Random ();
		RandomNumber=Math.abs(myRandomizer.nextInt() % maximumRandom );
		return RandomNumber;

	}

	/**
	 * 
	 * @param length
	 * length is the the size of the ship
	 * 
	 * to set all ships on the screen
	 */
	public void setships(int length){
		int randomIndex;
		int horVer;	// a variable to show that the ship is horizontally if 0 or vertically if 1 
		boolean again_Random;
		do {
			horVer = randomizer(2);    // to make randomly ship horizontally or vertically on the screen 
			randomIndex =randomizer(100); // to locate the ship randomly 
			again_Random=collide_detect(randomIndex,length , horVer);
		}while (again_Random);
		ships.add(new Ship(randomIndex,length ,horVer ));

	}
	/**
	 * 
	 * @param randomIndex
	 * 		one random index on the screen
	 * @param length
	 * 		the length of the ship
	 * @param horVar
	 * 		one variable which shows our ship is vertically or horizontally 
	 * @return
	 *  a method to check if a new ship cross the previous ones or not 
	 * 	if it returns true then it is located on the another one 
	 * 	if it returns false then it is on the right place 
	 * 
	 */
	public boolean collide_detect (int randomIndex ,int length, int horVar ){
		if (horVar==0){
			if ((randomIndex%10)+length>9)
				return true;
		}else{
			if ((randomIndex)+(length*10)>99)
				return true;
		}
		for (Ship ship:ships){
			if (horVar==0){
				for (int j =0 ;j<ship.Indexes.size();j++){
					for (int x=randomIndex; x <=(randomIndex+length);x++){
						if (ship.Indexes.get(j)==x||ship.Indexes.get(j)==x+1||ship.Indexes.get(j)==x-1
								||ship.Indexes.get(j)==x+10||ship.Indexes.get(j)==x-10){
							return true;
						}
					}
				}
			}else {
				for (int j =0 ;j<ship.Indexes.size();j++){
					for (int x=randomIndex; x <=(randomIndex+(length*10));x+=10){
						if (ship.Indexes.get(j)==x||ship.Indexes.get(j)==x+1||ship.Indexes.get(j)==x-1
								||ship.Indexes.get(j)==x+10||ship.Indexes.get(j)==x-10){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	/**
	 * playing simple player and start first random shoot
	 * 
	 */
	public void startGame(){
		int random_Shot=0;
		Scanner scan = new Scanner (System.in);
		int user_quess= 0;
		boolean keep_Shotting = false;
		do {
			if (!keep_Shotting){
				do {
					repeated=true;
					random_Shot=randomizer(100);
				}while (new_Shot(random_Shot));
				shotPositions.add(random_Shot);

			}
			if (hitChecker(random_Shot)){

				keep = random_Shot;
				if (!hit(random_Shot)){
					keep_Shotting=true;
					++side;
				}
				else {
					keep_Shotting=false;
					side=0;					
				}
			}else{
				screendisplay.missShot(random_Shot);
				for (int f=0; f<15 ; f++){
					screendisplay.updateGraphics();
				}
			}
			user_quess = scan.nextInt();
		}while (user_quess>0);
	}



	/**
	 * 
	 * @param shootIndex
	 * one random integer between 0 - 100 
	 * @return
	 * a method to check if random shot hit any ships or not
	 * if returns true then the random shot hits a ship 
	 */
	public boolean hitChecker(int shootIndex){
		for (Ship i:ships)		
			for (int j =0 ;j<i.Indexes.size();j++)
				if (i.Indexes.get(j)==shootIndex){
					return true;
				}
		return false;
	}


	/**
	 * 
	 * @param index
	 * the index which hit a ship and method should continue this index to destroy the ship
	 * @return
	 *  true - if the whole ship is destroyed 
	 *  false - if the whole ship is not destroyed yet.
	 */
	public boolean hit (int index1){
		index = index1;
		int objectNumber=getObjectNumber(index);
		if(!ships.get(objectNumber).is_Destroyed(shotPositions)){
			do {
				if (keep==index){
					if (repeated){
						screendisplay.hitShot(index);
						for ( int f=0 ; f<15 ; f++ ){
							screendisplay.updateGraphics();
						}
						repeated=false;
					}
				}else 
				{
					screendisplay.hitShot(index);
					for ( int f=0 ; f<15 ; f++ ){
						screendisplay.updateGraphics();
					}
				}
				if ((index%10)==0){

					if (side==0){
						side++;
						index =keep;
					}
				}
				if ((index%10)==9){
					if (side==1){
						side++;
						index =keep;
					}
				}
				if ((index/10)==0){
					if (side ==2){
						side++;
						index =keep;
					}
				}
				if ((index/10)==9){

					if (side==3){
						side++;
						index =keep;
					}

				}
				switch (side){
				case 0:
					leftHitting(--index);
					break;
				case 1:
					rightHitting(++index);
					break;
				case 2:
					upHitting(index-=10);
					break;
				case 3 :
					downHitting(index+=10);
					break;
				default :
					side=0;
					break;
				}

			} while ((!ships.get(objectNumber).is_Destroyed(shotPositions)) && hitChecker(index));
			if (!ships.get(objectNumber).is_Destroyed(shotPositions)){
				screendisplay.missShot(index);
				for (int f=0; f<15 ; f++){
					screendisplay.updateGraphics();
				}
			}else{
				screendisplay.setShipOrientation(ships.get(objectNumber).Indexes, ships.get(objectNumber).length-1 , ships.get(objectNumber).horVar);
				screendisplay.hitShot(index);
				screendisplay.destroyShot(index);
				for ( int f=0 ; f<15 ; f++ ){
					screendisplay.updateGraphics();
				}

			}
		}
		return ships.get(objectNumber).is_Destroyed(shotPositions);
	}
	/**
	 * @param index
	 * to get one index on the screen and show the objectIndex of that ship in the ArrayList of the ships
	 * @return
	 * one integer number which is objectIndex of the ship
	 * 
	 * 
	 * get the ship object to check it's indexes on screen 
	 */
	public int getObjectNumber(int index){
		for (int i=0;i<ships.size();i++)										
			for (int j =0 ;j<ships.get(i).Indexes.size();j++)
				if (ships.get(i).Indexes.get(j)==index)
					return i;
		return -1;
	}

	/**
	 * 
	 * @param index
	 * one random number 
	 * @return
	 * true if the randomNumber is new one on the screen 
	 * false if there was a previous shot on the screen before 
	 * 
	 *  a method to check if our shot is new on the screen or not
	 */
	public boolean new_Shot(int index){
		for (int i =0;i<shotPositions.size();i++)
			if (index== shotPositions.get(i)){
				return true;
			}
		return false;
	}
	/**
	 * 
	 * @param index
	 * one index to shot 
	 */
	public void rightHitting(int index){
		if (!new_Shot(index)){
			shotPositions.add(index);
		}else{
			this.index=keep;
			side ++;
		}
	}
	/**
	 * 
	 * @param index
	 * one index to shot 
	 */
	public void leftHitting(int index){			
		if (!new_Shot(index)){
			shotPositions.add(index);
		}else{
			this.index=keep;
			side++;
		}
	}
	/**
	 * 
	 * @param index
	 * one index to shot 
	 */
	public void downHitting(int index){			 
		if (!new_Shot(index)){
			shotPositions.add(index);
		}else{
			this.index=keep;
			side++;
		}
	}
	/**
	 * 
	 * @param index
	 * one index to shot 
	 */
	public void upHitting(int index){			 
		if (!new_Shot(index)){
			shotPositions.add(index);
		}
		else{
			this.index=keep;
			side++;
		}
	}
}