package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameScreen implements Screen {
    private Texture p1boy;
    private Texture p2boy;
    private Texture bgTexture;
    private Texture roundstart;
    private Sound p1shot;
    private Sound p2shot;
    private Sound highnoon;
    private OrthographicCamera camera;
    public SpriteBatch batch;
    //	private SpriteBatch gamebatch;
    private Rectangle p1hit;
    private Rectangle p2hit;
    private float ttb;


    public GameScreen(final qdGame game) {
        //sprites
        p1boy = new Texture(Gdx.files.internal("cowboy.bmp"));
        p2boy = new Texture(Gdx.files.internal("cowboy2.bmp"));
        bgTexture = new Texture(Gdx.files.internal("ww.bmp"));
        roundstart = new Texture(Gdx.files.internal("roundstart.bmp"));
        //Sounds
        p1shot  = Gdx.audio.newSound(Gdx.files.internal("intervention_fire.ogg"));
        p2shot  = Gdx.audio.newSound(Gdx.files.internal("revolver_fire.ogg"));
        highnoon  = Gdx.audio.newSound(Gdx.files.internal("highnoon.ogg"));
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
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(p1boy, 100, 175);
        batch.draw(p2boy, 1400, 175);
        batch.end();
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
    }
}
