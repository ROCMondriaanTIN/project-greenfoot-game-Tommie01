
import javax.swing.JOptionPane;
import greenfoot.*;

public class MyWorld extends World {
    private static final boolean debug = false;
    private static int level = 1;
    private static int maxLevel = 1;
    private static int player = 1;
    private static int levens = 2;
    private boolean alive = true;
    private static boolean inUitleg = false;
    StartButton strtBtn = new StartButton();
    QuitButton qtBtn = new QuitButton();
    LevelSelectorButton lvlSelectBtn = new LevelSelectorButton();
    LevelButton lvl1Btn = new LevelButton("button_level1.png");
    LevelButton lvl2Btn = new LevelButton("button_level2_lck.png");
    LevelButton lvl3Btn = new LevelButton("button_level3_lck.png");
    LevelButton lvl4Btn = new LevelButton("button_level4_lck.png");
    LevelButton debugLvlBtn = new LevelButton("button_debug.png");
    HeroPicker h1 = new HeroPicker(1);
    HeroPicker h2 = new HeroPicker(2);
    HeroPicker h3 = new HeroPicker(3);

    public MyWorld() {
        super(1000, 800, 1, false);
        //Greenfoot.start();
        startScreen();
        Hero.inLevel = false;
    }

    @Override
    public void act() {
        buttons();
        isDead();
        hudUpdate();
        debug();
        newLife();
        buttons();
        backToMenu();
        endOfLevel();
        Music.bgMusic();
        Music.menuMusic();
    }

    public void debug(){
        if(debug == true){
            if(Greenfoot.isKeyDown("k")){
                Hero.alive = false;
                Greenfoot.delay(10);
            }
            if(Greenfoot.isKeyDown("m")){
                String debugCoins = JOptionPane.showInputDialog(null, "Debug coins");
                Hero.coins = Integer.parseInt(debugCoins);
                Greenfoot.delay(10);
            }
            if(Greenfoot.isKeyDown("n")){
                String debugDiamonds = JOptionPane.showInputDialog(null, "Debug diamonds");
                Hero.diamonds = Integer.parseInt(debugDiamonds);
                Greenfoot.delay(10);
            }
            if(Greenfoot.isKeyDown("b")){
                Hero.hasKey = true;
                Greenfoot.delay(10);
            }
            maxLevel = 4;
        }
    }

    public void backToMenu(){
        if(Greenfoot.isKeyDown("escape")){
            clearScreen();
            startScreen();
        }
    }

    public static void newLife(){
        if(Hero.coins >= 40){
            Hero.coins = 0;
            levens ++;
            Music.newLife.play();
        }
    }

    public void buttons(){
        if(Greenfoot.mouseClicked(strtBtn)){
            clearScreen();
            startScreen();
        }
        if(Greenfoot.mouseClicked(lvlSelectBtn)){
            Music.lvlClr.stop();
            Music.menuMusic();
            clearScreen();
            levelSelector();
        }
        if(Greenfoot.mouseClicked(qtBtn)){
            clearScreen();
            startScreen();
            Greenfoot.stop();
        }
        if(debug == true){
            if(Greenfoot.mouseClicked(debugLvlBtn)){
                level = 0;
                clearScreen();
                characterMenu();
            }
        }
        if(Greenfoot.mouseClicked(lvl1Btn)){
            level = 1;
            clearScreen();
            characterMenu();
        }
        if(Greenfoot.mouseClicked(lvl2Btn)){
            if(maxLevel >= 2){
                level = 2;
                clearScreen();
                characterMenu();
            }
            else{
                JOptionPane.showMessageDialog(null, "Je hebt dit level nog niet vrijgespeeld",
                    "", JOptionPane.WARNING_MESSAGE);
            }
        }
        if(Greenfoot.mouseClicked(lvl3Btn)){
            if(maxLevel >= 3){
                level = 3;
                clearScreen();
                characterMenu();
            }
            else{
                JOptionPane.showMessageDialog(null, "Je hebt dit level nog niet vrijgespeeld",
                    "", JOptionPane.WARNING_MESSAGE);
            }
        }
        if(Greenfoot.mouseClicked(lvl4Btn)){
            if(maxLevel >= 4){
                level = 4;
                clearScreen();
                characterMenu();
            }
            else{
                JOptionPane.showMessageDialog(null, "Je hebt dit level nog niet vrijgespeeld",
                    "", JOptionPane.WARNING_MESSAGE);
            }
        }
        if(Greenfoot.mouseClicked(h1)){
            clearScreen();
            Hero.player = 1;
            uitleg();
        }
        if(Greenfoot.mouseClicked(h2)){
            clearScreen();
            Hero.player = 2;
            uitleg();
        }
        if(Greenfoot.mouseClicked(h3)){
            clearScreen();
            Hero.player = 3;
            uitleg();
        }
        if(inUitleg == true){
            if(Greenfoot.isKeyDown("space")){
                inUitleg = false;
                levelGenerator();
            }
        }
    }

    public void isDead(){
        if(Hero.inLevel == true){
            if(Hero.alive == false){
                Hero.inLevel = false;
                if(levens == 0){
                    gameOver();
                    level = 1;
                    maxLevel = 1;
                    alive = true;
                }
                else{
                    Music.die.play();
                    levens --;
                    clearScreen();
                    levelGenerator();
                    alive = true;
                }
            }
        }
    }

    public void endOfLevel(){
        if(Hero.isTouchingDoor == true){
            if(Hero.hasKey == true){
                if(level == 4){
                    clearScreen();
                    setBackground("gameClear.png");
                    Music.worldClear.play();
                }
                else{
                    clearScreen();
                    Hero.isTouchingDoor = false;
                    levens = 2;
                    if(level <= 3){
                        level ++;
                    }
                    if(maxLevel <= 3){
                        maxLevel ++;
                    }
                    levelCleared();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "De deur is nog op slot je moet een sleutel vinden",
                    "", JOptionPane.WARNING_MESSAGE);
                Hero.isTouchingDoor = false;    
            }
        }
    }

