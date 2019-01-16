package planets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Body {
    private Sprite sprite;

    private float radius;
    private float alpha;
    private float speed;

    private float centerX;
    private float centerY;

    public Body(Texture texture, float centerX, float centerY, float radius, float speed) {

        sprite = new Sprite(texture);
        setCenterX(centerX);
        setCenterY(centerY);

        this.radius = radius;
        alpha = 0f;
        this.speed = speed;
    }

    public void update() {
        alpha = alpha + speed;
        float x = (radius * MathUtils.cos(alpha)) + centerX - sprite.getWidth() / 2;
        float y = (radius * MathUtils.sin(alpha)) + centerY - sprite.getHeight() / 2;
        sprite.setPosition(x, y);
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public Sprite getSprite() {
        return sprite;
    }
}