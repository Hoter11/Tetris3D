package company.roc.tetris3d.View.Activities;

import company.roc.tetris3d.View.Framework.Implementation.AndroidGame;
import company.roc.tetris3d.View.Framework.Screen;
import company.roc.tetris3d.View.GameScreen;

/**
 * Created by roc on 14/07/16.
 */
public class TetrisGame extends AndroidGame {
    @Override
    public Screen getInitScreen() {
        return new GameScreen(this);
    }

}
