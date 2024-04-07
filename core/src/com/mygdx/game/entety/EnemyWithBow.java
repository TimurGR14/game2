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
    private Circle boundsEnemyBow;
    private Circle bbEnemy;
    private float radius=64;
    public EnemyWithBow(Point2D pos,int Rang){
        switch (Rang){
            case 1:
                imgEnemyBow=new Texture("Enemy1.jpg");
                healthEnemyBow=20;
                speedEnemyBow=6;
                bbEnemy=new Circle(pos,radius*2*3);
                break;
            case 2:
                imgEnemyBow=new Texture("Enemy1.jpg");
                healthEnemyBow=40;
                speedEnemyBow=3;
                break;
            case 3:
                imgEnemyBow=new Texture("Enemy1.jpg");
                healthEnemyBow=15;
                speedEnemyBow=13;
                break;
            default:
                imgEnemyBow=new Texture("Enemy1.jpg");
                healthEnemyBow=25;
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
        }else if(!(bbEnemy.isConteins(Player.position))){
            directionEnemyBow.setPoint(0,0);
        }
        positionEnemyBow.add(directionEnemyBow.getX()*speedEnemyBow,directionEnemyBow.getY()*speedEnemyBow);

    }
    public void attack(){
        float xs=Math.abs(positionEnemyBow.getX()-Player.position.getX());
        float ys=Math.abs(positionEnemyBow.getY()-Player.position.getY());
        float ds= (float) Math.sqrt(xs*xs+ys*ys);
        if (ds<64){
            directionEnemyBow.setPoint(0,0);
        }else if(ds>64) {
            directionEnemyBow.setPoint(-(xs / ds), -(ys / ds));
        }
        //positionEnemyBow.setX(100);
        //positionEnemyBow.setY(100);
    }
}
