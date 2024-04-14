package com.mygdx.game.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Main;
import com.mygdx.game.entety.Bullet;
import com.mygdx.game.entety.EnemyWithBow;

public class GameScreen implements Screen {
    private Main main;

    public GameScreen(Main main){
        this.main=main;
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }
            //

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY= (int) (Main.Height-screenY);
                multitouch((int)screenX,(int)screenY,true,pointer);
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenY= (int) (Main.Height-screenY);
                multitouch((int)screenX,(int)screenY,false,pointer);
                return false;
            }

            @Override
            public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
                screenY= (int) (Main.Height-screenY);
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                screenY= (int) (Main.Height-screenY);
                multitouch((int)screenX,(int)screenY,true,pointer);
                return false;
            }
            //

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }

        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        GameUpdate();
        main.batch.begin();
        GameRender(Main.batch);
        main.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
    public void GameUpdate(){
        Main.player.setDirection(Main.joostikPlayer.getDir());
        Main.player.update();
        Main.bulletGenerator.update(Main.joostikBullet);
        for(int j=0;j<Main.bullets.size;j++){Main.bullets.get(j).update();if (Main.bullets.get(j).isOut)Main.bullets.removeIndex(j);}
        for(int k=0;k<Main.enemyWithBows.size;k++){Main.enemyWithBows.get(k).update();
            /**for(int l=0;l<Main.bullets.size;l++){
                if(Main.enemyWithBows.get(k).boundsEnemyBow.isConteins(Main.bullets.get(l).getPos())){
                    Main.enemyWithBows.get(k).setHealthEnemyBow(Main.enemyWithBows.get(k).getHealthEnemyBow()-10);
                    Main.bullets.removeIndex(l);
                }
                if (Main.enemyWithBows.get(k).getHealthEnemyBow()==0){Main.enemyWithBows.removeIndex(k);}
            }
             отслеживаю касание пули и нанесение урона
             нужна задержка при выстреливании пули
             **/
        }
    }
    public void GameRender(SpriteBatch batch){
        Main.player.draw(batch);
        Main.joostikPlayer.draw(batch);
        Main.joostikBullet.draw(batch);
        for(int j=0;j<Main.bullets.size;j++){Main.bullets.get(j).draw(batch);
        }
        for(int l=0;l<Main.enemyWithBows.size;l++){Main.enemyWithBows.get(l).draw(batch);

        }
    }
    //System.nanoTime();
    @Override
    public void dispose() {
        main.batch.dispose();
    }

    public void multitouch(float x,float y,boolean isDownTouch,int pointer){
        for(int i=0;i<5;i++){
            Main.joostikPlayer.update(x,y,isDownTouch,pointer);
            Main.joostikBullet.update(x,y,isDownTouch,pointer);
        }
    }
}
