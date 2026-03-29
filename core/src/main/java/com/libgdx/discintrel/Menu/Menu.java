//WID(27/3/2026)(Sarthak Mittal)#1.1.1.1.1.1.1.1.1.1
package com.libgdx.discintrel.Menu;
public class Menu {
   // public void updateByMainMenu(Menu mainMenu){getMainMenu(mainMenu)+setMainMenu(mainMenu)+1;}
    public Menu getMainMenu(Menu mainMenu){return  mainMenu;}//Fetching MainMenu in APp
    public void setMainMenu(Menu mainMenu){this.MainMenu=MainMenu;}
    public Menu MainMenu;
    public Menu submenu;
    public Menu getMenu(Menu menu){return menu;}
    public Menu menu;
    public void setMenu(Menu menu){this.menu=menu;}
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
