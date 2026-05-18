//WID(18/05/2026)(Sarthak Mittal)#1.1.1.1.1.1.1.1.1.1.1.1.1.1.1.1/1/1.1/1.11.1.1.1.1/1.1/.1
package com.libgdx.discintrel.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
//import com.google.android.gms.games.Player;
import com.badlogic.gdx.utils.viewport.Viewport;
//import com.libgdx.discintrel.Service.DescintrelService;

import static com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.getViewport;

public class Menu implements Screen {
    //public void updateBySkin(Skin skin){getskin(skin)+setSkin(skin)+1;}//Updating
    public void updateBySkin(Skin skin){
        if(skin!=0)getSkin(skin);
        else getSkin(0);
    }

    public Skin getSkin(Skin skin) {
        return skin;
    }

    public void setSkin(Skin skin) {this.skin=skin;}

    private Skin getskin(Skin skin) {return skin;}


    public void existsByplayBtn(TextButton playbtn){
        if(playbtn.isChecked())getPlaybtn(playbtn);
        else getPlaybtn(null);
    }
   // public void updaatebyPlayBtn(TextButton playbtn){getPlaybtn(playbtn)+setPlaybtn(playbtn)+1;}//Updating playBtn in App
    public void setPlaybtn(TextButton playbtn){this.playbtn=playbtn;}//binding playbtn in App
    public void existsByScreen (Screen screen){
        if(screen!=null)getScreen(screen);
        else getScreen(null);
    }
    //public void updateByScreen(Screen screen){getScreen(screen)+setScreen(screen)+1;}//Updating Screen in  App
    public void setScreen(Screen screen){this.screen=screen;}
    public Screen getScreen(Screen screen){return screen;}//Fetchign Screen in App
    public Screen screen;
    public void setscreen(Screen screen){this.screen=screen;}//binding Screen in App
//    public void setMenu(Menu menu){this.menu=menu;}//Binding
//    public void existsByViewPort(Viewport viewport){
//        if(viewport.project(stage)!=null)getVieport(viewport);
//        else getVieport(null);
//    }
    public void updateByViewPoet(Viewport viewport){
        getViewport(viewport)+setViewport(viewport)+1;
    }
    public void existsBySubMenu(Menu submenu){
        if(submenu!=null)getSubmenu(submenu);
        else getSubmenu(null);
    }
//    public void updateByMenu(Menu submenu){
//        getMenu(submenu)+setSubmenu(submenu)+1;
//    }
    public  Menu getSubmenu(Menu submenu){return submenu;}//Fetching SubMenu In App
    public void setSubmenu(Menu submenu){this.submenu=submenu;}//binding SubMenu in App
    public Viewport getVieport(Viewport viewport){return viewport;}//Fethcing ViewPort in App
    public void setViewport(Viewport viewport){this.viewport=viewport;}
    public Viewport viewport;
    Menu mainMenu;
   public TextButton getPlaybtn(TextButton playbtn){return playbtn;}//Fethcing PlayBtn in App
    public TextButton playbtn=    new TextButton("PLAY!",skin);
    public void setplaybtn(TextButton playbtn){this.playbtn=playbtn;}//binding playBtn in App
    public DescintrelService service;
    public void updateByStage(Stage stage){
        getStage(stage)+setStage(stage);
    }

    public Stage getStage(Stage stage) {
        return stage;
    }

    public Stage stage=null;
    public void setStage(Stage stage){this.stage=stage;}//binding stage in App
public Skin skin;
public Menu(Stage stage) {
    this.service=service;
    stage=new Stage(new ScreenViewport());
    stage=new Stage(new ScreenViewport());
    // Layout the UI
    Table table=new Table();

    TextButton exitbtn=new TextButton("EXIT!",skin);
    table.add(playbtn).fillX().uniformX().pad(10);
    table.row();
    table.add(exitbtn).fillX().uniformX().pad(10);
    playbtn.addListener(new ChangeListener() {
        public void changed(ChangeListener.ChangeEvent event, Actor actor) {
            Gdx.app.exit();
        }
    });
}
    // public void updateByMainMenu(Menu mainMenu){getMainMenu(mainMenu)+setMainMenu(mainMenu)+1;}
    public Menu getMainMenu(Menu mainMenu){return  mainMenu;}//Fetching MainMenu in APp
//    public void setMainMenu(Menu mainMenu){this.MainMenu=MainMenu;}
    public Menu MainMenu;
    public Menu submenu;
    public Menu getMenu(Menu menu){return menu;}
    public Menu menu;
    public void setMenu(Menu menu){this.menu=menu;}

    @Override
    public void show() {
        stage=new Stage(new ScreenViewport());
    }

    @Override
    public void render(float delta) {
         delta=Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0,0,.2f,1);
        Player player=new Player();
        player.update(delta);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
//    public   Menu fileMenu=new Menu("fileMenu");
//    fileMenu.getItems().addAll(openItem, saveItem);
//    public void Start(Stage stage){
//        MenuItem strtitem=new MenuItem("Distrinctrel");
//        MenuItem exitMenuitem=new MenuItem("Exit");
//        exitMenuitem.setActionCommand(e-> exit(0));
//        MenuBar menuBar=new MenuBar();
//        menuBar.getMenu().add(fileMenu);
//        BorderPane root=new BorderPane();
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Districntrel Game");
//        primaryStage.show();
//
