package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MainMenuScreen implements Screen {

    final qdGame game;
    private Texture bgTexture;
    private Texture roundstart;
    private Sound highnoon;
    OrthographicCamera camera;
    public SpriteBatch batch;


    public MainMenuScreen(final qdGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        roundstart = new Texture(Gdx.files.internal("roundstart.bmp"));
        bgTexture = new Texture(Gdx.files.internal("ww.bmp"));
        highnoon  = Gdx.audio.newSound(Gdx.files.internal("highnoon.ogg"));
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        batch.draw(bgTexture,0,0,1920,1080);
        batch.draw(roundstart,200,300,1400,600);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            highnoon.play();
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }
    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
    }
    @Override
    public void hide() {
    }
    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
    @Override
    public void dispose () {
        batch.dispose();
        highnoon.dispose();
        roundstart.dispose();
    }

}