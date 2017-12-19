/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author lamon
 */
public class MainGame implements Screen{

    private PlatformGame game;
    Player p1;
    
    public MainGame(PlatformGame game){
        this.game = game;
        p1 = new Player(100,100);
        
    }
    
    @Override
    public void show() {
        
    }

    @Override
    public void render(float deltaTime) {
        // update the player
        p1.update(deltaTime);
        
        // get the SpriteBatch from the Game
        SpriteBatch batch = game.getBatch();
        
        //draw the player
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	batch.begin();
	
        p1.render(batch);
        
	batch.end();
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

    @Override
    public void dispose() {
        
    }
    
}
