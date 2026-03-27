//package com.libgdx.discintrel.Service;
//
//import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input.Keys;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.PerspectiveCamera;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.math.Vector3;
////import net.mgsx.gltf.loaders.glb.GLBLoader;
////import net.mgsx.gltf.scene3d.scene.Scene;
////import net.mgsx.gltf.scene3d.scene.SceneAsset;
////import net.mgsx.gltf.scene3d.scene.SceneManager;
////import net.mgsx.gltf.scene3d.lights.DirectionalLightEx;
//
//public class SquirrelGame extends ApplicationAdapter {
//    private SceneManager sceneManager;
//    private SceneAsset squirrelAsset, nutAsset;
//    private Scene squirrelScene, nutScene;
//    private PerspectiveCamera camera;
//
//    // Game Logic Variables
//    private float speed = 3.0f;
//    private int score = 0;
//    private int level = 1;
//    private boolean finishLineVisible = false;
//
//    // UI
//    private SpriteBatch uiBatch;
//    private BitmapFont font;
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
//        camera.far = 100f;
//
//        // 2. Load Models (Using GLB for 2026 standards)
//        squirrelAsset = new GLBLoader().load(Gdx.files.internal("models/Squirel.glb"));
//        squirrelScene = new Scene(squirrelAsset.scene);
//
//        nutAsset = new GLBLoader().load(Gdx.files.internal("models/nut.glb"));
//        nutScene = new Scene(nutAsset.scene);
//
//        sceneManager.addScene(squirrelScene);
//        sceneManager.addScene(nutScene);
//
//        // 3. Lighting
//        DirectionalLightEx light = new DirectionalLightEx();
//        light.direction.set(1, -3, 1).nor();
//        sceneManager.environment.add(light);
//
//        resetNut();
//    }
//
//    @Override
//    public void render() {
//        updateLogic(Gdx.graphics.getDeltaTime());
//
//        // Render 3D Scene
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
//        sceneManager.setCamera(camera);
//        sceneManager.update(Gdx.graphics.getDeltaTime());
//        sceneManager.render();
//
//        // Render 2D UI (Scoreboard)
//        uiBatch.begin();
//        font.draw(uiBatch, "Score: " + score + " | Speed: " + speed + " | Level: " + level, 20, Gdx.graphics.getHeight() - 20);
//        if (finishLineVisible) font.draw(uiBatch, "GO TO FINISH LINE!", 350, 300);
//        uiBatch.end();
//    }
//
//    private void updateLogic(float delta) {
//        // Movement Logic
//        if (Gdx.input.isKeyPressed(Keys.UP)) squirrelScene.modelInstance.transform.trn(0, 0, -speed * delta);
//        if (Gdx.input.isKeyPressed(Keys.DOWN)) squirrelScene.modelInstance.transform.trn(0, 0, speed * delta);
//        if (Gdx.input.isKeyPressed(Keys.LEFT)) squirrelScene.modelInstance.transform.trn(-speed * delta, 0, 0);
//        if (Gdx.input.isKeyPressed(Keys.RIGHT)) squirrelScene.modelInstance.transform.trn(speed * delta, 0, 0);
//
//        // Collision Detection (Simplified for 3D)
//        Vector3 squirrelPos = new Vector3();
//        Vector3 nutPos = new Vector3();
//        squirrelScene.modelInstance.transform.getTranslation(squirrelPos);
//        nutScene.modelInstance.transform.getTranslation(nutPos);
//
//        if (squirrelPos.dst(nutPos) < 1.5f) { // Distance-based collision
//            score++;
//            speed += 0.5f;
//            if (score >= 5) {
//                finishLineVisible = true;
//                nutScene.modelInstance.transform.setTranslation(-100, 0, 0); // Hide nut
//            } else {
//                resetNut();
//            }
//        }
//
//        // Level progression
//        if (finishLineVisible && squirrelPos.x > 15) { // Assuming finish line is at x > 15
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
//    private void nextLevel() {
//        level++;
//        score = 0;
//        speed += 1.0f;
//        finishLineVisible = false;
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
//}
