package planets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class InputManager {

    public static void handleInput(OrthographicCamera camera) {

        if (Gdx.input.justTouched()) {
            GameManager.temp.set(Gdx.input.getX(), Gdx.input.getY(), 0);

            camera.unproject(GameManager.temp);
            float touchX = GameManager.temp.x;
            float touchY = GameManager.temp.y;

            handleButtonClick(touchX, touchY);
        }
    }

    public static void handleButtonClick(float touchX, float touchY) {
        if ((touchX >= GameManager.buttonSprite.getX()) && touchX <= (GameManager.buttonSprite.getX() + GameManager.buttonSprite.getWidth()) && (touchY >= GameManager.buttonSprite.getY()) && touchY <= (GameManager.buttonSprite.getY() + GameManager.buttonSprite.getHeight())) {
            GameManager.startPauseGame();
        }
    }
}