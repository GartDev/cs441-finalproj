package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class qdGame extends ApplicationAdapter {
	private Texture p1boy;
	private Texture p2boy;
	private Texture bgTexture;
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		p1boy = new Texture("cowboy.bmp");
		p2boy = new Texture("cowboy2.bmp");
		bgTexture = new Texture("ww.bmp");
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
