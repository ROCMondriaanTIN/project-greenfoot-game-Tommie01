
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlatformY extends Mover
{   
    private int walkRange;
    private int yMin;
    private int yMax;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;
    private int getal;

    public PlatformY(int walkrange){
        setImage("platform2.png");
        this.walkRange = walkrange; //default 250
        this.getal = getal;
        firstAct = true;
        speed = -1;
    }

    public void act() 
    {
        Movement();
    }    

    public void Movement(){
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
