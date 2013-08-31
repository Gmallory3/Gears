/*
 * This class exists solely to serve as the entry point and kick the game off.
 */
package mule;

import gears.GGame;
import java.awt.Color;

/**
 *
 * @author Zack
 */
public class Mule extends GGame{
    /**
     * Entry Point
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mule mule = new Mule();
    }

    public Mule(){
        //Game start.
        super(new MainMenu(), 640, 480, Color.black);
    }
}
