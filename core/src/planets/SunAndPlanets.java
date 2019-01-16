package planets;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SunAndPlanets extends ApplicationAdapter {

    private SpriteBatch batch;
    private OrthographicCamera camera;

    @Override
    public void create () {

        float height = Gdx.graphics.getHeight();
        float width = Gdx.graphics.getWidth();

        camera = new OrthographicCamera(width,height);
        camera.setToOrtho(false);

        batch = new SpriteBatch();

        GameManager.initialize(width, height);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        InputManager.handleInput(camera);

        batch.begin();
        GameManager.renderGame(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        GameManager.backgroundMusic.stop();
        GameManager.dispose();
    }
}