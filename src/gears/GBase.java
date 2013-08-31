package gears;

import java.awt.Font;
import java.awt.FontMetrics;

/**
 *
 * @author Zack
 */
public class GBase {
    public static GState currentState;
    public static long elapsed;
    public static long totalElapsedTime;
    public static FontMetrics consoleFontMetrics;
    public static Font consoleFont;
    public static int gameWidth;
    public static int gameHeight;
    public static GInput input;
    public static GConsole console;


    /**
     * Adds a message to the console's message view (F1)
     * @param message The message to be added
     */
    public static void log(String message){
        console.addMessage(message);
    }
    /**
     * Registers a variable to be watched by the console's real-time variable view (F2).
     * @param prefix The string to prefix the variable. ex: "Player X position: "
     * @param varName The basic name of the variable as a string. ex: "x"
     * @param instance The instance of the object to be watched. Generally this will be 'this'
     *                  but there are instances where you might want to use another object.
     */
    public static void watch(String prefix, String varName, Object instance){
        console.watch(prefix, varName, instance);
    }
}
