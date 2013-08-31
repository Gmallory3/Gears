/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gears;

import java.awt.Graphics;

/**
 *
 * @author Zack
 */
public class GObject {
    public static int numRenders = 0;
    public static int numUpdates = 0;
    
    public boolean visible;
    public boolean active;
    public boolean exists;
    public double x;
    public double y;
    
    public GObject(double x, double y){
        exists = true;
        active = true;
        visible = true;
        this.x = x;
        this.y = y;
    }
    
    public void update(){
        numUpdates++;
    }
    
    public void render(Graphics g){
        numRenders++;
    }
}
