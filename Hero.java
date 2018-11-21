

import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {
    public static boolean inLevel = false;
    private final double gravity;
    private final double acc;
    private final double drag;
    private static int cntr = 0;
    private static int heroX;
    public static int player;
    private boolean onGround = true;
    public static boolean alive = true;
    public static boolean hasKey = false;
    public static boolean hasDiamond = false;
    public static boolean isTouchingDoor = false;
    public static int diamonds = 0;
    public static int coins = 0;

    public Hero(int player) {
        super();
        cntr = 0;
        this.player = player;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        onGround = false;
        onGround = true;
        switch(player){

            case 1: setImage("p1_front.png");
            break;
            case 2: setImage("p2_front.png");
            break;
            case 3: setImage("p3_front.png");
            break;

        }
    }

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.9;
    }

    @Override
    public void act() {
        if(Greenfoot.isKeyDown("l")){
            System.out.println(cntr + ":" + getX() + ", " + getY());
            Greenfoot.delay(10);
            cntr ++;
        }
        handleInput();
        touching();
        touchingDoor();
        platformCollision();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        removeOrNotRemove();
    }
    
    public void touchingDoor(){
        for (Actor door : getIntersectingObjects(DoorTile.class)) {
            if (door != null) {
                isTouchingDoor = true;
                heroX = getX();
                velocityX = 0;
                setLocation((heroX - 50), getY());
                return;
            }
        }
    }

    public void touching(){
        if(isTouching(Key.class)){
            removeTouching(Key.class);
            hasKey = true;
        }
        if(isTouching(GoldCoin.class)){
            removeTouching(GoldCoin.class);
            coins += 2;
        }
        if(isTouching(SilverCoin.class)){
            removeTouching(SilverCoin.class);
            coins ++;
        }
        if(isTouching(Diamond.class)){
            removeTouching(Diamond.class);
            diamonds ++;
        }
    }
    
    public void removeOrNotRemove(){
        for (Actor enemy : getIntersectingObjects(WaterTile.class)) {
            if(inLevel == true){
                if (enemy != null) {
                    getWorld().removeObject(this);
                    alive = false;
                    return;
                }
            }
        }
        if(inLevel == true){
            if(isTouching(Fireball.class)){
                getWorld().removeObject(this);
                alive = false;
                return;
            }
        }
        if(inLevel == true){
            if(isTouching(Enemy.class)){
                getWorld().removeObject(this);
                alive = false;
                return;
            }
        }
    }
    
    public void platformCollision(){
        if(isTouching(Platform.class)){
            setLocation(getX(), getY() - 11);
            onGround = true;
        }
    }
    
    public void handleInput() {
        if (Greenfoot.isKeyDown("space")) {
            if(onGround == true){
                velocityY = -13;
            }
        }

        /*if(inLevel == true){
            if(isTouching(Tile.class) == false){
                onGround = false;
            }
            else{
                onGround = true;
            }
        }*/

        if (Greenfoot.isKeyDown("left")) {
            velocityX = -6;
            switch(player){
                case 1: setImage("p1_walk_left.png");
                break;
                case 2: setImage("p2_walk_left.png");
                break;
                case 3: setImage("p3_walk_left.png");
                break;
            }
        } else if (Greenfoot.isKeyDown("right")) {
            velocityX = 6;
            switch(player){
                case 1: setImage("p1_walk_right.png");
                break;
                case 2: setImage("p2_walk_right.png");
                break;
                case 3: setImage("p3_walk_right.png");
                break;
            }
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

}
