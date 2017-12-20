package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// we are extending game instead of ApplicationAdapter
// this lets of use some of the screen management tools
public class PlatformGame extends Game {
        // we only want 1 sprite batch for the game
        // here it is!
	private SpriteBatch batch;

	
	@Override
	public void create () {
            // initialize the sprite batch
            batch = new SpriteBatch();
            // create the main game screen we want to use
            MainGame game = new MainGame(this);
            // set the screen to show it
            this.setScreen(game);
	}

	@Override
	public void render () {
            // this will automatically call render on the screen that is set
            super.render();
	}
	
	@Override
	public void dispose () {
            // get rid of heavy variables
            batch.dispose();
	}
        
        public SpriteBatch getBatch(){
            // returns the spritebatch so other screens can use it
            return batch;
        }
        
}
