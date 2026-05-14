//WID(14/05/2026)(Sarthak Mittal)#1c
package com.libgdx.discintrel.teavm;

import com.github.xpenatan.gdx.teavm.backends.web.WebApplicationConfiguration;
import com.github.xpenatan.gdx.teavm.backends.web.WebApplication;
//import com.libgdx.discintrel.Main.MainApp;

/**
 * Launches the TeaVM/HTML application.
 */
public class TeaVMLauncher {
    public WebApplicationConfiguration config =new WebApplicationConfiguration();
    void setconfig(WebApplicationConfiguration config){this.config=config;}
    public static void main(String[] args) {

        WebApplicationConfiguration config = new WebApplicationConfiguration("canvas");
        //// If width and height are each greater than 0, then the app will use a fixed size.
        //config.width = 640;
        //config.height = 480;
        //// If width and height are both 0, then the app will use all available space.
        config.width = 0;
        config.height = 0;
        new WebApplication(new MainApp(), config);
    }
}
