//WID(02/7/2026(Sarthak Mittal(DegamieSign(GameScene(optimization))#1
package util;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.badlogic.gdx.math.Vector2;
public class PathOutput extends Poolable{
    public PathOutput output;
    public void setWaypts(Array<Vector2>waypts){this.waypts=waypts;}//binding Waypts in GameApp
    public void setPlayerId() {
         this.playerId=playerId;
    }

    //TDO(Transfer Data OBject)
    public final int playerId;
    public final Array<Vector2> waypts=new Array<>();


}
