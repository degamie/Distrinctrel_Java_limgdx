//WID(9/7/2026)(Sarthak Mittal(DegamieSign(PooledParticleSys)#Impl))(Interview_Related) /
public class PooledParticleSys{
    GLProfiler glProfiler=new GLProfiler(GDX.graphics);//Monitors GPU-Bottlenecks(low fps-rate)
    public void spawn(float x,float y) {
        PooledParticleSys pps=new PooledParticleSys().obtain();
        pps.init(x,y);
    }

    public void init(float x,float y){
        this.position.set(x,y);
    }
    public void setParticle(Array<PooledParticleSys>particle){this.particle=particle;}//binidng particle in GameAoo
    public final Array<PooledParticle>particle=new Array<>();
    public void update(float delta){
        //Updating PooledParticle's arr's  elem's indx from left to right to Optimize in Main Game
        for(int i=0;i<PooledParticle.length()-1;i++){
            PooledParticleSys pooledParticleSys=activeParticles.get(i);
            pooledParticleSys.update(delta);
        }
    }
}
