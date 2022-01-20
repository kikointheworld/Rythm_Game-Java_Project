package rythm_game;

// import libraries
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.*;


public class RythmGame extends JFrame{
	private int mouseX, mouseY; // mouse position

	private boolean isMainScreen = false; // to know the state of program.
	private boolean isGameScreen = false;
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("../images/BackGround.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));


	private ImageIcon exitButtonOnImage = new ImageIcon(Main.class.getResource("../images/exitButtonOn.png"));
	private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../images/exitButton.png"));
	private ImageIcon startButtonImage = new ImageIcon(Main.class.getResource("../images/startButton.png"));
	private ImageIcon startButtonOnImage = new ImageIcon(Main.class.getResource("../images/startButtonOn.png"));
	private ImageIcon quitButtonImage = new ImageIcon(Main.class.getResource("../images/quitButton.png"));
	private ImageIcon quitButtonOnImage = new ImageIcon(Main.class.getResource("../images/quitButtonOn.png"));
	private ImageIcon leftButtonImage= new ImageIcon(Main.class.getResource("../images/leftImage.png"));
	private ImageIcon leftButtonOnImage = new ImageIcon(Main.class.getResource("../images/leftImageOn.png"));
	private ImageIcon rightButtonImage = new ImageIcon(Main.class.getResource("../images/rightImage.png"));
	private ImageIcon rightButtonOnImage = new ImageIcon(Main.class.getResource("../images/rightImageOn.png"));
	private ImageIcon easyButtonImage = new ImageIcon(Main.class.getResource("../images/easy.png"));
	private ImageIcon easyButtonOnImage = new ImageIcon(Main.class.getResource("../images/easyOn.png"));
	private ImageIcon hardButtonImage = new ImageIcon(Main.class.getResource("../images/hard.png"));
	private ImageIcon hardButtonOnImage = new ImageIcon(Main.class.getResource("../images/hardOn.png"));
	private ImageIcon backButtonImage = new ImageIcon(Main.class.getResource("../images/back.png"));
	private ImageIcon backButtonOnImage = new ImageIcon(Main.class.getResource("../images/backOn.png"));

	// initialize buttons
	private JButton exitButton= new JButton(exitButtonImage);
	private JButton startButton = new JButton(startButtonImage);
	private JButton quitButton = new JButton(quitButtonImage);
	private JButton leftButton = new JButton(leftButtonImage);
	private JButton rightButton = new JButton(rightButtonImage);
	private JButton easyButton = new JButton(easyButtonImage);
	private JButton hardButton = new JButton(hardButtonImage);
	private JButton backButton = new JButton(backButtonImage);

	ArrayList<Track> trackList = new ArrayList<Track>(); // program's track list
	private int nowSelected = 0; // index of track list

	// initialize images and music
	private Image titleImage;
	private Image selectedImage ;
	private Music selectedMusic;

	private Music introMusic = new Music("POPSTARS.mp3", true); // intro music of the program

	public static Game game;


	
	public RythmGame() {
		trackList.add(new Track("POPSTARStitle.png", "POPSTARSstart.jpg",
				"POPSTARSgame.jpg", "POPSTARSselected.mp3", "POPSTARS.mp3", "POPSTARS"));
		trackList.add(new Track("MOREtitle.png", "MOREstart.jpg",
				"MOREgame.jpg", "MOREselected.mp3", "MORE.mp3", "MORE"));
		trackList.add(new Track("GIANTStitle.png", "GIANTSstart.jpg",
				"GIANTSgame.jpg", "GIANTSselected.mp3", "GIANTS.mp3", "GIANTS"));
		setUndecorated(true);
		setTitle("Rythm Game");
		setSize(Main.Frame_Width, Main.Frame_Height);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		addKeyListener(new KeyListener());
		introMusic.start();


		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.setBorderPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonOnImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				exitButton.setIcon(exitButtonImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex){
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(exitButton);


		startButton.setBounds(275, 580, 400, 100);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.setBorderPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonOnImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				startButton.setIcon(startButtonImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				enterMain();
			}
		});
		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(startButton);


		quitButton.setBounds(555, 580, 400, 100);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.setBorderPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonOnImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				quitButton.setIcon(quitButtonImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex){
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(quitButton);


		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.setBorderPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonOnImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				leftButton.setIcon(leftButtonImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectLeft();
			}
		});
		leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(leftButton);

		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.setBorderPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonOnImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				rightButton.setIcon(rightButtonImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectRight();
			}
		});
		rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(rightButton);


		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 125);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.setBorderPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonOnImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				easyButton.setIcon(easyButtonImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				gameStart(nowSelected, "Easy");
			}
		});
		easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(easyButton);

		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 125);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.setBorderPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonOnImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				hardButton.setIcon(hardButtonImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				gameStart(nowSelected, "Hard");
			}
		});
		hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(hardButton);

		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.setBorderPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonOnImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				backButton.setIcon(backButtonImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				backMain();
			}
		});
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(backButton);


		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});
		add(menuBar);
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.Frame_Width, Main.Frame_Height);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		
	}

	private void screenDraw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0, null);
		if(isMainScreen){
			g.drawImage(selectedImage,340,100,null);
			g.drawImage(titleImage,340, 450, null);
		}
		if (isGameScreen){
			game.screenDraw(g);
		}
		paintComponents(g);
		try{
			Thread.sleep(5);
		}catch (Exception e){
			e.printStackTrace();
		}
		this.repaint();
	}

	public void selectTrack(int nowSelected){
		if(selectedMusic != null){
			selectedMusic.close();
		}
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void selectLeft() {
		if(nowSelected == 0){
			nowSelected = trackList.size() - 1;
		}
		else{
			nowSelected--;
		}
		selectTrack(nowSelected);
	}
	public void selectRight() {
		if(nowSelected == trackList.size() - 1) {
			nowSelected = 0;
		}
		else{
			nowSelected++;
		}
		selectTrack(nowSelected);
	}

	public void gameStart(int nowSelected, String difficulty){

		if(selectedMusic != null){
			selectedMusic.close();
		}
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);
		requestFocus();
	}

	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackGround.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
		game.close();

	}

	public void enterMain(){
		startButton.setVisible(false);
		quitButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackGround.jpg")).getImage();
		isMainScreen = true;


		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectTrack(0);
	}
}
