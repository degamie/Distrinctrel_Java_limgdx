//WID(8/7/2026(Sarthak Mittal(VectorCache_Impl)
import androidx.xr.runtime.math.Vector2;


public class VectorCache{
    VectorCache(Vector2 v2pool){this.v2pool=v2pool;}//Param Constructor
    public void setindx(int indx){this.indx=indx;}
    public void setV2pool(Vector2 v2pool){this.v2pool=v2pool;}
    public Vector2 v2pool=new Vector2[4];
    public final static int indx=0;
public static Vector2 get(float x,float y){
    Vector2 v=new v2Pool[indx];
    v.set(x,y);
}
}
