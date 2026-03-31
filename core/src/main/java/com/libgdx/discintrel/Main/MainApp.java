package com.libgdx.discintrel.Main;
import com.badlogic.gdx.ApplicationAdapter;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import net.mgsx.gltf.loaders.glb.GLBLoader;
import net.mgsx.gltf.loaders.shared.SceneAssetLoaderParameters;
import net.mgsx.gltf.scene3d.lights.DirectionalLightEx;
import net.mgsx.gltf.scene3d.scene.Scene;
import net.mgsx.gltf.scene3d.scene.SceneAsset;
import net.mgsx.gltf.scene3d.scene.SceneManager;
import net.mgsx.gltf.scene3d.utils.IBLBuilder;
//
public class MainApp extends ApplicationAdapter {// 2D Core
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
//public App app;
//    public SceneManager sceneManager;
//    public SceneAsset squirrelAsset, nutAsset;
//    public Scene squirrelScene, nutScene;
//    public PerspectiveCamera camera;
//
//    public float speed = 5.0f;
//    public int score = 0;
//    public int level = 1;
//    public boolean finishLineVisible = false;
//
//    public SpriteBatch uiBatch;
//    public BitmapFont font;
////    public SceneAssetLoader loader;
//    SceneAssetLoaderParameters params = new SceneAssetLoaderParameters();
//
//    @Override
//    public void create() {
//        // Initialize SceneManager first!
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
//        camera.far = 100f;
//        sceneManager.setCamera(camera);
//
//        // 2. Load mdl
//        squirrelAsset = new GLBLoader().load(Gdx.files.internal("mdl/Squirel.glb"));
//        squirrelScene = new Scene(squirrelAsset.scene);
//
//        nutAsset = new GLBLoader().load(Gdx.files.internal("mdl/nut.glb"));
//        nutScene = new Scene(nutAsset.scene);
//
//        sceneManager.addScene(squirrelScene);
//        sceneManager.addScene(nutScene);
//
//        // 3. Lighting (DirectionalLightEx requires normalization)
//        DirectionalLightEx light = new DirectionalLightEx();
//        light.direction.set(1, -3, 1).nor();
//        light.color.set(Color.WHITE);
//        sceneManager.environment.add(light);
//
//        // Optional: Add basic Image Based Lighting (IBL) so mdl aren't black
//        IBLBuilder iblBuilder = IBLBuilder.createOutdoor(light);
//        sceneManager.setAmbientLight(0.5f);
//
//        resetNut();
//    }
//
//    @Override
//    public void render() {
//        float delta = Gdx.graphics.getDeltaTime();
//        updateLogic(delta);
//
//        // Render 3D Scene
//        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
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
//    public void updateLogic(float delta) {
//        // Use modelInstance.transform.translate for world-space movement
//        if (Gdx.input.isKeyPressed(Input.Keys.UP)) squirrelScene.modelInstance.transform.trn(0, 0, -speed * delta);
//        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) squirrelScene.modelInstance.transform.trn(0, 0, speed * delta);
//        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) squirrelScene.modelInstance.transform.trn(-speed * delta, 0, 0);
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) squirrelScene.modelInstance.transform.trn(speed * delta, 0, 0);
//
//        Vector3 squirrelPos = new Vector3();
//        Vector3 nutPos = new Vector3();
//        squirrelScene.modelInstance.transform.getTranslation(squirrelPos);
//        nutScene.modelInstance.transform.getTranslation(nutPos);
//
//        // Collision logic
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
//
//        if (finishLineVisible && squirrelPos.x > 15) {
//            nextLevel();
//        }
//    }
//
//    private void resetNut() {
//        nutScene.modelInstance.transform.setTranslation(
//            MathUtils.random(-10, 10), 0, MathUtils.random(-10, 10)
//        );
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
//
//    @Override
//    public void dispose() {
//        sceneManager.dispose();
//        squirrelAsset.dispose();
//        nutAsset.dispose();
//        uiBatch.dispose();
//        font.dispose();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//    }
//
//    @Override
//    public void pause() {
//    }
//
//    @Override
//    public void resume() {
//    }
////app.
//    //    controller.start()
//
////    private SpriteBatch batch;
////    private Texture image;
////
////    @Override
////    public void create() {
////        batch = new SpriteBatch();
////        image = new Texture("libgdx.jpeg");
////    }
////
////    @Override
////    public void render() {
////        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
////        batch.begin();
////        batch.draw(image, 140, 210);
////        batch.end();
////    }
////
////    @Override
////    public void dispose() {
////        batch.dispose();
////        image.dispose();
////    }
//}
//
////public class MainApp extends ApplicationAdapter {
////    public SpriteBatch batch;
////    public Texture squirrelTexture, nutTexture;
////    public Sprite squirrelSprite, nutSprite;
////    public OrthographicCamera camera;
////
////    public float speed = 300.0f; // Speed is higher for pixel-based movement
////    public int score = 0;
////    public int level = 1;
////    public boolean finishLineVisible = false;
////
////    public BitmapFont font;
////
////    @Override
////    public void create() {
////        batch = new SpriteBatch();
////        font = new BitmapFont();
////        font.setColor(Color.WHITE);
////
////        // 1. Setup 2D Camera
////        float w = Gdx.graphics.getWidth();
////        float h = Gdx.graphics.getHeight();
////        camera = new OrthographicCamera(w, h);
////        camera.position.set(w / 2f, h / 2f, 0);
////        camera.update();
////
////        // 2. Load Textures (Replace these paths with your 2D .png files)
////        squirrelTexture = new Texture(Gdx.files.internal("mdl/Squirel_img.png"));
////        nutTexture = new Texture(Gdx.files.internal("mdl/nuts.jpg"));
////
////        squirrelSprite = new Sprite(squirrelTexture);
////        nutSprite = new Sprite(nutTexture);
////
////        // Set initial positions
////        squirrelSprite.setPosition(w / 2, h / 2);
////        resetNut();
////    }
////
////    @Override
////    public void render() {
////        float delta = Gdx.graphics.getDeltaTime();
////        updateLogic(delta);
////
////        // Clear Screen
////        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
////        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
////
////        camera.update();
////        batch.setProjectionMatrix(camera.combined);
////
////        batch.begin();
////
////        // Draw Game Objects
////        nutSprite.draw(batch);
////        squirrelSprite.draw(batch);
////
////        // Draw UI
////        font.draw(batch, "Score: " + score + " | Speed: " + (int)speed + " | Level: " + level, 20, Gdx.graphics.getHeight() - 20);
////        if (finishLineVisible) {
////            font.draw(batch, "GO TO THE RIGHT EDGE!", Gdx.graphics.getWidth() / 2f - 50, Gdx.graphics.getHeight() / 2f);
////        }
////
////        batch.end();
////    }
////
////    public void updateLogic(float delta) {
////        // 2D Movement logic
////        if (Gdx.input.isKeyPressed(Input.Keys.UP)) squirrelSprite.setY(squirrelSprite.getY() + speed * delta);
////        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) squirrelSprite.setY(squirrelSprite.getY() - speed * delta);
////        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) squirrelSprite.setX(squirrelSprite.getX() - speed * delta);
////        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) squirrelSprite.setX(squirrelSprite.getX() + speed * delta);
////
////        // 2D Collision logic (using Rectangles is more precise, but distance works too)
////        Vector2 squirrelCenter = new Vector2(squirrelSprite.getX() + squirrelSprite.getWidth()/2, squirrelSprite.getY() + squirrelSprite.getHeight()/2);
////        Vector2 nutCenter = new Vector2(nutSprite.getX() + nutSprite.getWidth()/2, nutSprite.getY() + nutSprite.getHeight()/2);
////
////        if (!finishLineVisible && squirrelCenter.dst(nutCenter) < 40f) {
////            score++;
////            speed += 20.0f;
////            if (score >= 5) {
////                finishLineVisible = true;
////                nutSprite.setPosition(-500, -500); // Hide the nut
////            } else {
////                resetNut();
////            }
////        }
////
////        // Finish line logic (Check if squirrel crossed the right side of the screen)
////        if (finishLineVisible && squirrelSprite.getX() > Gdx.graphics.getWidth() - 50) {
////            nextLevel();
////        }
////    }
////
////    private void resetNut() {
////        float padding = 50f;
////        nutSprite.setPosition(
////            MathUtils.random(padding, Gdx.graphics.getWidth() - padding),
////            MathUtils.random(padding, Gdx.graphics.getHeight() - padding)
////        );
////    }
////
////    public void nextLevel() {
////        level++;
////        score = 0;
////        speed += 30.0f;
////        finishLineVisible = false;
////        squirrelSprite.setPosition(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
////        resetNut();
////    }
////
////    @Override
////    public void dispose() {
////        batch.dispose();
////        squirrelTexture.dispose();
////        nutTexture.dispose();
////        font.dispose();
////    }
////
////    @Override
////    public void resize(int width, int height) {
////        camera.setToOrtho(false, width, height);
////    }
////}
//
//////import com.libgdx.discintrel.Controller.DistrinctrelController;
////
