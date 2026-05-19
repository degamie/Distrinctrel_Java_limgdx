//WID(19/05/2026)(Sarthak Mittal)(DegamieISign)#1.1.1,1.1.1.1.1/1/1.1
package com.libgdx.discintrel.entity;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import net.mgsx.gltf.scene3d.scene.SceneAsset;
import org.w3c.dom.Text;

import javax.swing.plaf.nimbus.State;
import java.awt.*;

public class DisitrinctEntity{
    public Texture grasshopperTexture=null;
    //2D Core Assets(Version 1.0)#1
   // public void updateByBatch(SpriteBatch batch){getBatch()+setBatch(batch)+1;}//Updating Batch in App
    public Label label;
    public void setsquirrelTexture(Texture squirrelTexture){this.squirrelTexture=squirrelTexture;}//binding Squireltexture in App

    public SpriteBatch batch;
    public SpriteBatch getBatch(SpriteBatch batch){return batch;}//Fetching batch in App
    public OrthographicCamera camera;
    public OrthographicCamera getCamera(OrthographicCamera camera){return camera;}//Fetching Camera in App

    // Sprites & Textures
    public Texture squirrelTexture, nutTexture,bckg;
    public Sprite squirrelSprite, nutSprite,bckgSprite;


    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public Texture getSquirrelTexture() {
        return squirrelTexture;
    }

    public void setSquirrelTexture(Texture squirrelTexture) {
        this.squirrelTexture = squirrelTexture;
    }

    public Group getNut() {
        return nut;
    }

    public void setNut(Group nut) {
        this.nut = nut;
    }


    // Game Logic
    public float speed = 300.0f; // Pixels per second
    public int score = 0;
    public int level = 1;
    public boolean finishLineVisible = false;
    //3d Mdl(Assets)(TBC)(Beta-Stage)
    public SceneAsset asset;

    public SceneAsset getAsset() {
        return asset;
    }

    public State goalstate;
    public Rectangle finishLine;
    public Text statsDisplay;
    public Group nest;
    public Group Squirel;
    public Group Stem;
    public Group  leafModel;
    public DisitrinctEntity disitrinctEntity;
//    public final Set<KeyCode> activeKeys= new HashSet<>();
    public DisitrinctEntity e=null;
//    public int score = 0;
//    public float  speed  = 3.0;
//    public int level = 1;
    public final int GOAL_SCORE = 5;
    public Stage stage;
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


   // public static void setActiveKeys(Set<KeyCode> activeKeys){activeKeys=activeKeys;}
    public Group nut;

    public DisitrinctEntity(Group nut, Rectangle finishLine, Text statsDisplay, Group nest, Group squirel, Group stem, Group leafModel, DisitrinctEntity disitrinctEntity, DisitrinctEntity e, int score, float  speed , int level) {
        this.nut = nut;
        this.finishLine = finishLine;
        this.statsDisplay = statsDisplay;
        this.nest = nest;
        Squirel = squirel;
        Stem = stem;
        this.leafModel = leafModel;
//        this.disitrinctEntity = disitrinctEntity;
//        this.e = e;
        this.score = score;
        this.speed = speed;
        this.level = level;
    }



    public Group getSquirel() {
        return Squirel;
    }

    public void setSquirel(Group squirel) {
        Squirel = squirel;
    }

    public Group getStem() {
        return Stem;
    }

    public void setStem(Group stem) {
        Stem = stem;
    }

    public Group getLeafModel() {
        return leafModel;
    }

    public void setLeafModel(Group leafModel) {
        this.leafModel = leafModel;
    }

//    public Set<KeyCode> getActiveKeys() {
//        return activeKeys;
//    }

    public DisitrinctEntity getE() {
        return e;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(float  speed ) {
        this.speed = speed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGOAL_SCORE() {
        return GOAL_SCORE;
    }

    public Group getSquirel(Group Squirel){return Squirel;}

    public Group getNest() {
        return nest;
    }

    public void setNest(Group nest) {
        this.nest = nest;
    }

    public DisitrinctEntity getDisitrinctEntity() {
        return disitrinctEntity;
    }
}
    //public void setE(DisitrinctEntity e) {
//        this.e = e;
//    }


    //public void setDisitrinctEntity(DisitrinctEntity disitrinctEntity) {
//        this.disitrinctEntity = disitrinctEntity;
//    }

//    public URL Stem;
//    public URL squirel;
//    public URL nuts;
//    public URL Nest;
//    public URL Leaf;
//    public Mesh mesh;


    // JavaFX Nodes


//    public Group squirel;
//    public Group nuts;
//    public Group Nest;
//
//    public Mesh Leaf;
//    public Mesh mesh;
//    public DisitrinctEntity  entities;
//
//    public Group getSquirel() {
//        return squirel;
//    }
//
//    public void setSquirel(Group squirel) {
//        this.squirel = squirel;
//    }
//
//    public Group getNuts() {
//        return nuts;
//    }
//
//    public void setNuts(Group nuts) {
//        this.nuts = nuts;
//    }
//
//    public Group getNest() {
//        return Nest;
//    }
//
//    public void setNest(Group nest) {
//        Nest = nest;
//    }
//
//    public Group getSteam() {
//        return Steam;
//    }
//
//    public void setSteam(Group steam) {
//        Steam = steam;
//    }
//
//    public Group getLeaf() {
//        return Leaf;
//    }
//
//    public void setLeaf(Group leaf) {
//        Leaf = leaf;
//    }
//
//    public Mesh getMesh() {
//        return mesh;
//    }
//
//    public void setMesh(Mesh mesh) {
//        this.mesh = mesh;
//    }
//
//    public DisitrinctEntity getEntities() {
//        return entities;
//    }
//
//    public void setEntities(DisitrinctEntity entities) {
//        this.entities = entities;
//    }
