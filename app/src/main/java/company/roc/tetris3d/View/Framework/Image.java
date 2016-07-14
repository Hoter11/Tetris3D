package company.roc.tetris3d.View.Framework;

import company.roc.tetris3d.View.Framework.Graphics.ImageFormat;

/**
 * Created by roc on 14/07/16.
 */
public interface Image {

    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}
