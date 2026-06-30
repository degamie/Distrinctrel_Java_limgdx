//WID(30/6/2026(Sartthak Mittal(DegamieSign(AsyncWorkerManager))#1
package util;
import util.PathOutput;
public class AsyncWorkerManager {
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
    }
}
