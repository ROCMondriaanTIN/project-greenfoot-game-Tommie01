import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeroPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeroPicker extends Actor
{
    /**
     * Act - do whatever the HeroPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int player;
    
    public HeroPicker(int player){
        this.player = player;
        switch(player){

            case 1: setImage("p1_front.png");
            break;
            case 2: setImage("p2_front.png");
            break;
            case 3: setImage("p3_front.png");
            break;

        }
    }
    
    public void act() 
    {
    }    
}
