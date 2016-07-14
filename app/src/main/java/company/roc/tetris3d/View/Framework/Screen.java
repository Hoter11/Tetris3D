package company.roc.tetris3d.View.Framework;

/**
 * Created by roc on 14/07/16.
 */
public abstract class Screen {

    protected  final Game game;

    public Screen(Game game){
        this.game = game;
    }

    public abstract void update(float deltaTime);

    public abstract void paint(float deltaTime);

    public abstract void pause();

    public abstract void resume();

    public abstract void dispose();

    public abstract void backButton();

}
