//WID(26/7/2026)(Sarthak Mittal(DegamieSign(EntityWorkerManeger))#Impl#1
import com.badlogic.gdx.utils.Bits;
public class EntityWorkerManager{
    private final static int VELOCITY_COMP=1;
    public void setPOSITION_COMP(String POSITION_COMP){this.POSITION_COMP=POSITION_COMP;}//binding Position Compoennt in  GameApp
    public static  final int POSITION_COMP=0;
    public final Bits componentBits=new Bits();
    public void addComponent(int compId){
        componentBits.set(compId);
    }
    public void isRednerable(){
        return new componentMask.get(RENDER_COMP) && componentBits.get(POSITION_COMP);
    }
}
