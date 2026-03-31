package com.libgdx.discintrel.lwjgl2;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.libgdx.discintrel.Controller.DistrinctrelController;
import com.libgdx.discintrel.Main.App;
import com.libgdx.discintrel.Main.MainApp;
//import com.libgdx.discintrel.Main.MainApp;

/** Launches the desktop (LWJGL2) application. */
public class Lwjgl2Launcher {
    public static void main(String[] args) {
        createApplication();
    }
    public static LwjglApplication createApplication() {
        return new LwjglApplication(new DistrinctrelController(), getDefaultConfiguration());
    }
//          return new LwjglApplication(new MainApp(), getDefaultConfiguration());


//    private static LwjglApplication createApplication() {
//        return new LwjglApplication(new MainApp(), getDefaultConfiguration());
//    }

    private static LwjglApplicationConfiguration getDefaultConfiguration() {
        LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
        configuration.title = "Discintrel";
        configuration.width = 2480;
        configuration.height = 1290;
        //// This prevents a confusing error that would appear after exiting normally.
        configuration.forceExit = false;
        return configuration;
    }
}

//        for (int size : new int[] { 128, 64, 32, 16 }) {
//            configuration.addIcon("libgdx" + size + ".png", FileType.Internal);
//        }
