/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author lamon
 */
public class World {
    // an array of rectangles to create the look of the level
    private Rectangle[] blocks;
    // since we dont have a picture to draw, we can use a shaperenderer
    // this guy allows us to draw primitive shapes to the screen like in grade 11
    // it cannot be used INSIDE of the spritebatch commands
    private ShapeRenderer shape;
    
    public World(){
        // only create 2 rectangles....
        blocks = new Rectangle[2];
        // here are the 2 blocks
        blocks[0] = new Rectangle(300, 150, 20, 100);
        blocks[1] = new Rectangle(700, 300, 100, 20);
        // initialize the shaperenderer
        shape = new ShapeRenderer();
    }
    
    public void render(OrthographicCamera camera){
        shape.setProjectionMatrix(camera.combined);
        // shaperenderer works like the spritebatch
        // we tell it if we want it as an outline or filled shape
        shape.begin(ShapeRenderer.ShapeType.Filled);
        // go through every block
        for (int i = 0; i < blocks.length; i++) {
            // draw the block
            shape.rect(blocks[i].x, blocks[i].y, blocks[i].width, blocks[i].height);
        }
        // tell the shape renderer that we are done drawing shapes
        shape.end();
    }
    
    // returns the blocks from the world
    public Rectangle[] getBlocks(){
        return blocks;
    }
}
