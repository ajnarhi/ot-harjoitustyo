/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuplakonsonantitjavokaalit;

import java.util.ArrayList;

/**
 *
 * @author ajnarhi
 */
public class Question {
    
    
    
    
    String question;
    String rightAnswer;
    String optionalAnswer;
    
    public Question(String question, String rightAnswer, String optionalAnswer){
        this.question=question;
        this.rightAnswer=rightAnswer;    
        this.optionalAnswer=optionalAnswer;
    }
    public String getRightAnswer(){
        
        return rightAnswer;
    }
    
    public String getOptionalAnswer(){
        return optionalAnswer;
    }
    public String ask(){
        return question;
    }
    
  
    
    
    
    
}


/*  
ArrayList <Question>questions=new ArrayList();
Question question1=new Question("Tien yli kulki ...", "kissa", "kisa");
        Question question2=new Question("Oi miten ihanalta tämä ... tuoksuu","kukka", "kuka");
        Question question3=new Question("... vei kirjani?","kuka", "kukka");
        Question question4=new Question("Mikään ei polta ihoa niin pahasti kuin ...","tuli","tuuli");
        Question question5=new Question("Meidän täytyy ottaa joskus juoksu...","kisa", "kissa");
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);*/