/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuplakonsonantitjavokaalit;

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
    public void ask(){
        System.out.println(question);
    }
    
    public void options(){
        System.out.println("Tässä vastausvaihtoehdot:"+ rightAnswer +" tai "+ optionalAnswer);
    }
    
    
}
