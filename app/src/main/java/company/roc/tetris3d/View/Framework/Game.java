package company.roc.tetris3d.View.Framework;

/**
 * Created by roc on 14/07/16.
 */
public interface Game {
    public Audio getAudio();
    public Input getInput();
    public FileIO getFileIO();
    public Graphics getGraphics();
    public void setScreen(Screen screen);
    public Screen getCurrentScreen();
    public Screen getInitScreen();
}
