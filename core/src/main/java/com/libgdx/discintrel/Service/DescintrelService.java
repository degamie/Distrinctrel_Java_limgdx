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
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class DescintrelService implements ApplicationListener {
    // 2D Core
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

    public BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);

        // 1. Setup 2D Orthographic Camera
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h); // false = y-up (0,0 is bottom left)

        // 2. Load 2D Assets (Ensure these exist in your assets folder)
        squirrelTexture = new Texture(Gdx.files.internal("mdl/sprites/Squirel_img.png"));
        nutTexture = new Texture(Gdx.files.internal("mdl/sprites/nuts.jpg"));

        squirrelSprite = new Sprite(squirrelTexture);
        nutSprite = new Sprite(nutTexture);

        // Scale sprites if they are too large/small
        squirrelSprite.setSize(300, 300);
        nutSprite.setSize(32, 32);

        resetNut();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        updateLogic(delta);

        // Clean background (No depth buffer needed for 2D, but it doesn't hurt)
        Gdx.gl.glClearColor(0, 1f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        // Draw Sprites
        nutSprite.draw(batch);
        squirrelSprite.draw(batch);

        // Draw UI
        font.draw(batch, "Score: " + score + " | Level: " + level, 80, Gdx.graphics.getHeight() - 80);
        if (finishLineVisible) font.draw(batch, "RUN TO THE RIGHT EDGE!", 500, Gdx.graphics.getHeight() / 4);

        batch.end();
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
            nutSprite.getX() + nutSprite.getWidth()/2,
            nutSprite.getY() + nutSprite.getHeight()/2
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
