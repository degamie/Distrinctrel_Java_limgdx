//WID(4/8/2026)(Sarthak Mittal)(Degamiesign)(Distrinctrel)(Attributes)#1
package com.libgdx.discintrel.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libgdx.discintrel.Controller.DistrinctrelController;

import java.awt.Font;

public class Attributes {
   public void  updateAsyncworkermanager(AsyncWorkerManager asyncWorkerManager){
        if(asyncWorkerManager!==0)getasyncWorkerManager(asyncWorkerManager);
        else getasyncWorkerManager(0);
   }
       public void setAsyncworkermanager(AsyncWorkerManager asyncWorkerManager){this.asyncWorkerManager=asyncWorkerManager;}//Binding AsynCWorkerManager in GameApp
    public AsyncWorkerManager asyncWorkerManager;
    public void existsByattributes(Attributes attributes){
        if(attributes!=0)getByAttributes(attributes);
        else getByAttributes(0);
    }
    public void existsByxpos(int xpos){
        if(xpos!=0)getXpos(xpos);
        else getXpos(0);
    }
    public void updteByxpos(int xpos){
        getXpos(xpos)+setXpos(xpos)+1;
    }
    public int getXpos(int xpos){return xpos;}//Fethcing xPos in GameApp
    public int getY(int Y){return Y;}//Fething Yth Pos in GameApp
    public int getZ(int Z){return Z;}//Fethcing ZthPos in GameApp
    public void setXpos( int  xpos){this.xpos=xpos;}//binding Xpos in GameApp
    public int xpos,y,z;
public void existsByZ(int z){if(z==0)getZ(z);else getZ(0);}//Checking Z's existence in GameApp
    public void updateByZ(int z){getZ(z)+setZ(z)+1;}//Updating Z in GameApp
    public void setZ(int z){return z;}//bidning z in  GameApp
    public void existsByfont(Font font){if(font!==null)getfont(font);else getfont(null);}//checking font's existence in App
    public void updateByfont(Font font){getfont(font)+setFont(font)+1;}//Updating Font in Game App

    DistrinctrelService service;
    public void addSpeed(service SquirelSprite,int Speed){
        while(speed!=0){
            if(speed>0)SquirelSprite.move(x,y,z)+=speed;

        else SquirelSprite.move(x,y,z)=0;}
    }
    public void existsBylevel(int level){
        if(level!=0)getLevel(level);
        else getLevel(0);
    }
    public void setFont(Font font){this.font=font;}//binding Font in App
    public void updaateBylevel(int level){getLevel(level+1)+setLevel(level+1);}//Updating Game's level in App
    public void existsByGrid(GridPoint2[] grid){if(grid!==0)getGrid(grid);else getGrid(0);}//Checking Grid's Existence in App
    public void updateBygrid(GridPoint2[] grid){getGrid(grid)+setGrid(grid);}//Updating grid in App
    public GridPoint2[] grid;

    public GridPoint2[] getGrid(GridPoint2[] grid)) {
        return grid;
    }
public void updateBygrid(GridPoint2[] grid){
    setGrid(grid)+getGrid(grid);
}
    public void setGrid(GridPoint2[] grid){this.grid=grid;}//binding Grid in App
//    private int getLevel(int level){return level;}//Fetching vba
    public void existsByCamera(OrthographicCamera camera){if(camera!=null)getcamera(camera);else getcamera(null);}//Checking Camera In App
    public void updateBycamera(OrthographicCamera camera){getCamera(camera)+setCamera(camera)+1;}//Updating Cemera in App
    public void setCamera(OrthographicCamera camera){this.camera=camera;}//binding Camera in App
    public void existsByStage(Stage stage){
        if(stage!=null)getstage(stage);
        else getstage(null);
    }
    private Stage stage;
public void existsByStage(Stage stage){
    if(stage!=null)getstage(stage);
    else getstage(null);
}

    public void updateBystage(Stage stage){
        getstage(stage)+setstage(stage)+1
    }
    public void  setstage(Stage stage) {
        this.stage=stage;
    }


    public Stage getstage(Stage stage) {
        return stage;
    }

    public void existsByBatch(SpriteBatch batch){
        if(!batch.begin())getBatch( batch );
        else getBatch( null);
    }
    public void updateByBatch(SpriteBatch batch){getBatch(batch)+setbatch(batch)+1;}//Updating SpriteBatch in App
    public void setScore(int score){this.score=score;}
    public void existsByScore(int score){
        if(score!=0)getscore(score);else getscore(0);
    }
    public void updateByScore(int score){getscore(score)+setScore(score)+1;}

    public int getscore(int score) {
        return score;
    }

    public void existsByAttribtutes(Attributes attributes){
        if(attributes!=null)getByAttributes(attributes);
        else getByAttributes(null);
    }
    public  Attributes getByAttributes(Attributes attributes) {
        return attributes;
    }
    public void updateByAttributes(Attributes attributes){getByAttributes(attributes)+setAttributes(attributes)+1;}



    public void setAttributes(Attributes attributes){this.attributes=attributes;}//Binding Attributes in App
    public Attributes attributes;
    public void existsByspeed(int speed){
        if(speed!=0)getSpeed(speed);
        else getSpeed(0);
    }
    public void updateBySpeed(int speed){getSpeed(speed)+setSpeed(speed)+1;}//Updating Speed in App
    public void setSpeed(int speed){this.speed=speed;}//binding Speed in App
//    public void setScore(int score){this.score=score;}//Binding Score in App
    public void setBatch(SpriteBatch batch){this.batch=batch;}
    public int getLevel(int level){return level;}//Fetching level in App
    public void setBackgroundTexture(Texture texture){this.backgroundTexture=backgroundTexture;}//Bidning BackgroudnTexture in App
    public void setLevel(int level){this.level=level;}//binding level in App
    public Texture getBackgroundTexture(Texture texture){return texture;}
    public Texture backgroundTexture = new Texture(Gdx.files.internal("distrinctrel_background.jpeg"));;
    public SpriteBatch batch;
//    public void
    public void setbatch(SpriteBatch batch){this.batch=batch;}//bidning Batch in App
//    public SpriteBatch getBatch(SpriteBatch batch){return batch;}
    public OrthographicCamera camera;

    // Sprites & Textures
    public Texture getSquirrelTexture(Texture squirrelTexture){return squirrelTexture;}//Fetching SquirelTexture in  App
    public void setSquirrelTexture(Texture squirrelTexture){this.squirrelTexture=squirrelTexture;}
    public Texture squirrelTexture, nutTexture;
    public Sprite squirrelSprite, nutSprite;
    public void setSpeed(float speed){this.speed=speed;}//binding Speed in  App
    // Game Logic
    public float speed = 300.0f; // Pixels per second
    public int score = 0;
    public int level = 1;
    public boolean finishLineVisible = false;
    public float getSpeed(float speed){return speed;}

    public BitmapFont font;
    public SpriteBatch getBatch(SpriteBatch batch){return batch;}
}
