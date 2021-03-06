package company.roc.tetris3d.View;

import java.util.List;

import company.roc.tetris3d.View.Framework.Game;
import company.roc.tetris3d.View.Framework.Graphics;
import company.roc.tetris3d.View.Framework.Input;
import company.roc.tetris3d.View.Framework.Input.TouchEvent;
import company.roc.tetris3d.View.Framework.Screen;

/**
 * Created by roc on 14/07/16.
 */
public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);
    }


    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, g.getHeight()/2, g.getWidth()/2, 250, 250)) {
                    //START GAME
                    game.setScreen(new GameScreen(game));
                }
            }
        }
    }


    private boolean inBounds(TouchEvent event, int x, int y, int width,
                             int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }


    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(Assets.menu, g.getHeight()/2, g.getWidth()/2);
    }


    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void dispose() { }

    @Override
    public void backButton() {
        //Display "Exit Game?" Box
    }
}