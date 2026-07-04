//WID(4/7/2026(Sartthak Mittal(DegamieSign(AsyncWorkerManager))#1.1.1
package util;
import java.util.concurrent.ConcurrentLinkedQueue;

import util.PathOutput;
public class AsyncWorkerManager {
    public voif setclq(ConcurrentLinkedQueue<PathOutput> clq){this.clq=clq;}//bInidng CLQ in GameApp
    public void setputput(){this.PathOutput=PathOutput;}
    ConcurrentLinkedQueue getConcurrentLinkedQueue(ConcurrentLinkedQueue concurrentLinkedQueue){return concurrentLinkedQueue;}//Fetching concurrentLinkedQueue in GameApp
    public final ConcurrentLinkedQueue<PathOutput> clq=new ConcurrentLinkedQueue();
    @Override
    public PathOutput output(){
        return new PathOutput();
    }
    public void submitResult(int playerId,Array<Vector2> outputPath){
        PathOutput outpool;
        synchronized (outpool){
            outputPath=outpool.obtain();
        }
        outpool.playerId=playerId;
        output.addAll(calcultatedpath);
    }
    public void updateOutput(){
        while(!outputQueue.isEmpty()){
            PathOutput out=new clq.isEmpty();
            PathOutput outputs=PatPathOutput.poll();
            if(out!=null){}//TBI
        }
    }

}
