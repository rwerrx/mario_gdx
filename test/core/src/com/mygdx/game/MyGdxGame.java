package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    AnimatedSprite mario;

    @Override
    public void create() {
        batch = new SpriteBatch();
        mario = new AnimatedSprite(
                new Texture("mario-spritesheet.png"),
                new Vector2(0, 0)
        );
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && mario.position.y == 0) {
            mario.delta = 100;
        }
//        if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
//            mario.currentFrameY = (mario.currentFrameY + 1) % 4;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && mario.position.x <= Gdx.graphics.getWidth()-100) {
//            mario.position.x += Gdx.graphics.getDeltaTime() * 100;
//        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && mario.position.x >= 0) {
//            mario.position.x -= Gdx.graphics.getDeltaTime() * 100;
//        }

        batch.begin();
        mario.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
