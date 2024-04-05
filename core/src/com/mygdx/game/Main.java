package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.entety.Bullet;
import com.mygdx.game.entety.EnemyWithBow;
import com.mygdx.game.entety.Player;
import com.mygdx.game.settings.BulletGenerator;
import com.mygdx.game.settings.GameScreen;
import com.mygdx.game.settings.JoostikPlayer;
import com.mygdx.game.settings.Point2D;

public class Main extends Game {
	public static SpriteBatch batch;
	public Texture img;
	private Point2D posPlayer=new Point2D(300,200);
	public static Player player;
	public static float Widith,Height;
	public static Texture circle,stick;
	public static JoostikPlayer joostikPlayer,joostikBullet;
	public static Array<Bullet> bullets;
	public static BulletGenerator bulletGenerator;
	public static Array<EnemyWithBow>enemyWithBows;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player=new Player(posPlayer);
		Widith= Gdx.graphics.getWidth();
		Height=Gdx.graphics.getHeight();
		circle=new Texture("circle.jpg");
		stick=new Texture("stick.jpg");
		joostikPlayer=new JoostikPlayer(circle,stick,new Point2D(Widith*4/5,Height/3),Height/4);
		setScreen(new GameScreen(this));
		bullets=new Array<Bullet>();
		joostikBullet=new JoostikPlayer(circle,stick,new Point2D(Widith/5,Height/3),Height/5);
		bulletGenerator=new BulletGenerator();
		enemyWithBows=new Array<EnemyWithBow>();
		enemyWithBows.add(new EnemyWithBow(new Point2D(100,100),1));
		enemyWithBows.add(new EnemyWithBow(new Point2D(100,100),2));
		enemyWithBows.add(new EnemyWithBow(new Point2D(100,100),3));
	}
}
