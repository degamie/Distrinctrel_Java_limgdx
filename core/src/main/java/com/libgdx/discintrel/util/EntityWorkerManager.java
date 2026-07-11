//WID(11/7/2026)(Sarthak Mittal(DegamieSign(EntityWorkerManeger))
import com.badlogic.gdx.utils.Bits;
public class EntityWorkerManager{
    public static  final int POSITION_COMP=0;
    public final Bits componentBits=new Bits();
    public void isRednerable(){
        return new componentMask.get(RENDER_COMP) && componentBits.get(POSITION_COMP);
    }
}
