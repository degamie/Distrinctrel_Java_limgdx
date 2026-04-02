//WID(2/4/2026)(Sarthak Mittal)(Degamiesign)#1
package com.libgdx.discintrel.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Attributes {
    public Texture backgroundTexture = new Texture(Gdx.files.internal("distrinctrel_background.jpeg"));;
    public SpriteBatch batch;
    public OrthographicCamera camera;

    // Sprites & Textures
    public Texture squirrelTexture, nutTexture;
    public Sprite squirrelSprite, nutSprite;
    // Game Logic
    public float speed = 300.0f; // Pixels per second
    public int score = 0;
    public int level = 1;
    public boolean finishLineVisible = false;
    public float getSpeed(float speed){return speed;}

    public BitmapFont font;
}
