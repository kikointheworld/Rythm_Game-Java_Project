package rythm_game;

public class Main {
	public static final int Frame_Width = 1280;
	public static final int Frame_Height = 720;

	public static int SPEED = 3; // speed of notes
	public static final int SLEEP_TIME = 5; // it makes notes move smoothly
	public static final int REACH_TIME = 2; // time from top to judgement line

	public static void main(String[] args) {
		new RythmGame(); // initialize the game
	}
}
