package gears;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Zack
 */
public class GSprite extends GObject{
    public static int FACING_RIGHT = 0;
    public static int FACING_LEFT = 1;
    public static int FACING_UP = 2;
    public static int FACING_DOWN = 3;

    public int facing = 0;
    public Image fullImage;
    public int frameWidth;
    public int frameHeight;

    public GSprite(double x, double y, Image graphic){
        super(x, y);
        fullImage = graphic;
        if(graphic != null){
            frameWidth = graphic.getWidth(null);
            frameHeight = graphic.getHeight(null);
        }
    }

    @Override
    public void update(){
        super.update();
    }

    @Override
    public void render(Graphics g){
        if(fullImage != null){
            if(facing == FACING_RIGHT){
                g.drawImage(fullImage, (int)x, (int)y, null);
            }else if(facing == FACING_LEFT){
                g.drawImage(fullImage, (int)x+frameWidth, (int)y, (int)x, (int)y+frameHeight, 0, 0, frameWidth, frameHeight, null);
            }
            super.render(g);
        }
    }

    protected void createImage(int width, int height, Color color){
        BufferedImage temp = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        //Calling getGraphics() on a buffered image returns a new Graphics object every time.
        //Why? Fuck if I know, java is dumb a lot of the time.
        Graphics g = temp.getGraphics();
        g.setColor(Color.red);
        g.fillRect(0,0,width,height);
        fullImage = temp;
        g.dispose();
    }
}
