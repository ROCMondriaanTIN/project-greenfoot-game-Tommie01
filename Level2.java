import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level2 extends MyWorld
{
    private CollisionEngine ce;

    public void act(){
        super.act();
       try{
            ce.update();
        }
        catch(Exception e){}
    }

    public Level2()
    {    
        Hero.alive = true;
        clearScreen();
        Hero.inLevel = true;
        Hero.hasKey = false;
        this.setBackground("bg1.png");
        int[][] map = {
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,140,140,140,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,140,140,140,140,140,140,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,140,140,140,140,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,140,140,140,140,140,140,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,140,140,140,140,140,140,140,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,520,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,186,186,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,451,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,8,8,8,-1,-1,-1,-1,-1,-1,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,186,-1,-1,518,-1,450,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,8,8,8,8,8,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,246,-1,-1,-1,-1,-1,-1,-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,245,-1,14,-1,-1,-1,-1,-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,8,8,8,8,-1,-1,-1,-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,11,11,11,11,11,11,11,11,11,11},
                {-1,-1,6,6,6,6,-1,-1,-1,-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {-1,-1,6,6,6,6,-1,-1,-1,-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {-1,-1,6,6,6,6,-1,-1,-1,-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {11,11,6,6,6,6,-1,-1,-1,-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,204,204,204,204,204,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,-1,-1,-1,-1,-1,6,6,6,6,-1,-1,-1,-1,-1,-1,204,204,204,204,204,186,-1,-1,-1,613,-1,-1,-1,-1,-1,-1,-1,-1,-1,613,-1,-1,-1,-1,519,-1,-1,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,11,11,11,11,11,6,6,6,6,11,11,11,11,11,11,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},
                {10,10,6,6,6,6,10,10,10,10,10,6,6,6,6,10,10,10,10,10,10,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,204,6,6,6,6,6,6,10,10,10,10,10,10,10,10,10,10},

            };
        Hero hero = new Hero(Hero.player);
        TileEngine te = new TileEngine(this, 60, 60, map);
        Camera camera = new Camera(te);
        camera.follow(hero);
        addObject(camera, 0, 0);
        ce = new CollisionEngine(te, camera);
        ce.addCollidingMover(hero);
        addObject(hero, 300, 900);
        addObject(new PlatformY(250), 500, 900);
        addObject(new PlatformY(450), 1061,900);
        addObject(new Key(), 2813,1212);
        addObject(new GoldCoin(), 765,612);
        addObject(new SilverCoin(), 1427,1092);
        addObject(new GoldCoin(), 405, 192);
        addObject(new SilverCoin(), 1390,132);
        addObject(new GoldCoin(), 2889,612);
        addObject(new GoldCoin(), 1836,612);
        addObject(new Enemy(), 1836,645);
        addObject(new Enemy(), 2141, 1245);
        addObject(new Fireball(), 1893, 270);
        if(Hero.diamonds != 2){
            addObject(new Diamond(), 329,192);
        }
        hud();
    }
}
