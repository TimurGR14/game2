package com.mygdx.game.entety;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Main;
import com.mygdx.game.settings.Circle;
import com.mygdx.game.settings.Point2D;

public class Player extends Entety {
    public static Point2D position;
    float speed=7;
    float side=128;
    int health=100;
    private Texture imgPlayer;
    private Circle bounds;
    public static Point2D direction;

    public Player(Point2D position){
        imgPlayer=new Texture("giga.jpg");
        this.position=position;
        direction=new Point2D(0,0);
        bounds=new Circle(position,64);

    }
    @Override
    public void draw(SpriteBatch batch) {

        batch.draw(imgPlayer,position.getX()-side,position.getY()-side,side,side);
    }

    @Override
    public void update() {
        if(position.getX()+side> Main.Widith)position.setX(Main.Widith-side);
        if(position.getX()-side<0)position.setX(side);
        if(position.getY()+side> Main.Height)position.setY(Main.Height-side);
        if(position.getY()-side<0)position.setY(side);

        position.add(direction.getX()*speed,direction.getY()*speed);

    }
    public void setDirection(Point2D dir){
        direction=dir;
    }

}
