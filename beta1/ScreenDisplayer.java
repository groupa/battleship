import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

/**
 * 
 * @author Johan and Sebastian
 * 
 */

public class ScreenDisplayer extends BackgroundPanel implements MouseInputListener {
	// value for controlling the current displayed screen.
	private int currentScreen = 1;
	private LocalGame localGame;
	int[] counter = new int[6];
	
	/**
	 * Constructor for screendisplayer:
	 * mouselistener added, counter value for animations initialized
	 */
	public ScreenDisplayer() {
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);
		for (int i = 0; i < 6; i++)
			counter[i] = 0;
	}
	
	/**
	 * calls the methods for setting labels to visible/invisible
	 */
	public void displayCurrentScreen() {
		switch (currentScreen) {
		case 1: displayStart();
		break;
		case 2: displayNewGame();
		break;
		case 3: displayInstructions();
		break;
		case 4: displayHighscore();
		break;
		case 5: displayCredits();
		break;
		case 6: displayDifficulty();
		break;
		case 7: displayNetworkMode();
		break;
		case 8: displayLogin();
		break;
		case 9: displayServers();
		break;
		case 10: displayLobby();
		break;
		case 11: displayGame();
		break;
		case 12: exit();
		break;
		}
	}

	/**
	 * Sets the visibility of all the labels to either true or false.
	 */
	
	/**
	 * Displays startscreen.
	 */
	private void displayStart() {
		
		//true
		StarshipBattleTextStart.setVisible(true);
		BackgroundShip1.setVisible(true);
		BackgroundShip2.setVisible(true);
		NewgameText.setVisible(true);
		InstructionsSmallText.setVisible(true);
		HighscoreText.setVisible(true);
		ExitGameText.setVisible(true);
		winGame.setVisible(false);
		loseGame.setVisible(false);
		mainMenu.setVisible(false);
		//false
		whatIsHit.setVisible(false);
		whatIsMiss.setVisible(false);
		gameErrors.setVisible(false);
		highScore.setVisible(false);
		ship1.setVisible(false);
		ship2.setVisible(false);
		ship3.setVisible(false);
		ship4.setVisible(false);
		ship5.setVisible(false);
		PlayerVsComp.setVisible(false);
		PlayerVsPlayer.setVisible(false);
		TwoPlayerVsTwoPlayer.setVisible(false);
		back.setVisible(false);
		InstructionsBigText.setVisible(false);
		InstructionsText.setVisible(false);
		HighscoreBigText.setVisible(false);
		BigInput.setVisible(false);
		Credits.setVisible(false);
		board1Label.setVisible(false);
		board2Label.setVisible(false);
		StarshipBattleTextLabel.setVisible(false);
		enemyBoardText.setVisible(false);
		myBoardText.setVisible(false);
		returnToMain.setVisible(false);
		ip.setVisible(false);
		serverName.setVisible(false);
		password.setVisible(false);
		newPassword.setVisible(false);
		verifyPassword.setVisible(false);
	}
	
	/**
	 * Displays New game Screen
	 */
	private void displayNewGame() {
		//true
		PlayerVsComp.setVisible(true);
		PlayerVsPlayer.setVisible(true);
		TwoPlayerVsTwoPlayer.setVisible(true);
		back.setVisible(true);
		//false
		gameErrors.setVisible(false);
		StarshipBattleTextStart.setVisible(false);
		BackgroundShip1.setVisible(false);
		BackgroundShip2.setVisible(false);
		NewgameText.setVisible(false);
		InstructionsSmallText.setVisible(false);
		HighscoreText.setVisible(false);
		ExitGameText.setVisible(false);
		Difficulty.setVisible(false);
		Easy.setVisible(false);
		Medium.setVisible(false);
		Hard.setVisible(false);
		NetworkMode.setVisible(false);
		Online.setVisible(false);
		Lan.setVisible(false);
	}
	
	/**
	 * Displays Instruction screen.
	 */
	private void displayInstructions() {
		//true
		back.setVisible(true);
		InstructionsBigText.setVisible(true);
		InstructionsText.setVisible(true);
		//false
		StarshipBattleTextStart.setVisible(false);
		BackgroundShip1.setVisible(false);
		BackgroundShip2.setVisible(false);
		NewgameText.setVisible(false);
		InstructionsSmallText.setVisible(false);
		HighscoreText.setVisible(false);
		ExitGameText.setVisible(false);
	}

	/**
	 * Displays Highscore Screen.
	 */
	private void displayHighscore() {
		//true
		HighscoreBigText.setVisible(true);
		BigInput.setVisible(true);
		back.setVisible(true);
		highScore.setVisible(true);
		//false
		StarshipBattleTextStart.setVisible(false);
		BackgroundShip1.setVisible(false);
		BackgroundShip2.setVisible(false);
		NewgameText.setVisible(false);
		InstructionsSmallText.setVisible(false);
		HighscoreText.setVisible(false);
		ExitGameText.setVisible(false);
	}

	/**
	 * Displays Credit screen.
	 */
	private void displayCredits() {
		//true
		Credits.setVisible(true);
		//false
		StarshipBattleTextStart.setVisible(false);
		BackgroundShip1.setVisible(false);
		BackgroundShip2.setVisible(false);
		NewgameText.setVisible(false);
		InstructionsSmallText.setVisible(false);
		HighscoreText.setVisible(false);
		ExitGameText.setVisible(false);
		back.setVisible(false);
		currentScreen = 12;
	}

	/**
	 * Displays Difficulty screen.
	 */
	private void displayDifficulty() {
		//true
		back.setVisible(true);
		Difficulty.setVisible(true);
		Easy.setVisible(true);
		Medium.setVisible(true);
		Hard.setVisible(true);
		//false
		PlayerVsComp.setVisible(false);
		PlayerVsPlayer.setVisible(false);
		TwoPlayerVsTwoPlayer.setVisible(false);
		Credits.setVisible(false);

	}

	/**
	 * Displays Network screen.
	 */
	private void displayNetworkMode() {
		//true
		NetworkMode.setVisible(true);
		Online.setVisible(true);
		Lan.setVisible(true);
		back.setVisible(true);
		//false
		loginCreate.setVisible(false);
		PlayerVsComp.setVisible(false);
		PlayerVsPlayer.setVisible(false);
		TwoPlayerVsTwoPlayer.setVisible(false);
		Credits.setVisible(false);
		Login.setVisible(false);
		Login2.setVisible(false);
		SmallInput.setVisible(false);
		SmallInput2.setVisible(false);
		SmallInput3.setVisible(false);
		SmallInput4.setVisible(false);
		SmallInput5.setVisible(false);
		CreateNewAccount.setVisible(false);
		Create.setVisible(false);
		username.setVisible(false);
		password.setVisible(false);
		newUsername.setVisible(false);
		newPassword.setVisible(false);
		verifyPassword.setVisible(false);
	}

	/**
	 * Displays LoginScreen
	 */
	private void displayLogin() {
		//true
		back.setVisible(true);
		Login.setVisible(true);
		Login2.setVisible(true);
		SmallInput.setVisible(true);
		SmallInput2.setVisible(true);
		SmallInput3.setVisible(true);
		SmallInput4.setVisible(true);
		SmallInput5.setVisible(true);
		CreateNewAccount.setVisible(true);
		Create.setVisible(true);
		username.setVisible(true);
		password.setVisible(true);
		newUsername.setVisible(true);
		newPassword.setVisible(true);
		verifyPassword.setVisible(true);
		loginCreate.setVisible(true);
		//false
		serversError.setVisible(false);
		Credits.setVisible(false);
		NetworkMode.setVisible(false);
		Online.setVisible(false);
		Lan.setVisible(false);
		Servers.setVisible(false);
		BigInput2.setVisible(false);
		LongInput.setVisible(false);
		LongInput2.setVisible(false);
		Join.setVisible(false);
		Create2.setVisible(false);
		returnToMain.setVisible(false);
		ip.setVisible(false);
		serverName.setVisible(false);
	}

	/**
	 * Displays Server Screen.
	 */
	private void displayServers() {
		//true
		back.setVisible(true);
		Servers.setVisible(true);
		BigInput2.setVisible(true);
		LongInput.setVisible(true);
		LongInput2.setVisible(true);
		Join.setVisible(true);
		Create2.setVisible(true);
		ip.setVisible(true);
		serverName.setVisible(true);
		serversError.setVisible(true);
		//false
		getServerName.setVisible(false);
		getIpNumber.setVisible(false);
		getPlayerNames.setVisible(false);
		loginCreate.setVisible(false);
		Credits.setVisible(false);
		Login.setVisible(false);
		Login2.setVisible(false);
		SmallInput.setVisible(false);
		SmallInput2.setVisible(false);
		SmallInput3.setVisible(false);
		SmallInput4.setVisible(false);
		SmallInput5.setVisible(false);
		CreateNewAccount.setVisible(false);
		Create.setVisible(false);
		MediumInput.setVisible(false);
		Start.setVisible(false);
		Cancel.setVisible(false);
		username.setVisible(false);
		password.setVisible(false);
		newUsername.setVisible(false);
		newPassword.setVisible(false);
		verifyPassword.setVisible(false);
	}

	/**
	 * Displays Lobby Screen.
	 */
	private void displayLobby() {
		//true
		MediumInput.setVisible(true);
		Start.setVisible(true);
		Cancel.setVisible(true);
		getServerName.setVisible(true);
		getIpNumber.setVisible(true);
		getPlayerNames.setVisible(true);
		//false
		gameErrors.setVisible(false);
		serversError.setVisible(false);
		back.setVisible(false);
		Credits.setVisible(false);
		Servers.setVisible(false);
		BigInput2.setVisible(false);
		LongInput.setVisible(false);
		LongInput2.setVisible(false);
		Join.setVisible(false);
		Create2.setVisible(false);
		ip.setVisible(false);
		serverName.setVisible(false);
	}

	/**
	 * Displays Game Screen.
	 */
	private void displayGame() {
		//true
		board1Label.setVisible(true);
		board2Label.setVisible(true);
		StarshipBattleTextLabel.setVisible(true);
		enemyBoardText.setVisible(true);
		myBoardText.setVisible(true);
		returnToMain.setVisible(true);
		ship1.setVisible(true);
		ship2.setVisible(true);
		ship3.setVisible(true);
		ship4.setVisible(true);
		ship5.setVisible(true);
		gameErrors.setVisible(true);
		whatIsHit.setVisible(true);
		whatIsMiss.setVisible(true);

		//false
		getServerName.setVisible(false);
		getIpNumber.setVisible(false);
		getPlayerNames.setVisible(false);
		back.setVisible(false);
		InstructionsBigText.setVisible(false);
		InstructionsText.setVisible(false);
		Credits.setVisible(false);
		Difficulty.setVisible(false);
		Easy.setVisible(false);
		Medium.setVisible(false);
		Hard.setVisible(false);
		MediumInput.setVisible(false);
		Start.setVisible(false);
		Cancel.setVisible(false);
	}
	
	/**
	 * Displays Game Finished screen.
	 * Receives one argument (int) that controls if it displays win or loose.
	 * 0=win, anything else is loose.
	 */
	public void displayFinished(int i) {
		emptyArrays();
		//true
		if (i == 0) {
			winGame.setVisible(true);
			if (dBg)
				System.out.println("Win screen displayed");
		}
		else {
			loseGame.setVisible(true);
			if (dBg)
				System.out.println("Loose screen displayed");
		}
		mainMenu.setVisible(true);
		//false
		board1Label.setVisible(false);
		board2Label.setVisible(false);
		StarshipBattleTextLabel.setVisible(false);
		enemyBoardText.setVisible(false);
		myBoardText.setVisible(false);
		returnToMain.setVisible(false);
		ship1.setVisible(false);
		ship2.setVisible(false);
		ship3.setVisible(false);
		ship4.setVisible(false);
		ship5.setVisible(false);
		gameErrors.setVisible(false);
		whatIsHit.setVisible(false);
		whatIsMiss.setVisible(false);
	}

	/* This method must be called at each iteration of the game play loop.
	   This method updates the graphic 20frames per second
	   game loop can never stop, or else the animations flow is at risk.
	 */
	public void updateGraphics () {
		/**
		 * Small explosion animation
		 */
		if (smallXplsn.isVisible()) {
			if (dBg && counter[0] == 0)
				System.out.println("Small Explosion Animation starts");
			smallXplsn.setIcon(new ImageIcon(smallXplsnBuff.getSubimage(counter[0]*34, counter[1]*34, 34, 34)));
			counter[0]++;
			if (counter[1] == 3 && counter [0] == 3) {
				if (dBg)
					System.out.println("Small Explosion Animation Finished");
				smallXplsn.setVisible(false);
				smallXplsn.setIcon(new ImageIcon(smallXplsnBuff.getSubimage(0, 0, 34, 34)));
				counter[0] = 0;
				counter[1] = 0;
				showHit(smallXplsn.getX(), smallXplsn.getY());
			}
			else if (counter[0] == 3) {
				counter[1]++;
				counter[0] = 0;
			}
		}
		
		/**
		 * Big Explosion Animation
		 */
		if (bigXplsn.isVisible()) {
			if (dBg && counter[2] == 0)
				System.out.println("Big Explosion Animation starts");
			bigXplsn.setIcon(new ImageIcon(bigXplsnBuff.getSubimage(counter[2]*64, counter[3]*64, 64, 64)));
			counter[2]++;
			if (counter[3] == 3 && counter [2] == 3) {
				if (dBg)
					System.out.println("Big Explosion Animation Finished");
				bigXplsn.setVisible(false);
				bigXplsn.setIcon(new ImageIcon(bigXplsnBuff.getSubimage(0, 0, 64, 64)));
				counter[2] = 0;
				counter[3] = 0;
			}
			else if (counter[2] == 3) {
				counter[3]++;
				counter[2] = 0;
			}
		}
		
		/**
		 * Miss animation
		 */
		if (missAni.isVisible()) {
			if (dBg && counter[4] == 0)
				System.out.println("miss Animation starts");
			missAni.setIcon(new ImageIcon(missAniBuff.getSubimage(counter[4]*34, counter[5]*34, 34, 34)));
			counter[4]++;
			if (counter[5] == 3 && counter [4] == 3) {
				if (dBg)
					System.out.println("miss Animation Finished");
				missAni.setVisible(false);
				missAni.setIcon(new ImageIcon(missAniBuff.getSubimage(0, 0, 34, 34)));
				counter[4] = 0;
				counter[5] = 0;
				showMiss(missAni.getX(), missAni.getY());
			}
			else if (counter[4] == 3) {
				counter[5]++;
				counter[4] = 0;
			}
		}

		// this block controls the frame rate. (how fast the game updates) you can modify the value here.
		try {
			Thread.currentThread().sleep(50);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Activates the shot-hits-related methods (animation, sound, indication)
	 * indx = what cell index
	 * board = on which board.
	 */
	public void hitShot (int indx, int board) {
		smallXplsn.setLocation(40 + ((indx%10))*34 + 380 * (board - 1), 220 + ((indx/10))*34);
		smallXplsn.setVisible(true);
		playHit();
		if (dBg)
			System.out.println("small explosion located in x: " +(40 + ((indx%10))*34 + 380 * (board - 1)) + " y: " + (220 + ((indx/10))*34));
	}

	/**
	 * Activates the shot-misses-related methods (animation, sound, indication)
	 * indx = what cell index
	 * board = on which board.
	 */
	public void missShot (int indx, int board) {
		missAni.setLocation(40 + ((indx%10))*34 + 380 * (board - 1), 220 + ((indx/10))*34);
		missAni.setVisible(true);
		playMiss();
		if (dBg)
			System.out.println("Miss animation located in x: " +(40 + ((indx%10))*34 + 380 * (board - 1)) + " y: " + (220 + ((indx/10))*34));
	}

	/**
	 * Activates the ship-destroyed-related methods (animation, sound, indication)
	 * indx = what cell index
	 * board = on which board.
	 */
	public void destroyShot (int indx, int board) {
		bigXplsn.setLocation(8 + ((indx%10))*34 + 380 * (board - 1), 188 + ((indx/10))*34);
		bigXplsn.setVisible(true);
		playDestroyed();
		if (dBg)
			System.out.println("Big explosion located in x: " +(8 + ((indx%10))*34 + 380 * (board - 1)) + " y: " + (188 + ((indx/10))*34));
	}

	/**
	 * Adds a new label placed in the Arraylist hits and shows it.
	 * @param x= coordinates   
	 * @param y= coordinates  
	 */
	private void showHit (int x, int y) {
		ImageIcon image = new ImageIcon("img/hit.png");
		hits.add(new JLabel(image));
		hits.get(hits.size() - 1).setBounds(x, y, image.getIconWidth(), image.getIconHeight());
		hits.get(hits.size() - 1).setVisible(true);
		layeredPane.add(hits.get(hits.size() - 1), new Integer(4));
		if (dBg)
			System.out.println("Hit indicator shown at x: " +x +" y: " +y);
	}
	
	/** Adds a new label placed in the Arraylist misses and shows it.
	 * @param x= coordinates   
	 * @param y= coordinates  
	 */
	private void showMiss (int x, int y) {
		ImageIcon image = new ImageIcon("img/miss.png");
		misses.add(new JLabel(image));
		misses.get(misses.size() - 1).setBounds(x, y, image.getIconWidth(), image.getIconHeight());
		misses.get(misses.size() - 1).setVisible(true);
		layeredPane.add(misses.get(misses.size() - 1), new Integer(4));
		if (dBg)
			System.out.println("Miss indicator shown at x: " +x +" y: " +y);
	}

	/**
	 * plays hit sound
	 */
	private void playHit() {
		new AudioPlayer("sounds/hit.wav").start();
		if (dBg)
			System.out.println("hit sound played");
	}
	
	/**
	 * plays miss sound
	 */
	private void playMiss() {
		new AudioPlayer("sounds/laser.wav").start();
		if (dBg)
			System.out.println("miss sound played");
	}
	
	/**
	 * plays ship destroyed sound
	 */
	private void playDestroyed() {
		new AudioPlayer("sounds/kaboom.wav").start();
		if (dBg)
			System.out.println("destroyed ship sound played");
	}

	/** 
	 * Exits the program.
	 * Invoked when credits-screen is entered. 5 seconds after the game exits, giving
	 * the user time to read.
	 */
	private void exit () {
		try {
			Thread.currentThread().sleep(5000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	/**
	 * If statements for checking if any, and which label is pressed, then changes it appearance
	 */
	public void mousePressed(MouseEvent e) {
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == NewgameText) {
			NewgameText.setIcon(new ImageIcon("img/newgamepush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == InstructionsSmallText) {
			InstructionsSmallText.setIcon(new ImageIcon("img/Instructionspush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == HighscoreText) {
			HighscoreText.setIcon(new ImageIcon("img/highscorepush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == ExitGameText) {
			ExitGameText.setIcon(new ImageIcon("img/exitgamepush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == back) {
			back.setIcon(new ImageIcon("img/backpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == PlayerVsComp) {
			PlayerVsComp.setIcon(new ImageIcon("img/playvscomptextpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == PlayerVsPlayer) {
			PlayerVsPlayer.setIcon(new ImageIcon("img/playervsplayertextpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == TwoPlayerVsTwoPlayer) {
			TwoPlayerVsTwoPlayer.setIcon(new ImageIcon("img/2playervs2playertextpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Easy) {
			Easy.setIcon(new ImageIcon("img/easytextpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Medium) {
			Medium.setIcon(new ImageIcon("img/mediumtextpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Hard) {
			Hard.setIcon(new ImageIcon("img/hardtextpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Online) {
			Online.setIcon(new ImageIcon("img/onlinetextpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Lan) {
			Lan.setIcon(new ImageIcon("img/lantextpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Login2) {
			Login2.setIcon(new ImageIcon("img/loginpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Create) {
			Create.setIcon(new ImageIcon("img/createpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Join) {
			Join.setIcon(new ImageIcon("img/joinpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Create2) {
			Create2.setIcon(new ImageIcon("img/createpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Start) {
			Start.setIcon(new ImageIcon("img/starttextpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Cancel) {
			Cancel.setIcon(new ImageIcon("img/cancelpush.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == returnToMain) {
			returnToMain.setIcon(new ImageIcon("img/return to main menu push.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == mainMenu) {
			mainMenu.setIcon(new ImageIcon("img/mainmenupush.png"));
		}
		displayCurrentScreen();
	}

	//If statements checking if any, and which label was clicked. Takes the player another screen.
	public void mouseReleased(MouseEvent e) {
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == NewgameText) {
			currentScreen = 2;
			if (dBg)
				System.out.println("New game screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != NewgameText) {
			NewgameText.setIcon(new ImageIcon("img/New game text.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == InstructionsSmallText) {
			currentScreen = 3;
			if (dBg)
				System.out.println("Instructions screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != InstructionsSmallText) {
			InstructionsSmallText.setIcon(new ImageIcon("img/instructionstext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == HighscoreText) {
			currentScreen = 4;
			if (dBg)
				System.out.println("Highscore screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != HighscoreText) {
			HighscoreText.setIcon(new ImageIcon("img/highscoretext.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == ExitGameText) {
			currentScreen = 5;
			if (dBg)
				System.out.println("Game exits after 5seconds delay, and credit screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != ExitGameText) {
			ExitGameText.setIcon(new ImageIcon("img/exit game.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == PlayerVsComp) {
			currentScreen = 6;
			if (dBg)
				System.out.println("Difficulty screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != PlayerVsComp) {
			PlayerVsComp.setIcon(new ImageIcon("img/playvscomptext.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == PlayerVsPlayer) {
			currentScreen = 7;
			if (dBg)
				System.out.println("Network Mode screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != PlayerVsPlayer) {
			PlayerVsPlayer.setIcon(new ImageIcon("img/playervsplayertext.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == TwoPlayerVsTwoPlayer) {
			currentScreen = 7;
			if (dBg)
				System.out.println("Network Mode screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != TwoPlayerVsTwoPlayer) {
			TwoPlayerVsTwoPlayer.setIcon(new ImageIcon("img/2playervs2playertext.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Easy) {
			if (dBg)
				System.out.println("game screen displayed");
			currentScreen = 11;
			localGame = new LocalGame(this, 0);
			board1Label.setGame(localGame);
			board2Label.setGame(localGame);
			board1Label.setClickable(false);
			board2Label.setClickable(true);
			
			
			
		}
		
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Easy) {
			Easy.setIcon(new ImageIcon("img/easytext.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Medium) {
			currentScreen = 11;
			if (dBg)
				System.out.println("game screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Medium) {
			Medium.setIcon(new ImageIcon("img/mediumtext.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Hard) {
			currentScreen = 11;
			if (dBg)
				System.out.println("game screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Hard) {
			Hard.setIcon(new ImageIcon("img/hardtext.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Online) {
			currentScreen = 8;
			if (dBg)
				System.out.println("Login screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Online) {
			Online.setIcon(new ImageIcon("img/onlinetext.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Lan) {
			currentScreen = 8;
			if (dBg)
				System.out.println("Login screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Lan) {
			Lan.setIcon(new ImageIcon("img/lantext.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Login2) {
			char[] passwordSequence = password.getPassword();
			String userNameString = username.getText();
			System.out.println("\n" + userNameString);
			for (int i = 0; i < passwordSequence.length; i++)
				System.out.print(passwordSequence[i]);
			currentScreen = 9;
			if (dBg)
				System.out.println("Server screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Login2) {
			Login2.setIcon(new ImageIcon("img/login.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Create) {
			char[] newPasswordSequence = newPassword.getPassword();
			char[] verPassSequence = verifyPassword.getPassword();
			String newUserNameString = newUsername.getText();
			currentScreen = 9;
			if (dBg)
				System.out.println("Server screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Create) {
			Create.setIcon(new ImageIcon("img/create.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Join) {
			String ipString = ip.getText();
			currentScreen = 10;
			if (dBg)
				System.out.println("Lobby screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Join) {
			Join.setIcon(new ImageIcon("img/join.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Create2) {
			String serverNameString = serverName.getText();
			currentScreen = 10;
			if (dBg)
				System.out.println("Lobby screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Create2) {
			Create2.setIcon(new ImageIcon("img/create.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Start) {
			currentScreen = 11;
			if (dBg)
				System.out.println("Game screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Start) {
			Start.setIcon(new ImageIcon("img/starttext.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Cancel) {
			currentScreen = 9;
			if (dBg)
				System.out.println("Server screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Cancel) {
			Cancel.setIcon(new ImageIcon("img/cancel.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == returnToMain) {
			emptyArrays();
			currentScreen = 1;
			if (dBg)
				System.out.println("start screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != returnToMain) {
			returnToMain.setIcon(new ImageIcon("img/return to main menu.png"));
		}
		
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == mainMenu) {
			currentScreen = 1;
			if (dBg)
				System.out.println("start screen displayed");
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != mainMenu) {
			mainMenu.setIcon(new ImageIcon("img/mainmenu.png"));
		}

		if (layeredPane.findComponentAt(e.getX(), e.getY()) == back) {
			switch (currentScreen) {
			case 2: currentScreen = 1;
				if (dBg)
					System.out.println("start screen displayed");
			break;
			case 3: currentScreen = 1;
				if (dBg)
					System.out.println("start screen displayed");
			break;
			case 4: currentScreen = 1;
				if (dBg)
					System.out.println("start screen displayed");
			break;
			case 6: currentScreen = 2;
			if (dBg)
				System.out.println("New Game screen displayed");
			break;
			case 7: currentScreen = 2;
			if (dBg)
				System.out.println("start screen displayed");
			break;
			case 8: currentScreen = 7;
			if (dBg)
				System.out.println("Network mode screen displayed");
			break;
			case 9: currentScreen = 8;
			if (dBg)
				System.out.println("Login screen displayed");
			break;
			}
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != back) {
			back.setIcon(new ImageIcon("img/back.png"));
		}
		displayCurrentScreen();
	}

	public void mouseDragged(MouseEvent e) {

	}

	/**
	 * If statements to see if any labels are hoovered over. If so, the image is changed. If left, the image is changed.
	 */
	public void mouseMoved(MouseEvent e) {
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != NewgameText) {
			NewgameText.setIcon(new ImageIcon("img/New game text.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == NewgameText) {
			NewgameText.setIcon(new ImageIcon("img/newgameholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != InstructionsSmallText) {
			InstructionsSmallText.setIcon(new ImageIcon("img/instructionstext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == InstructionsSmallText) {
			InstructionsSmallText.setIcon(new ImageIcon("img/Instructionsholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != HighscoreText) {
			HighscoreText.setIcon(new ImageIcon("img/highscoretext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == HighscoreText) {
			HighscoreText.setIcon(new ImageIcon("img/highscoreholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != ExitGameText) {
			ExitGameText.setIcon(new ImageIcon("img/exit game.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == ExitGameText) {
			ExitGameText.setIcon(new ImageIcon("img/exit game holdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != back) {
			back.setIcon(new ImageIcon("img/back.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == back) {
			back.setIcon(new ImageIcon("img/backholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != PlayerVsComp) {
			PlayerVsComp.setIcon(new ImageIcon("img/playvscomptext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == PlayerVsComp) {
			PlayerVsComp.setIcon(new ImageIcon("img/playvscompholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != PlayerVsPlayer) {
			PlayerVsPlayer.setIcon(new ImageIcon("img/playervsplayertext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == PlayerVsPlayer) {
			PlayerVsPlayer.setIcon(new ImageIcon("img/playervsplayertextholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != TwoPlayerVsTwoPlayer) {
			TwoPlayerVsTwoPlayer.setIcon(new ImageIcon("img/2playervs2playertext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == TwoPlayerVsTwoPlayer) {
			TwoPlayerVsTwoPlayer.setIcon(new ImageIcon("img/2playervs2playertextholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Easy) {
			Easy.setIcon(new ImageIcon("img/easytext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Easy) {
			Easy.setIcon(new ImageIcon("img/easytextholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Medium) {
			Medium.setIcon(new ImageIcon("img/mediumtext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Medium) {
			Medium.setIcon(new ImageIcon("img/mediumtextholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Hard) {
			Hard.setIcon(new ImageIcon("img/hardtext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Hard) {
			Hard.setIcon(new ImageIcon("img/hardtextholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Online) {
			Online.setIcon(new ImageIcon("img/onlinetext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Online) {
			Online.setIcon(new ImageIcon("img/onlinetextholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Lan) {
			Lan.setIcon(new ImageIcon("img/lantext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Lan) {
			Lan.setIcon(new ImageIcon("img/lantextholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Login2) {
			Login2.setIcon(new ImageIcon("img/login.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Login2) {
			Login2.setIcon(new ImageIcon("img/loginholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Create) {
			Create.setIcon(new ImageIcon("img/create.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Create) {
			Create.setIcon(new ImageIcon("img/createholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Join) {
			Join.setIcon(new ImageIcon("img/join.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Join) {
			Join.setIcon(new ImageIcon("img/joinholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Create2) {
			Create2.setIcon(new ImageIcon("img/create.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Create2) {
			Create2.setIcon(new ImageIcon("img/createholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Start) {
			Start.setIcon(new ImageIcon("img/starttext.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Start) {
			Start.setIcon(new ImageIcon("img/starttextholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != Cancel) {
			Cancel.setIcon(new ImageIcon("img/cancel.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == Cancel) {
			Cancel.setIcon(new ImageIcon("img/cancelholdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != returnToMain) {
			returnToMain.setIcon(new ImageIcon("img/return to main menu.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == returnToMain) {
			returnToMain.setIcon(new ImageIcon("img/return to main menu holdover.png"));
		}
		if (layeredPane.findComponentAt(e.getX(), e.getY()) != mainMenu) {
			mainMenu.setIcon(new ImageIcon("img/mainmenu.png"));
		}	
		if (layeredPane.findComponentAt(e.getX(), e.getY()) == mainMenu) {
			mainMenu.setIcon(new ImageIcon("img/mainmenuholdover.png"));
		}
		displayCurrentScreen();	
	}

	/**
	 * Set method for ship orientation. The index of the ships location and which ship
	 * @param ships = the indexes that the ships overlaps.
	 * @param ship = which ship
	 * @param horVar = horizontal or vertical (vertical = 1, horizontal = everything else)
	 * @param board = which board
	 */
	public void setShipOrientation(ArrayList<Integer> ships, int ship, int horVar, int board) {
		if (board == 1) {
			if (horVar != 1)
				switch (ship) {
				case 1: ship1.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, ship1.getWidth(), ship1.getHeight());
				if (dBg)
					System.out.println("Set ship1 horizontal on the left board");
				break;
				case 2: ship2.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, ship2.getWidth(), ship2.getHeight());
				if (dBg)
					System.out.println("Set ship2 horizontal on the left board");
				break;
				case 3: ship3.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, ship3.getWidth(), ship3.getHeight());
				if (dBg)
					System.out.println("Set ship3 horizontal on the left board");
				break;
				case 4: ship4.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, ship4.getWidth(), ship4.getHeight());
				if (dBg)
					System.out.println("Set ship4 horizontal on the left board");
				break;
				case 5: ship5.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, ship5.getWidth(), ship5.getHeight());
				if (dBg)
					System.out.println("Set ship5 horizontal on the left board");
				break;
				}
			else {
				int tmp;
				int tmpC;
				switch (ship) {
				case 1: tmp = ship1.getHeight();
				tmpC = ship1.getWidth();
				ship1.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, tmp, tmpC);
				ship1.setIcon(new ImageIcon("img/ship1r.png"));
				if (dBg)
					System.out.println("Set ship1 vertical on the left board");
				break;
				case 2: tmp = ship2.getHeight();
				tmpC = ship2.getWidth();
				ship2.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, tmp, tmpC);
				ship2.setIcon(new ImageIcon("img/ship2r.png"));
				if (dBg)
					System.out.println("Set ship2 vertical on the left board");
				break;
				case 3: tmp = ship3.getHeight();
				tmpC = ship3.getWidth();
				ship3.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, tmp, tmpC);
				ship3.setIcon(new ImageIcon("img/ship3r.png"));
				if (dBg)
					System.out.println("Set ship3 vertical on the left board");
				break;
				case 4: tmp = ship4.getHeight();
				tmpC = ship4.getWidth();
				ship4.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, tmp, tmpC);
				ship4.setIcon(new ImageIcon("img/ship4r.png"));
				if (dBg)
					System.out.println("Set ship4 vertical on the left board");
				break;
				case 5: tmp = ship5.getHeight();
				tmpC = ship5.getWidth();
				ship5.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, tmp, tmpC);
				ship5.setIcon(new ImageIcon("img/ship5r.png"));
				if (dBg)
					System.out.println("Set ship5 vertical on the left board");
				break;
				}
			}
		}
		else {
			if (horVar != 1)
				switch (ship) {
				case 1: enemyShip1.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, enemyShip1.getWidth(), enemyShip1.getHeight());
				if (dBg)
					System.out.println("Sets enemyShip1 horizontal on the right board");
				break;
				case 2: enemyShip2.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, enemyShip2.getWidth(), enemyShip2.getHeight());
				if (dBg)
					System.out.println("Sets enemyShip2 horizontal on the right board");
				break;
				case 3: enemyShip3.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, enemyShip3.getWidth(), enemyShip3.getHeight());
				if (dBg)
					System.out.println("Sets enemyShip3 horizontal on the right board");
				break;
				case 4: enemyShip4.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, enemyShip4.getWidth(), enemyShip4.getHeight());
				if (dBg)
					System.out.println("Sets enemyShip4 horizontal on the right board");
				break;
				case 5: enemyShip5.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, enemyShip5.getWidth(), enemyShip5.getHeight());
				if (dBg)
					System.out.println("Sets enemyShip5 horizontal on the right board");
				break;
				}
			else {
				int tmp;
				int tmpC;
				switch (ship) {
				case 1: tmp = enemyShip1.getHeight();
				tmpC = enemyShip1.getWidth();
				enemyShip1.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, tmp, tmpC);
				enemyShip1.setIcon(new ImageIcon("img/ship1r.png"));
				if (dBg)
					System.out.println("Sets enemyShip1 vertical on the right board");
				break;
				case 2: tmp = enemyShip2.getHeight();
				tmpC = enemyShip2.getWidth();
				enemyShip2.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, tmp, tmpC);
				enemyShip2.setIcon(new ImageIcon("img/ship2r.png"));
				if (dBg)
					System.out.println("Sets enemyShip2 vertical on the right board");
				break;
				case 3: tmp = enemyShip3.getHeight();
				tmpC = enemyShip3.getWidth();
				enemyShip3.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, tmp, tmpC);
				enemyShip3.setIcon(new ImageIcon("img/ship3r.png"));
				if (dBg)
					System.out.println("Sets enemyShip3 vertical on the right board");
				break;
				case 4: tmp = enemyShip4.getHeight();
				tmpC = enemyShip4.getWidth();
				enemyShip4.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, tmp, tmpC);
				enemyShip4.setIcon(new ImageIcon("img/ship4r.png"));
				if (dBg)
					System.out.println("Sets enemyShip4 vertical on the right board");
				break;
				case 5: tmp = enemyShip5.getHeight();
				tmpC = enemyShip5.getWidth();
				enemyShip5.setBounds(40 + ((ships.get(0)%10))*34, 220 + ((ships.get(0)/10))*34, tmp, tmpC);
				enemyShip5.setIcon(new ImageIcon("img/ship5r.png"));
				if (dBg)
					System.out.println("Sets enemyShip5 vertical on the right board");
				break;
				}
			}
		}
	}
	
	/**
	 * Removes all the hits and miss indicators for the next round.
	 */
	private void emptyArrays () {
		for (int i = 0; i < hits.size(); i++) {
			hits.get(i).setVisible(false);
			if (dBg && i==0)
				System.out.println("removes hit indicators");
		}
		for (int i = 0; i < misses.size(); i++) {
			misses.get(i).setVisible(false);
			if (dBg && i==0)
				System.out.println("removes miss indicators");
		}
		hits.clear();
		misses.clear();
	}
}
