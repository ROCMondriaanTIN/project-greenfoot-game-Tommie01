
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Platform extends Mover
{   
    private int walkRange;
    private int yMin;
    private int yMax;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;
    private int getal;

    public Platform(int walkrange, int getal){
        setImage("platform2.png");
        this.walkRange = walkrange; //default 250
        this.getal = getal;
        firstAct = true;
        speed = 1;
    }
    
    public void act() 
    {
        Movement();
    }    
    
    public void Movement(){
        int x = getX();
        int y = getY();
        
        if(getal == 1){
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
        else if(getal == 0){
            if (firstAct) {
                firstAct = false;
                xMin = x - walkRange / 2;
                xMax = x + walkRange / 2;
            }
            
            velocityX = speed;
            applyVelocity();
            if (getX() <= xMin) {
                speed *= -1;
                x = xMax;
            } else if (getX() >= xMax) {
                speed *= -1;
                x = xMin;
            }
        }
    }
}
