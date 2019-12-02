/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuplakonsonantitjavokaalit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ajnarhi
 */
public class DatabaseQuestionDao implements QuestionDao{

    @Override
    public List<Question> getQuestions() {
        List<Question> allQuestions=new ArrayList();
        Connection connection = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection("jdbc:sqlite:questions.db");
         Statement statement=connection.createStatement();
         ResultSet rs=statement.executeQuery("select * from questions");
         while(rs.next())
         {
             Question question=new Question(rs.getString("question"), rs.getString("rightAnswer"), rs.getString("optionalAnswer"));
             allQuestions.add(question);
         }
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
      
      
      return allQuestions;
      
   }
    
    
}
    
    
    
    

