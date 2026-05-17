//WID(17/05/2026)(Sarthak Mittal)(DegamieSign)#1.1.1,1
package com.libgdx.discintrel.Controller;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libgdx.discintrel.Service.DescintrelService;
public class DistrinctrelController  extends DescintrelService {
    public DescintrelService distrinctrelService;

    public void start(Stage stage) {
        distrinctrelService.create();
        distrinctrelService.render();
        distrinctrelService.updateLogic(delta);
        distrinctrelService.nextLevel();
        distrinctrelService.handleGrasshopperInput(delta);
        distrinctrelService.dispose();
    }

    public void setDistrinctrelService(DescintrelService distrinctrelService) {
        this.distrinctrelService = distrinctrelService;
    }

    public DescintrelService getDistrinctrelService() {
        return distrinctrelService;
    }
}
