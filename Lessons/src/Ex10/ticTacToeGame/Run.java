package Ex10.ticTacToeGame;

public class Run {
    private GameLogic gameLogic;

    public Run(){
        gameLogic = new GameLogic();
    }

    public int makeMove(int playerMove){
        int aiMove = -1;

        gameLogic.makeMove(playerMove);

        if (!gameLogic.isADraw()){
            aiMove = gameLogic.aiMove();
        }

        return aiMove;
    }

    public String changeAiStrategy(int id){
        String strategyName;
        switch (id){
            case 1:{
                gameLogic.setAiGameStrategy(new IfElseAiGameStrategy());
                strategyName = IfElseAiGameStrategy.class.getName();
            }break;
            default:{
                gameLogic.setAiGameStrategy(new RandomAiGameStrategy());
                strategyName = IfElseAiGameStrategy.class.getName();
            };
        }
        return strategyName;
    }


    public int checkResult(){
        if (gameLogic.isPlayerWin()){
            return Integer.MAX_VALUE;
        }
        if (gameLogic.isAiWin()){
            return Integer.MIN_VALUE;
        }
        if (gameLogic.isADraw()){
            return 0;
        }
        return -1;
    }
}
