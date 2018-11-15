
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
    public static int player;
    private boolean onGround = true;
    public static boolean alive = true;

    public Hero(int player) {
        super();
        this.player = player;
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
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
        drag = 0.8;
    }

    @Override
    public void act() {
        handleInput();

        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        removeOrNotRemove();
        if(inLevel == true){
            if(isTouching(Tile.class) == false){
                onGround = false;
            }
            else{
                onGround = true;
            }
        }
    }

    public void removeOrNotRemove(){
        /*for (Actor enemy : getIntersectingObjects(Enemy.class)) {
        if (enemy != null) {
        getWorld().removeObject(this);
        inLevel = false;
        return;
        }
        }*/
        for (Actor enemy : getIntersectingObjects(WaterTile.class)) {
            if(inLevel == true){
                if (enemy != null) {
                    getWorld().removeObject(this);
                    alive = false;
                    inLevel = false;
                    return;
                }
            }
        }
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space")) {
            if(onGround == true){
                velocityY = -15;
            }
        }

        if (Greenfoot.isKeyDown("left")) {
            velocityX = -4;
            switch(player){
                case 1: setImage("p1_walk_left.png");
                break;
                case 2: setImage("p2_walk_left.png");
                break;
                case 3: setImage("p3_walk_left.png");
                break;
            }
        } else if (Greenfoot.isKeyDown("right")) {
            velocityX = 4;
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