    public void levelCleared(){
        Music.lvlClr.play();
        clearScreen();
        setBackground("lvlClr.png");
        addObject(qtBtn, 100, 700);
        addObject(lvlSelectBtn, 100, 600);
    }

    public void hud(){
        if(Hero.inLevel == true){
            for (int i = 0; i < levens; i ++){
                addObject(new HUDLives(), (50 + (i * 15)), 40);
            }
            for (int i = 0; i < Hero.coins; i ++){
                if(i <= 9){
                    addObject(new HUDCoins(), (50 + (i * 15)), 100);
                }
                else if(i >= 10 && i < 20){
                    addObject(new HUDCoins(), (50 + ((i * 15) - 150)), 160);
                }
                else if(i >= 20 && i < 30){
                    addObject(new HUDCoins(), (50 + ((i * 15) - 300)), 220);
                }
                else if(i >= 30 && i < 40){
                    addObject(new HUDCoins(), (50 + ((i * 15) - 450)), 280);
                }
            }
            for (int i = 0; i < Hero.diamonds; i ++){
                addObject(new HUDDiamond(), (50 + (i * 15)), 340);
            }
            if(Hero.hasKey == true){
                addObject(new HUDKey("hud_keyYellow.png"), 50, 400);
                removeObjects(getObjects(Key.class));
            }
            else{
                addObject(new HUDKey("hud_keyYellow_disabled.png"), 50, 400);
            }
        }
    }

    public void hudUpdate(){
        if(getObjects(HUDLives.class).size() != levens){
            removeObjects(getObjects(HUDLives.class));
            hud();
        }
        if(getObjects(HUDCoins.class).size() != Hero.coins){
            removeObjects(getObjects(HUDCoins.class));
            hud();
        }
        if(getObjects(HUDDiamond.class).size() != Hero.diamonds){
            removeObjects(getObjects(HUDDiamond.class));
            hud();
        }
        if(getObjects(HUDKey.class).size() == 0 || Hero.hasKey == true){
            removeObjects(getObjects(HUDKey.class));
            hud();
        }
    }

    public void gameOver(){
        Music.gameOver.play();
        clearScreen();
        setBackground("gameOverScreen.jpg");
        addObject(qtBtn, 100, 700);
        addObject(strtBtn, 100, 600);
        player = 1;
        levens = 2;
        Hero.coins = 0;
        Hero.diamonds = 0;
        maxLevel = 1;
        level = 0;
    }

    public void characterMenu(){
        this.setBackground("bg2.png");
        showText("Kies een speler", 100, 400);
        addObject(h1, 100, 500);
        addObject(h2, 100, 700);
        addObject(h3, 400, 500);
    }

    public void startScreen(){
        clearScreen();
        this.setBackground("bg2.png");
        addObject(qtBtn, 150, 700);
        addObject(lvlSelectBtn, 150, 600);
    }

    public void clearScreen(){
        Hero.inLevel = false;
        removeObjects(getObjects(HUDLives.class));
        removeObjects(getObjects(HUDKey.class));
        removeObjects(getObjects(HUDCoins.class));
        removeObjects(getObjects(Key.class));
        removeObjects(getObjects(Diamond.class));
        removeObjects(getObjects(StartButton.class));
        removeObjects(getObjects(LevelSelectorButton.class));
        removeObjects(getObjects(QuitButton.class));
        removeObjects(getObjects(Mover.class));
        removeObjects(getObjects(Tile.class));
        removeObjects(getObjects(Enemy.class));
        removeObjects(getObjects(LevelButton.class));
        removeObjects(getObjects(HeroPicker.class));
        removeObjects(getObjects(SilverCoin.class));
        removeObjects(getObjects(GoldCoin.class));
        removeObjects(getObjects(Diamond.class));
        removeObjects(getObjects(HUDDiamond.class));
        removeObjects(getObjects(Fireball.class));
        showText("", 100, 500);
        showText("", 100, 400);
    }

    public void levelSelector(){
        this.setBackground("bg2.png");
        if(debug == true){
            addObject(debugLvlBtn, 100, 300);
        }
        showText("Kies een level", 100, 500);
        addObject(lvl1Btn, 100, 600);
        addObject(lvl2Btn, 100, 700);
        addObject(lvl3Btn, 300, 600);
        addObject(lvl4Btn, 300, 700);
        switch(maxLevel){
            case 1: lvl1Btn.setImage("button_level1.png");   
            break;
            case 2: lvl1Btn.setImage("button_level1.png"); lvl2Btn.setImage("button_level2.png");
            break;
            case 3: lvl1Btn.setImage("button_level1.png"); lvl2Btn.setImage("button_level2.png");  
            lvl3Btn.setImage("button_level3.png");   break;
            case 4: lvl1Btn.setImage("button_level1.png"); lvl2Btn.setImage("button_level2.png");  
            lvl3Btn.setImage("button_level3.png"); lvl4Btn.setImage("button_level4.png"); 
            break;
        }
    }

    public void uitleg(){
        inUitleg = true;
        clearScreen();
        setBackground("uitleg.png");
    }

    public void levelGenerator(){
        switch(level){
            case 0: Greenfoot.setWorld(new Debug());
            break;
            case 1: Greenfoot.setWorld(new Level1());
            break;
            case 2: Greenfoot.setWorld(new Level2());
            break;
            case 3: Greenfoot.setWorld(new Level3());
            break;
            case 4: Greenfoot.setWorld(new Level4());
            break;

        }
    }
}
