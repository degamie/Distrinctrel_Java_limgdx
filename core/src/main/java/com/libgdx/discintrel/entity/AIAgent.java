//Perceptron(AI(Agent)) entity Declare (28/03/2026)(GD)(Sarthak Mittal)#1.1.1,.1.1.1,1.1
package com.libgdx.discintrel.entity;

import com.libgdx.discintrel.Service.DescintrelService;

public class AIAgent {
    AIAgent aiAgent;
    public DescintrelService service;
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


