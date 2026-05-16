//WID(16/05/2026)(Sarthak Mittal)(Degamiesign)#1.1s.1.1.1.1.1.1/.1/1.1
package com.libgdx.discintrel.Service;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.libgdx.discintrel.util.SfxManager;

//import java.awt.*;

public class DescintrelService extends SfxManager implements ApplicationListener {
    //GrassHoper's Axial 2d Grid's Coordinates Declare
     public final GridPoint2[] DIRECTIONS={//2d Grid's Directions Declare
        new GridPoint2(-1,0),//Top-Left  cooroinates Declare
        new GridPoint2(0,-1),//bottom Left   cooroinates declare
        new GridPoint2(+1,0),//Top Right cooroinates Declare
        new GridPoint2(0,+1),//bottom Right cooroinates declare
        new GridPoint2(-1,-1),//bottom cooroinates declare
        new GridPoint2(1,1)//Top cooroinates declare

    };
    public void setDelta(float delta){this.delta=delta;}//binidng Delta
    public float delta=0f;
    public void updateBySpeed(int speed){getspeed(speed)+setSpeed(speed)+1;}//updating Speed in App

    public int  getspeed(int speed) {
        return speed;
    }


    public void setSpeed(int speed){this.speed=speed;}//Binding Speed in App
    public SfxManager sfxManager=new SfxManager();
    public SfxManager getSfxManager(SfxManager sfxManager){return sfxManager;}

    @Override
    public void setSfxManager(SfxManager sfxManager) {
        this.sfxManager = sfxManager;
    }

    //    public Label getLabel(Label label){}
    public Label label;
    // 2D Core
    public void setBatch(SpriteBatch spriteBatch){this.batch=batch;}//binding batch in App
    public SpriteBatch batch;
    public SpriteBatch getBatch(SpriteBatch batch){return batch;}//Fetching batch in App
    public OrthographicCamera camera;
    public void setCamera(OrthographicCamera camera){this.camera=camera;}//binding Camera in App
    public OrthographicCamera getCamera(OrthographicCamera camera){return camera;}//Fetching Camera in App

    // Sprites & Textures
    public Texture squirrelTexture, nutTexture,bckg;
    public Sprite squirrelSprite, nutSprite,bckgSprite;

    // Game Logic
    public float speed = 300.0f; // Pixels per second
    public int score = 0;
    public int level = 1;
    public boolean finishLineVisible = false;

    public BitmapFont font;

    @Override
    public void create() {
        sfxManager.create();
        sfxManager.pause();
        sfxManager.resume();
        sfxManager.dispose();
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.BLUE);
//        font.setColor(Color.WHITE);

        // 1. Setup 2D Orthographic Camera
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h); // false = y-up (0,0 is bottom left
//Background Texture and Sprite Impl
        bckg = new Texture(Gdx.files.internal("distrinctrel_background.jpeg"));
        bckgSprite=new Sprite(bckg);

        // 2. Load 2D Assets (Ensure these exist in your assets folder)
        squirrelTexture = new Texture(Gdx.files.internal("mdl/sprites/Squirel_img.png"));
        nutTexture = new Texture(Gdx.files.internal("mdl/sprites/nuts.jpg"));

        squirrelSprite = new Sprite(squirrelTexture);
        nutSprite = new Sprite(nutTexture);

        // Scale sprites (to Both Sprites and Background)
        squirrelSprite.setSize(300, 300);
        nutSprite.setSize(32, 32);
        bckgSprite.setSize(2480,1290);

        resetNut();
    }

    public float getdelta(float delta){
        return delta;
    }

    @Override
    public void render() {
        delta= Gdx.graphics.getDeltaTime();
        updateLogic(delta);

        // Clean background (No depth buffer needed for 2D, but it doesn't hurt)
        Gdx.gl.glClearColor(0, 1f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        // Draw Sprites
        bckgSprite.draw(batch);
        nutSprite.draw(batch);
        squirrelSprite.draw(batch);

        // Draw UI
        font.draw(batch, "Score: " + score + " | Level: " + level, 80, Gdx.graphics.getHeight() - 40);
        if (finishLineVisible) font.draw(batch, "RUN TO THE RIGHT EDGE!", 500, Gdx.graphics.getHeight() / 4);
        batch.end();

        font.getData().setScale(2.0f);
//        label.setFontScale(2.0f);

    }

    public void updateLogic(float delta) {
        // 2D Movement (X and Y instead of X and Z)
        if (Gdx.input.isKeyPressed(Keys.UP)) squirrelSprite.translateY(speed * delta);
        if (Gdx.input.isKeyPressed(Keys.DOWN)) squirrelSprite.translateY(-speed * delta);
        if (Gdx.input.isKeyPressed(Keys.LEFT)) squirrelSprite.translateX(-speed * delta);
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) squirrelSprite.translateX(speed * delta);

        // Simple Circle-based Collision using Centers
        Vector2 squirrelCenter = new Vector2(
            squirrelSprite.getX() + squirrelSprite.getWidth()/2,
            squirrelSprite.getY() + squirrelSprite.getHeight()/2
        );
        Vector2 nutCenter = new Vector2(
            nutSprite.getX() + nutSprite.getWidth()/4,
            nutSprite.getY() + nutSprite.getHeight()/4
        );

        if (!finishLineVisible && squirrelCenter.dst(nutCenter) < 40f) {
            score++;
            speed += 20f;
            if (score >= 5) {
                finishLineVisible = true;
                nutSprite.setPosition(-1000, -1000); // Move nut off-screen
            } else {
                resetNut();
            }
        }

        // Finish line logic: Check if squirrel hit the right edge of screen
        if (finishLineVisible && squirrelSprite.getX() > Gdx.graphics.getWidth() - squirrelSprite.getWidth()) {
            nextLevel();
        }
    }

    private void resetNut() {
        // Randomly place nut within screen bounds
        float x = MathUtils.random(0, Gdx.graphics.getWidth() - nutSprite.getWidth());
        float y = MathUtils.random(0, Gdx.graphics.getHeight() - nutSprite.getHeight());
        nutSprite.setPosition(x, y);
    }

    public void nextLevel() {
        level++;
        score = 0;
        speed += 50.0f;
        finishLineVisible = false;
        squirrelSprite.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        resetNut();
    }

    @Override
    public void dispose() {
        batch.dispose();
        squirrelTexture.dispose();
        nutTexture.dispose();
        font.dispose();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }

    @Override public void pause() {}
    @Override public void resume() {}
}
