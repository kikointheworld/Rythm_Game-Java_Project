package rythm_game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e){
        if(RythmGame.game == null){
            return;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            RythmGame.game.pressS();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            RythmGame.game.pressD();
        }
        else if(e.getKeyCode() == KeyEvent.VK_F){
            RythmGame.game.pressF();
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            RythmGame.game.pressSpace();
        }
        else if(e.getKeyCode() == KeyEvent.VK_J){
            RythmGame.game.pressJ();
        }
        else if(e.getKeyCode() == KeyEvent.VK_K){
            RythmGame.game.pressK();
        }
        else if(e.getKeyCode() == KeyEvent.VK_L){
            RythmGame.game.pressL();
        }

    }

    @Override
    public void keyReleased(KeyEvent e){
        if(RythmGame.game == null){
            return;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            RythmGame.game.releaseS();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            RythmGame.game.releaseD();
        }
        else if(e.getKeyCode() == KeyEvent.VK_F){
            RythmGame.game.releaseF();
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            RythmGame.game.releaseSpace();
        }
        else if(e.getKeyCode() == KeyEvent.VK_J){
            RythmGame.game.releaseJ();
        }
        else if(e.getKeyCode() == KeyEvent.VK_K){
            RythmGame.game.releaseK();
        }
        else if(e.getKeyCode() == KeyEvent.VK_L){
            RythmGame.game.releaseL();
        }
    }
}
