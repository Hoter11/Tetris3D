package company.roc.tetris3d.Model;

import java.io.Serializable;
import java.sql.Array;

/**
 * Created by roc on 28/08/16.
 */
public class GameData implements Serializable{

    private String [] BLANK_LINE = new String[] {"w","w","w","w","w","w","w","w","w"};

    private int puntuation;
    private String[][] map;

    public GameData(){
        this.puntuation = 0;
        this.map = new String[][] {BLANK_LINE, BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,
                BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,BLANK_LINE,new String[] {"w","w","w","w","w","w","b","g","r"}};
    }

    public void setCel(int x, int y, String newString){
        System.out.println(map[x][y]);
        this.map[x][y] = newString;
    }

    public void printMap(){
        String str = "";
        for (int j=0; j < 21; j++) {
            for (int i = 0; i < 9; i++) {
                str+=map[j][i];
            }
            str+="\n";
        }
        System.out.println("---------------------------------");
        System.out.println(str);
    }

    public String [][] getMap(){return map;}
}
