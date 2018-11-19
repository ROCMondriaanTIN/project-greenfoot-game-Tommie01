import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Fireball extends Mover
{
    private static int rotation = 0;
    
    public void act() 
    {
        applyVelocity();
        rotation();
    }  
    public Fireball(){
        setImage("fireball.png");
    }
    public void rotation(){
        if(rotation == 380){
           rotation = 0;
        }
        setRotation(rotation);
        rotation += 10;
    }
}
