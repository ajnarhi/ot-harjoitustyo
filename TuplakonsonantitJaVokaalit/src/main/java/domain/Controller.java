/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.QuestionDao;
import dao.DatabaseQuestionDao;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ajnarhi
 */
public class Controller {

    QuestionDao database;
    Random random = new Random();
    List<Question> databaseQuestions;
    List<Player> databasePlayers;
    Question question;
    int randomNumberForAnswers;

    public Controller(QuestionDao database) {
        this.database = database;
        databaseQuestions = database.getQuestions();
        databasePlayers = database.getPlayers();

    }

    public Question getRandomQuestionFromTheList() {
        return databaseQuestions.get(random.nextInt(databaseQuestions.size()));

    }

    public void newRound() {
        question = getRandomQuestionFromTheList();
        randomNumberForAnswers = random.nextInt(2);

    }

    public String getQuestion() {
        return question.ask();
    }

    public String getFirstAnswer() {

        if (randomNumberForAnswers == 0) {
            return question.getRightAnswer();

        } else {
            return question.getOptionalAnswer();
        }

    }

    public String getSecondAnswer() {
        if (randomNumberForAnswers == 0) {
            return question.getOptionalAnswer();

        } else {
            return question.getRightAnswer();
        }
    }

    public int getRandomNumber() {
        return randomNumberForAnswers;
    }

    public boolean checkIfNameIsOnThePlayerList(String name) {
        String nameLower = name.toLowerCase();
        for (Player player : databasePlayers) {
            String playerName = player.getName();
            if (playerName.equals(nameLower)) {
                return true;
            }
            
        }
        return false;

    }
    
    public int ifNameIsOnTheDatabaseReturnPoints(String name){
        int playerPoints=0;
        String nameLower = name.toLowerCase();
        
        for (Player player : databasePlayers) {
            String playerName = player.getName();
            if (playerName.equals(nameLower)) {
                playerPoints=player.getPoints();
                
            }
            
    }
        return playerPoints;
}
}
