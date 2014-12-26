/**
 * File name:	MenuScreen.java
 * Version:		1.0
 * Date:		25/12/2014 17:02:27
 * Author:		Sawan J. Kapai Harpalani
 * Copyright:	Copyright 200X Sawan J. Kapai Harpalani
 *
 *				This file is part of Math Attack.
 *
 *				Math Attack is free software: you can redistribute it 
 *				and/or modify it under the terms of the GNU General
 *				Public License as published by the Free Software 
 *				Foundation, either version 3 of the License, 
 *				or (at your option) any later version.
 *
 *				Math Attack is distributed in the hope that it will 
 *				be useful, but WITHOUT ANY WARRANTY; without even 
 *				the implied warranty of MERCHANTABILITY or FITNESS 
 *				FOR A PARTICULAR PURPOSE. See the GNU General Public
 *			    License for more details.
 *
 *				You should have received a copy of the GNU General 
 *				Public License along with Math Attack. If not, see 
 *				http://www.gnu.org/licenses/.
 */
package com.sawan.mathattack.screen.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.sawan.mathattack.camera.OrthoCamera;
import com.sawan.mathattack.screen.Screen;

/**
 * The Class MenuScreen.
 *
 * @author Sawan J. Kapai Harpalani
 */
public class MenuScreen extends Screen {
	
	private OrthoCamera camera;

	private final static String BACKGROUND = "menu_back.jpg";
	
	private Texture background_image;
	
	private Sprite sprite_background;
	
	private Stage menu_screen_stage;
	
	
	public class MyActor extends Actor {
        Texture texture = new Texture(Gdx.files.internal("0.png"));
        float actorX = 0, actorY = 0;
        public boolean started = false;

        public MyActor(){
            setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
            addListener(new InputListener(){
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    ((MyActor)event.getTarget()).started = true;
                    return true;
                }
            });
        }
        
        
        @Override
        public void draw(Batch batch, float alpha){
            batch.draw(texture,actorX,actorY);
        }
        
        @Override
        public void act(float delta){
            if(started){
                actorX+=5;
            }
        }
    }
	
	
	
	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#create()
	 */
	@Override
	public void create() {
		camera = new OrthoCamera();
		background_image = new Texture(BACKGROUND);
		sprite_background = new Sprite(background_image);
		menu_screen_stage = new Stage();
		Gdx.input.setInputProcessor(menu_screen_stage);
		
		MyActor hero = new MyActor();
		hero.setTouchable(Touchable.enabled);
		menu_screen_stage.addActor(hero);
		}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#render(com.badlogic.gdx.graphics.g2d.SpriteBatch)
	 */
	@Override
	public void render(SpriteBatch sprite_batch) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sprite_batch.begin();
		//sprite_batch.draw(sprite_background, 0, 0, camera.viewportWidth, camera.viewportHeight);
	    menu_screen_stage.act(Gdx.graphics.getDeltaTime());
	    menu_screen_stage.draw();
		sprite_batch.end();
	}

	

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#resize(int, int)
	 */
	@Override
	public void resize(int width, int height) {
		camera.resize();
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#dispose()
	 */
	@Override
	public void dispose() {
		
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#hide()
	 */
	@Override
	public void hide() {
		
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#pause()
	 */
	@Override
	public void pause() {
		
	}

	/* (non-Javadoc)
	 * @see com.sawan.mathattack.screen.Screen#resume()
	 */
	@Override
	public void resume() {
		
	}

	@Override
	public void update() {
		//camera.update();
	}

}
