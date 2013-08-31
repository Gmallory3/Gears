package mule;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Zack
 */
public class AssetManager {
    public static Image annoying;

    public static void initImages(){
        annoying = new ImageIcon(AssetManager.class.getResource("../assets/Annoying.png")).getImage();
    }
}
