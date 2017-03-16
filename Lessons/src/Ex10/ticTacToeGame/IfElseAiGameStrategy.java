package Ex10.ticTacToeGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IfElseAiGameStrategy implements AiGameStrategy{

    @Override
    public int aiMakeTurn(int[] field) {
        int move = -1;
        if (field[4]==0){
            move = 4;
        }
        else if ((move=tryAngle(field))==-1){
            move = tryLine(field);
        }

        return move;
    }

    private int tryLine(int[] field){
        int move=-1;
        List<Integer> moves = new ArrayList<Integer>();
        for(int i=1; i<field.length; i+=2) {
            if (field[i]==0){
                moves.add(i);
            }
        }
        if (!moves.isEmpty()){
            Random random = new Random();
            int moveId = random.nextInt(moves.size());
            move = moves.get(moveId);
        }

        return move;
    }


    private int tryAngle(int[] field){
        int move = -1;
        List<Integer> moves = new ArrayList<Integer>();
        for (int i=0; i<3; i+=2){
            if (field[i]==0){
                moves.add(i);
            }
            if (field[i+6]==0){
                moves.add(i+6);
            }
        }
        if (!moves.isEmpty()){
            Random random = new Random();
            int moveId = random.nextInt(moves.size());
            move = moves.get(moveId);
        }
        return move;
    }
}
