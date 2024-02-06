package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class AnimatedSprite {
    public final float FRAME_DURATION = 0.1f;
    public Vector2 position;
    public TextureRegion[][] frames;
    public int currentFrameX = 0;
    public int currentFrameY = 0;
    public float frame_duration = 0;
    public float delta = -100;
    public AnimatedSprite(Texture texture, Vector2 position) {
        this.position = position;
        int w = texture.getWidth() / 4;
        int h = texture.getHeight() / 4;
        frames = TextureRegion.split(texture, w, h);

    }
    public void draw(SpriteBatch batch) {
        frame_duration += Gdx.graphics.getDeltaTime();
        if (frame_duration > FRAME_DURATION){
            currentFrameX = (currentFrameX + 1) % 4;
            frame_duration -= FRAME_DURATION;

        }
        batch.draw(frames[currentFrameY][currentFrameX], position.x, position.y);
        delta = Math.max(delta - 1, -100);
        position.y += delta * Gdx.graphics.getDeltaTime();
        if (position.y < 0) {
            position.y = 0;

        }}
}
