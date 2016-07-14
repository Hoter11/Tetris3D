package company.roc.tetris3d.View.Framework.Implementation;

import android.view.View;

import java.util.List;

import company.roc.tetris3d.View.Framework.Input;

/**
 * Created by roc on 14/07/16.
 */
public interface TouchHandler extends View.OnTouchListener {

    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<Input.TouchEvent> getTouchEvents();

}
