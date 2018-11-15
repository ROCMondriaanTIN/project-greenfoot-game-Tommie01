

import javax.swing.JOptionPane;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 *
 * @author R. Springer
 */
public class MyWorld extends World {

    private final boolean debug = true;
    private CollisionEngine ce;
    private static int level = 1;
    private static int maxLevel = 1;
    private int levelX;
    private int levelY;
    private int player = 1;
    private int levens = 2;
    private int coins = 0;
    private int diamonds = 0;
    private boolean alive = true;
    private String debugCoins;
    StartButton strtBtn = new StartButton();
    QuitButton qtBtn = new QuitButton();
    LevelSelectorButton lvlSelectBtn = new LevelSelectorButton();
    LevelButton lvl1Btn = new LevelButton();
    LevelButton lvl2Btn = new LevelButton();
    LevelButton lvl3Btn = new LevelButton();
    LevelButton lvl4Btn = new LevelButton();
    LevelButton debugLvlBtn = new LevelButton();
    Hero hr = new Hero();
    HeroPicker h1 = new HeroPicker(1);
    HeroPicker h2 = new HeroPicker(2);
    HeroPicker h3 = new HeroPicker(3);
    Logo logo = new Logo();

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        //levelGenerator();
        startScreen();
        hr.inLevel = false;
    }

    @Override
    public void act() {
        if(hr.inLevel == true){
            ce.update();
        }
        buttons();
        backToMenu();
        isDead();
        hudUpdate();
        debug();
        //System.out.println("Hr: " + hr.alive);
    }

    public void debug(){
        if(debug == true){
            if(Greenfoot.isKeyDown("k")){
                removeObjects(getObjects(Mover.class));
                Greenfoot.delay(10);
            }
            if(Greenfoot.isKeyDown("m")){
                debugCoins = JOptionPane.showInputDialog(null, "Debug coins");
                coins = Integer.parseInt(debugCoins);
                Greenfoot.delay(10);
            }
        }
    }

    public void backToMenu(){
        if(Greenfoot.isKeyDown("escape")){
            clearScreen();
            startScreen();
        }
    }

    public void buttons(){
        if(Greenfoot.mouseClicked(strtBtn)){
            clearScreen();
            startScreen();
        }
        if(Greenfoot.mouseClicked(lvlSelectBtn)){
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
            hr.player = 1;
            levelGenerator();
        }
        if(Greenfoot.mouseClicked(h2)){
            clearScreen();
            hr.player = 2;
            levelGenerator();
        }
        if(Greenfoot.mouseClicked(h3)){
            clearScreen();
            hr.player = 3;
            levelGenerator();
        }
    }
    
    public void isDead(){
        if(hr.inLevel == true){
            if(hr.alive == false || getObjects(Hero.class).isEmpty()){
                    System.out.println("1");
                    hr.inLevel = false;
                    if(levens == 1){
                        gameOver();
                        alive = true;
                    }
                    else{
                        System.out.println("2");
                        levens --;
                        clearScreen();
                        levelGenerator();
                        alive = true;
                    }
                }
            }
        }

    public void hud(){
        if(hr.inLevel == true){
            for (int i = 0; i < levens; i ++){
                addObject(new HUDLives(), (50 + (i * 15)), 40);
            }
            if(coins >= 1 && coins <= 10){
                for (int i = 0; i < coins; i ++){
                    addObject(new HUDCoins(), (50 + (i * 15)), 100);
                }
            }
            else if(coins >= 1 && coins <= 20){
                for (int i = 0; i < (coins - 10); i ++){
                    addObject(new HUDCoins(), (50 + (i * 15)), 160);
                }
            }
            else if(coins >= 1 && coins <= 30){
                for (int i = 0; i < (coins - 20); i ++){
                    addObject(new HUDCoins(), (50 + (i * 15)), 220);
                }
            }
            else if(coins >= 1 && coins <= 40){
                for (int i = 0; i < (coins - 30); i ++){
                    addObject(new HUDCoins(), (50 + (i * 15)), 280);
                }
            }
        }
    }

    public void hudUpdate(){
        if(getObjects(HUDLives.class).size() != levens){
            removeObjects(getObjects(HUDLives.class));
            hud();
        }
        if(getObjects(HUDCoins.class).size() != levens){
            removeObjects(getObjects(HUDCoins.class));
            hud();
        }
    }

    public void gameOver(){
        clearScreen();
        setBackground("bg.png");
        showText("Hahaha je bent dood", 500, 400);
        addObject(logo, 500, 200);
        addObject(qtBtn, 100, 700);
        showText("Stoppen", 235, 700);
        addObject(strtBtn, 100, 600);
        showText("Begin Scherm", 250, 600);
        player = 1;
        levens = 2;
        coins = 0;
        diamonds = 0;
        maxLevel = 1;
        level = 0;
    }

    public void characterMenu(){
        this.setBackground("bg2.png");
        addObject(logo, 500, 200);
        showText("Kies een speler", 100, 400);
        addObject(h1, 100, 500);
        addObject(h2, 100, 700);
        addObject(h3, 400, 500);
    }

    public void startScreen(){
        this.setBackground("bg2.png");
        addObject(logo, 500, 200);
        addObject(qtBtn, 100, 700);
        showText("Stoppen", 235, 700);
        addObject(lvlSelectBtn, 100, 600);
        showText("Level kiezen", 250, 600);
    }

    //If it looks stupid but it works it ain't stupid
    public void clearScreen(){
        hr.inLevel = false;
        removeObjects(getObjects(HUDLives.class));
        removeObjects(getObjects(HUDCoins.class));
        removeObjects(getObjects(Key.class));
        removeObjects(getObjects(StartButton.class));
        removeObjects(getObjects(LevelSelectorButton.class));
        removeObjects(getObjects(QuitButton.class));
        removeObjects(getObjects(Mover.class));
        removeObjects(getObjects(Tile.class));
        removeObjects(getObjects(Enemy.class));
        removeObjects(getObjects(LevelButton.class));
        removeObjects(getObjects(Logo.class));
        removeObjects(getObjects(HeroPicker.class));
        showText("", 250, 600);
        showText("", 235, 700);
        showText("", 250, 500);
        showText("", 200, 500);
        showText("", 200, 700);
        showText("", 700, 500);
        showText("", 700, 700);
        showText("", 100, 400);
        showText("", 500, 400);
    }

    public void levelSelector(){
        this.setBackground("bg2.png");
        if(debug == true){
            addObject(debugLvlBtn, 100, 300);
        }
        addObject(logo, 500, 200);
        showText("Kies een level", 100, 400);
        addObject(lvl1Btn, 100, 500);
        showText("Level 1", 200, 500);
        addObject(lvl2Btn, 100, 700);
        showText("Level 2", 200, 700);
        addObject(lvl3Btn, 600, 500);
        showText("Level 3", 700, 500);
        addObject(lvl4Btn, 600, 700);
        showText("Level 4", 700, 700);
        switch(maxLevel){

            case 1: lvl1Btn.setImage("grass.png");   
            break;
            case 2: lvl1Btn.setImage("grass.png"); lvl2Btn.setImage("grass.png");
            break;
            case 3: lvl1Btn.setImage("grass.png"); lvl2Btn.setImage("grass.png");   
            lvl3Btn.setImage("grass.png");   break;
            case 4: lvl1Btn.setImage("grass.png"); lvl2Btn.setImage("grass.png"); 
            lvl3Btn.setImage("grass.png"); lvl4Btn.setImage("grass.png"); 
            break;
        }
    }

    public void levelGenerator(){
        hud();
        this.setBackground("bg.png");
        int[][] map = {
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,582,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,583,-1,-1,-1,-1,140,140,140,140,140,140,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,244,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,140,140,-1,-1,140,140,140,140,140,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,12,-1,243,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,583,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,583,-1,-1,-1,140,140,140,140,8,8,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,140,140,140,140,140,140,140,-1,-1,-1,-1,-1,-1,-1,140,140,140,140,140,140,140,-1,-1,-1,-1,-1,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,14,-1,-1,-1,-1,-1,-1,-1,611,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,8,8,8,8,5,5,5,5,5,5,8,8,8,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,140,140,140,140,-1,-1,-1,-1,-1,-1,-1,-1,-1,140,140,140,-1,-1,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,8,-1,-1,-1,-1,-1,-1,-1,-1,583,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,611,-1,-1,-1,-1,1,6,6,-1,-1,-1,-1,-1,-1,-1,140,140,140,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,8,8,8,8,8,8,6,6,-1,-1,-1,-1,611,-1,-1,-1,-1,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,613,-1,-1,-1,-1,-1,-1,-1,14,-1,-1,-1,-1,-1,-1,6,6,6,6,6,6,6,6,6,-1,-1,-1,8,8,8,8,8,8,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,204,204,204,204,11,11,0,0,0,11,11,0,0,11,11,6,6,6,6,6,6,6,6,6,11,11,11,250,250,250,250,250,250,11,11,6,6,6,279,279,279,279,279,279,280,280,280,280,280,280,280,280},
                {-1,-1,6,6,6,6,-1,-1,44,-1,-1,-1,204,204,204,204,10,10,10,10,10,10,10,10,10,10,10,6,6,6,6,6,6,6,6,6,10,10,10,250,250,250,250,250,250,10,10,6,6,6,278,278,278,278,278,278,278,278,278,278,278,278,278,278},
                {-1,-1,6,6,6,6,11,1,1,1,1,11,204,204,204,204,10,10,10,10,10,10,10,10,10,10,10,6,6,6,6,6,6,6,6,6,10,10,10,6,6,6,6,6,6,10,10,6,6,6,278,278,278,278,278,278,278,278,278,278,278,278,278,278},
                {10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,10,10,10,10,10,10,10,10,10,10,10,6,6,6,6,6,6,6,6,6,10,10,10,6,6,6,6,6,6,10,10,6,6,6,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,10,10,10,10,10,10,10,10,10,10,10,6,6,6,6,6,6,6,6,6,10,10,10,6,6,6,6,6,6,10,10,6,6,6,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,10,10,10,10,10,10,10,10,10,10,10,6,6,6,6,6,6,6,6,6,10,10,10,6,6,6,6,6,6,10,10,6,6,6,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,10,10,10,10,10,10,10,10,10,10,10,6,6,6,6,6,6,6,6,6,10,10,10,6,6,6,6,6,6,10,10,6,6,6,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,10,10,10,10,10,10,10,10,10,10,10,6,6,6,6,6,6,6,6,6,10,10,10,6,6,6,6,6,6,10,10,6,6,6,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204},
                {204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204},
                {204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204},

            };
        Hero hero = new Hero(hr.player);
        Key key = new Key();
        addObject(key, 180, 550);
        TileEngine te = new TileEngine(this, 60, 60, map);
        Camera camera = new Camera(te);
        camera.follow(hero);
        addObject(camera, 0, 0);
        ce = new CollisionEngine(te, camera);
        ce.addCollidingMover(hero);
        addObject(hero, 300, 900);
        hr.inLevel = true;
        /*switch(level){
            case 0: Debug debug = new Debug();
            break;
            case 1: Level1 lvl1 = new Level1();
            break;
            case 2: Level2 lvl2 = new Level2();
            break;
            case 3: Level3 lvl3 = new Level3();
            break;
            case 4: Level4 lvl4 = new Level4();
            break;

        }*/
    }
}
