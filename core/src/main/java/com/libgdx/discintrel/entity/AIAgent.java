//Perceptron(AI(Agent)) entity Declare (31/03/2026)(GD)(Sarthak Mittal)#1.1.1,.1.1.1,1.1.1.1.1.1.1.1.1
package com.libgdx.discintrel.entity;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.libgdx.discintrel.Service.DescintrelService;
import org.w3c.dom.Text;

public class AIAgent extends DisitrinctEntity{
    public String aiId;
    public Text statsDisplay(Text statsDisplay){return statsDisplay;}
    public int getHeight(int height){return height;}
    public int getWidth(int width){return width;}//Fethcing Width in App
    public DescintrelService service;
    int width;int height;
//    service.resize(width,height);
    AIAgent aiAgent;
    public int getlevel(int level){return level;}//Fetching level in App
    public  void setstatsDisplay( Text statsDisplay){this.statsDisplay=statsDisplay;}

    public AIAgent(Group nut, Rectangle finishLine, Text statsDisplay, Group nest, Group squirel, Group stem, Group leafModel, DisitrinctEntity disitrinctEntity, DisitrinctEntity e, int score, double speed, int level) {
        super(nut, finishLine, statsDisplay, nest, squirel, stem, leafModel, disitrinctEntity, e, score, speed, level);
    }

    public void setAiAgent(AIAgent aiAgent){this.aiAgent=aiAgent;}//binding AiAgent in App
    public AIAgent getaiAgent(AIAgent aiAgent){return aiAgent;}//Fetching AiAgent in App
    public void setainame(String ainame){this.ainame=ainame;}
    public void setAiperceptron(String aiperceptron){this.aiperceptron=aiperceptron;}
    public String aiperceptron;
    public String ainame;
    public String getAiperceptron() {
        return aiperceptron;
    }


//    public Chat aichatbot;
    public String getAiname() {
        return ainame;
    }

    public void setAiname(String ainame) {
        this.ainame = ainame;
    }
}
//    public Chat getAichatbot() {
//        return aichatbot;
//    }

    //public void setAichatbot(Chat aichatbot) {
//        this.aichatbot = aichatbot;
//    }


