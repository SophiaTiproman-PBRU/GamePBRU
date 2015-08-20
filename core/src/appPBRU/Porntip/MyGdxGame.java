package appPBRU.Porntip;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Texture myTexture, myTexture2, myWallpaper;	//texture >> picture<< not image
	private int xAnInt;
	private boolean statusABoolean = true;


	//setup
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		myTexture = new Texture("lotus1.png");
		myTexture2 = new Texture("cloud.png");
		myWallpaper = new Texture("wallpapers_a_04a.png");
	}

	//render กระพริบตลอดเวลา
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		//batch.draw(img, 0, 0);
		//Draw Wallpaper
		batch.draw(myWallpaper, 0, 0);

		batch.draw(myTexture, 0, 0);
		batch.draw(myTexture2, xAnInt, 450);
		batch.end();

		//Increase
		//xAnInt += 100 * Gdx.graphics.getDeltaTime();

		//ทำให้ cloud ไปกลับ
		if (statusABoolean) {
			//Increase xAnInt
			if (xAnInt < 1184-263) {
				xAnInt += 100 * Gdx.graphics.getDeltaTime();
			} else {
				statusABoolean = !statusABoolean;
			}
		} else {
			//Decrease xAnInt
			if (xAnInt > 0) {
				xAnInt -= 100 * Gdx.graphics.getDeltaTime();
			} else {
				statusABoolean = !statusABoolean;
			}
		}

	}	//render
}
