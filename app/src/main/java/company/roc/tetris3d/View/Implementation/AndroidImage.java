package company.roc.tetris3d.View.Implementation;

import android.graphics.Bitmap;

import company.roc.tetris3d.View.Framework.Graphics.ImageFormat;
import company.roc.tetris3d.View.Framework.Image;

/**
 * Created by roc on 14/07/16.
 */
public class AndroidImage implements Image {
    Bitmap bitmap;
    ImageFormat format;

    public AndroidImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}