//WID(27/7/2026)(Sarthak Mittal(NetworkSystem (cls)))#1
public class NetworkSystem {
    public Packet packet;
    public void onDataRecieved(Packet packet){
        incomingPackets.offer(packet);
    }
    @Override
    public void render(){
        while ((packet = incomingPackets.poll()) != null) {
            packet.process();
        }
    }

}//TBI
