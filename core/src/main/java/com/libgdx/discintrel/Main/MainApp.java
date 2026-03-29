package com.libgdx.discintrel.Main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.libgdx.discintrel.Controller.DistrinctrelController;
//import com.libgdx.discintrel.Controller.DistrinctrelController;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainApp extends ApplicationAdapter {
    public DistrinctrelController controller;
    private SpriteBatch batch;
    private Texture image;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.jpeg");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 140, 210);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
