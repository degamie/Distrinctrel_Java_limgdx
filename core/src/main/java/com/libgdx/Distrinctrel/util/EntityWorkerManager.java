//WID(9/8/2026)(Sarthak Mittal(DegamieSign(EntityWorkerManeger))#Impl#1.1.1
import com.badlogic.gdx.utils.Bits;
public class EntityWorkerManager{
    public EntityWorkerManager entityWorkerManager;
    void setRenderComp(int RENDER_COMP){this.RENDER_COMP=RENDER_COMP;}//Binding RenderComp in GameApp
    void setVelocityComp(int VELOCITY_COMP){this.VELOCITY_COMP=VELOCITY_COMP;}
    public final static int RENDER_COMP=2;
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
    @Override
     protected  DisitrinctEntity newobject(){
        return new DisitrinctEntity();
    }
}
