/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gears;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 *
 * @author Zack
 */
public class GInput implements KeyListener, MouseWheelListener, MouseListener {
    public int currentKeyState[];
    public boolean lastM1State, currentM1State;
    public int mouseWheelMovement;

    public GInput(){
        currentKeyState = new int[256];
    }


    public void update(){
        for(int i = 0; i < currentKeyState.length; i++){
            if(currentKeyState[i] == 2)
                currentKeyState[i] = 1;
            if(currentKeyState[i] == -1)
                currentKeyState[i] = 0;
        }
        mouseWheelMovement = 0;
    }

    public boolean justPressed(int keyCode){
        return currentKeyState[keyCode] == 2;
    }

    public boolean justReleased(int keyCode){
        return currentKeyState[keyCode] == -1;
    }

    public boolean isDown(int keyCode){
        return currentKeyState[keyCode] > 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(currentKeyState[e.getKeyCode()] < 1){
            GBase.log("[Input Recieved] Key Pressed: "+e.getKeyCode());
            currentKeyState[e.getKeyCode()] = 2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //
        currentKeyState[e.getKeyCode()] = -1;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        //
        mouseWheelMovement = e.getWheelRotation();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //
    }

}
