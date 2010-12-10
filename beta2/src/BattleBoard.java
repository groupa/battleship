import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * 
 * @author Amir Almasi
 *
 */
public class BattleBoard extends JLabel {
	public ArrayList<Ship> ships = new ArrayList<Ship>();
	public boolean [] ships_Flag= new boolean [101];
	public int Index;
	public LocalGame _game;
	private boolean clickable;
	
	public BattleBoard() {
		// TODO Auto-generated constructor stub
		this (100);
		Index = -1;
		
	}
	
	public BattleBoard(int _difficulty, int np) {
		// TODO Auto-generated constructor stub
		this (100);
		Index = -1;
		
	}
	
	public BattleBoard(LocalGame game) {
		// TODO Auto-generated constructor stub
		this (100);
		Index = -1;

	}
	
	public BattleBoard(int index1){
	//	_game = new LocalGame(0);
		setships(2);
		setships(3);
		setships(4);
		setships(5);
		for (Ship i:ships){												//for showing the indexes
			for (int j =0 ;j<i.Indexes.size();j++){
		//_game.screendisplayer.board1Label.setShips(i.Indexes.get(j));			//screen has problem;
				System.out.print(i.Indexes.get(j)+" ");
			}
			System.out.println();
		}
		setVisible(false);
		addMouseMotionListener(new MouseHandler());
		addMouseListener(new MouseHandler());

	}
	
	public void setImageBoard (ImageIcon image, int x , int y ){
		setIcon(image);
		setBounds(x, y, image.getIconWidth(),image.getIconHeight());
	}
	public int getIndex (int x ,int y) {
		Index = -1;
		if (x > 0) {
		System.out.println("X: "+x +" y: "+ y);
		Index = ((Math.abs(x / 33))+((Math.abs(y /33)*10)));
		
		System.out.println("X: " + x);
		}
		return Index;
	}
	
	public int getIndex () {
			return Index;
	}
	
	public void reset() 
	{
		Index = -1;
	}
	
	public void move(int index) {
	//	_game = new LocalGame();
		_game.move(index);
	}
	
	public boolean getIndexChecker(int x , int y) {
		//return ships_Flag[getIndex(x, y)];
		return false;
	}
	
	LocalGame getGame() {
		return _game;
	}
	
	void setGame(LocalGame game) {
		_game = game;
	}
	
	void setClickable(boolean _clickable) {
		clickable = _clickable;
	}
	
	boolean getClickable() {
		return clickable;
	}
	
	public void setShips(int index1){
		ships_Flag[index1]=true;
//		for (int i =0;i<100;i++)
//			if (ships_Flag[i])
//			System.out.print(i+""+ships_Flag[i]+" ");
	}
	
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
	 
	 public int randomizer(){
			int RandomNumber;
			Random myRandomizer = new Random ();
			RandomNumber=Math.abs(myRandomizer.nextInt() % 100 );
			return RandomNumber;

		}
	 
	 public int randomizer(int maximumRandom){
			int RandomNumber;
			Random myRandomizer = new Random ();
			RandomNumber=Math.abs(myRandomizer.nextInt() % maximumRandom );
			return RandomNumber;

		}
	
	private class MouseHandler implements MouseListener , MouseMotionListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub

		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			//_game.move(getIndex(e.getX(), e.getY()));
			//getGame().move(-34);
			if (clickable) {
			System.out.println("Index: " + getIndex(e.getX(), e.getY()));
			move(getIndex(e.getX(), e.getY()));
			}
			//System.out.println(getIndexChecker(e.getX(), e.getY()));
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

}
