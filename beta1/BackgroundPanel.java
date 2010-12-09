import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.lang.*;
import javax.imageio.ImageIO;
import javax.swing.event.*;
import javax.swing.*;

/**
 * 
 * @author Johan and Sebastian
 * 
 */

public class BackgroundPanel extends JFrame {
	
	BattleBoard shipPlacer = new BattleBoard();
	
	//Textfields and textareas for input and output
	JTextField username = new JTextField("Username");
	JPasswordField password = new JPasswordField("Password");
	JTextField newUsername = new JTextField("Username");
	JPasswordField newPassword = new JPasswordField("Password");
	JPasswordField verifyPassword = new JPasswordField("Verify password");
	JTextField ip = new JTextField("Enter ip adress");
	JTextField serverName = new JTextField("Enter server name");
	JTextArea highScore = new JTextArea("");
	JTextField loginCreate = new JTextField("");
	JTextField serversError = new JTextField("");
	JTextArea getPlayerNames = new JTextArea("");
	JTextField getIpNumber = new JTextField("");
	JTextField getServerName = new JTextField("");
	JTextField gameErrors = new JTextField("");
	
	/* 
	 * Arraylists to store hit and miss JLabels. This is to avoid creating to many
	 * Jlabels for hits and misses
	 */
	protected ArrayList<JLabel> hits = new ArrayList<JLabel>();
	protected ArrayList<JLabel> misses = new ArrayList<JLabel>();
	
	//Integer to keep track of which screen is currently displayed. Used for toggling labels on and off
	protected int currentScreen = 1;
	//The labels
	//background
	protected JLabel backgroundLabel;
	protected JLabel back; // used in almost all frames
	//game screen
	protected JLabel whatIsMiss;
	protected JLabel whatIsHit;
	public BattleBoard board1Label;
	public BattleBoard board2Label;
	protected JLabel StarshipBattleTextLabel;
	protected JLabel enemyBoardText;
	protected JLabel myBoardText;
	protected JLabel returnToMain;
	//start screen
	protected JLabel StarshipBattleTextStart;
	protected JLabel NewgameText;
	protected JLabel InstructionsSmallText;
	protected JLabel HighscoreText;
	protected JLabel ExitGameText;
	protected JLabel BackgroundShip1;
	protected JLabel BackgroundShip2;
	//new game screen
	protected JLabel PlayerVsComp;
	protected JLabel PlayerVsPlayer;
	protected JLabel TwoPlayerVsTwoPlayer;
	//Instructions screen
	protected JLabel InstructionsBigText;
	protected JLabel InstructionsText;
	//High score screen
	protected JLabel HighscoreBigText;
	protected JLabel BigInput; // also used in server list
	//Credits screen
	protected JLabel Credits;
	protected JLabel CreditText;
	//Player vs comp
	protected JLabel Difficulty;
	protected JLabel Easy;
	protected JLabel Medium;
	protected JLabel Hard;
	//Network screen
	protected JLabel NetworkMode;
	protected JLabel Online;
	protected JLabel Lan;
	//Login/create
	protected JLabel Login;
	protected JLabel Login2;
	protected JLabel SmallInput;
	protected JLabel SmallInput2;
	protected JLabel SmallInput3;
	protected JLabel SmallInput4;
	protected JLabel SmallInput5;
	protected JLabel CreateNewAccount;
	protected JLabel Create;
	//server list
	protected JLabel Servers;
	protected JLabel Join;
	protected JLabel LongInput;
	protected JLabel LongInput2;
	protected JLabel BigInput2;
	protected JLabel Create2;
	//ships
	protected JLabel ship1;
	protected JLabel ship2;
	protected JLabel ship3;
	protected JLabel ship4;
	protected JLabel ship5;
	protected JLabel enemyShip1;
	protected JLabel enemyShip2;
	protected JLabel enemyShip3;
	protected JLabel enemyShip4;
	protected JLabel enemyShip5;
	//Lobby
	protected JLabel Mode;
	protected JLabel MediumInput;
	protected JLabel Start;
	protected JLabel Cancel;
	//Animations
	protected JLabel smallXplsn;
	protected JLabel bigXplsn;
	protected JLabel missAni;
	protected BufferedImage smallXplsnBuff;
	protected BufferedImage bigXplsnBuff;
	protected BufferedImage missAniBuff;
	//Win/Lose
	protected JLabel winGame;
	protected JLabel loseGame;
	protected JLabel mainMenu;
	
