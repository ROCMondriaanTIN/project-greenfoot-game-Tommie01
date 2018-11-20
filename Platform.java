import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Platform extends Mover
{   
    private int walkRange;
    private int yMin;
    private int yMax;
    private boolean firstAct;
    private int speed;

    public Platform(){
        setImage("grassPlatform.png");
        walkRange = 250;
        firstAct = true;
        speed = 1;
    }

    public void act() 
    {
        int x = getX();
        int y = getY();
        
        if (firstAct) {
            firstAct = false;
            yMin = y - walkRange / 2;
            yMax = y + walkRange / 2;
        }
        velocityY = speed;
        applyVelocity();
        if (getY() >= yMax) {
            speed *= -1;
            y = yMax;
        } else if (getY() <= yMin) {
            speed *= -1;
            y = yMin;
        }
    }    
}
