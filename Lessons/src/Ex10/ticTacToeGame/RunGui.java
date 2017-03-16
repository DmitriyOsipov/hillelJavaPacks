package Ex10.ticTacToeGame;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class RunGui extends Application{
    List<Button> buttons;
    GameLogicWork gameLogicWorkGame = new GameLogicWork();

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Tic-tac-toe");
        primaryStage.setWidth(360);
        primaryStage.setHeight(450);
        primaryStage.setResizable(false);

        Pane rootPane = new Pane();
        Scene scene = new Scene(rootPane);
        buttons = createButtons();

        rootPane.getChildren().add(createLabel());
        rootPane.getChildren().add(createComboBox());
        rootPane.getChildren().addAll(buttons);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private Control createComboBox(){
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().add("Random strategy");
        comboBox.getItems().add("If-Else strategy");
        comboBox.getSelectionModel().selectFirst();
        comboBox.setTranslateX(100);
        comboBox.setTranslateY(30);

        comboBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String aiStrategy = gameLogicWorkGame.changeAiStrategy(newValue.intValue());
                showMessage(aiStrategy);
            }
        });

        return comboBox;
    }


    private Control createLabel(){
        Label label = new Label("Choose AI Strategy");
        label.setTranslateX(100);
        return label;
    }

    private List<Button> createButtons(){
        List<Button> buttons = new ArrayList<>();
        int startX = 10;
        int startY = 100;
        Font btnFont = new Font("Arial", 55);

        int counter = 0;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++) {
                Button button = new Button();
                button.setTranslateX(startX + j*100 + 15);
                button.setTranslateY(startY + i*100 + 15);
                button.setPrefSize(100, 100);
                final int value = counter;

                button.setFont(btnFont);
                //button.setText(String.valueOf(value));
                button.setOnAction(event -> {
                    clickButton(value);
                });

                buttons.add(button);
                counter++;
            }
        }
        return buttons;
    }

    private void clickButton(int value){
        playerMove(value);
        checkResult();
        gameTurn(value);
        checkResult();
    }

    private void checkResult() {
        switch (gameLogicWorkGame.checkResult()){
            case Integer.MAX_VALUE: {
                showEndMessage("You win!");
            }break;
            case Integer.MIN_VALUE:{
                showEndMessage("AI win!");
            }break;
            case 0:{
                showEndMessage("Draw!");
            }break;
            default:{};
        }
    }

    private void showEndMessage(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game over");
        alert.setContentText(text);
        alert.setHeaderText(null);
        alert.showAndWait();
        System.exit(0);
    }

    private void showMessage(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("AI strategy changed");
        alert.setContentText("New strategy is " + text);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void playerMove(int value){
        changeButton(value, "X", "red");
    }

    private void gameTurn(int playerPosition){
        int result = gameLogicWorkGame.makeMove(playerPosition);
        if (result>=0 && result<buttons.size()) {
            changeButton(result, "O", "green");
        }
    }

    private void changeButton(int id, String text, String color){
        Button clickedButton = buttons.get(id);
        clickedButton.setTextFill(Paint.valueOf(color));
        clickedButton.setText(text);
        clickedButton.setDisable(true);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
