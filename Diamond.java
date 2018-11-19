import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diamond here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamond extends Mover
{
    public Diamond(){
        setImage("gemBlue.png");
    }
    public void act() 
    {
        applyVelocity();
    }    
}
