package company.roc.tetris3d.Controller;

import android.app.Application;
import android.content.Context;

import company.roc.tetris3d.Model.Data;

/**
 * Created by roc on 5/07/16.
 */
public class Controller extends Application {

    //instance of the context of the application
    private static Controller instance;
    //Data of the application
    private Data myData = new Data();

    //**************************************** Methods to make possible see the context from everywhere ************************************//
    public static Controller getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
        // or return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
