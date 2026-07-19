//WID(19/7/2026(Sarthak Mittal(DegamieSign(GameScene(optimization))#Impl#1.1.1
package util;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
public class PathOutput extends Poolable{
    @Override
    public void reset(){
        playerId-=1;
        waypts.clear();

    }
    public void init(float x,float y,float Velx,float VelY){}
    public void setPathOutput(PathOutput pathOutput){this.pathOutput=pathOutput;}
    public void requestpath(int playerId,Vector2 start,Vector2 end){
        PathCalculatedTask  task;
    }
    public PathOutput pathOutput;
    public String getPlayerId(String playerId){return playerId;}//Fetching PlayerId in GameApp
    void setOutput(PathOutput output){this.output=output;}
    public PathOutput output;
    public void setWaypts(Array<Vector2>waypts){this.waypts=waypts;}//binding Waypts in GameApp
    public void setPlayerId() {
         this.playerId=playerId;
    }

    //TDO(Transfer Data OBject)
    public final int playerId;
    public final Array<Vector2> waypts=new Array<>();


}
