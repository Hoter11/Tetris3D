package company.roc.tetris3d.View;

import company.roc.tetris3d.View.Framework.Game;
import company.roc.tetris3d.View.Framework.Graphics;
import company.roc.tetris3d.View.Framework.Graphics.ImageFormat;
import company.roc.tetris3d.View.Framework.Screen;

/**
 * Created by roc on 14/07/16.
 */
public class LoadingScreen extends Screen {

    public LoadingScreen(Game game){
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("menu.jpg", ImageFormat.RGB565);
        Assets.click = game.getAudio().createSound("explode.ogg");

        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void paint(float deltaTime) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void dispose() { }

    @Override
    public void backButton() { }
}
