
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
    public static boolean alive = true;
    public static boolean hasKey = false;
    public static boolean hasDiamond = false;
    public static boolean isTouchingDoor = false;
    private static boolean onGround = false;
    public static int diamonds = 0;
    public static int coins = 0;
    private static int scaleDecrease = 1;

    public Hero(int player) {
        super();
        cntr = 0;
        this.player = player;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        switch(player){

            case 1: setImage("p1_front.png");
            break;
            case 2: setImage("p2_front.png");
            getImage().scale(getWidth() - scaleDecrease, getHeight() - scaleDecrease);
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
        if (isTouching(DoorTile.class)) {
            isTouchingDoor = true;
            heroX = getX();
            velocityX = 0;
            setLocation((heroX - 50), getY());
            return;
        }
    }

    public void touching(){
        if(isTouching(Key.class)){
            removeTouching(Key.class);
            hasKey = true;
            Music.key.play();
        }
        if(isTouching(GoldCoin.class)){
            removeTouching(GoldCoin.class);
            if(coins != 39){
                Music.coin.play();
            }
            if(coins == 39){
                Music.newLife.play();
                coins = 1;
            }
            else{
                coins += 2;
            }
        }
        if(isTouching(SilverCoin.class)){
            removeTouching(SilverCoin.class);
            if(coins != 39){
                Music.coin.play();
            }
            coins ++;
        }
        if(isTouching(Diamond.class)){
            removeTouching(Diamond.class);
            diamonds ++;
            Music.diamond.play();
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
        else{
            onGround = false;
        }
    }

    public boolean onGround(){
        if(onGround == true){
            return true;
        }
        if(isTouching(Tile.class) == false ){
            return false;
        }
        return true;
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space")) {
            if(onGround() == true){
                Music.jump.play();
                velocityY = -15;
            }
        }
        if (Greenfoot.isKeyDown("left")) {
            velocityX = -6;
            switch(player){
                case 1: setImage("p1_walk_left.png");
                break;
                case 2: setImage("p2_walk_left.png");
                getImage().scale(getWidth() - scaleDecrease, getHeight() - scaleDecrease);
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
                getImage().scale(getWidth() - scaleDecrease, getHeight() - scaleDecrease);
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
