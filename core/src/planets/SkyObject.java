package planets;

import com.badlogic.gdx.graphics.Texture;

public class SkyObject extends Body {
    public SkyObject(Texture texture, float centerX, float centerY, float radius, float speed) {
        super(texture, centerX, centerY, radius, speed);
    }
}
