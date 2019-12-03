/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Question;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ajnarhi
 */
public class MockQuestionDao implements QuestionDao {

    @Override
    public List<Question> getQuestions() {
        List<Question> allQuestions = new ArrayList();
        Question testQuestion = new Question("Tien poikki kulki <mikä?>", "kissa", "kisa");
        allQuestions.add(testQuestion);
        return allQuestions;

    }

}
