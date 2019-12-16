/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.DatabaseQuestionDao;
import domain.Admin;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import domain.Controller;
import domain.Player;
import domain.Question;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author ajnarhi
 */
public class UserInterface extends Application {

    @Override
    public void start(Stage window) {

        Controller controller = new Controller(new DatabaseQuestionDao());

        controller.newRound();
        Player player1 = new Player("", 0);
        Admin admin=new Admin();

        window.setTitle("Harjoitus");

        //otsikot
        Label label = new Label("Harjoitellaan tuplakonsonantteja ja - vokaaleja");
        Label labelWelcome = new Label("Tervetuloa! Kirjoita nimesi. \nNimi ei voi olla tyhjä ");
        Label labelWelcomeName = new Label();
        Label labelWelcomeNameForNewPlayer = new Label();
        Label labelGreat = new Label("Oikein! Hienoa. Pisteesi: " + player1.getPoints());
        Label labelWrong = new Label("Väärin. Kokeile uudestaan. Pisteesi: " + player1.getPoints());
        Label labelQuestion = new Label(controller.getQuestion());

        //napit
        Button buttonLetsBegin = new Button("Aloita!");
        Button buttonFirstChoice = new Button(controller.getFirstAnswer());
        Button buttonSecondChoice = new Button(controller.getSecondAnswer());
        Button buttonNewQuestion1 = new Button("Uusi kysymys");
        Button buttonNewQuestion2 = new Button("Uusi kysymys");
        Button buttonQuit1 = new Button("Lopeta");
        Button buttonQuit2 = new Button("Lopeta");
        Button nameGiven = new Button("Nimi kirjoitettu");
        Button startNewGame = new Button("Aloita uusi peli");
        Button startNewGame2 = new Button("Aloita uusi peli");
        Button newQuestionToDatabase = new Button("Tallenna uusi kysymys ja vastaukset");
        Button passwordGiven = new Button("Password Given");
        Button anotherQuestionToDatabase =new Button ("Lisää uusi kysymys");
        Button quitAdmin =new Button ("Lopeta");
        
        HBox settingAnotherQuestion = new HBox();
        settingAnotherQuestion.getChildren().add(anotherQuestionToDatabase);
        settingAnotherQuestion.getChildren().add(quitAdmin);
        Scene sceneAnotherQuestion =new Scene (settingAnotherQuestion);
        anotherQuestionToDatabase.setOnAction((event) -> {
            
            window.close();//tähän pitäisi laittaa window.setScene(sceneAdmin); mutta se on tuossa alla. Miten sen saisi oikeaan paikkaan?
        });
        quitAdmin.setOnAction((event) -> {
            
            window.close();
        });
        

        VBox settingAdmin = new VBox();
        TextField questionText = new TextField();
        TextField rightAnswerText = new TextField();
        TextField optionalAnswerText = new TextField();
        settingAdmin.getChildren().add(questionText);
        settingAdmin.getChildren().add(rightAnswerText);
        settingAdmin.getChildren().add(optionalAnswerText);
        settingAdmin.getChildren().add(newQuestionToDatabase);
        Scene sceneAdmin = new Scene(settingAdmin);
        newQuestionToDatabase.setOnAction((event) -> {
            String textFieldValueQuestion = questionText.getText();
            String textFieldValueRightAnswer = rightAnswerText.getText().toLowerCase();
            String textFieldValueOptionalAnswer = optionalAnswerText.getText().toLowerCase();
            Question databaseNewQuestion = new Question(textFieldValueQuestion, textFieldValueRightAnswer, textFieldValueOptionalAnswer);
            controller.insertNewQuestionIntoDatabase(databaseNewQuestion);
            window.setScene(sceneAnotherQuestion);
        });

        HBox settingPassword = new HBox();
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Admin password");
        settingPassword.getChildren().add(passwordField);
        settingPassword.getChildren().add(passwordGiven);
        Scene scenePassword = new Scene(settingPassword);
        passwordGiven.setOnAction((event) -> {
            String textFieldValuePassword = passwordField.getText();
            if (textFieldValuePassword.equals(admin.getPassword())) {
                window.setScene(sceneAdmin);
            }

        });

        BorderPane settingQuestion = new BorderPane();
        settingQuestion.setTop(labelQuestion);
        settingQuestion.setLeft(buttonFirstChoice);
        settingQuestion.setRight(buttonSecondChoice);
        Scene sceneQuestion = new Scene(settingQuestion);

        BorderPane settingPlayerHasNotPlayedBefore = new BorderPane();

        settingPlayerHasNotPlayedBefore.setTop(labelWelcomeNameForNewPlayer);
        settingPlayerHasNotPlayedBefore.setBottom(startNewGame2);
        Scene scenePlayerHasNotPlayedBefore = new Scene(settingPlayerHasNotPlayedBefore);
        startNewGame2.setOnAction((event) -> {
            window.setScene(sceneQuestion);

        });

        BorderPane settingPlayerHasPlayedBefore = new BorderPane();

        settingPlayerHasPlayedBefore.setTop(labelWelcomeName);
        settingPlayerHasPlayedBefore.setBottom(startNewGame);
        Scene scenePlayerHasPlayedBefore = new Scene(settingPlayerHasPlayedBefore);
        startNewGame.setOnAction((event) -> {
            player1.setPoints(0);

            window.setScene(sceneQuestion);

        });

        BorderPane settingFirst = new BorderPane();
        settingFirst.setLeft(labelWelcome);
        TextField nameText = new TextField();
        settingFirst.setCenter(nameText);
        settingFirst.setBottom(nameGiven);
        Scene sceneFirst = new Scene(settingFirst);
        nameGiven.setOnAction((event) -> {
            String textFieldValueName = nameText.getText();
            if (textFieldValueName.equals("")) {
                System.out.println("tyhjä annettu");
            } else if (textFieldValueName.equals("admin") || textFieldValueName.equals("Admin")) {
                System.out.println("Admin annettu");
                window.setScene(scenePassword);
            } else if (controller.checkIfNameIsOnThePlayerList(textFieldValueName)) {
                System.out.println("toimii");
                player1.setName(textFieldValueName);
                int player1points = controller.ifNameIsOnTheDatabaseReturnPoints(textFieldValueName);
                player1.setPoints(player1points);
                labelWelcomeName.setText("Tervetuloa takaisin " + player1.getName() + ". Edelliset pisteesi: " + player1.getPoints() + "\nHarjoitellaan tuplakonsonantteja ja - vokaaleja");
                window.setScene(scenePlayerHasPlayedBefore);

            } else {
                System.out.println("Ei toimi");
                player1.setName(textFieldValueName);
                player1.setPoints(0);
                controller.insertNewPlayerIntoDatabase(player1);
                labelWelcomeNameForNewPlayer.setText("Tervetuloa " + player1.getName() + ". Pisteesi nyt: " + player1.getPoints() + "\nHarjoitellaan tuplakonsonantteja ja - vokaaleja");
                window.setScene(scenePlayerHasNotPlayedBefore);
            }
        });

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
            if (controller.getRandomNumber() == 0) {
                player1.increasePoints();
                settingRightAnswer.setTop(new Label("Oikein! Hienoa. Pisteesi: " + player1.getPoints()));
                window.setScene(sceneRightAnswer);
            } else {
                player1.decreasePoints();
                settingWrongAnswer.setTop(new Label("Väärin. Kokeile uudestaan. Pisteesi: " + player1.getPoints()));
                window.setScene(sceneWrongAnswer);

            }

        }
        );
        buttonSecondChoice.setOnAction((event) -> {

            if (controller.getRandomNumber() == 1) {
                player1.increasePoints();
                settingRightAnswer.setTop(new Label("Oikein! Hienoa. Pisteesi: " + player1.getPoints()));
                window.setScene(sceneRightAnswer);
            } else {
                player1.decreasePoints();
                settingWrongAnswer.setTop(new Label("Väärin. Kokeile uudestaan. Pisteesi: " + player1.getPoints()));
                window.setScene(sceneWrongAnswer);

            }
        }
        );

        buttonNewQuestion1.setOnAction(
                (event) -> {
                    controller.newRound();
                    labelQuestion.setText(controller.getQuestion());
                    buttonFirstChoice.setText(controller.getFirstAnswer());
                    buttonSecondChoice.setText(controller.getSecondAnswer());

                    window.setScene(sceneQuestion);
                }
        );

        buttonNewQuestion2.setOnAction(
                (event) -> {
                    controller.newRound();
                    labelQuestion.setText(controller.getQuestion());
                    buttonFirstChoice.setText(controller.getFirstAnswer());
                    buttonSecondChoice.setText(controller.getSecondAnswer());
                    window.setScene(sceneQuestion);
                }
        );

        buttonQuit1.setOnAction(
                (event) -> {

                    controller.updatePlayersPointsOnDatabase(player1);
                    window.close();
                }
        );

        buttonQuit2.setOnAction(
                (event) -> {

                    controller.updatePlayersPointsOnDatabase(player1);
                    window.close();
                }
        );
        window.setScene(sceneFirst);

        window.show();

    }

}
