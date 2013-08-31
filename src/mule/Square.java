package mule;

import gears.GBase;
import gears.GPoint;
import gears.GSprite;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Zack
 */
public class Square extends GSprite {
    GPoint initialPosition;
    public Square(double x, double y){
        super(x, y, AssetManager.annoying);
        //createImage(50, 50, Color.red);
        initialPosition = new GPoint(x, y);
    }

    @Override
    public void update(){
        double moveAmount = Math.sin(GBase.totalElapsedTime*(3.14/1000));
        x = initialPosition.x + 60*moveAmount;
        y = initialPosition.y + 30*Math.sin(GBase.totalElapsedTime*(3.14/500));
        if(moveAmount < 0){
            facing = GSprite.FACING_LEFT;
        }else{
            facing = GSprite.FACING_RIGHT;
        }

        if(GBase.input.justPressed(65)){
            GBase.log("Some stuff");
        }

        super.update();
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.white);
        g.drawString("Hey Listen!", (int)x+10, (int)y-5);
        super.render(g);
    }
}
