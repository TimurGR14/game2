package com.mygdx.game.entety;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Main;
import com.mygdx.game.settings.Circle;
import com.mygdx.game.settings.Point2D;

public class EnemyWithBow extends Entety{
    private Texture imgEnemyBow;
    private Point2D positionEnemyBow;
    private Point2D directionEnemyBow;
    private float healthEnemyBow;
    private float speedEnemyBow;
    public static Circle boundsEnemyBow;
    private Circle bbEnemy;
    private float radius=64;
    public EnemyWithBow(Point2D pos,int Rang){
        switch (Rang){
            case 1:
                imgEnemyBow=new Texture("Enemy1.jpg");
                boundsEnemyBow=new Circle(pos,radius);
                healthEnemyBow=50;
                speedEnemyBow=6;
                bbEnemy=new Circle(pos,radius*2*5);
                break;
            case 2:
                imgEnemyBow=new Texture("Enemy2.jpg");
                healthEnemyBow=80;
                speedEnemyBow=3;
                boundsEnemyBow=new Circle(pos,radius);
                bbEnemy=new Circle(pos,radius*4);
                break;
            case 3:
                imgEnemyBow=new Texture("Enemy1.jpg");
                healthEnemyBow=30;
                speedEnemyBow=13;
                break;
            default:
                imgEnemyBow=new Texture("Enemy1.jpg");
                healthEnemyBow=60;
                speedEnemyBow=9;
                break;
        }
        positionEnemyBow=pos;
        boundsEnemyBow=new Circle(positionEnemyBow,radius);
        directionEnemyBow=new Point2D(0,0);
        //directionEnemyBow.setX((float) Math.sin(Math.toRadians(Math.random()*360)));
        //directionEnemyBow.setY((float) Math.cos(Math.toRadians(Math.random()*360)));
    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(imgEnemyBow,positionEnemyBow.getX()-radius,positionEnemyBow.getY()-radius,radius*2,radius*2);
    }

    @Override
    public void update() {
        if(positionEnemyBow.getX()+radius> Main.Widith)directionEnemyBow.setX(-directionEnemyBow.getX());
        if(positionEnemyBow.getX()-radius<0)directionEnemyBow.setX(-directionEnemyBow.getX());
        if(positionEnemyBow.getY()+radius> Main.Height)directionEnemyBow.setY(-directionEnemyBow.getY());
        if(positionEnemyBow.getY()-radius<0)directionEnemyBow.setY(-directionEnemyBow.getY());
        if(bbEnemy.isConteins(Player.position)){
            attack();
        }
        /**else if(!(bbEnemy.isConteins(Player.position))){
            directionEnemyBow.setPoint(0,0);
        }**/
        positionEnemyBow.add(directionEnemyBow.getX()*speedEnemyBow,directionEnemyBow.getY()*speedEnemyBow);


    }
    public void attack(){
        float xs=positionEnemyBow.getX()-Player.position.getX();
        float ys=positionEnemyBow.getY()-Player.position.getY();
        float ds= (float) Math.sqrt(xs*xs+ys*ys);
        /**
        if (ds<64){
            directionEnemyBow.setPoint(0,0);
        }else if(ds>64) {
            directionEnemyBow.setPoint(-(xs / ds), -(ys / ds));
        }**/
        directionEnemyBow.setPoint(-(xs / ds), -(ys / ds));
    }
    public float getHealthEnemyBow(){return healthEnemyBow;}

    public void setHealthEnemyBow(float healthEnemyBow) {
        this.healthEnemyBow = healthEnemyBow;
    }
}
