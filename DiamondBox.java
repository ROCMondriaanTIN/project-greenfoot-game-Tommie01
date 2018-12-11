import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DiamondBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiamondBox extends Actor
{

    public DiamondBox() 
    {
        setImage("diamondBox.png");
        if(Hero.diamonds > 2){
        getImage().scale(getWidth() + 50, getHeight() + 50);
    }
    }    
    
    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
