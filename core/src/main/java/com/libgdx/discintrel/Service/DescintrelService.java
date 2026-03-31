package com.libgdx.discintrel.Service;

import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class DescintrelService extends ApplicationAdapter {
    public Texture backgroundTexture;
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
//    public SpriteBatch batch;


    @Override
    public void create() {
        batch = new SpriteBatch();
        // Ensure your image is in the 'assets' folder
        backgroundTexture = new Texture("2d_img/distrinctrel_background.jpeg");
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);

        // 1. Setup 2D Orthographic Camera
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h); // false = y-up (0,0 is bottom left)

        // 2. Load 2D Assets (Ensure these exist in your assets folder)
        squirrelTexture = new Texture(Gdx.files.internal("mdl/Squirel_img.png"));
        nutTexture = new Texture(Gdx.files.internal("mdl/nuts.jpg"));

        squirrelSprite = new Sprite(squirrelTexture);
        nutSprite = new Sprite(nutTexture);

        // Scale sprites if they are too large/small
        squirrelSprite.setSize(320, 320);
        nutSprite.setSize(64, 64);

        resetNut();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        updateLogic(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // 2. Draw the background
        batch.begin();
        // Drawing from (0,0) and stretching to fill the screen width/height
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        // Clean background (No depth buffer needed for 2D, but it doesn't hurt)
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        // Draw Sprites
        nutSprite.draw(batch);
        squirrelSprite.draw(batch);

        // Draw UI
        font.draw(batch, "Score: " + score + " | Level: " + level, 20, Gdx.graphics.getHeight() - 20);
        if (finishLineVisible) font.draw(batch, "RUN TO THE RIGHT EDGE!", 200, Gdx.graphics.getHeight() / 2);

        batch.end();
    }

    public void updateLogic(float delta) {
        // 2D Movement (X and Y instead of X and Z)
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) squirrelSprite.translateY(speed * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) squirrelSprite.translateY(-speed * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) squirrelSprite.translateX(-speed * delta);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) squirrelSprite.translateX(speed * delta);

        // Simple Circle-based Collision using Centers
        Vector2 squirrelCenter = new Vector2(
            squirrelSprite.getX() + squirrelSprite.getWidth() / 2,
            squirrelSprite.getY() + squirrelSprite.getHeight() / 2
        );
        Vector2 nutCenter = new Vector2(
            nutSprite.getX() + nutSprite.getWidth() / 2,
            nutSprite.getY() + nutSprite.getHeight() / 2
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
        squirrelSprite.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
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

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
//package com.libgdx.discintrel.Service;
//
//import com.badlogic.gdx.ApplicationListener;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input.Keys;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.PerspectiveCamera;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g3d.Attribute;
//import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.math.Vector3;
//import net.mgsx.gltf.loaders.glb.GLBLoader;
//import net.mgsx.gltf.scene3d.lights.DirectionalLightEx;
//import net.mgsx.gltf.scene3d.scene.Scene;
//import net.mgsx.gltf.scene3d.scene.SceneAsset;
//import net.mgsx.gltf.scene3d.scene.SceneManager;
//import net.mgsx.gltf.scene3d.scene.SceneSkybox;
//import net.mgsx.gltf.scene3d.utils.IBLBuilder;
//
//public class DescintrelService implements ApplicationListener {
//    public SceneManager sceneManager;
//    public SceneAsset squirrelAsset, nutAsset;
//    public Scene squirrelScene, nutScene;
//    public PerspectiveCamera camera;
//    public SceneSkybox skybox; // Added Skybox reference
//
//    public float speed = 5.0f;
//    public int score = 0;
//    public int level = 1;
//    public boolean finishLineVisible = false;
//
//    public SpriteBatch uiBatch;
//    public BitmapFont font;
//
//    @Override
//    public void create() {
//        sceneManager = new SceneManager();
//        uiBatch = new SpriteBatch();
//        font = new BitmapFont();
//        font.setColor(Color.WHITE);
//
//        // 1. Setup Camera
//        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        camera.position.set(0, 10f, 20f);
//        camera.lookAt(0, 0, 0);
//        camera.near = 1f;
//        camera.far = 500f; // Increased far plane for skybox visibility
//        sceneManager.setCamera(camera);
//
//        // 2. Load Models
//        squirrelAsset = new GLBLoader().load(Gdx.files.internal("mdl/Squirel.glb"));
//        squirrelScene = new Scene(squirrelAsset.scene);
//        nutAsset = new GLBLoader().load(Gdx.files.internal("mdl/nut.glb"));
//        nutScene = new Scene(nutAsset.scene);
//
//        sceneManager.addScene(squirrelScene);
//        sceneManager.addScene(nutScene);
//
//        // 3. Lighting & Skybox
//        DirectionalLightEx light = new DirectionalLightEx();
//        light.direction.set(1, -3, 1).nor();
//        light.color.set(Color.WHITE);
//        sceneManager.environment.add(light);
//
//        // --- NEW: Ambient Lighting & Skybox Setup ---
//        IBLBuilder iblBuilder = IBLBuilder.createOutdoor(light);
//        sceneManager.render(); // Quality settings
////        sceneManager.setPlaceholderConfig(20, 1024); // Quality settings
//
//        // Generate environmental maps (Ambient Light)
//        sceneManager.setAmbientLight(0.8f); // Base brightness for shadows
//        sceneManager.environment.set((Iterable<Attribute>) iblBuilder.buildEnvMap(1024));
//        sceneManager.environment.set((Iterable<Attribute>) iblBuilder.buildIrradianceMap(256));
//
//        // Create and set the Skybox
//
////        skybox = new SceneSkybox(iblBuilder.buildCubemap(1024));
//        sceneManager.setSkyBox(skybox);
//        // --------------------------------------------
//
//        resetNut();
//    }
//
//    @Override
//    public void render() {
//        float delta = Gdx.graphics.getDeltaTime();
//        updateLogic(delta);
//
//        // Render 3D Scene (Ensure Depth Buffer is cleared!)
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
//
//        sceneManager.update(delta);
//        sceneManager.render();
//
//        // Render 2D UI
//        uiBatch.begin();
//        font.draw(uiBatch, "Score: " + score + " | Speed: " + (int)speed + " | Level: " + level, 20, Gdx.graphics.getHeight() - 20);
//        if (finishLineVisible) font.draw(uiBatch, "GO TO FINISH LINE (X > 15)!", 300, 300);
//        uiBatch.end();
//    }
//
//    // ... (rest of your logic methods remain the same) ...
//
//    @Override
//    public void dispose() {
//        sceneManager.dispose();
//        if (skybox != null) skybox.dispose(); // Dispose skybox textures
//        squirrelAsset.dispose();
//        nutAsset.dispose();
//        uiBatch.dispose();
//        font.dispose();
//    }
//
//    @Override public void resize(int width, int height) { sceneManager.updateViewport(width, height); }
//    @Override public void pause() {}
//    @Override public void resume() {}
//
//    public void updateLogic(float delta) {
//        if (Gdx.input.isKeyPressed(Keys.UP)) squirrelScene.modelInstance.transform.trn(0, 0, -speed * delta);
//        if (Gdx.input.isKeyPressed(Keys.DOWN)) squirrelScene.modelInstance.transform.trn(0, 0, speed * delta);
//        if (Gdx.input.isKeyPressed(Keys.LEFT)) squirrelScene.modelInstance.transform.trn(-speed * delta, 0, 0);
//        if (Gdx.input.isKeyPressed(Keys.RIGHT)) squirrelScene.modelInstance.transform.trn(speed * delta, 0, 0);
//
//        Vector3 squirrelPos = new Vector3();
//        Vector3 nutPos = new Vector3();
//        squirrelScene.modelInstance.transform.getTranslation(squirrelPos);
//        nutScene.modelInstance.transform.getTranslation(nutPos);
//
//        if (!finishLineVisible && squirrelPos.dst(nutPos) < 1.5f) {
//            score++;
//            speed += 0.5f;
//            if (score >= 5) {
//                finishLineVisible = true;
//                nutScene.modelInstance.transform.setTranslation(-100, 0, 0);
//            } else {
//                resetNut();
//            }
//        }
//        if (finishLineVisible && squirrelPos.x > 15) nextLevel();
//    }
//
//    private void resetNut() {
//        nutScene.modelInstance.transform.setTranslation(MathUtils.random(-10, 10), 0, MathUtils.random(-10, 10));
//    }
//
//    public void nextLevel() {
//        level++;
//        score = 0;
//        speed += 1.0f;
//        finishLineVisible = false;
//        squirrelScene.modelInstance.transform.setTranslation(0,0,0);
//        resetNut();
//    }
//}
