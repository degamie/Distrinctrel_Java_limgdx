//WID(26/06/2026)(Sarthak Mittal)(DegamieSign)(Controller)s
package com.libgdx.discintrel.Controller;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libgdx.discintrel.Service.DescintrelService;
public class DistrinctrelController  extends DescintrelService {
    public DistrinctrelController controller;
    public DistrinctrelController(DescintrelService descintrelService){
        this.descintrelService=descintrelService;
    }
    public DescintrelService descintrelService;

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
