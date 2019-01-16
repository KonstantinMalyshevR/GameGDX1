package planets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Sputnik extends Body {

    private SkyObject skyObject;

    public Sputnik(Texture texture, float width, float height, float radius, float speed) {
        super(texture, width, height, radius, speed);
    }

    public void setMasterPlanet(SkyObject planet) {
        skyObject = planet;
    }

    @Override
    public void update() {
        if (skyObject != null) {
            Sprite sprite = skyObject.getSprite();
            setCenterX(sprite.getX() + sprite.getWidth() / 2);
            setCenterY(sprite.getY() + sprite.getHeight() / 2);
        }

        super.update();
    }
}