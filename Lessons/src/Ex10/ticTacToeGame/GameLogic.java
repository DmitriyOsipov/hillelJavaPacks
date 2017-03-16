package Ex10.ticTacToeGame;

public class GameLogic {
    private final int PLAYER_VALUE = 1;
    private final int AI_VALUE = 2;
    //private int endGame = -1;

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
    /*
    private void checkResult(){
        endGame = gameField.checkResult();
    }//*/

    public boolean isPlayerWin(){
        return (gameField.checkResult() == PLAYER_VALUE);
    }

    public boolean isAiWin(){
        return (gameField.checkResult() == AI_VALUE);
    }

    public boolean isADraw(){
        return (gameField.checkResult() == 0);
    }

}
