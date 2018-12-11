import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Text extends Actor
{
    public Text(String text){
        setImage(new GreenfootImage(text, 30, Color.BLUE, new Color(0, 0, 0, 0)));
    }
    public Text(String text, Color kleurText){
        setImage(new GreenfootImage(text, 30, kleurText, new Color(0, 0, 0, 100)));
    }
}
