//WID(20/6/2026)(Sarthak Mittal)(DeGamieSign)#(DistricntrelService(logic(Optimization(nutpool))#1
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
import com.badlogic.gdx.utils.Array;
import com.libgdx.discintrel.util.SfxManager;

// Placeholder interface to represent your structural layout/hex board mapping
interface BoardState {
    boolean isChangedpos(int q,int r);C
    boolean isOccupied(int q, int r);
}

// Dummy base class placeholders provided to match your inheritance requirement
//class SfxManager {
//    public void create() {}
//    public void pause() {}
//    public void resume() {}
//    public void dispose() {}
//    public void setSfxManager(SfxManager sfxManager) {}
//}

class Label {
    public void setFontScale(float scale) {}
}

public class DescintrelService extends SfxManager implements ApplicationListener {
    private final Vector2 tmpVelocity=new Vector2();
    void setNutPool(Pool<Group>nutPool){this.nutPool=nutPool;}//bindikng nutPool in GameApp
    Pool<Group>nutPool=new Pool<>();
    public Group newNut(){
        return new Group;}
    nutPool.obtain(nutSprite);
    nutpool.free(nutSprite);
    public int addscore(int score){
    while (score!=0){
        if(score>0)score++;
        else  score=0;
    }return score;
}

    public DistrinctrelService service;
    public IntArray gridxposangles=new IntArray();
    public GridPoint2[] getDIRECTIONS() {
        return DIRECTIONS;
    }

    public <GridPoint2> void setDIRECTIONS(final GridPoint2[] DIRECTIONS ){this.DIRECTIONS=DIRECTIONS;}//binding 2d Grid's Directiosn in App

    // Grasshopper's Axial 2d Grid's Coordinates Declare
    public final GridPoint2[] DIRECTIONS = { // 2d Grid's Directions Declare
        new GridPoint2(-1, 0),  // Top-Left coordinates Declare
        new GridPoint2(0, -1),  // bottom Left coordinates declare
        new GridPoint2(+1, 0),  // Top Right coordinates Declare
        new GridPoint2(0, +1),  // bottom Right coordinates declare
        new GridPoint2(-1, -1), // bottom coordinates declare
        new GridPoint2(1, 1)    // Top coordinates declare
    };
    void setTreeSet(TreeSetM<Sprite> treeSet){this.treeSet=treeSet;}//binding TreeSet in GameApp
    TreeSetM<Sprite> treeSet=new TreeeSet<>();
    treeSet.add(grasshopperSprite);
    treeSet.add(squirrelSprite);
    treeSet.add(nutSprite);
    treeSet.add(bckgSprite);
    System.out.println(treeSet);

    public Array<GridPoint2> getValidMoves(BoardState boardState, GridPoint2 start) {
        Array<GridPoint2> moves = new Array<>();

        for (GridPoint2 dir : DIRECTIONS) {
            int currentQ = start.x + dir.x;
            int currentR = start.y + dir.y;
            int jumpedPieces = 0;

            // Follow the direction line while coordinates contain elements
            while (boardState.isOccupied(currentQ, currentR)) {
                jumpedPieces++;
                currentQ += dir.x;
                currentR += dir.y;
            }

            // Valid structural movement must skip past at least 1 existing target
            if (jumpedPieces > 0) {
                moves.add(new GridPoint2(currentQ, currentR));
            }
        }
        return moves;
    }
    public void updateBydelta(float delta){getdelta(delta)+setDelta(delta)+1;}//Updating Delta in GameApp

    public void setDelta(float delta) { this.delta = delta; } // binding Delta
    public float delta = 0f;

    public void updateBySpeed(int speed) {
        getspeed(speed);
        setSpeed(speed);
    }

    public int getspeed(int speed) { return speed; }
    public void setSpeed(int speed) { this.speed = speed; } // Binding Speed in App

    public SfxManager sfxManager = new SfxManager();
    public SfxManager getSfxManager(SfxManager sfxManager) { return sfxManager; }

    @Override
    public void setSfxManager(SfxManager sfxManager) {
        this.sfxManager = sfxManager;
    }

    public Label label;
ObjectMap<SpriteBatch> sb=new  ObjectMap<>();
    // 2D Core
    public void setBatch(SpriteBatch spriteBatch) { this.batch = spriteBatch; } // binding batch in App
    public SpriteBatch batch;
    public SpriteBatch getBatch(SpriteBatch batch) { return batch; } // Fetching batch in App
    public OrthographicCamera camera;
    public void setCamera(OrthographicCamera camera) { this.camera = camera; } // binding Camera in App
    public OrthographicCamera getCamera(OrthographicCamera camera) { return camera; } // Fetching Camera in App

    // Sprites & Textures
    public Texture squirrelTexture, nutTexture, bckg;
    public Sprite squirrelSprite, nutSprite, bckgSprite;