	protected JLayeredPane layeredPane;
	private JFrame frame;

	//constructor
	public BackgroundPanel() {
		
		//Frame and container for the labels
		setupImages();
		frame = new JFrame("Battleship");
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
		Container contentPane = frame.getContentPane();
		
		//Set custom cursor
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("img/cursor_25_white.png");
		Cursor cursor = toolkit.createCustomCursor(image, new Point(0,0), "Target");
		contentPane.setCursor(cursor);

		//Layered pane, to be able to display labels on top of each other
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(800, 600));
		//Background
		layeredPane.add(backgroundLabel, new Integer(0));
		layeredPane.add(back, new Integer(2)); //used in many screens
		//Game Screen
		layeredPane.add(whatIsMiss, new Integer(3));
		layeredPane.add(whatIsHit, new Integer(3));
		layeredPane.add(gameErrors, new Integer(2));
		layeredPane.add(board1Label, new Integer(2));
		layeredPane.add(board2Label, new Integer(2));
		layeredPane.add(StarshipBattleTextLabel, new Integer(2));
		layeredPane.add(enemyBoardText, new Integer(2));
		layeredPane.add(myBoardText, new Integer(2));
		layeredPane.add(returnToMain, new Integer(2));
		//Start Screen
		layeredPane.add(StarshipBattleTextStart, new Integer(2));
		layeredPane.add(NewgameText, new Integer(2));
		layeredPane.add(InstructionsSmallText, new Integer(2));
		layeredPane.add(HighscoreText, new Integer(2));
		layeredPane.add(ExitGameText, new Integer(2));
		layeredPane.add(BackgroundShip1, new Integer(1));
		layeredPane.add(BackgroundShip2, new Integer(1));
		//New game screen
		layeredPane.add(PlayerVsComp, new Integer(2));
		layeredPane.add(PlayerVsPlayer, new Integer(2));
		layeredPane.add(TwoPlayerVsTwoPlayer, new Integer(2));
		//Instruction screen
		layeredPane.add(InstructionsBigText, new Integer(2));
		layeredPane.add(InstructionsText, new Integer(2));
		//High score screen
		layeredPane.add(highScore, new Integer(5));
		layeredPane.add(HighscoreBigText, new Integer(2));
		layeredPane.add(BigInput, new Integer(2)); // also used in server list
		//Credit screen
		layeredPane.add(Credits, new Integer(2));
		//	layeredPane.add(CreditText, new Integer(2));
		//player vs comp screen
		layeredPane.add(Difficulty, new Integer(2));
		layeredPane.add(Easy, new Integer(2));
		layeredPane.add(Medium, new Integer(2));
		layeredPane.add(Hard, new Integer(2));
		//Network mode
		layeredPane.add(NetworkMode, new Integer(2));
		layeredPane.add(Online, new Integer(2));
		layeredPane.add(Lan, new Integer(2));
		//Login/create screen
		layeredPane.add(loginCreate, new Integer(3));
		layeredPane.add(Login, new Integer(2));
		layeredPane.add(Login2, new Integer(2));
		layeredPane.add(SmallInput, new Integer(2));
		layeredPane.add(SmallInput2, new Integer(2));
		layeredPane.add(SmallInput3, new Integer(2));
		layeredPane.add(SmallInput4, new Integer(2));
		layeredPane.add(SmallInput5, new Integer(2));
		layeredPane.add(CreateNewAccount, new Integer(2));
		layeredPane.add(Create, new Integer(2)); //also used in server list
		//server list
		layeredPane.add(serversError, new Integer(3));
		layeredPane.add(Servers, new Integer(2));
		layeredPane.add(Join, new Integer(2));
		layeredPane.add(Create2, new Integer(2));
		layeredPane.add(LongInput, new Integer(2));
		layeredPane.add(LongInput2, new Integer(2));
		layeredPane.add(BigInput2, new Integer(2));
		//ships
		layeredPane.add(ship1, new Integer(3));
		layeredPane.add(ship2, new Integer(3));
		layeredPane.add(ship3, new Integer(3));
		layeredPane.add(ship4, new Integer(3));
		layeredPane.add(ship5, new Integer(3));
		layeredPane.add(enemyShip1, new Integer(3));
		layeredPane.add(enemyShip2, new Integer(3));
		layeredPane.add(enemyShip3, new Integer(3));
		layeredPane.add(enemyShip4, new Integer(3));
		layeredPane.add(enemyShip5, new Integer(3));
		//Lobby
		
