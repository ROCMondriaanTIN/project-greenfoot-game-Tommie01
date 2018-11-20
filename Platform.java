import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Platform extends Mover
{
    public Platform(){
        setImage("grassPlatform.png");
    }
    public void act() 
    {
        applyVelocity();
    }    
}
