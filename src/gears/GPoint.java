/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gears;

/**
 *
 * @author Zack
 */
public class GPoint {
    public double x;
    public double y;

    public GPoint(double x, double y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "GPoint: (" + x + "," + y + ")";
    }
}
