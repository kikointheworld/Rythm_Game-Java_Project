package rythm_game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends Thread{
    private final String[] noteNames = {"S", "D", "F", "Space", "J", "K", "L"};

    private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameinfo.png")).getImage();
    private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image judgeImage;
    private Image flareImage;
    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    private int score = 0; // score of the game

    ArrayList<Note> noteList = new ArrayList<Note>();

    public Game(String titleName, String difficulty, String musicTitle){
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);
    }

    public void screenDraw(Graphics2D g){
        g.drawImage(noteRouteSImage,228,30,null);
        g.drawImage(noteRouteDImage,332,30,null);
        g.drawImage(noteRouteFImage,436,30,null);
        g.drawImage(noteRouteSpace1Image,540,30,null);
        g.drawImage(noteRouteSpace2Image,640,30,null);
        g.drawImage(noteRouteJImage,744,30,null);
        g.drawImage(noteRouteKImage,848,30,null);
        g.drawImage(noteRouteLImage,952,30,null);
        g.drawImage(noteRouteLineImage,224,30,null);
        g.drawImage(noteRouteLineImage,328,30,null);
        g.drawImage(noteRouteLineImage,432,30,null);
        g.drawImage(noteRouteLineImage,536,30,null);
        g.drawImage(noteRouteLineImage,740,30,null);
        g.drawImage(noteRouteLineImage,844,30,null);
        g.drawImage(noteRouteLineImage,948,30,null);
        g.drawImage(noteRouteLineImage,1052,30,null);
        g.drawImage(gameInfoImage,0,660,null);
        g.drawImage(judgementLineImage,224,580,null);

        for (int i = 0;i <noteList.size();i++){
            Note note = noteList.get(i);
            if(note.getY() > 620){
                judgeImage = new ImageIcon(Main.class.getResource("../images/missImage.png")).getImage();
            }
            if(!note.isProceeded()){
                noteList.remove(i);
                i--;
            }
            else{
                note.screenDraw(g);
            }
            note.screenDraw(g);
        }
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 35));
        g.drawString(Integer.toString(score), 600, 702);
        g.drawString(titleName, 50, 702);


        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.BLACK);
        g.drawString("S", 270, 609);
        g.drawString("D", 374, 609);
        g.drawString("F", 478, 609);
        g.drawString("SPACE BAR", 580, 609);
        g.drawString("J", 784, 609);
        g.drawString("K", 889, 609);
        g.drawString("L", 993, 609);
        g.drawImage(flareImage, 515, 430, null);
        g.drawImage(judgeImage, 460, 420, null);
    }

    public void pressS(){
        judge("S");
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSound.mp3", false).start();
    }
    public void releaseS(){
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    public void pressD(){
        judge("D");
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSound.mp3", false).start();
    }
    public void releaseD(){
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    public void pressF(){
        judge("F");
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSound.mp3", false).start();
    }
    public void releaseF(){
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    public void pressSpace(){
        judge("Space");
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSound.mp3", false).start();
    }
    public void releaseSpace(){
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }


    public void pressJ(){
        judge("J");
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSound.mp3", false).start();
    }
    public void releaseJ(){
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    public void pressK(){
        judge("K");
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSound.mp3", false).start();
    }
    public void releaseK(){
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    }

    public void pressL(){
        judge("L");
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseL(){
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    }

    @Override
    public void run(){
        dropNotes();
    }

    public void close() {
        gameMusic.close();
        this.interrupt();
    }

    public void dropNotes(){
        ArrayList<Beat> beats = new ArrayList<Beat>();
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        if(titleName.equals("POPSTARS") && difficulty.equals("Easy")){
            Main.SPEED = 3;
            int startTime = 170 * 34 - Main.REACH_TIME * 1000;
            int bpm = 170 * 2;
            int tmp = startTime;
            while (tmp < 202000){
                beats.add(new Beat(tmp, noteNames[random.nextInt(7)]));
                tmp += bpm;
            }
        }
        else if(titleName.equals("POPSTARS") && difficulty.equals("Hard")){
            Main.SPEED = 5;
            int startTime = 170 * 34 - Main.REACH_TIME * 1000;
            int bpm = 170 * 2;
            int tmp = startTime;
            while (tmp < 202000){
                beats.add(new Beat(tmp, noteNames[random.nextInt(7)]));
                tmp += bpm;
            }

        }
        else if(titleName.equals("MORE") && difficulty.equals("Easy")){
            Main.SPEED = 3;
            int startTime = 142 * 30 - Main.REACH_TIME * 1000;
            int bpm = 142 * 3;
            int tmp = startTime;
            while (tmp < 231000){
                beats.add(new Beat(tmp, noteNames[random.nextInt(7)]));
                tmp += bpm;
            }
        }
        else if(titleName.equals("MORE") && difficulty.equals("Hard")){
            Main.SPEED = 5;
            int startTime = 142 * 30 - Main.REACH_TIME * 1000;
            int bpm = 142 * 3;
            int tmp = startTime;
            while (tmp < 231000){
                beats.add(new Beat(tmp, noteNames[random.nextInt(7)]));
                tmp += bpm;
            }
        }
        else if(titleName.equals("GIANTS") && difficulty.equals("Easy")){
            Main.SPEED = 3;
            int startTime = 155 * 41 - Main.REACH_TIME * 1000;
            int bpm = 155 * 4;
            int tmp = startTime;
            while (tmp < 198000){
                beats.add(new Beat(tmp, noteNames[random.nextInt(7)]));
                tmp += bpm;
            }
        }
        else if(titleName.equals("GIANTS") && difficulty.equals("Hard")){
            Main.SPEED = 5;
            int startTime = 155 * 45 - Main.REACH_TIME * 1000;
            int bpm = 155 * 3;
            int tmp = startTime;
            while (tmp < 198000){
                beats.add(new Beat(tmp, noteNames[random.nextInt(7)]));
                tmp += bpm;
            }
        }
        int i = 0;
        gameMusic.start();
        while (i < beats.size() &&  !isInterrupted()){
            boolean dropped = false;
            if (beats.get(i).getTime() <= gameMusic.getTime()){
                Note note = new Note(beats.get(i).getNoteName());
                note.start();
                noteList.add(note);
                i++;
                dropped = true;
            }
            if(!dropped) {
                try{
                    Thread.sleep(5);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void judge(String input){
        for (int i = 0; i< noteList.size(); i++){
            Note note = noteList.get(i);
            if(input.equals(note.getNoteType())){
                note.judge();
                judgeEvent(note.judge());
                break;
            }
        }
    }

    public void judgeEvent(String judge){
        if (!judge.equals("none")){
            flareImage = new ImageIcon(Main.class.getResource("../images/flareImage.png")).getImage();
        }
        if(judge.equals("Miss")){
            judgeImage = new ImageIcon(Main.class.getResource("../images/missImage.png")).getImage();
        }
        else if(judge.equals("Late")){
            judgeImage = new ImageIcon(Main.class.getResource("../images/lateImage.png")).getImage();
            score += 10;
        }
        else if(judge.equals("Good")){
            judgeImage = new ImageIcon(Main.class.getResource("../images/goodImage.png")).getImage();
            score += 30;
        }
        else if(judge.equals("Great")){
            judgeImage = new ImageIcon(Main.class.getResource("../images/greatImage.png")).getImage();
            score += 50;
        }
        else if(judge.equals("Perfect")){
            judgeImage = new ImageIcon(Main.class.getResource("../images/perfectImage.png")).getImage();
            score += 100;
        }
        else if(judge.equals("Early")){
            judgeImage = new ImageIcon(Main.class.getResource("../images/earlyImage.png")).getImage();
            score += 25;
        }

    }
}
