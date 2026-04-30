//WID(29/4/2026)(Sarthak Mittal)(Degamiesign)#1.1.1.1.1.1c.1.1.1.1.1
package com.libgdx.discintrel.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Attributes {
    public void setBatch(SpriteBatch batch){this.batch=batch;}
    public int getLevel(int level){return level;}//Fetching level in App
    public void setBackgroundTexture(Texture texture){this.backgroundTexture=backgroundTexture;}//Bidning BackgroudnTexture in App
    public void setLevel(int level){this.level=level;}//binding level in App
    public Texture getBackgroundTexture(Texture texture){return texture;}
    public Texture backgroundTexture = new Texture(Gdx.files.internal("distrinctrel_background.jpeg"));;
    public SpriteBatch batch;
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
