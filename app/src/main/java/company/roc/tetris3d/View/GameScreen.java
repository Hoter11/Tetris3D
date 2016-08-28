package company.roc.tetris3d.View;


import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.DragEvent;

import company.roc.tetris3d.Controller.Controller;
import company.roc.tetris3d.Model.GameData;
import company.roc.tetris3d.R;
import company.roc.tetris3d.View.Framework.Game;
import company.roc.tetris3d.View.Framework.Graphics;
import company.roc.tetris3d.View.Framework.Image;
import company.roc.tetris3d.View.Framework.Screen;
import company.roc.tetris3d.View.Framework.Input.TouchEvent;

/**
 * Created by roc on 14/07/16.
 */
public class GameScreen extends Screen implements SensorEventListener{

    private static final int LEFT = 50;
    private static final int RIGHT = 500;
    private static final int TOP = 100;
    private static final int BOTTOM = 1160;

    enum GameState {
        Ready, Running, Paused, GameOver
    }

    GameState state = GameState.Ready;
    GameData gameData;

    // Variable Setup
    // You would create game objects here.

    int livesLeft = 1;
    Paint paint;

    public GameScreen(Game game) {
        super(game);

        // Initialize game objects here
        gameData = new GameData();
        // Defining a paint object
        paint = new Paint();
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);

        //Sensor management
        sensorManager=(SensorManager) Controller.getContext().getSystemService(Controller.getContext().SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        // We have four separate update methods in this example.
        // Depending on the state of the game, we call different update methods.
        // Refer to Unit 3's code. We did a similar thing without separating the
        // update methods.

        if (state == GameState.Ready)
            updateReady(touchEvents);
        if (state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if (state == GameState.Paused)
            updatePaused(touchEvents);
        if (state == GameState.GameOver)
            updateGameOver(touchEvents);
    }

    private void updateReady(List<TouchEvent> touchEvents) {

        // This example starts with a "Ready" screen.
        // When the user touches the screen, the game begins.
        // state now becomes GameState.Running.
        // Now the updateRunning() method will be called!

        if (touchEvents.size() > 0)
            state = GameState.Running;
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {

        //This is identical to the update() method from our Unit 2/3 game.


        // 1. All touch input is handled here:
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);

            if (event.type == TouchEvent.TOUCH_DOWN) {
                System.out.println("X: "+event.x+" | Y: "+event.y);
                System.out.println("Values: "+ax+" "+ay+" "+az);
                if (event.x < 640) {
                    // Move left.
                }

                else if (event.x > 640) {
                    // Move right.
                }

            }

            if (event.type == TouchEvent.TOUCH_UP) {

                if (event.x < 640) {
                    // Stop moving left.
                }

                else if (event.x > 640) {
                    // Stop moving right. }
                }
            }


        }

        // 2. Check miscellaneous events like death:

        if (livesLeft == 0) {
            state = GameState.GameOver;
        }


        // 3. Call individual update() methods here.
        // This is where all the game updates happen.
        // For example, robot.update();
    }

    private void updatePaused(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {

            }
        }
    }

    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (event.x > 300 && event.x < 980 && event.y > 100
                        && event.y < 500) {
                    nullify();
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();

        // First draw the game elements.

        // Example:
        // g.drawImage(Assets.background, 0, 0);
        // g.drawImage(Assets.character, characterX, characterY);

        // Secondly, draw the UI above the game elements.
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI();
        if (state == GameState.Paused)
            drawPausedUI();
        if (state == GameState.GameOver)
            drawGameOverUI();

    }

    private void nullify() {

        // Set all variables to null. You will be recreating them in the
        // constructor.
        paint = null;

        // Call garbage collector to clean up memory.
        System.gc();
    }

    private void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.clearScreen(Controller.getContext().getResources().getColor(R.color.whiteManhattan));

        if (Controller.getContext().getResources().getConfiguration().orientation == Controller.getContext().getResources().getConfiguration().ORIENTATION_PORTRAIT) {
            //Pieces to use
            g.drawRect(575, 900, 200, 200, Color.GREEN);
            g.drawRect(575, 600, 200, 200, Color.BLUE);
            g.drawRect(575, 300, 200, 200, Color.RED);
            //Map
            //g.drawRect(LEFT,TOP,RIGHT,BOTTOM,Color.BLACK);
            //Quads
            updateMap(g);

            /*
            //Vertical lines
            g.drawLine(LEFT, TOP, LEFT, BOTTOM, Color.BLACK);
            g.drawLine(RIGHT, TOP, RIGHT, BOTTOM, Color.BLACK);
            //Horizontal lines
            g.drawLine(LEFT, TOP, RIGHT, TOP, Color.BLACK);
            g.drawLine(LEFT, BOTTOM, RIGHT, BOTTOM, Color.BLACK);*/
        }else{
            g.drawRect(300, 575, 200, 200, Color.GREEN);
            g.drawRect(600, 575, 200, 200, Color.BLUE);
            g.drawRect(900, 575, 200, 200, Color.RED);
            //Vertical lines
            g.drawLine(TOP, RIGHT, TOP, LEFT, Color.BLACK);
            g.drawLine(BOTTOM, RIGHT, BOTTOM, LEFT, Color.BLACK);
            //Horizontal lines
            g.drawLine(TOP, RIGHT, BOTTOM, RIGHT, Color.BLACK);
            g.drawLine(TOP, LEFT, BOTTOM, LEFT, Color.BLACK);
        }

    }

    private void drawRunningUI() {
        Graphics g = game.getGraphics();

    }

    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        // Darken the entire screen so you can display the Paused screen.
        g.drawARGB(155, 0, 0, 0);

    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();
        g.drawRect(0, 0, 1281, 801, Color.BLACK);
        g.drawString("GAME OVER.", 640, 300, paint);

    }

    @Override
    public void pause() {
        if (state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
        pause();
    }

    public void updateMap(Graphics g){
        String cell;
        for (int j=0; j < 21; j++){
            for (int i=0; i < 9; i++){
                cell = gameData.getMap()[j][i];
                switch(cell){
                    case "w":
                        g.drawRect(LEFT+5+i*55,TOP+5+j*55,50,50,Color.BLACK);
                        break;
                    case "r":
                        g.drawRect(LEFT+5+i*55,TOP+5+j*55,50,50,Color.RED);
                        break;
                    case "b":
                        g.drawRect(LEFT+5+i*55,TOP+5+j*55,50,50,Color.BLUE);
                        break;
                    case "g":
                        g.drawRect(LEFT+5+i*55,TOP+5+j*55,50,50,Color.GREEN);
                        break;
                }


            }
        }
    }


    //********************************************** SENSOR MANAGEMENT *********************************************************//
    private SensorManager sensorManager;
    double ax,ay,az;   // these are the acceleration in x,y and z axis

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            ax=event.values[0];
            ay=event.values[1];
            az=event.values[2];
            if (ax < -5){
                gameData.setCel(16,6,"r");
                gameData.printMap();
            }
            else if (ax > 5){
                gameData.setCel(3,6,"b");
                gameData.printMap();
            }

        }
    }
}
