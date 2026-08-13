//WID(13/8/2026(Sartthak Mittal(DegamieSign(AsyncWorkerManager))#Impl(Binidng Task)#1.1
package util;
import util.PathOutput;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AsyncWorkerManager {
     void setpathOutputQueue(ConcurrentLinkedQueue<PathOutput> pathOutputQueue ){
         this.pathOutputQueue=pathOutputQueue;
     }
    AsyncWorkerManager(PathOutPut task){
        this.tasK=task;
    }
void setObjectSet(ObjectSet objectSet){
         this.objectSet=objectSet;
}
    public ObjectSet objectSet;
    void setTask(PathOutput task){this.task=task;}

    void setpathOutput(ConcurrentLinkedQueue<PathOutput> pathOutputQueue){
        this.pathOutputQueue=pathOutputQueue;
    }
    private float[][] heightMap;
    private float chunkX;
    private float chunkY;
    private PathOutput outputPool;
    void setoutputPool(PathOutput outputPool){this.outputPool=outputPool;}

    // Final thread-safe queue for async path outputs
    private final ConcurrentLinkedQueue<PathOutput> pathOutputQueue = new ConcurrentLinkedQueue<>();

    // --- Getters and Setters ---

    public float[][] getHeightMap() {
        return heightMap;
    }

    public void setHeightMap(float[][] heightMap) {
        this.heightMap = heightMap;
    }

    public float getChunkX() {
        return chunkX;
    }

    public void setChunkX(float chunkX) {
        this.chunkX = chunkX;
    }

    public ConcurrentLinkedQueue<PathOutput> getPathOutputQueue() {
        return pathOutputQueue;
    }

    public PathOutput getOutputPool() {
        return outputPool;
    }

    public void setOutputPool(PathOutput outputPool) {
        this.outputPool = outputPool;
    }

    // --- Async / Processing Methods ---

    public void generateTerrainChunkAsync(float chunkX, float chunkY) {
        this.chunkX = chunkX;
        this.chunkY = chunkY;
        // TODO: Offload noise generation to a background task
        // this.heightMap = Math.generateNoise(chunkX, chunkY);
    }

    public PathOutput output() {
        return new PathOutput();
    }

    public void existsByWorkerManager(AsyncWorkerManager asyncWorkerManager) {
        if (asyncWorkerManager != null && asyncWorkerManager.output() != null) {
            // Logic for existing worker manager
        }
    }

    public void submitResult(int playerId, Array<Vector2> outputPath) {
        if (outputPool == null) return;

        synchronized (outputPool) {
            // Configure output pool object and offer to processing queue
            outputPool.playerId = playerId;
            outputPool.setPath(outputPath);
            pathOutputQueue.offer(outputPool);
        }
    }

    /**
     * Call this on the OpenGL / Main render thread to safely apply calculated data.
     */
    public void updateOutput() {
        while (!pathOutputQueue.isEmpty()) {
            PathOutput out = pathOutputQueue.poll();
            if (out != null) {
                DistinctEntity player = EntityManager.getPlayerById(out.playerId);
                if (player != null) {
                    player.applyPath(out);
                }

                // Recycle/free memory back to the pool
                if (outputPool != null) {
                    synchronized (outputPool) {
                        outputPool.free(out);
                    }
                }
            }
        }
    }

    /**
     * Drains pending queue tasks to offload the main thread.
     */
    public void updateMainThread() {
        while (!pathOutputQueue.isEmpty()) {
            PathOutput task = pathOutputQueue.poll();
            if (task != null) {
                // Process offloaded Voxel I/O task
            }
        }
    }
}
