/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

import gears.GSprite;
import gears.GState;
import java.awt.Graphics;
/**
 *
 * @author Zack
 */
public class MainMenu extends GState{
    GSprite square;
    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    @Override
    public void destroy() {

        super.destroy();
    }

    @Override
    public void create() {
        super.create();
        //this is your real constructor.
        AssetManager.initImages();
        square = new Square(100, 100);
        add(square);
        
    }

}
