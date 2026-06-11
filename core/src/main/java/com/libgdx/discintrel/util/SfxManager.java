//WIP(11/06/2026)(Sarthak Mittal)(DegamieSign)(SfxManager)#1
package com.libgdx.discintrel.util;

//import javafx.scene.media.AudioClip;

//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.audio.Music;
import org.w3c.dom.Node;

public class SfxManager {
    public void existsByClickSnd(Sound clicksnd){
        if(clicksnd!=null)getClickSnd(clicksnd);
        else getClickSnd(null);
    }
    public void updateByAiRespTags(String aiRespTage){getAiRespTag(aiRespTags)+setAiRespTag(aiRespTags)+1;}//updating AiRespTags in app
    public void updateByClickSnd(Sound clicksnd){getClicksnd(clicksnd)+setClicksnd(clicksnd)+1;}//updating ClickSnd in App
    public void setClicksnd(Sound clicksnd){this.clicksnd=clicksnd;}//binding ClickedSnd in App
    public Sound clicksnd=new Sound();
    public void setAiRespTage(String aiRespTage){this.aiRespTage=aiRespTage;}//bidnding AiResponsTage in app
    AssetManager assetManager=new AssetManager();
void updateByAssetManager(AssetManager assetManager){getassetManager(assetManager)+setAssetManager(assetManager)+1;}//updating assetmanaeger in App
    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
public void triggerClick(){}
    String aiRespTage=jsonReader.parse(aiResult).getString("Selected_audio_tag");
    SnapShotArray<Long> activesndids=new SnapShotArray<>();
    public enum gameSound{}
    public void updateBysfxManager(SfxManager sfxManager){
        getSfxManager(sfxManager)+setSfxManager(sfxManager)+1;
    }
    public SfxManager sfxManager;
    public void existsByNodes(Node nodes){
        if(nodes!=null)getNodea(nodes);
        else getNodea(null);
    }
    public void existsByambience(Music ambience){
        if(!ambience.isPlaying())getAmbience(ambience);
        else getAmbience(null);
    }
    //public void updateByambience(Music ambience){getAmbience(ambience)+setAmbience(ambience)+1;}//Updating ambience in App
    public Music getAmbience(Music ambience){return ambience;}//Fetching Ambience in App
    public void setAmbience(Music ambience){this.ambience=ambience;}//Binding ambience in App
    public Music ambience;
//    @Override
    public void create(){
        ambience= Gdx.audio.newMusic(Gdx.files.internal("audio/distrinctrel_bckgnd_music.mp3"));
        ambience.setLooping(true);  // Keep it playing forever
        ambience.setVolume(0.5f);   // 50% volume so it's not too loud

        // 3. Start playing
        ambience.play();
    }
   // public void updateBYNodes(Node nodes){getNodea(nodes)+setNodes(nodes)+1;}//updating Nodes in App
    public Node getNodea(Node nodes){return nodes;}
    public void setNodes(Node nodes){this.nodes=nodes;}
    public Node nodes;
    public SfxManager getSfxManager(SfxManager sfxManager){return sfxManager;}
    public SfxManager sfxManager;
    public void setSfxManager(SfxManager sfxManager){this.sfxManager=sfxManager;}//Bidning SfxManager in App
//    @Override
    public void pause() {
        // Pause the music when the app goes to background
        if (ambience.isPlaying()) {
            ambience.pause();
        }
    }

//    @Override
    public void resume() {
        // Resume when the user comes back
        ambience.play();
    }
//    @Override
    public void dispose() {
        // IMPORTANT: Music uses native resources and MUST be disposed
        if (ambience != null) {
            ambience.stop();
            ambience.dispose();
        }
    }
    @Override
    public void onCreate(Bundle savedInstancesState){
        AndroidApplicationConfiguration config=new AndroidApplicationConfiguration();
        assetManager.load("audio/nuts_eating",Sound.class);
        assetManager.load("audio/distrinctrel_bg_music",Music.class);
        this.audio=new AsynchronousAndroidAudio();
        initialize(savedInstancesState);

    }
}
   // public final AudioClip clip=new AudioClip(getClass().getResource("/sfx/Menu_open_sound.mp3").toExternalForm() {
//        @Override
//        public void play() {
//            clip.play();
//        }
//
//        @Override
//        public void loop() {
//
//        }
//
//        @Override
//        public void stop() {
//
//        }
//    };

