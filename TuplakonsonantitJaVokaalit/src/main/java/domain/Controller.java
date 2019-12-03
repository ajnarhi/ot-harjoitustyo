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
    Question question;

    public Controller(QuestionDao database) {
        this.database = database;
        databaseQuestions = database.getQuestions();

    }

    public Question getRandomQuestionFromTheList() {
        return databaseQuestions.get(random.nextInt(databaseQuestions.size()));
        

    }

    public void newRound() {
        question = getRandomQuestionFromTheList();
    }

    public String getQuestion() {
        return question.ask();
    }

    public String getFirstAnswer() {
        return question.getRightAnswer();
    }

    public String getSecondAnswer() {
        return question.getOptionalAnswer();
    }

}
