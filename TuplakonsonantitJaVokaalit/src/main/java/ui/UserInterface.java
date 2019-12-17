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

        Controller controller = new Controller(new DatabaseQuestionDao("questions.db"));

        controller.newRound();
        Player player1 = new Player("", 0);
        Admin admin = new Admin();

        window.setTitle("Harjoitus");

        //näkymät
        Scene sceneAdmin;
        Scene sceneAnotherQuestion;
        Scene scenePassword;
        Scene sceneQuestion;
        Scene scenePlayerHasNotPlayedBefore;
        Scene scenePlayerHasPlayedBefore;
        Scene sceneFirst;
        Scene sceneRightAnswer;
        Scene sceneWrongAnswer;

        //otsikot
        Label label = new Label("Harjoitellaan tuplakonsonantteja ja - vokaaleja");
        Label labelWelcome = new Label("Tervetuloa! Kirjoita nimesi. \nNimi ei voi olla tyhjä ");
        Label labelWelcomeName = new Label();
        Label labelWelcomeNameForNewPlayer = new Label();
        Label labelGreat = new Label("Oikein! Hienoa. Pisteesi: " + player1.getPoints());
        Label labelWrong = new Label("Väärin. Kokeile uudestaan. Pisteesi: " + player1.getPoints());
        Label labelQuestion = new Label(controller.getQuestion());
        Label labelInstruction = new Label("Anna kysymys ja vastausvaihtoehdot. \nEt voi jättää kohtia tyhjiksi");
        Label labelAdminQuestion = new Label("Harjoituskysymys");
        Label labelAdminRight = new Label("Oikea vastaus");
        Label labelAdminOptional = new Label("Väärä vastaus");

        //napit
        Button buttonLetsBegin = new Button("Aloita!");
        Button buttonFirstChoice = new Button(controller.getFirstAnswer());
        Button buttonSecondChoice = new Button(controller.getSecondAnswer());
        Button buttonNewQuestion1 = new Button("Uusi kysymys");
        Button buttonNewQuestion2 = new Button("Uusi kysymys");
        Button buttonQuit1 = new Button("Lopeta");
        Button buttonQuit2 = new Button("Lopeta");
        Button buttonNameGiven = new Button("Nimi kirjoitettu");
        Button buttonStartNewGame = new Button("Aloita uusi peli");
        Button buttonStartNewGame2 = new Button("Aloita uusi peli");
        Button buttonNewQuestionToDatabase = new Button("Tallenna uusi kysymys ja vastaukset");
        Button buttonPasswordGiven = new Button("Salasana kirjoitettu");
        Button buttonAnotherQuestionToDatabase = new Button("Lisää uusi kysymys");
        Button buttonQuitAdmin = new Button("Lopeta");
        
           
        
        //Ensimmäinen näkymä
        VBox settingFirst = new VBox(10);
        HBox settingFirstTextAndNameBox = new HBox(10);
        HBox settingFirstButton= new HBox(10);
        TextField nameText = new TextField();
        settingFirstTextAndNameBox.getChildren().addAll(labelWelcome, nameText);
        settingFirstButton.getChildren().add(buttonNameGiven);
        settingFirst.getChildren().add(settingFirstTextAndNameBox);
        settingFirst.getChildren().add(settingFirstButton);
      
        sceneFirst = new Scene(settingFirst);
        //Ensimmäinen näkymä päättyy
        
        //Näkymä jos pelaaja on uusi
        VBox settingPlayerHasNotPlayedBefore = new VBox(10);
        settingPlayerHasNotPlayedBefore.getChildren().addAll(labelWelcomeNameForNewPlayer, buttonStartNewGame2);
        scenePlayerHasNotPlayedBefore = new Scene(settingPlayerHasNotPlayedBefore);
        //Näkymä päättyy

        //Näkymä jos pelaaja on pelannut ennenkin
        VBox settingPlayerHasPlayedBefore = new VBox(10);
        settingPlayerHasPlayedBefore.getChildren().addAll(labelWelcomeName, buttonStartNewGame);
        scenePlayerHasPlayedBefore = new Scene(settingPlayerHasPlayedBefore);
        //Näkymä päättyy
        
        //Admin salasananäkymä
        HBox settingPassword = new HBox();
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Pääkäyttäjän salasana");
        settingPassword.getChildren().add(passwordField);
        settingPassword.getChildren().add(buttonPasswordGiven);
        scenePassword = new Scene(settingPassword);
        //Admin salasananäkymä päättyy
        
        //Admin näkymä 
        VBox settingAdmin = new VBox(10);

        HBox settingAdminQuestion = new HBox(10);
        HBox settingAdminRight = new HBox(10);
        HBox settingAdminOptional = new HBox(10);

        TextField questionText = new TextField();
        TextField rightAnswerText = new TextField();
        TextField optionalAnswerText = new TextField();

        settingAdminQuestion.getChildren().addAll(labelAdminQuestion, questionText);
        settingAdminRight.getChildren().addAll(labelAdminRight, rightAnswerText);
        settingAdminOptional.getChildren().addAll(labelAdminOptional, optionalAnswerText);

        settingAdmin.getChildren().add(labelInstruction);
        settingAdmin.getChildren().add(settingAdminQuestion);
        settingAdmin.getChildren().add(settingAdminRight);
        settingAdmin.getChildren().add(settingAdminOptional);
        settingAdmin.getChildren().add(buttonNewQuestionToDatabase);

        sceneAdmin = new Scene(settingAdmin);
        //Admin näkymä päättyy

        //Admin uusi kysymys vai lopetus
        HBox settingAnotherQuestion = new HBox();
        settingAnotherQuestion.getChildren().add(buttonAnotherQuestionToDatabase);
        settingAnotherQuestion.getChildren().add(buttonQuitAdmin);
        sceneAnotherQuestion = new Scene(settingAnotherQuestion);
        //Näkymä päättyy
        
        
        //Kysymys näkymä
        VBox settingQuestion = new VBox(10);
        HBox settingAnswerOptions = new HBox(200);
        settingAnswerOptions.getChildren().addAll(buttonFirstChoice,buttonSecondChoice);
        settingQuestion.getChildren().addAll(labelQuestion,settingAnswerOptions);
        sceneQuestion = new Scene(settingQuestion);
        //Näkymä päättyy

        
        //Oikea vastaus näkymä
        BorderPane settingRightAnswer = new BorderPane();
        settingRightAnswer.setTop(labelGreat);
        HBox settingRightAnswerOptions=new HBox(150);
        settingRightAnswerOptions.getChildren().addAll(buttonNewQuestion1,buttonQuit1);
        settingRightAnswer.setCenter(settingRightAnswerOptions);
        
        sceneRightAnswer = new Scene(settingRightAnswer);
        //Näkymä päättyy
        
        //Väärä vastaus näkymä
        BorderPane settingWrongAnswer = new BorderPane();
        settingWrongAnswer.setTop(labelWrong);
        HBox settingWrongAnswerOptions=new HBox(150);
        settingWrongAnswerOptions.getChildren().addAll(buttonNewQuestion2, buttonQuit2);
        settingWrongAnswer.setCenter(settingWrongAnswerOptions);
        sceneWrongAnswer = new Scene(settingWrongAnswer);
        //Näkymä päättyy
        
        //Nappien toiminnot
        buttonLetsBegin.setOnAction((event) -> {
            window.setScene(sceneQuestion);
        });

        buttonAnotherQuestionToDatabase.setOnAction((event) -> {

            window.setScene(sceneAdmin);
        });

        buttonQuitAdmin.setOnAction((event) -> {

            window.close();
        });

        buttonNewQuestionToDatabase.setOnAction((event) -> {
            String textFieldValueQuestion = questionText.getText();
            String textFieldValueRightAnswer = rightAnswerText.getText().toLowerCase();
            String textFieldValueOptionalAnswer = optionalAnswerText.getText().toLowerCase();
            if (questionText.getText().isEmpty() || rightAnswerText.getText().toLowerCase().isEmpty() || optionalAnswerText.getText().toLowerCase().isEmpty()) {

            } else {

                Question databaseNewQuestion = new Question(textFieldValueQuestion, textFieldValueRightAnswer, textFieldValueOptionalAnswer);
                controller.insertNewQuestionIntoDatabase(databaseNewQuestion);
                questionText.clear();
                rightAnswerText.clear();
                optionalAnswerText.clear();
                window.setScene(sceneAnotherQuestion);
            }
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

        buttonPasswordGiven.setOnAction((event) -> {
            String textFieldValuePassword = passwordField.getText();
            if (textFieldValuePassword.equals(admin.getPassword())) {
                window.setScene(sceneAdmin);
            }

        });

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

        buttonPasswordGiven.setOnAction((event) -> {
            String textFieldValuePassword = passwordField.getText();
            if (textFieldValuePassword.equals(admin.getPassword())) {
                window.setScene(sceneAdmin);
            }

        });

        buttonNameGiven.setOnAction((event) -> {
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

        buttonPasswordGiven.setOnAction((event) -> {
            String textFieldValuePassword = passwordField.getText();
            if (textFieldValuePassword.equals(admin.getPassword())) {
                window.setScene(sceneAdmin);
            }

        });

        buttonStartNewGame2.setOnAction((event) -> {
            window.setScene(sceneQuestion);

        });

        buttonStartNewGame.setOnAction((event) -> {
            player1.setPoints(0);

            window.setScene(sceneQuestion);

        });

        window.setScene(sceneFirst);

        window.show();

    }

}
