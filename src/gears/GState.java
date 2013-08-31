/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gears;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Zack
 */
public class GState {
    public ArrayList<GObject> members;
    /**
     * Updates the state of the Game State.
     * Call super.update when you feel the objects need to be updated.
     */
    public void update(){
        for(GObject a : members){
            if(a.active && a.exists){
                a.update();
            }
        }
    }
    /**
     * Renders the current state of the Game State onto the graphic g.
     * Call Super.render when you feel you need the objects to be rendered
     * @param g the image the state will draw to
     */
    public void render(Graphics g){
        for(GObject a : members){
            if(a.visible && a.exists){
                a.render(g);
            }
        }
    }
    /**
     * Destroys the state. Call super.destroy AFTER your stuff.
     */
    public void destroy(){
        
    }

    /**
     * Called when the game is ready to create the state. Don't do too much
     * in the state constructor since the game is not yet ready for the state
     * to start doing stuff.
     */
    public void create(){
        members = new ArrayList<>(16);
    }
    
    /**
     * Registers an object to be included in the game's update and render loop.
     * @param object the object to be added
     */
    public void add(GObject object){
        members.add(object);
    }
}
