
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
    private static int scaleDecrease = 2;
    private GreenfootImage run1 = new GreenfootImage("p1_walk01L.png");
    private GreenfootImage run2 = new GreenfootImage("p1_walk02L.png");
    private GreenfootImage run3 = new GreenfootImage("p1_walk03L.png");
    private GreenfootImage run4 = new GreenfootImage("p1_walk04L.png");
    private GreenfootImage run5 = new GreenfootImage("p1_walk05L.png");
    private GreenfootImage run6 = new GreenfootImage("p1_walk06L.png");
    private GreenfootImage run7 = new GreenfootImage("p1_walk07L.png");
    private GreenfootImage run8 = new GreenfootImage("p1_walk08L.png");
    private GreenfootImage run9 = new GreenfootImage("p1_walk09L.png");
    private GreenfootImage run10 = new GreenfootImage("p1_walk10L.png");
    private GreenfootImage run11 = new GreenfootImage("p1_walk11L.png");
    private GreenfootImage run12 = new GreenfootImage("p1_walk01.png");
    private GreenfootImage run13 = new GreenfootImage("p1_walk02.png");
    private GreenfootImage run14 = new GreenfootImage("p1_walk03.png");
    private GreenfootImage run15 = new GreenfootImage("p1_walk04.png");
    private GreenfootImage run16 = new GreenfootImage("p1_walk05.png");
    private GreenfootImage run17 = new GreenfootImage("p1_walk06.png");
    private GreenfootImage run18 = new GreenfootImage("p1_walk07.png");
    private GreenfootImage run19 = new GreenfootImage("p1_walk08.png");
    private GreenfootImage run20 = new GreenfootImage("p1_walk09.png");
    private GreenfootImage run21 = new GreenfootImage("p1_walk10.png");
    private GreenfootImage run22 = new GreenfootImage("p1_walk11.png");
    private GreenfootImage p2Run1 = new GreenfootImage("p2_walk01L.png");
    private GreenfootImage p2Run2 = new GreenfootImage("p2_walk02L.png");
    private GreenfootImage p2Run3 = new GreenfootImage("p2_walk03L.png");
    private GreenfootImage p2Run4 = new GreenfootImage("p2_walk04L.png");
    private GreenfootImage p2Run5 = new GreenfootImage("p2_walk05L.png");
    private GreenfootImage p2Run6 = new GreenfootImage("p2_walk06L.png");
    private GreenfootImage p2Run7 = new GreenfootImage("p2_walk07L.png");
    private GreenfootImage p2Run8 = new GreenfootImage("p2_walk08L.png");
    private GreenfootImage p2Run9 = new GreenfootImage("p2_walk09L.png");
    private GreenfootImage p2Run10 = new GreenfootImage("p2_walk10L.png");
    private GreenfootImage p2Run11 = new GreenfootImage("p2_walk11L.png");
    private GreenfootImage p2Run12 = new GreenfootImage("p2_walk01.png");
    private GreenfootImage p2Run13 = new GreenfootImage("p2_walk02.png");
    private GreenfootImage p2Run14 = new GreenfootImage("p2_walk03.png");
    private GreenfootImage p2Run15 = new GreenfootImage("p2_walk04.png");
    private GreenfootImage p2Run16 = new GreenfootImage("p2_walk05.png");
    private GreenfootImage p2Run17 = new GreenfootImage("p2_walk06.png");
    private GreenfootImage p2Run18 = new GreenfootImage("p2_walk07.png");
    private GreenfootImage p2Run19 = new GreenfootImage("p2_walk08.png");
    private GreenfootImage p2Run20 = new GreenfootImage("p2_walk09.png");
    private GreenfootImage p2Run21 = new GreenfootImage("p2_walk10.png");
    private GreenfootImage p2Run22 = new GreenfootImage("p2_walk11.png");
    private GreenfootImage p3Run1 = new GreenfootImage("p3_walk01L.png");
    private GreenfootImage p3Run2 = new GreenfootImage("p3_walk02L.png");
    private GreenfootImage p3Run3 = new GreenfootImage("p3_walk03L.png");
    private GreenfootImage p3Run4 = new GreenfootImage("p3_walk04L.png");
    private GreenfootImage p3Run5 = new GreenfootImage("p3_walk05L.png");
    private GreenfootImage p3Run6 = new GreenfootImage("p3_walk06L.png");
    private GreenfootImage p3Run7 = new GreenfootImage("p3_walk07L.png");
    private GreenfootImage p3Run8 = new GreenfootImage("p3_walk08L.png");
    private GreenfootImage p3Run9 = new GreenfootImage("p3_walk09L.png");
    private GreenfootImage p3Run10 = new GreenfootImage("p3_walk10L.png");
    private GreenfootImage p3Run11 = new GreenfootImage("p3_walk11L.png");
    private GreenfootImage p3Run12 = new GreenfootImage("p3_walk01.png");
    private GreenfootImage p3Run13 = new GreenfootImage("p3_walk02.png");
    private GreenfootImage p3Run14 = new GreenfootImage("p3_walk03.png");
    private GreenfootImage p3Run15 = new GreenfootImage("p3_walk04.png");
    private GreenfootImage p3Run16 = new GreenfootImage("p3_walk05.png");
    private GreenfootImage p3Run17 = new GreenfootImage("p3_walk06.png");
    private GreenfootImage p3Run18 = new GreenfootImage("p3_walk07.png");
    private GreenfootImage p3Run19 = new GreenfootImage("p3_walk08.png");
    private GreenfootImage p3Run20 = new GreenfootImage("p3_walk09.png");
    private GreenfootImage p3Run21 = new GreenfootImage("p3_walk10.png");
    private GreenfootImage p3Run22 = new GreenfootImage("p3_walk11.png");
    private static int frame = 0;
    private static int width = 70;
    private static int height = 95;

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

    public void animatieRight() {
        switch(player){
            case 1:
            if(frame == 1)
            {
                setImage(run12);

            }
            else if (frame == 2)
            {
                setImage(run13);

            }
            else if (frame == 3)
            {
                setImage(run14);

            }
            else if (frame == 4)
            {
                setImage(run15);

            }
            else if (frame == 5)
            {
                setImage(run16);

            }
            else if (frame == 6)
            {
                setImage(run17);

            }
            else if (frame == 7)
            {
                setImage(run18);

            }
            else if (frame == 8)
            {
                setImage(run19);

            }
            else if (frame == 9)
            {
                setImage(run20);

            }
            else if (frame == 10)
            {
                setImage (run21);
                frame = 0;
                return;
            }
            frame ++;
            break;
            case 2:
            if(frame == 1)
            {
                setImage(p2Run12);
                
            }
            else if (frame == 2)
            {
                setImage(p2Run13);
                
            }
            else if (frame == 3)
            {
                setImage(p2Run14);
                
            }
            else if (frame == 4)
            {
                setImage(p2Run15);
                
            }
            else if (frame == 5)
            {
                setImage(p2Run16);
                
            }
            else if (frame == 6)
            {
                setImage(p2Run17);
                
            }
            else if (frame == 7)
            {
                setImage(p2Run18);
                
            }
            else if (frame == 8)
            {
                setImage(p2Run19);
                
            }
            else if (frame == 9)
            {
                setImage(p2Run20);
                
            }
            else if (frame == 10)
            {
                setImage (p2Run21);
                
                frame = 0;
                return;
            }
            getImage().scale(width, height);
            frame ++;
            break;
            case 3:
            if(frame == 1)
            {
                setImage(p3Run12);

            }
            else if (frame == 2)
            {
                setImage(p3Run13);

            }
            else if (frame == 3)
            {
                setImage(p3Run14);

            }
            else if (frame == 4)
            {
                setImage(p3Run15);

            }
            else if (frame == 5)
            {
                setImage(p3Run16);

            }
            else if (frame == 6)
            {
                setImage(p3Run17);

            }
            else if (frame == 7)
            {
                setImage(p3Run18);

            }
            else if (frame == 8)
            {
                setImage(p3Run19);

            }
            else if (frame == 9)
            {
                setImage(p3Run20);

            }
            else if (frame == 10)
            {
                setImage (p3Run21);

                frame = 0;
                return;
            }
            frame ++;
        }
    }

    public void animatieLeft() {
        switch(player){
        case 1:    
        if(frame == 1)
        {
            setImage(run1);

        }
        else if (frame == 2)
        {
            setImage(run2);

        }
        else if (frame == 3)
        {
            setImage(run3);
        }
        else if (frame == 4)
        {
            setImage(run4);
        }
        else if (frame == 5)
        {
            setImage(run5);
        }
        else if (frame == 6)
        {
            setImage(run6);
        }
        else if (frame == 7)
        {
            setImage(run7);
        }
        else if (frame == 8)
        {
            setImage(run8);
        }
        else if (frame == 9)
        {
            setImage(run9);
        }
        else if (frame == 10)
        {
            setImage (run10);

            frame = 0;
            return;
        }
        frame ++;
        break;
        case 2:    
        if(frame == 1)
        {
            setImage(p2Run1);

        }
        else if (frame == 2)
        {
            setImage(p2Run2);

        }
        else if (frame == 3)
        {
            setImage(p2Run3);
        }
        else if (frame == 4)
        {
            setImage(p2Run4);
        }
        else if (frame == 5)
        {
            setImage(p2Run5);
        }
        else if (frame == 6)
        {
            setImage(p2Run6);
        }
        else if (frame == 7)
        {
            setImage(p2Run7);
        }
        else if (frame == 8)
        {
            setImage(p2Run8);
        }
        else if (frame == 9)
        {
            setImage(p2Run9);
        }
        else if (frame == 10)
        {
            setImage (p2Run10);

            frame = 0;
            return;
        }
        getImage().scale(width, height);
        frame ++;
        break;
        case 3:    
        if(frame == 1)
        {
            setImage(p3Run1);

        }
        else if (frame == 2)
        {
            setImage(p3Run2);

        }
        else if (frame == 3)
        {
            setImage(p3Run3);
            
        }
        else if (frame == 4)
        {
            setImage(p3Run4);
            
        }
        else if (frame == 5)
        {
            setImage(p3Run5);
            
        }
        else if (frame == 6)
        {
            setImage(p3Run6);
            
        }
        else if (frame == 7)
        {
            setImage(p3Run7);
            
        }
        else if (frame == 8)
        {
            setImage(p3Run8);
            
        }
        else if (frame == 9)
        {
            setImage(p3Run9);
            
        }
        else if (frame == 10)
        {
            setImage (p3Run10);

            frame = 0;
            return;
        }
        frame ++;
        break;
    }
}
    public void handleInput() {
        if (Greenfoot.isKeyDown("space")) {
            for (Actor enemy : getIntersectingObjects(Tile.class)) {
            if(inLevel == true){
                if (enemy != null) {
                    Music.jump.play();
                    velocityY = -15;
                    return;
                }
            }
        }
        }
        if (Greenfoot.isKeyDown("left")) {
            velocityX = -6;
            switch(player){
                case 1: 
                animatieLeft();
                break;
                case 2: animatieLeft();
                break;
                case 3: animatieLeft();
                break;
            }
        } else if (Greenfoot.isKeyDown("right")) {
            velocityX = 6;
            switch(player){
                case 1: 
                animatieRight();
                break;
                case 2: animatieRight();
                break;
                case 3: animatieRight();
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
