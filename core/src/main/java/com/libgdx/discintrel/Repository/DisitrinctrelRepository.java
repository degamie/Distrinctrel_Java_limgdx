//WID(23/6/2026)(Sarthak Mittal(DegamieSign)(Distrinctrel Repsotiertogt))#1
package com.libgdx.discintrel.Repository;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.libgdx.discintrel.entity.DisitrinctEntity;
//import com.libgdx.discintrel.entity.DisitrinctEntity;

//import javafx.scene.Group;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;

//import static com.libgdx.discintrel.Main.MainApp.entity;
public interface DisitrinctrelRepository  {
    void updateBystepsCnt(int stepscnt);
    void setStpscnt(int stpscnt){this.stpscnt=stpscnt;}//Binding StepsCount in GameApp
    public int stpscnt;
    public void existsBYEntity(DisitrinctEntity entity);
    public void updateByentity(DisitrinctEntity entity){getEntity(entity)+setEntity(entity)+1;}//updating Entity in GameApp
    public Entity getEntity(DisitrinctEntity entity){return entity;}//Fetching Entity in GameApp
    public void setDestrinctrelentity(DisitrinctEntity entity){this.entity=entity;}//binding Entity in GameApp
    public DisitrinctEntity entity;
    public void existsByRenderTime(TimeFormat renderTime);
    public void updateByrenderTime(TimeFormat renderTime);
    public boolean update(){return assetManager.update();}//Updating AssetManeager's Sound In App
        public void setrendertime(TimeFormat rendertime);
    public void animmategrasshopper(Animation Grasshopper);
//    public void getalpha(int alpha);
    public void existsBydelta(int delta);
    public void updateBydelta(int delta);
    public void setdelta(float delta);
    public float getdelta(float delta );
    public DisitrinctrelEntity destrinctrelentity;
    public void handleGrasshopperInput(float delta);
    public void exisysBySquirelMaterial(Material squirelMaterial);
    public void setSquirelmaterial(Material squirelmaterial);
    public void existsByanimateSquirel(SpriteBatch squirel);
    public void updateByanimateSquirel(SpriteBatch squirel);
    public void setanimateSquirel(SpriteBatch squirel);
    public Animation animateSquirel(SpriteBatch squirel);
    public void existsByEntity(DisitrinctEntity entity);
    public void updateByEntity(DisitrinctEntity entity);//Entity's Update in App
    public void existsByloadModel(String resourcepath);
    public void updateByloadModel(String resourcePath);
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
