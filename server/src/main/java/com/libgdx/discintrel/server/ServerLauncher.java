//WID(22/05/2026)(Sarthak Mittal)(DegamieSign)(ServerLauncher#1)
package com.libgdx.discintrel.server;

import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

/** Launches the server application. */
public class ServerLauncher {
    public void setServerLauncher(ServerLauncher serverLauncher){this.serverLauncher=serverLauncher;}//binding SerVer Launcher in Game App
    public ServerLauncher serverLauncher;
    public static void main(String[] args) {
        HeadlessApplicationConfiguration headlessApplicationConfiguration=new HeadlessApplicationConfiguration();
    }
}
