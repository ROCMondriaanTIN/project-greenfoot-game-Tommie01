import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hudLife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUDLives extends Actor
{
    Hero hr = new Hero();

    public HUDLives(){
        switch(hr.player){

            case 1: setImage("hud_p1.png");
            break;
            case 2: setImage("hud_p2.png");
            break;
            case 3: setImage("hud_p3.png");
            break;

        }   
    }

    private void hudUpdate(){
        switch(hr.player){

            case 1: setImage("hud_p1.png");
            break;
            case 2: setImage("hud_p2.png");
            break;
            case 3: setImage("hud_p3.png");
            break;

        }   
    }

    public void act() 
    {
        hudUpdate();
    }    
}
