import greenfoot.*;

public class Music
{
    static Hero hr = new Hero();
    static GreenfootSound bgMusic = new GreenfootSound("backgroundMusic1.mp3");
    static GreenfootSound titleMusic = new GreenfootSound("titleScreen.mp3");  
    static GreenfootSound jump = new GreenfootSound("jump.mp3");
    static GreenfootSound coin = new GreenfootSound("coin.mp3");
    static GreenfootSound newLife = new GreenfootSound("1up.mp3");
    static GreenfootSound gameOver = new GreenfootSound("gameOver.mp3");
    static GreenfootSound diamond = new GreenfootSound("diamond.mp3");
    static GreenfootSound key = new GreenfootSound("key.mp3");
    static GreenfootSound die = new GreenfootSound("die.mp3");
    static GreenfootSound lvlClr = new GreenfootSound("lvlClr.mp3");
    static GreenfootSound worldClear = new GreenfootSound("worldClear.mp3");
    
    public static void bgMusic(){
        if(hr.inLevel == true && bgMusic.isPlaying() == false){
            titleMusic.stop();
            bgMusic.playLoop();
            bgMusic.setVolume(60);
        }
        if(hr.alive == false || hr.inLevel == false){
            bgMusic.stop();
        }
    }
    public static void menuMusic(){
        if(lvlClr.isPlaying() == false && gameOver.isPlaying() == false && bgMusic.isPlaying() == false && worldClear.isPlaying() == false){
            titleMusic.playLoop();
        }
    }
}
