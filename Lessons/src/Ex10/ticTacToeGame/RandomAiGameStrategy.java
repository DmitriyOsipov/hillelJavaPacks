package Ex10.ticTacToeGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mtzadmin on 16.03.2017.
 */
public class RandomAiGameStrategy implements AiGameStrategy{

    public RandomAiGameStrategy(){

    }

    @Override
    public int aiMakeTurn(int[] field){
        int moveInd=-1;

        List<Integer> freePos = new ArrayList();
        for (int i=0; i<field.length; i++){
            if (field[i]==0){
                freePos.add(i);
            }
        }
        if (freePos.size()>0) {
            Random random = new Random();
            moveInd = freePos.get(random.nextInt(freePos.size()));
        }

        return moveInd;
    }
}