		layeredPane.add(getServerName, new Integer(3));
		layeredPane.add(getPlayerNames, new Integer(3));
		layeredPane.add(getIpNumber, new Integer(3));
		layeredPane.add(MediumInput, new Integer(2));
		layeredPane.add(Start, new Integer(2));
		layeredPane.add(Cancel, new Integer(2));
		layeredPane.add(username, new Integer(3));
		layeredPane.add(password, new Integer(3));
		layeredPane.add(newUsername, new Integer(3));
		layeredPane.add(newPassword, new Integer(3));
		layeredPane.add(verifyPassword, new Integer(3));
		layeredPane.add(ip, new Integer(3));
		layeredPane.add(serverName, new Integer(3));
		//Animations
		layeredPane.add(smallXplsn, new Integer(5));
		layeredPane.add(bigXplsn, new Integer(5));
		layeredPane.add(missAni, new Integer(5));
		//Win/lose
		layeredPane.add(winGame, new Integer(3));
		layeredPane.add(loseGame, new Integer(3));
		layeredPane.add(mainMenu, new Integer(3));
	
		contentPane.add(layeredPane);

		frame.pack();
		frame.setVisible(true);
	}

	//Set up the images, part of the constructors. Sets all the attributes to the labels.
	private void setupImages() {
		ImageIcon image;

		//background
		image = new ImageIcon("img/background.png");
		backgroundLabel = new JLabel(image);
		backgroundLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		backgroundLabel.setVisible(true);

		//back
		image = new ImageIcon("img/back.png");
		back = new JLabel(image);
		back.setBounds(650, 547, image.getIconWidth(), image.getIconHeight());
		back.setVisible(false);

		//game screen

		
		board1Label = new BattleBoard();
		image = new ImageIcon("img/battleboard1.png");
		board1Label.setImageBoard(image,40, 220);
		//board1Label.setShips(23);
		
		board2Label = new BattleBoard();
		image = new ImageIcon("img/battleboard2.png");
		board2Label.setImageBoard(image,420, 220);

		image = new ImageIcon("img/starshipbattletext.png");
		StarshipBattleTextLabel = new JLabel(image);
		StarshipBattleTextLabel.setBounds(10, 10, image.getIconWidth(), image.getIconHeight());
		StarshipBattleTextLabel.setVisible(false);

		image = new ImageIcon("img/enemyboardtext.png");
		enemyBoardText = new JLabel(image);
		enemyBoardText.setBounds(420, 205, image.getIconWidth(), image.getIconHeight());
		enemyBoardText.setVisible(false);

		image = new ImageIcon("img/myboardtext.png");
		myBoardText = new JLabel(image);
		myBoardText.setBounds(40, 205, image.getIconWidth(), image.getIconHeight());
		myBoardText.setVisible(false);

		image = new ImageIcon("img/return to main menu.png");
		returnToMain = new JLabel(image);
		returnToMain.setBounds(620, 580, image.getIconWidth(), image.getIconHeight());
		returnToMain.setVisible(false);
		
		image = new ImageIcon("img/thisismiss.png");
		whatIsMiss = new JLabel(image);
		whatIsMiss.setBounds(700, 50, image.getIconWidth(), image.getIconHeight());
		whatIsMiss.setVisible(false);
		
		image = new ImageIcon("img/thisishit.png");
		whatIsHit = new JLabel(image);
		whatIsHit.setBounds(700, 100, image.getIconWidth(), image.getIconHeight());
		whatIsHit.setVisible(false);

		//Start screen
		image = new ImageIcon("img/Starshipbattletextstartpage.png");
		StarshipBattleTextStart = new JLabel(image);
		StarshipBattleTextStart.setBounds(151, 100, image.getIconWidth(), image.getIconHeight());
		StarshipBattleTextStart.setVisible(false);

		image = new ImageIcon("img/New game text.png");
		NewgameText = new JLabel(image);
		NewgameText.setBounds(277, 210, image.getIconWidth(), image.getIconHeight());
		NewgameText.setVisible(false);

		image = new ImageIcon("img/instructionstext.png");
		InstructionsSmallText = new JLabel(image);
		InstructionsSmallText.setBounds(241, 260, image.getIconWidth(), image.getIconHeight());
		InstructionsSmallText.setVisible(false);

		image = new ImageIcon("img/highscoretext.png");
		HighscoreText = new JLabel(image);
		HighscoreText.setBounds(279, 310, image.getIconWidth(), image.getIconHeight());
		HighscoreText.setVisible(false);

		image = new ImageIcon("img/exit game.png");
		ExitGameText = new JLabel(image);
		ExitGameText.setBounds(279, 360, image.getIconWidth(), image.getIconHeight());
		ExitGameText.setVisible(false);

		image = new ImageIcon("img/startmenuship1.png");
		BackgroundShip1 = new JLabel(image);
		BackgroundShip1.setBounds(50, 280, image.getIconWidth(), image.getIconHeight());
		BackgroundShip1.setVisible(false);

		image = new ImageIcon("img/startmenuship2.png");
		BackgroundShip2 = new JLabel(image);
		BackgroundShip2.setBounds(420, 280, image.getIconWidth(), image.getIconHeight());
		BackgroundShip2.setVisible(false);

		//New game screen
		image = new ImageIcon("img/playvscomptext.png");
		PlayerVsComp = new JLabel(image);
		PlayerVsComp.setBounds(198, 235, image.getIconWidth(), image.getIconHeight());
		PlayerVsComp.setVisible(false);

		image = new ImageIcon("img/playervsplayertext.png");
		PlayerVsPlayer = new JLabel(image);
		PlayerVsPlayer.setBounds(173, 285, image.getIconWidth(), image.getIconHeight());
		PlayerVsPlayer.setVisible(false);

		image = new ImageIcon("img/2playervs2playertext.png");
		TwoPlayerVsTwoPlayer = new JLabel(image);
		TwoPlayerVsTwoPlayer.setBounds(97, 335, image.getIconWidth(), image.getIconHeight());
		TwoPlayerVsTwoPlayer.setVisible(false);

		//Instructions screen

		image = new ImageIcon("img/InstructionsBIG.png");
		InstructionsBigText = new JLabel(image);
		InstructionsBigText.setBounds(210, 100, image.getIconWidth(), image.getIconHeight());
		InstructionsBigText.setVisible(false);

		image = new ImageIcon("img/instructions TEXT.png");
		InstructionsText = new JLabel(image);
		InstructionsText.setBounds(137, 150, image.getIconWidth(), image.getIconHeight());
		InstructionsText.setVisible(false);


		//High score screen

		image = new ImageIcon("img/HighscoreBIG.png");
		HighscoreBigText = new JLabel(image);
		HighscoreBigText.setBounds(255, 100, image.getIconWidth(), image.getIconHeight());
		HighscoreBigText.setVisible(false);

		image = new ImageIcon("img/highscore server border.png");
		BigInput = new JLabel(image);
		BigInput.setBounds(150, 150, image.getIconWidth(), image.getIconHeight());
		BigInput.setVisible(false);


		//Credit screen
		image = new ImageIcon("img/credits.png");
		Credits = new JLabel(image);
		Credits.setBounds(293, 100, image.getIconWidth(), image.getIconHeight());
		Credits.setVisible(false);

		//Player vs comp screen

		image = new ImageIcon("img/Choose difficulty BIG.png");
		Difficulty = new JLabel(image);
		Difficulty.setBounds(141, 100, image.getIconWidth(), image.getIconHeight());
		Difficulty.setVisible(false);

		image = new ImageIcon("img/easytext.png");
		Easy = new JLabel(image);
		Easy.setBounds(337, 235, image.getIconWidth(), image.getIconHeight());
		Easy.setVisible(false);

		image = new ImageIcon("img/mediumtext.png");
		Medium = new JLabel(image);
		Medium.setBounds(316, 285, image.getIconWidth(), image.getIconHeight());
		Medium.setVisible(false);

		image = new ImageIcon("img/hardtext.png");
		Hard = new JLabel(image);
		Hard.setBounds(341, 335, image.getIconWidth(), image.getIconHeight());
		Hard.setVisible(false);

		//Choose network

		image = new ImageIcon("img/Choose network BIG.png");
		NetworkMode = new JLabel(image);
		NetworkMode.setBounds(82, 100, image.getIconWidth(), image.getIconHeight());
		NetworkMode.setVisible(false);

		image = new ImageIcon("img/onlinetext.png");
		Online = new JLabel(image);
		Online.setBounds(328, 260, image.getIconWidth(), image.getIconHeight());
		Online.setVisible(false);

		image = new ImageIcon("img/lantext.png");
		Lan = new JLabel(image);
		Lan.setBounds(356, 310, image.getIconWidth(), image.getIconHeight());
		Lan.setVisible(false);

		//Login/create account

		image = new ImageIcon("img/loginverysmall.png");
		Login = new JLabel(image);
		Login.setBounds(200, 135, image.getIconWidth(), image.getIconHeight());
		Login.setVisible(false);

		image = new ImageIcon("img/login.png");
		Login2 = new JLabel(image);
		Login2.setBounds(400, 175, image.getIconWidth(), image.getIconHeight());
		Login2.setVisible(false);

		image = new ImageIcon("img/inputfieldshort.png");
		SmallInput = new JLabel(image);
		SmallInput.setBounds(200, 150, image.getIconWidth(), image.getIconHeight());
		SmallInput.setVisible(false);

		image = new ImageIcon("img/inputfieldshort.png");
		SmallInput2 = new JLabel(image);
		SmallInput2.setBounds(200, 200, image.getIconWidth(), image.getIconHeight());
		SmallInput2.setVisible(false);

		image = new ImageIcon("img/inputfieldshort.png");
		SmallInput3 = new JLabel(image);
		SmallInput3.setBounds(200, 300, image.getIconWidth(), image.getIconHeight());
		SmallInput3.setVisible(false);

		image = new ImageIcon("img/inputfieldshort.png");
		SmallInput4 = new JLabel(image);
		SmallInput4.setBounds(200, 350, image.getIconWidth(), image.getIconHeight());
		SmallInput4.setVisible(false);

		image = new ImageIcon("img/inputfieldshort.png");
		SmallInput5 = new JLabel(image);
		SmallInput5.setBounds(200, 400, image.getIconWidth(), image.getIconHeight());
		SmallInput5.setVisible(false);

		image = new ImageIcon("img/createnewaccount.png");
		CreateNewAccount = new JLabel(image);
		CreateNewAccount.setBounds(200, 285, image.getIconWidth(), image.getIconHeight());
		CreateNewAccount.setVisible(false);

		image = new ImageIcon("img/create.png");
		Create = new JLabel(image);
		Create.setBounds(400, 350, image.getIconWidth(), image.getIconHeight());
		Create.setVisible(false);

		//Server list

		image = new ImageIcon("img/servers.png");
		Servers = new JLabel(image);
		Servers.setBounds(150, 80, image.getIconWidth(), image.getIconHeight());
		Servers.setVisible(false);

		image = new ImageIcon("img/highscore server border.png");
		BigInput2 = new JLabel(image);
		BigInput2.setBounds(150, 120, image.getIconWidth(), image.getIconHeight());
		BigInput2.setVisible(false);

		image = new ImageIcon("img/inputfieldlong.png");
		LongInput = new JLabel(image);
		LongInput.setBounds(150, 450, image.getIconWidth(), image.getIconHeight());
		LongInput.setVisible(false);

		image = new ImageIcon("img/inputfieldlong.png");
		LongInput2 = new JLabel(image);
		LongInput2.setBounds(150, 500, image.getIconWidth(), image.getIconHeight());
		LongInput2.setVisible(false);

		image = new ImageIcon("img/join.png");
		Join = new JLabel(image);
		Join.setBounds(500, 450, image.getIconWidth(), image.getIconHeight());
		Join.setVisible(false);

		image = new ImageIcon("img/create.png");
		Create2 = new JLabel(image);
		Create2.setBounds(500, 500, image.getIconWidth(), image.getIconHeight());
		Create2.setVisible(false);
		
		//ships
		
		File input = new File("img/ship1.png");
		BufferedImage source = null;
		try {
			source = ImageIO.read(input);
		} catch (IOException e) {}

		image = new ImageIcon("img/ship1.png");
		ship1 = new JLabel(image);
		ship1.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		ship1.setVisible(false);
			
		image = new ImageIcon("img/ship2.png");
		ship2 = new JLabel(image);
		ship2.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		ship2.setVisible(false);
		
		image = new ImageIcon("img/ship3.png");
		ship3 = new JLabel(image);
		ship3.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		ship3.setVisible(false);
		
		image = new ImageIcon("img/ship4.png");
		ship4 = new JLabel(image);
		ship4.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		ship4.setVisible(false);
		
		image = new ImageIcon("img/ship5.png");
		ship5 = new JLabel(image);
		ship5.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		ship5.setVisible(false);
		
		image = new ImageIcon("img/ship1.png");
		enemyShip1 = new JLabel(image);
		enemyShip1.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		enemyShip1.setVisible(false);
			
		image = new ImageIcon("img/ship2.png");
		enemyShip2 = new JLabel(image);
		enemyShip2.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		enemyShip2.setVisible(false);
		
		image = new ImageIcon("img/ship3.png");
		enemyShip3 = new JLabel(image);
		enemyShip3.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		enemyShip3.setVisible(false);
		
		image = new ImageIcon("img/ship4.png");
		enemyShip4 = new JLabel(image);
		enemyShip4.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		enemyShip4.setVisible(false);
		
		image = new ImageIcon("img/ship5.png");
		enemyShip5 = new JLabel(image);
		enemyShip5.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		enemyShip5.setVisible(false);

		//Lobby screen

		image = new ImageIcon("img/lobbyborder.png");
		MediumInput = new JLabel(image);
		MediumInput.setBounds(200, 200, image.getIconWidth(), image.getIconHeight());
		MediumInput.setVisible(false);

		image = new ImageIcon("img/starttext.png");
		Start = new JLabel(image);
		Start.setBounds(200, 420, image.getIconWidth(), image.getIconHeight());
		Start.setVisible(false);

		image = new ImageIcon("img/cancel.png");
		Cancel = new JLabel(image);
		Cancel.setBounds(430, 420, image.getIconWidth(), image.getIconHeight());
		Cancel.setVisible(false);

		image = new ImageIcon("img/smallxplsnsheet.png");
		smallXplsnBuff = new BufferedImage(136, 136, BufferedImage.TYPE_INT_ARGB);
		Graphics gSmall = smallXplsnBuff.getGraphics();
		gSmall.drawImage(image.getImage(), 0, 0, null);
		image = new ImageIcon(smallXplsnBuff);
		smallXplsn = new JLabel(image);
		smallXplsn.setBounds(0, 0, 34, 34);
		smallXplsn.setVisible(false);
		smallXplsn.setIcon(new ImageIcon(smallXplsnBuff.getSubimage(0, 0, 34, 34)));
		
		image = new ImageIcon("img/biglxplsnsheet.png");
		bigXplsnBuff = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
		Graphics gBig = bigXplsnBuff.getGraphics();
		gBig.drawImage(image.getImage(), 0, 0, null);
		image = new ImageIcon(bigXplsnBuff);
		bigXplsn = new JLabel(image);
		bigXplsn.setBounds(0, 0, 64, 64);
		bigXplsn.setVisible(false);
		bigXplsn.setIcon(new ImageIcon(bigXplsnBuff.getSubimage(0, 0, 64, 64)));
		
		image = new ImageIcon("img/misssheet.png");
		missAniBuff = new BufferedImage(136, 136, BufferedImage.TYPE_INT_ARGB);
		Graphics gMiss = missAniBuff.getGraphics();
		gMiss.drawImage(image.getImage(), 0, 0, null);
		image = new ImageIcon(missAniBuff);
		missAni = new JLabel(image);
		missAni.setBounds(0, 0, 34, 34);
		missAni.setVisible(false);
		missAni.setIcon(new ImageIcon(missAniBuff.getSubimage(0, 0, 34, 34)));
		
		/*
		 * textfields/area fields. input/output
		 * The get methods can be called when the mouslistener "mousereleased" is
		 * invoked. The value inputed in the textfield can at that time
		 * be accessed from the textfield by a simple object.getText() method
		 */
	
		//Texfield for showing servername in lobby. Needs setmethod
		getServerName.setBounds(200,160, 150, 30);
		getServerName.setOpaque(true);
		getServerName.setVisible(false);
		getServerName.setFont(new Font("Eurostile-Normal", 1, 24));
		getServerName.setForeground(new Color(255, 255, 255));
		getServerName.setBorder(null);
		getServerName.setEditable(false);
		//Texfield for showing player names in lobby. Needs setmethod
		getPlayerNames.setBounds(MediumInput.getX() + 5, MediumInput.getY() + 7, MediumInput.getWidth() - 10, MediumInput.getHeight() - 10);
		getPlayerNames.setOpaque(true);
		getPlayerNames.setVisible(false);
		getPlayerNames.setFont(new Font("Eurostile-Normal", 1, 24));
		getPlayerNames.setForeground(new Color(255, 255, 255));
		getPlayerNames.setBorder(null);
		getPlayerNames.setEditable(false);
		
		//Texfield for showing ipadress. Needs setmethod
		getIpNumber.setBounds(450,160, 150, 30);
		getIpNumber.setOpaque(true);
		getIpNumber.setVisible(false);
		getIpNumber.setFont(new Font("Eurostile-Normal", 1, 24));
		getIpNumber.setForeground(new Color(255, 255, 255));
		getIpNumber.setBorder(null);
		getIpNumber.setEditable(false);
		
		//Textfield for errors of serverproblem. Needs setmethod
		serversError.setBounds(150,550, 200, 30);
		serversError.setOpaque(true);
		serversError.setVisible(false);
		serversError.setFont(new Font("Eurostile-Normal", 1, 24));
		serversError.setForeground(new Color(255, 0, 0));
		serversError.setBorder(null);
		serversError.setEditable(false);
		
		//Textfield for displaying ingame information massages. Needs setmethod
		gameErrors.setBounds(600,0, 200, 30);
		gameErrors.setOpaque(true);
		gameErrors.setVisible(false);
		gameErrors.setFont(new Font("Eurostile-Normal", 1, 24));
		gameErrors.setForeground(new Color(255, 0, 0));
		gameErrors.setBorder(null);
		gameErrors.setEditable(false);
		
		//Textfield for errors login or accountcreationproblems. Needs setmethod
		loginCreate.setBounds(200,400, 200, 30);
		loginCreate.setOpaque(true);
		loginCreate.setVisible(false);
		loginCreate.setFont(new Font("Eurostile-Normal", 1, 24));
		loginCreate.setForeground(new Color(255, 255, 255));
		loginCreate.setBorder(null);
		loginCreate.setEditable(false);

		//Textarea for showing the highscore. Needs setmethod
		highScore.setBounds(BigInput.getX() + 5, BigInput.getY() + 7, BigInput.getWidth() - 10, BigInput.getHeight() - 10);
		highScore.setOpaque(true);
		highScore.setVisible(false);
		highScore.setFont(new Font("Eurostile-Normal", 1, 24));
		highScore.setForeground(new Color(255, 255, 255));
		highScore.setBorder(null);
		highScore.setEditable(false);
		
		//Textfield for inputing username. Needs getmethod
		username.setBounds(SmallInput.getX() + 5, SmallInput.getY() + 7, SmallInput.getWidth() - 10, SmallInput.getHeight() - 10);
		username.setOpaque(false);
		username.setVisible(false);
		username.setFont(new Font("Eurostile-Normal", 1, 24));
		username.setForeground(new Color(255, 255, 255));
		username.setBorder(null);
		username.setEditable(true);

		//Textfield for inputing password. Needs getmethod
		password.setBounds(SmallInput2.getX() + 5, SmallInput2.getY() + 5, SmallInput2.getWidth() - 10, SmallInput2.getHeight() - 5);
		password.setOpaque(false);
		password.setFont(new Font("Eurostile-Normal", 1, 24));
		password.setForeground(new Color(255, 255, 255));
		password.setBorder(null);
		password.setEditable(true);

		//Textfield for inputing new username. Needs getmethod
		newUsername.setBounds(SmallInput3.getX() + 5, SmallInput3.getY() + 7, SmallInput3.getWidth() - 10, SmallInput3.getHeight() - 10);
		newUsername.setOpaque(false);
		newUsername.setVisible(false);
		newUsername.setFont(new Font("Eurostile-Normal", 1, 24));
		newUsername.setForeground(new Color(255, 255, 255));
		newUsername.setBorder(null);
		newUsername.setEditable(true);
		
		//Textfield for inputing new password. Needs getmethod
		newPassword.setBounds(SmallInput4.getX() + 5, SmallInput4.getY() + 5, SmallInput4.getWidth() - 10, SmallInput4.getHeight() - 5);
		newPassword.setOpaque(false);
		newPassword.setFont(new Font("Eurostile-Normal", 1, 24));
		newPassword.setForeground(new Color(255, 255, 255));
		newPassword.setBorder(null);
		newPassword.setEditable(true);

		//Textfield for inputing verifying new password. Needs getmethod
		verifyPassword.setBounds(SmallInput5.getX() + 5, SmallInput5.getY() + 5, SmallInput5.getWidth() - 10, SmallInput5.getHeight() - 5);
		verifyPassword.setOpaque(false);
		verifyPassword.setFont(new Font("Eurostile-Normal", 1, 24));
		verifyPassword.setForeground(new Color(255, 255, 255));
		verifyPassword.setBorder(null);
		verifyPassword.setEditable(true);
		
		//Textfield for inputing ipadress when connecting to game. Needs getmethod
		ip.setBounds(LongInput.getX() + 5, LongInput.getY() + 5, LongInput.getWidth() - 10, LongInput.getHeight() - 5);
		ip.setOpaque(false);
		ip.setFont(new Font("Eurostile-Normal", 1, 24));
		ip.setForeground(new Color(255, 255, 255));
		ip.setBorder(null);
		ip.setEditable(true);

		//Textfield for inputing name of server when creating new game. Needs getmethod
		serverName.setBounds(LongInput2.getX() + 5, LongInput2.getY() + 5, LongInput2.getWidth() - 10, LongInput2.getHeight() - 5);
		serverName.setOpaque(false);
		serverName.setFont(new Font("Eurostile-Normal", 1, 24));
		serverName.setForeground(new Color(255, 255, 255));
		serverName.setBorder(null);
		serverName.setEditable(true);
		
		//Win/Lose game
		image = new ImageIcon("img/youwin.png");
		winGame = new JLabel(image);
		winGame.setBounds(118, 350, image.getIconWidth(), image.getIconHeight());
		winGame.setVisible(false);
		
		image = new ImageIcon("img/youlose.png");
		loseGame = new JLabel(image);
		loseGame.setBounds(97, 350, image.getIconWidth(), image.getIconHeight());
		loseGame.setVisible(false);
		
		image = new ImageIcon("img/mainmenu.png");
		mainMenu = new JLabel(image);
		mainMenu.setBounds(178, 350, image.getIconWidth(), image.getIconHeight());
		mainMenu.setVisible(false);
	}
} 
