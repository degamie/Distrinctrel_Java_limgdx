//WID(01/04/2026)(Sarthak Mittal)(DegamieSign)#1.1
package com.libgdx.discintrel.Controller;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libgdx.discintrel.Menu.Menu;
import com.libgdx.discintrel.Service.DescintrelService;
//import com.badlogic.gdx.Application;
//import com.badlogic.gdx.ApplicationAdapter;

//import com.libgdx.discintrel.Service.DescintrelService;

////WID(12/3/2026)(Sarthak Mittal)(DegamieSign)(#TBI)#1.1.1(Service (T
//package Controller;
//
//import Service.DistrinctrelService;
//import javafx.application.Application;
//import javafx.stage.Stage;
import com.libgdx.discintrel.*;
//public class DistrinctrelController  extends ApplicationAdapter {
public class DistrinctrelController  extends DescintrelService {
    public Menu menu;
    public float delta=0;
    public Stage stage = null;
    public DescintrelService distrinctrelService;


    //    @Override
    public void start(Stage stage) {
        distrinctrelService.create();
        distrinctrelService.render();
        distrinctrelService.updateLogic(delta);
        distrinctrelService.nextLevel();
//        distrinctrelService.nextlevel();
        distrinctrelService.dispose();
//        distrinctrelService.updateLogic();
    }

    //    @Override
    public void setDistrinctrelService(DescintrelService distrinctrelService) {
        this.distrinctrelService = distrinctrelService;
    }

    public DescintrelService getDistrinctrelService() {
        return distrinctrelService;
    }
}
//
////    public void loadSquirelMdl(Stage stage){
////        this.stage=stage;
//////        DistrinctrelService.loadSqurrielmdl(stage);
////    }

