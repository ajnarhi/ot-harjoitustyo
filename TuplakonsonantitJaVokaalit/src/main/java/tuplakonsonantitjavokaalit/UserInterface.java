/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuplakonsonantitjavokaalit;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ajnarhi
 */
public class UserInterface extends Application {

    @Override
    public void start(Stage window) {

        Question question1 = new Question("Tien yli kulki ...", "kissa", "kisa");
        Player player1 = new Player(0);

        window.setTitle("Harjoitus");

        //otsikot
        Label label = new Label("Harjoitellaan tuplakonsonantteja ja - vokaaleja");
        Label labelGreat = new Label("Oikein! Hienoa. Pisteesi: " + player1.getPoints());
        Label labelWrong = new Label("Väärin. Kokeile uudestaan. Pisteesi: " + player1.getPoints());
        Label labelQuestion = new Label(question1.ask());

        //napit
        Button buttonLetsBegin = new Button("Aloita!");
        Button buttonFirstChoice = new Button(question1.getRightAnswer());
        Button buttonSecondChoice = new Button(question1.getOptionalAnswer());
        Button buttonNewQuestion1 = new Button("Uusi kysymys");
        Button buttonNewQuestion2 = new Button("Uusi kysymys");
        Button buttonQuit1 = new Button("Lopeta");
        Button buttonQuit2 = new Button("Lopeta");

        BorderPane settingWelcome = new BorderPane();
        settingWelcome.setTop(label);
        settingWelcome.setCenter(buttonLetsBegin);
        Scene sceneWelcome = new Scene(settingWelcome);

        BorderPane settingQuestion = new BorderPane();
        settingQuestion.setTop(labelQuestion);
        settingQuestion.setLeft(buttonFirstChoice);
        settingQuestion.setRight(buttonSecondChoice);
        Scene sceneQuestion = new Scene(settingQuestion);

        BorderPane settingRightAnswer = new BorderPane();
        settingRightAnswer.setTop(labelGreat);
        settingRightAnswer.setCenter(buttonNewQuestion1);
        settingRightAnswer.setRight(buttonQuit1);
        Scene sceneRightAnswer = new Scene(settingRightAnswer);

        BorderPane settingWrongAnswer = new BorderPane();
        settingWrongAnswer.setTop(labelWrong);
        settingWrongAnswer.setCenter(buttonNewQuestion2);
        settingWrongAnswer.setRight(buttonQuit2);
        Scene sceneWrongAnswer = new Scene(settingWrongAnswer);

        buttonLetsBegin.setOnAction((event) -> {
            window.setScene(sceneQuestion);
        });
        buttonFirstChoice.setOnAction((event) -> {
            player1.increasePoints();
            settingRightAnswer.setTop(new Label("Oikein! Hienoa. Pisteesi: " + player1.getPoints()));
            window.setScene(sceneRightAnswer);

        });
        buttonSecondChoice.setOnAction((event) -> {
            player1.decreasePoints();
            settingWrongAnswer.setTop(new Label("Väärin. Kokeile uudestaan. Pisteesi: " + player1.getPoints()));
            window.setScene(sceneWrongAnswer);

        });

        buttonNewQuestion1.setOnAction((event) -> {
            window.setScene(sceneQuestion);
        });

        buttonNewQuestion2.setOnAction((event) -> {
            window.setScene(sceneQuestion);
        });

        buttonQuit1.setOnAction((event) -> {

            window.close();
        });

        buttonQuit2.setOnAction((event) -> {

            window.close();
        });

        window.setScene(sceneWelcome);
        window.show();

    }

}
