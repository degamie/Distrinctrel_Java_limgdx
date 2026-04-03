//WID(03/04/2026)(Sarthak Mittal)#1.1.1.1.1.1.1.1.1.1.1.1.1
package com.libgdx.discintrel.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.libgdx.discintrel.Service.DescintrelService;

public class Menu implements Screen {
    public DescintrelService service;
    public final Stage stage=null;
public Skin skin;
public Menu(Stage stage) {
    this.service=service;
    stage=new Stage(new ScreenViewport());
    stage=new Stage(new ScreenViewport());
    // Layout the UI
    Table table=new Table();
    TextButton playbtn=new TextButton("PLAY!",skin);
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
    public void setMainMenu(Menu mainMenu){this.MainMenu=MainMenu;}
    public Menu MainMenu;
    public Menu submenu;
    public Menu getMenu(Menu menu){return menu;}
    public Menu menu;
    public void setMenu(Menu menu){this.menu=menu;}

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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
