////WID(24/04/2026)(Sarthak Mittal)#1.1.1.1.1.1.1,1.1/1,1.1C.1.1.2.1
package com.libgdx.discintrel.Repository;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libgdx.discintrel.entity.DisitrinctEntity;
//import com.libgdx.discintrel.entity.DisitrinctEntity;

//import javafx.scene.Group;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;

//import static com.libgdx.discintrel.Main.MainApp.entity;


//package Repository;
//
//
//import entity.DisitrinctEntity;
//import javafx.scene.input.KeyCode;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import java.net.URL;
//import java.util.HashSet;
//import java.util.Set;
public interface DisitrinctrelRepository  {
    public void setloadModel(String resourcePath);
    public GroupLayout.Group getloadModel(String resourcePath);
    public void setEntity(DisitrinctEntity entity);
    public DisitrinctEntity getEntity(DisitrinctEntity entity);
    public State existsByState(State state);
    public DisitrinctEntity entity = null;
    public void redner();
//public interface DisitrinctrelRepository extends DisitrinctEntity {
    public void update();

    void resetnut();

    void showfinishLine();

    public void nextlevel();
    public void showFinishLine();
    public void resetnut(Rectangle nut);
    public DisitrinctEntity distrinctrelentity = null;
    public void updateStats();
    public GroupLayout.Group loadModel(String resourcepath);
    public void start(Stage stage);
    public void loadSqurrielmdl(Stage stage);
    public  void loadLeafmdl(Stage leaf);
    public  void loadStemmdl(Stage stem);
}
//    URL stem= distrinctentity.getResource("/images/mdl/stem_alpha.fbx");
//    DisitrinctEntity distrinctentity = null;
//    //Properties
//    public double speed = 3.0;
//    public int score = 0;
//    public int level = 1;
//    public final int GOAL_SCORE = 5;
//
////    public Rectangle squirrel = new Rectangle();
////    public Rectangle nut = new Rectangle();
////    public Rectangle finishLine = new Rectangle();
////    public Text statsDisplay = new Text();
//
//    // Track active keys to allow diagonal movement
//    public Set<KeyCode> activeKeys = new HashSet<>();
//    public disitrinctRepository repo = null;
//    public <Stage> void animateWind(Stage stage);
//    public DisitrinctEntity entities = null;

//}
