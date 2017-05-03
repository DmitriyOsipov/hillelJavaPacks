package com.lessons.Ex10.ticTacToeGame;

public class GameLogicWork {
    private GameLogic gameLogic;

    public GameLogicWork(){
        gameLogic = new GameLogic();
    }

    public int makeMove(int playerMove){
        int aiMove = -1;

        gameLogic.makeMove(playerMove);

        if (!gameLogic.isADraw() && !gameLogic.isPlayerWin()){
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
                strategyName = RandomAiGameStrategy.class.getName();
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