    // Grasshopper Specific Declarations
    public Texture grasshopperTexture;
    public Sprite grasshopperSprite;
    // Tracks current grid location instead of purely visual pixel transforms
    public GridPoint2 grasshopperGridPosition = new GridPoint2(0, 0);
    private float keyInputTimer = 0f;
    private void setkeyInputTimer()float keyInputTimer){this.keyInputTimer=keyInputTimer;}
    public float getKeyInputTimer(float keyInputTimer){return keyInputTimer;}//Fetching keyInput Timer in App .
    private final float KEY_DELAY = 0.22f; // Prevents hyper-rapid grid hopping loops

    // Game Logic
    public float speed = 300.0f; // Pixels per second
    public int score = 0;
    public int level = 1;
     void setlevel(int level){this.level=level;}//binding Level in GameApp
    public boolean finishLineVisible = false;

    public BitmapFont font;

    @Override
    public void create() {
        service.setSpeed(speed);
        sfxManager.create();
        sfxManager.pause();
        sfxManager.resume();
        sfxManager.dispose();
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.BLUE);

        // 1. Setup 2D Orthographic Camera
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h); // false = y-up (0,0 is bottom left)

        // Background Texture and Sprite Impl
        bckg = new Texture(Gdx.files.internal("distrinctrel_background.jpeg"));
        bckgSprite = new Sprite(bckg);

        // 2. Load 2D Assets (Ensure these exist in your assets folder)
        squirrelTexture = new Texture(Gdx.files.internal("mdl/sprites/Squirel_img.png"));
        nutTexture = new Texture(Gdx.files.internal("mdl/sprites/nuts.jpg"));

        // Grasshopper Loading Setup
        grasshopperTexture = new Texture(Gdx.files.internal("mdl/sprites/grasshopper_img.png"));

        squirrelSprite = new Sprite(squirrelTexture);
        nutSprite = new Sprite(nutTexture);
        grasshopperSprite = new Sprite(grasshopperTexture);

        // Scale sprites (to Both Sprites and Background)
        squirrelSprite.setSize(300, 300);
        nutSprite.setSize(85, 85);
        bckgSprite.setSize(2480, 1290);
        grasshopperSprite.setSize(128, 128);

        // Set initial positions
        grasshopperSprite.setPosition(400, 300);
        resetNut();
    }

    public float getdelta(float delta) { return delta; }
public final Vector2 tmppos=new Vector2();
    @Override
    public void render() {
        delta = Gdx.graphics.getDeltaTime();
        updateLogic(delta);
        handleGrasshopperInput(delta);

        // Clean background
        Gdx.gl.glClearColor(0, 1f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        // Draw Sprites
        bckgSprite.draw(batch);
        nutSprite.draw(batch);
        squirrelSprite.draw(batch);

        // Grasshopper Rendering Setup
        grasshopperSprite.draw(batch);

        // Draw UI
        font.draw(batch, "Score: " + score + " | Level: " + level, 80, Gdx.graphics.getHeight() - 40);
        font.draw(batch, "Grasshopper Pos's coordinates: (" + grasshopperGridPosition.x + "," + grasshopperGridPosition.y + ")", 80, Gdx.graphics.getHeight() - 80);
        if (finishLineVisible) font.draw(batch, "RUN TO THE RIGHT EDGE!", 500, Gdx.graphics.getHeight() / 4);
        batch.end();

        font.getData().setScale(2.0f);

        tmppos.set(squirrelSprite.getX(),squirrelSprite.getY());//Squirel's Vector Positioning on grid's Optimization
        tmppos.set(nutSprite.getX(),nutSprite.getY());//nutSprite's Vector Positioning on grid's Optimization
        tmppos.set(grasshopperSprite.getX(),grasshopperSprite.getY());//grasshopperSprite's Vector Positioning on grid's Optimization

    }

    /**
     * Maps user keyboard interface controls cleanly directly to your custom structural DIRECTIONS table array mappings
     */
    public void handleGrasshopperInput(float delta) {
        if (keyInputTimer > 0) {
            keyInputTimer -= delta;
            return;
        }

        GridPoint2 chosenDirection = null;

        // Map keyboard keys to specific elements inside your DIRECTIONS array matrix
        if (Gdx.input.isKeyPressed(Keys.Q)) {
            chosenDirection = DIRECTIONS[0]; // Top-Left (-1, 0)
        } else if (Gdx.input.isKeyPressed(Keys.A)) {
            chosenDirection = DIRECTIONS[1]; // Bottom-Left (0, -1)
        } else if (Gdx.input.isKeyPressed(Keys.E)) {
            chosenDirection = DIRECTIONS[2]; // Top-Right (+1, 0)
        } else if (Gdx.input.isKeyPressed(Keys.D)) {
            chosenDirection = DIRECTIONS[3]; // Bottom-Right (0, +1)
        } else if (Gdx.input.isKeyPressed(Keys.S)) {
            chosenDirection = DIRECTIONS[4]; // Bottom (-1, -1)
        } else if (Gdx.input.isKeyPressed(Keys.W)) {
            chosenDirection = DIRECTIONS[5]; // Top (1, 1)
        }

        if (chosenDirection != null) {
            // Update structural coordinates tracking state
            grasshopperGridPosition.add(chosenDirection);

            // Translate space visually based on selection to showcase direct input feedback response
            float visualStepMultiplier = 80f;
            grasshopperSprite.translate(chosenDirection.x * visualStepMultiplier, chosenDirection.y * visualStepMultiplier);

            // Set input delay timeout hook loop window reset
            keyInputTimer = KEY_DELAY;
        }
    }

    public void updateLogic(float delta) {
        // 2D Movement (X and Y instead of X and Z)
        if (Gdx.input.isKeyPressed(Keys.UP)) squirrelSprite.translateY(speed * delta);
        if (Gdx.input.isKeyPressed(Keys.DOWN)) squirrelSprite.translateY(-speed * delta);
        if (Gdx.input.isKeyPressed(Keys.LEFT)) squirrelSprite.translateX(-speed * delta);
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) squirrelSprite.translateX(speed * delta);

        // Simple Circle-based Collision using Centers
        Vector2 squirrelCenter = new Vector2(
            squirrelSprite.getX() + squirrelSprite.getWidth() / 2,
            squirrelSprite.getY() + squirrelSprite.getHeight() / 2
        );
        Vector2 nutCenter = new Vector2(
            nutSprite.getX() + nutSprite.getWidth() / 4,
            nutSprite.getY() + nutSprite.getHeight() / 4
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
        grasshopperTexture.dispose();
        bckg.dispose();
        font.dispose();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }

    @Override public void pause() {}
    @Override public void resume() {}
}
