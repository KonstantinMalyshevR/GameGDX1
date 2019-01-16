package planets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameManager {

    private static final float PLANET_RESIZE_FACTOR = 6500f;
    private static final float BUTTON_RESIZE_FACTOR = 4500f;
    private static final float LUNA_RESIZE_FACTOR = 7500f;

    static Vector3 temp = new Vector3();

    private static Texture backgroundTexture;
    private static Sprite backgroundSprite;

    private static Texture buttonTexture;
    public static Sprite buttonSprite;

    private static SkyObject sun;
    private static Texture sunTexture;

    private static SkyObject planetOne;
    private static Texture planetOneTexture;

    private static SkyObject planetTwo;
    private static Texture planetTwoTexture;

    private static Sputnik sputnik;
    private static Texture sputnikTexture;

    public static Music backgroundMusic;
    private static boolean isPlay = false;

    public static void initialize(float width, float height) {
        backgroundTexture = new Texture(Gdx.files.internal("space.jpg"));
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setSize(width, height);

        buttonTexture = new Texture(Gdx.files.internal("start-pause.jpg"));
        buttonSprite = new Sprite(buttonTexture);
        buttonSprite.setSize(buttonSprite.getWidth() * (width / BUTTON_RESIZE_FACTOR), buttonSprite.getHeight() * (width / BUTTON_RESIZE_FACTOR));
        buttonSprite.setPosition(10.0f, 10.0f);

        float centerX = width / 2;
        float centerY = height / 2;

        sunTexture = new Texture(Gdx.files.internal("sun.png"));
        sun = new SkyObject(sunTexture, centerX, centerY, 0, 0.0f);
        sun.getSprite().setSize(sun.getSprite().getWidth() * (width / PLANET_RESIZE_FACTOR), sun.getSprite().getHeight() * (width / PLANET_RESIZE_FACTOR));

        planetOneTexture = new Texture(Gdx.files.internal("planet12.png"));
        planetOne = new SkyObject(planetOneTexture, centerX, centerY, 400, 0.02f);
        planetOne.getSprite().setSize(planetOne.getSprite().getWidth() * (width / PLANET_RESIZE_FACTOR), planetOne.getSprite().getHeight() * (width / PLANET_RESIZE_FACTOR));

        planetTwoTexture = new Texture(Gdx.files.internal("planet11.png"));
        planetTwo = new SkyObject(planetTwoTexture, centerX, centerY, 250, 0.04f);
        planetTwo.getSprite().setSize(planetTwo.getSprite().getWidth() * (width / PLANET_RESIZE_FACTOR), planetTwo.getSprite().getHeight() * (width / PLANET_RESIZE_FACTOR));

        sputnikTexture = new Texture(Gdx.files.internal("LUNA.png"));
        sputnik = new Sputnik(sputnikTexture, centerX, centerY, 100, 0.1f);
        sputnik.getSprite().setSize(sputnik.getSprite().getWidth() * (width / LUNA_RESIZE_FACTOR), sputnik.getSprite().getHeight() * (width / LUNA_RESIZE_FACTOR));
        sputnik.setMasterPlanet(planetOne);

        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.play();

        isPlay = true;
    }

    public static void startPauseGame() {
        if (isPlay) {
            backgroundMusic.pause();
            isPlay = false;
        } else {
            backgroundMusic.play();
            isPlay = true;
        }
    }

    public static void renderGame(SpriteBatch batch) {
        backgroundSprite.draw(batch);
        buttonSprite.draw(batch);

        sun.render(batch);
        planetOne.render(batch);
        planetTwo.render(batch);
        sputnik.render(batch);

        if (isPlay) {
            sun.update();
            planetOne.update();
            planetTwo.update();
            sputnik.update();
        }
    }

    public static void dispose() {
        backgroundTexture.dispose();
        buttonTexture.dispose();
        sunTexture.dispose();
        planetOneTexture.dispose();
        planetTwoTexture.dispose();
        sputnikTexture.dispose();
        backgroundMusic.dispose();
    }
}