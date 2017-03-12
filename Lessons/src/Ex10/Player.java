package Ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player implements Playable{
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final int FIELD_SIDE = 3;

    private String readConsoleMove(){
        String temp;

        try {
            temp = bufferedReader.readLine();
        }
        catch (IOException ex){
            temp = "-1";
        }
        return temp;
    }

    private int getMove(){
        int result;
        try {
            result = Integer.parseInt(readConsoleMove());
        }
        catch (NumberFormatException ex){
            result = -1;
        }
        return result;
    }

    @Override
    public boolean makeMove(int[][] field) {
        boolean result = false;

        int move = this.getMove();
        if ((move<0)||(move>=field.length)){
            return false;
        }


        return result;
    }
}
