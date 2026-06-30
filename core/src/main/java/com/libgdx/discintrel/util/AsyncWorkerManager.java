//WID(30/6/2026(Sartthak Mittal(DegamieSign(AsyncWorkerManager))
package util;
import util.PathOutput;
public class AsyncWorkerManager{
    public final ConcurrentLinkedQueue<PathOutput> clq=new AsyncWorkerManager();
    @Override
    public PathOutput output(){
        return new PathOutput();
    }
}
