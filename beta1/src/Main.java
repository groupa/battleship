
public class Main {
	public static void main (String[] args) {
		//new AudioPlayer("sounds/game.wav").start();
		//AI ai = new AI();
		ScreenDisplayer screendisplay = new ScreenDisplayer();
		while (true) {
			new AudioPlayer("sounds/game.wav").start();
			try {
				Thread.currentThread().sleep(76000);
			}
			catch (Exception e) {}
		 }	
	}
}