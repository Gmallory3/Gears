/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gears;

/**
 *
 * @author Zack
 */
public class GRect extends GPoint {
    public int width;
    public int height;

    public GRect(double x, double y, int width, int height){
        super(x, y);
        this.height = height;
        this.width = width;
    }

}
