package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.mygdx.game.PlatformGame;

public class DesktopLauncher {

    public static void main(String[] arg) {
        
        // the texture packer takes all images in a folder, and makes them one image
        // this is a good idea for memory management and efficiency
        // this is set to take all images from a folder inside assets called raw
        // compresses them together into a single file named player
        // and places the new image with an atlas into a folder called packed
        TexturePacker.process("raw", "packed", "player");
        
        // used to start the desktop version of the game
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new PlatformGame(), config);
    }
}
