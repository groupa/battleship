
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.xml.ws.Holder;

/**
 * 
 * @author Amir Almasi
 * 
 */
public class AI {
	public ArrayList<Integer> shotPositions = new ArrayList<Integer>();
	public ArrayList<Ship> ships = new ArrayList<Ship>();
	private ScreenDisplayer screendisplay ;
	public int side=0, index , keep ;
	public AI (){
		
		showScreen();
		setships(2);
		setships(3);
		setships(4);
		setships(5);
		
		// show the ships on the printOut
		for (Ship i:ships){												//for showing the indexes
			for (int j =0 ;j<i.Indexes.size();j++){
				screendisplay.board1Label.setShips(i.Indexes.get(j));			//screen has problem;
				System.out.print(i.Indexes.get(j)+" ");
			}
			System.out.println();
		}
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
	//	screendisplay = new ScreenDisplayer();
	//	screendisplay.displayCurrentScreen();
	}
	/**
	 * 
	 * make a random number between 0 - 100
	 */
	public int randomizer(){
		int RandomNumber;
		Random myRandomizer = new Random ();
		RandomNumber=Math.abs(myRandomizer.nextInt() % 100 );
		return RandomNumber;

	}
	/**
	 * 
	 * @param maximumRandom
	 * @return integer
	 * 
	 * a  method to make a random number between 0 - maximumRandom
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
	 * to set all ships on the screen
	 */
	public void setships(int length){
		int randomShot , horVer;
		boolean again_Random;
		do {
			horVer = randomizer(2);
			randomShot =randomizer();
			again_Random=collide_detect(randomShot,length , horVer);
		}while (again_Random);							//just for now Horizantall
		ships.add(new Ship(randomShot,length ,horVer ));
	}
	
	/**
	 * 
	 * @param randomShot
	 * @param length
	 * @param horVar
	 * @return
	 *  a method to check if a new ship cross the previous ones or not 
	 * 
	 * 
	 */
	public boolean collide_detect (int randomShot ,int length, int horVar ){
		if (horVar==0){
			if ((randomShot%10)+length>9)
				return true;
		}else{
			if ((randomShot)+(length*10)>99)
				return true;
		}
		for (Ship ship:ships){
			if (horVar==0){
				if ((randomShot%10)+length>9)
					return true;
				for (int j =0 ;j<ship.Indexes.size();j++){
					for (int x=randomShot; x <=(randomShot+length);x++){
						if (ship.Indexes.get(j)==x){
							return true;
						}
					}
				}
			}else {
				for (int j =0 ;j<ship.Indexes.size();j++){
					for (int x=randomShot; x <=(randomShot+(length*10));x+=10){
						if (ship.Indexes.get(j)==x){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	/**
	 * playing the game and start first random shoot
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
					random_Shot=randomizer();
				}while (new_Shot(random_Shot));
				shotPositions.add(random_Shot);

			}
			System.out.println(random_Shot);
			if (hitChecker(random_Shot)){
				keep = random_Shot;
				if (!hit(random_Shot)){
					keep_Shotting=true;
					++side;
					System.out.println("variable should be countinued    " + "Side is : " + side);
				}
				else {
					keep_Shotting=false;
					side=0;					// keep_Shottng could be deleted and use side = 0;
				}
			}else{
				screendisplay.missShot(random_Shot, 0);
				for (int f=0; f<15 ; f++){
					screendisplay.updateGraphics();
				}
			}
			System.out.println("User should shot (index between 0-99)");
			user_quess = scan.nextInt();
		}while (user_quess>0);
	}
	/**
	 * 
	 * @param shootIndex
	 * @return
	 * a method to check if random shot hit any ships or not
	 */
	public boolean hitChecker(int shootIndex){
		for (Ship i:ships)												//for showing the indexes
			for (int j =0 ;j<i.Indexes.size();j++)
				if (i.Indexes.get(j)==shootIndex){
					return true;
				}
		return false;
	}
	/**
	 * 
	 * @param index
	 * @return
	 *  a method to continue shotting if hitCkecker returns true
	 *   
	 */
	public boolean hit (int index1){
		index = index1;
		System.out.println("hit function Starting");
		int objectNumber=getObjectNumber(index);
		System.out.println("objectNumber : " + objectNumber);
		if(!ships.get(objectNumber).is_Destroyed(shotPositions)){
			System.out.println("is destroyed :"+ ships.get(objectNumber).is_Destroyed(shotPositions));
			do {
				screendisplay.hitShot(index, 0);
				for ( int f=0 ; f<15 ; f++ ){
					screendisplay.updateGraphics();
				}
				if ((index%10)==0){

					if (side==0){
						System.out.println("amir% left=0"+index%10);
						side++;
						index =keep;
					}
				}
				if ((index%10)==9){

					if (side==1){
						System.out.println("amir% right=9"+index%10);
						side++;
						index =keep;
					}
				}
				if ((index/10)==0){

					if (side ==2){
						System.out.println("amir/ up=0"+index/10);
						side++;
						index =keep;
					}
				}
				if ((index/10)==9){

					if (side==3){
						System.out.println("amir/ down=9"+index/10);
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
			System.out.println("is destroyed "+ships.get(objectNumber).is_Destroyed(shotPositions));
			if (!ships.get(objectNumber).is_Destroyed(shotPositions)){
				screendisplay.missShot(index, 0);
				for (int f=0; f<15 ; f++){
					screendisplay.updateGraphics();
				}
			}else{
				screendisplay.setShipOrientation(ships.get(objectNumber).Indexes, ships.get(objectNumber).length-1 , ships.get(objectNumber).horVar, 0);
				screendisplay.hitShot(index, 0);
				screendisplay.destroyShot(index, 0);
				for ( int f=0 ; f<15 ; f++ ){
					screendisplay.updateGraphics();
				}
				
			}
		}
		return ships.get(objectNumber).is_Destroyed(shotPositions);
	}
	/**
	 * @param index
	 * @return
	 * get the ship object to check it's indexes on screen 
	 */
	public int getObjectNumber(int index){
		for (int i=0;i<ships.size();i++)										//for showing the indexes
			for (int j =0 ;j<ships.get(i).Indexes.size();j++)
				if (ships.get(i).Indexes.get(j)==index)
					return i;
		return -1;
	}

	/**
	 * 
	 * @param index
	 * @return
	 *  a method to check if our shot is new on the screen or not
	 */
	public boolean new_Shot(int index){
		for (int i =0;i<shotPositions.size();i++)
			if (index== shotPositions.get(i)){
				return true;
			}
		return false;
	}
	public void rightHitting(int index){			//it could return one boolean
		if (!new_Shot(index)){
			shotPositions.add(index);
		}else{
			this.index=keep;
			side ++;
		}
		System.out.println(index);
	}
	public void leftHitting(int index){			//it could return one boolean
		if (!new_Shot(index)){
			shotPositions.add(index);
		}else{
			this.index=keep;
			side++;
		}
		System.out.println(index);
	}
	public void downHitting(int index){			//it could return one boolean 
		if (!new_Shot(index)){
			shotPositions.add(index);
		}else{
			this.index=keep;
			side++;
		}
		System.out.println(index);
	}
	public void upHitting(int index){			//it could return one boolean 
		if (!new_Shot(index)){
			shotPositions.add(index);
		}
		else{
			this.index=keep;
			side++;
		}
		System.out.println(index);
	}
}