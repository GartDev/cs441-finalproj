package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class qdGame extends Game {
	private Texture p1boy;
	private Texture p2boy;
	private Texture draw;
	private Texture bgTexture;
	private Texture p1win;
	private Texture p2win;
	private Music p1shot;
	private Music p2shot;
	private Music yeehaw;
	private Music highnoon;
	private OrthographicCamera camera;
	public SpriteBatch batch;
//	private SpriteBatch gamebatch;
	private Rectangle p1hit;
	private Rectangle p2hit;
	private int text;
	private int overridetext;
	private long starttime;
	private long endtime;


	@Override
	public void create () {
		//sprites
		p1boy = new Texture(Gdx.files.internal("cowboy.bmp"));
		p2boy = new Texture(Gdx.files.internal("cowboy2.bmp"));
		draw = new Texture(Gdx.files.internal("draw.bmp"));
		bgTexture = new Texture(Gdx.files.internal("ww.bmp"));
		p1win = new Texture(Gdx.files.internal("p1w.bmp"));
		p2win = new Texture(Gdx.files.internal("p2w.bmp"));
		//Sounds
		p1shot  = Gdx.audio.newMusic(Gdx.files.internal("intervention_fire.ogg"));
		p2shot  = Gdx.audio.newMusic(Gdx.files.internal("revolver_fire.ogg"));
		yeehaw = Gdx.audio.newMusic(Gdx.files.internal("sv.ogg"));
		highnoon  = Gdx.audio.newMusic(Gdx.files.internal("highnoon.ogg"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
		batch = new SpriteBatch();
		//gamebatch = new SpriteBatch();
		p1hit = new Rectangle();
		p1hit.x = 100;
		p1hit.y = 175;
		p1hit.width = 100;
		p1hit.height = 100;
		p2hit = new Rectangle();
		p2hit.x = 1400;
		p2hit.y = 175;
		p2hit.width = 100;
		p2hit.height = 100;
		highnoon.play();
		starttime = System.currentTimeMillis();
		endtime = System.currentTimeMillis();
		text = 0;
		overridetext = 0;
	}

	@Override
	public void render () {
		super.render();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(bgTexture,0,0,1920,1080);
		batch.draw(p1boy, 100, 250);
		batch.draw(p2boy, 1400,250);
		endtime = System.currentTimeMillis();
		if(endtime - starttime > 5000) {
			text = 3;
			if (Gdx.input.isTouched()) {
				Vector3 touchPos = new Vector3();
				touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
				camera.unproject(touchPos);
				if (touchPos.x < 800) {
					p1shot.play();
					overridetext = 1;
					text = 1;
					yeehaw.play();
				} else {
					p2shot.play();
					overridetext = 2;
					text = 2;
					yeehaw.play();
				}
			}
		}
		if(text == 1 || overridetext == 1 ){
			batch.draw(p1win, 600, 400);
		}else if(text == 2 || overridetext == 2){
			batch.draw(p2win, 600, 400);
		}else if(text == 3 && overridetext == 0){
			batch.draw(draw, 600, 400);
		}else{

		}
			batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
