import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldCoin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldCoin extends Mover
{
    public GoldCoin(){
        setImage("coinGold.png");
    }
    public void act() 
    {
        applyVelocity();
    }    
}
