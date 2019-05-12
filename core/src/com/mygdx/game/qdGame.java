package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class qdGame extends ApplicationAdapter {
	private Texture p1boy;
	private Texture p2boy;
	private Texture bgTexture;
	private Texture roundstart;
	private Sound p1shot;
	private Sound p2shot;
	private Sound highnoon;
	private OrthographicCamera camera;
	SpriteBatch batch;
	private Rectangle p1hit;
	private Rectangle p2hit;
	private float ttb;
	
	@Override
	public void create () {
		//sprites
		p1boy = new Texture(Gdx.files.internal("cowboy.bmp"));
		p2boy = new Texture(Gdx.files.internal("cowboy2.bmp"));
		bgTexture = new Texture(Gdx.files.internal("ww.bmp"));
		roundstart = new Texture(Gdx.files.internal("roundstart.bmp"));
		//Sounds
		p1shot  = Gdx.audio.newSound(Gdx.files.internal("intervention_fire.ogg"));
		p2shot  = Gdx.audio.newSound(Gdx.files.internal("revolver_fire.ogg"));
		highnoon  = Gdx.audio.newSound(Gdx.files.internal("highnoon.ogg"));

		batch = new SpriteBatch();
		p1hit = new Rectangle();
		p1hit.x = 0;
		p1hit.y = 20;
		p1hit.width = 100;
		p1hit.height = 100;
		p2hit = new Rectangle();
		p2hit.x = 600;
		p2hit.y = 20;
		p2hit.width = 100;
		p2hit.height = 100;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(p1boy, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		p1boy.dispose();
	}
}
