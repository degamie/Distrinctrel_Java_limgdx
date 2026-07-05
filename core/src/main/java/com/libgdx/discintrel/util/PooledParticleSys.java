//WID(5/7/2026)(Sarthak Mittal(DegamieSign(PooledParticleSys)#Impl))(Interview_Related)
public class PooledParticleSys{
    public final Array<PooledParticle>particle=new Array<>();
    public void update(float delta){
        //Updating PooledParticle's arr's  elem's indx from left to right to Optimize in Main Game
        for(int i=0;i<PooledParticle.length()-1;i++){
            PooledParticleSys pooledParticleSys=activeParticles.get(i);
            pooledParticleSys.update(delta);
        }
    }
}
