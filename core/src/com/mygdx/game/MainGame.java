/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * This is a screen. We can create multiple and switch between them in our
 * PlatformGame class. It has a bunch of methods that come with it by default:
 * we really just worry about the render, dispose, and create ones
 *
 * @author lamon
 */
public class MainGame implements Screen {

    // we want to keep track of the game manager
    // this way we could make methods to switch screens!
    private PlatformGame gameManager;
    // our game needs a hero
    private Player p1;
    // our hero needs a place to be in
    private World world;
    //Sprite Batch
    private SpriteBatch batch;
    //camera and viewport
    private OrthographicCamera camera;
    private Viewport view;
    //game units
    private final int HEIGHT = 600;
    private final int WIDTH = 800;

    // the constructor for our maingame needs to know what made it
    // this is what the game variable is
    public MainGame(PlatformGame game) {
        // we save this so we can talk to it later
        this.gameManager = game;
        // create our new player at 100,100
        p1 = new Player(100, 100);
        // generate the world
        world = new World();
        //initialize the spirte Batch
        this.batch = game.getBatch();

        //set up the camera and view
        this.camera = new OrthographicCamera(WIDTH,HEIGHT);
        
        this.view = new FitViewport(WIDTH, HEIGHT, camera);
        // move the camera to the centrec
        this.camera.position.set(WIDTH/2,HEIGHT/2, 0);
        //make sure to apply the changes
        this.camera.update();
    }

    @Override
    public void show() {
        // this would be what happens when the game wakes up from being hidden
        // i.e. when you minimized the game and reopenned it
    }

    // the main game loop for this screen
    @Override
    public void render(float deltaTime) {
        // update the player
        p1.update(deltaTime);

        // check for collisions and fix them
        for (Rectangle block : world.getBlocks()) {
            p1.fixCollision(block);
        }


        // clears the screen in a black colour
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // ask the world to render
        // notice this is not in the SpriteBatch
        // This is because it uses its own ShapeRenderer
        world.render(camera);
        
        camera.position.set(p1.getX(),p1.getY(),0);
        camera.update();
        
        batch.setProjectionMatrix(camera.combined);
        
        // ask the SpriteBatch to start taking notes of what to draw
        batch.begin();
        // ask the player to draw themself
        p1.render(batch);
        // tell the SpriteBatch we are good to draw everything now
        batch.end();
    }

    // used when the window is resized.... we haven't use it here
    @Override
    public void resize(int width, int height) {
    }

    // if the game could pause, what do you need to happen?
    @Override
    public void pause() {
    }

    // when the game is unpaused, what do you need to happen?
    @Override
    public void resume() {
    }

    // when the game needs to be minimized, what needs to happen?
    @Override
    public void hide() {
    }

    // get rid of heavy objects...
    @Override
    public void dispose() {
    }
}
