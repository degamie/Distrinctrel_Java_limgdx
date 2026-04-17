    //WID(17/04/2026)(Sarthak Mittal)#1.1
package com.libgdx.discintrel.gwt;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.libgdx.discintrel.Controller.DistrinctrelController;
//import com.libgdx.discintrel.Main.MainApp;

/** Launches the GWT application. */
public class GwtLauncher extends GwtApplication {
    public DistrinctrelController getController(DistrinctrelController controller){return controller;}
    public DistrinctrelController controller;
        @Override
        public GwtApplicationConfiguration getConfig () {
            // Resizable application, uses available space in browser with no padding:
            GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(true);
            cfg.padVertical = 0;
            cfg.padHorizontal = 0;
            return cfg;
            // If you want a fixed size application, comment out the above resizable section,
            // and uncomment below:
            //return new GwtApplicationConfiguration(640, 480);
        }
        @Override
        public ApplicationListener createApplicationListener () {
            DistrinctrelController distrinctrelController=new DistrinctrelController();
            return controller;
        }
}
