package company.roc.tetris3d.View;

import company.roc.tetris3d.View.Framework.Implementation.AndroidGame;
import company.roc.tetris3d.View.Framework.Screen;

/**
 * Created by roc on 14/07/16.
 */
public class TetrisGame extends AndroidGame {
    @Override
    public Screen getInitScreen() {
        return new LoadingScreen(this);
    }

    @Override
    public void onBackPressed() {
        getCurrentScreen().backButton();
    }
}
