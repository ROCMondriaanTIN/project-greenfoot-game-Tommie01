import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HeroPicker extends Actor
{
    private static int player;
    
    public HeroPicker(int player){
        this.player = player;
        switch(player){

            case 1: setImage("p1_front.png");
            break;
            case 2: setImage("p2_front.png");
            break;
            case 3: setImage("p3_front.png");
            break;

        }
    }  
}
