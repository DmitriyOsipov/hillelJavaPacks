package Ex10.ticTacToeGame;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private final int PLAYER_VALUE = 1;
    private final int AI_VALUE = 2;

    private GameField gameField;
    private AiGameStrategy aiGameStrategy;

    public GameLogic(){
        gameField = new GameField();
        setAiGameStrategy(new RandomAiGameStrategy());
    }

    public void setAiGameStrategy(AiGameStrategy aiGameStrategy) {
        this.aiGameStrategy = aiGameStrategy;
    }

    public int makeMove(int position){
        if (gameField.makeTurn(position, PLAYER_VALUE)){
            return position;
        }
        return -1;
    }

    public int aiMove(){
        int aiPosition = aiGameStrategy.aiMakeTurn(gameField.getField());
        if (gameField.makeTurn(aiPosition, AI_VALUE)){
            return aiPosition;
        }
        return -1;
    }


    public boolean isPlayerWin(){
        return (gameField.checkResult() == PLAYER_VALUE);
    }

    public boolean isAiWin(){
        return (gameField.checkResult() == AI_VALUE);
    }

    public boolean isADraw(){
        return (gameField.checkResult() == 0);
    }


    private class GameField {
        private int[] field;


        private GameField(){
            field = new int[9];
        }

        public int[] getField() {
            return field;
        }

        private boolean makeTurn(int position, int value){
            boolean result = false;
            if (position>=0 && position<9 && field[position]==0){
                field[position] = value;
                result = true;
            }
            return result;
        }

        public List<Integer> getFreePositions(){
            List<Integer> free = new ArrayList<>();
            for (int i=0; i<field.length; i++) {
                if (field[i]==0){
                    free.add(i);
                }
            }
            return free;
        }

        private boolean isFieldFilled(){
            for (int square: field){
                if (square==0){
                    return false;
                }
            }
            return true;
        }

        private int checkResult(){
            //horizontal check
            for (int i=0; i<field.length-1; i=i+3){
                if ((field[i]>0) && (field[i]==field[i+1]) && (field[i]==field[i+2])){
                    return field[i];
                }
            }
            //vertical check
            for (int i=0; i<3; i++){
                if ((field[i]>0) && (field[i]==field[i+3]) && (field[i]==field[i+6])){
                    return field[i];
                }
            }
            //diagonal check
            if ((field[0]>0) && (field[0] == field[4]) && (field[0]==field[8])){
                return field[4];
            }
            if ((field[2]>0) && (field[2] == field[4]) && (field[2]==field[6])){
                return field[4];
            }
            //draw check
            if (isFieldFilled()){
                return 0;
            }
            //keep going
            return -1;
        }
    }

}
