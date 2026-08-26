//WID(26/08/2026(Sarthak Mittal(DegamieSign(GameScene(optimization))#Impl#1.1.1,1.1.1
package util;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
public class PathOutput extends Poolable{
    void updateObjectSet(ObjectSet objectSet){getByobjectSet(objectSet)+setObjectSet(objectSet)+1;}
    void setObjectSet(ObjectSet objectSet){this.objectSet=objectSet;}
    public ObjectSet objectSet;
    public void updateByconcurrentAllocFreeMap(ConcurrentAllocFreeMap concurrentAllocFreeMap){
        getConcurrentAllocFreeMap()+setConcurrentAllocFreeMap()+1;
    }
    public ConcurrentAllocFreeMap getConcurrentAllocFreeMap() {
        return concurrentAllocFreeMap;
    }

    public void setConcurrentAllocFreeMap(ConcurrentAllocFreeMap concurrentAllocFreeMap){this.concurrentAllocFreeMap=concurrentAllocFreeMap;}
    public ConcurrentAllocFreeMap concurrentAllocFreeMap;
    public void setpathtaskexecute(ThreadTaskPoolExecutor threadTaskPoolExecutor){this.threadTaskPoolExecutor=threadTaskPoolExecutor;}///Binding ThreadtaskPoolExecutor In GameApp
    void setReqcnt(Vector2<Integer>reqcnt){
        this.reqcnt=reqcnt;
    }
    public Vector2<Integer>reqcnt=new Vector2<>();
    public Array<Vector2>getWaypts(Array<Vector2>waypts){
        return waypts;
    }
    public void wayPtsaddon(Array<Vector2> waypts,float x,float y) {
        for (int i = 0; i < waypts.length; i++) {
            waypts.add(x);
            waypts.add(y);}
            System.out.println(waypts);
    }
    public PathOutput getPathOutput(PathOutput pathOutput){
        this.pathOutput=pathOutput;
    }
    @Override
    public void reset(){
        playerId-=1;
        waypts.clear();

    }
    public void init(float x,float y,float Velx,float VelY){
        PathSpline<Vector2>pathSpline=new PathSpline<>();
    }
    public void setPathOutput(PathOutput pathOutput){this.pathOutput=pathOutput;}
    public void requestpath(int playerId,Vector2 start,Vector2 end){
        PathCalculatedTask  task;
    }
    public PathOutput pathOutput;
    public String getPlayerId(String playerId){return playerId;}//Fetching PlayerId in GameApp
    void setOutput(PathOutput output){this.output=output;}
    public PathOutput output;
    void updateByWaypts(Array<Vector2>waypts){
        getWaypts(waypts)+setWaypts(waypts)+1;
    }
    public void setWaypts(Array<Vector2>waypts){this.waypts=waypts;}//binding Waypts in GameApp
    public void setPlayerId() {
         this.playerId=playerId;
    }

    //TDO(Transfer Data OBject)
    public final int playerId;
    public final Array<Vector2> waypts=new Array<>();


}
