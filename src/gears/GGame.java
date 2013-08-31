/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gears;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Zack
 */
public class GGame extends JPanel{
    public static JFrame gameFrame; //Our window for the game.

    boolean firstFrame = true;
    int frameCount = 0;
    int remainder = 0;
    long targetFramerate = 1000/60, lastTime = 0, totalElapsedTime = 0, reportedFramerate = 0;
    Graphics bufferGraphics;
    Graphics2D consoleGraphics;
    Image offscreen;
    Dimension dim;
    GConsole console;
    Color bgColor;

    public GGame(GState startState, int dimX, int dimY, Color bgColor){
        super(); //Get the superclass set up

        //Initialize window things
        dim = new Dimension(dimX, dimY);
        setPreferredSize(dim);
        setSize(dim);
        setFocusable(true);

        //Initialize game things
        lastTime = System.currentTimeMillis();
        GBase.consoleFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
        GBase.currentState = startState;
        GBase.gameWidth = dim.width;
        GBase.gameHeight = dim.height;
        GBase.input = new GInput();
        console = new GConsole(0, 0);
        GBase.console = console;

        //Build our window
        gameFrame = new JFrame("Gears");
        gameFrame.add(this);
        gameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        gameFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //exitProcedure();
                System.exit(0);
            }
        });
        gameFrame.pack();
        gameFrame.setVisible(true);
        this.bgColor = bgColor;
        if(bgColor != null)
            gameFrame.setBackground(bgColor);
        addKeyListener(GBase.input);
        addMouseWheelListener(GBase.input);

        //Finally ready
        GBase.currentState.create();
    }

    @Override
    public void update(Graphics g){
        GBase.elapsed = System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        UpdateFPS();

        //mouseX = MouseInfo.getPointerInfo().getLocation().x - getLocationOnScreen().x;
        //mouseY = MouseInfo.getPointerInfo().getLocation().y - getLocationOnScreen().y;

        GBase.currentState.update();

        if(GBase.input.justPressed(192)){
            console.exists = !console.exists;
            GObject.numRenders = 0;
            GObject.numUpdates = 0;
        }
        if(console.exists && console.active){
            console.update();
        }

        //'Update' the input last. the input is updated normally when the keys are pressed
        //so we clear all the 'just' flags at the end of the frame
        GBase.input.update();

        repaint();
    }

    /**
     * Updates the reported FPS.
     */
    private void UpdateFPS(){
        totalElapsedTime += GBase.elapsed;
        GBase.totalElapsedTime += GBase.elapsed;
        frameCount++;
        if(totalElapsedTime > 1000){
            reportedFramerate = (long) Math.round((double)frameCount / (double)totalElapsedTime*1000);
            frameCount = 0;
            totalElapsedTime -= 1000;

            console.fps = (int)reportedFramerate;
        }
    }

    /**
     * Draws the frame.
     * @param g Graphics passed down from the Almighty Java VM™
     */
    @Override
    public void paint(Graphics g){
        //We have to do the initial frame setup here because Java is a
        //piece of shit and will return a bunch of nulls if we do this in the
        //constructor.
        if(firstFrame){
            offscreen = createImage(dim.width, dim.height);
            bufferGraphics = offscreen.getGraphics();
            GBase.consoleFontMetrics = g.getFontMetrics(GBase.consoleFont);
            console.initRows();
            firstFrame = false;
        }else{
            bufferGraphics.clearRect(0, 0, dim.width, dim.height);

            GBase.currentState.render(bufferGraphics);

            if(console.exists && console.visible){
                console.render(bufferGraphics);
            }
            g.drawImage(offscreen, 0, 0,this.getWidth(),this.getHeight(), this);
        }

        GBase.elapsed = System.currentTimeMillis() - lastTime;
        try{
            if(GBase.elapsed < targetFramerate){
                remainder += 6;
                if(remainder > 10){
                    Thread.sleep(targetFramerate - GBase.elapsed + 1);
                    remainder -= 10;
                }else{
                    Thread.sleep(targetFramerate - GBase.elapsed);
                }
            }else{
                remainder = 0;
            }
        }catch(Throwable t){
            //Get mad as shit, becuase this should never fail.
        }
        update(g);
    }
}
