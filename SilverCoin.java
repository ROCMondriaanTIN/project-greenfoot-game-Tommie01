import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SilverCoin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SilverCoin extends Mover
{
    public SilverCoin(){
        setImage("coinSilver.png");
    }
    public void act() 
    {
        applyVelocity();
    }    
}
