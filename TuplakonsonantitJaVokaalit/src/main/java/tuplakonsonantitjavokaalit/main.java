/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuplakonsonantitjavokaalit;



import javafx.application.Application;



/**
 *
 * @author ajnarhi
 */

public class main {

         public static void main(String[] args) {
      Application.launch(UserInterface.class);
  }
}   

        
   /*  

public class main{
    
    public static void main(String [] args){
Scanner lukija = new Scanner(System.in);
        ArrayList <Question>questions=new ArrayList();
        
        Player player1=new Player(0);
        
        Question question1=new Question("Tien yli kulki ...", "kissa", "kisa");
        Question question2=new Question("Oi miten ihanalta tämä ... tuoksuu","kukka", "kuka");
        Question question3=new Question("... vei kirjani?","kuka", "kukka");
        Question question4=new Question("Mikään ei polta ihoa niin pahasti kuin ...","tuli","tuuli");
        Question question5=new Question("Meidän täytyy ottaa joskus juoksu...","kisa", "kissa");
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        
        
        
        System.out.println("Harjoitellaan tuleeko vokaaleja tai konsonantteja yksi vai kaksi");
        
        for (Question question:questions){
        question.ask();
        question.options();
        String vastaus = lukija.nextLine();
        
        if (vastaus.matches(question.getRightAnswer())){
            System.out.println("Hienoa!");
            player1.increasePoints();
        }else{System.out.println("Kokeile uudestaan!");
        player1.decreasePoints();
        
        }
        }
        
        System.out.println("Pisteesi tällä kierroksella: " + player1.getPoints() );
    }*/  
      
        
        
        
        
        
    

    


