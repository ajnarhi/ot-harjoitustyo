/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Player;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import domain.Question;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajnarhi
 */
/**
 * Luokka hakee tietoa ja kirjoittaa tietoa SqLite tietokantaan
 */
public class DatabaseQuestionDao implements QuestionDao {

    String databaseName;

    public DatabaseQuestionDao(String databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * Metodi ottaa yhteyden tietokantaan ja luo sinne tauluja jos niitä ei
     * vielä ole siellä return palauttaa yhteyden
     */
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuestionDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName);
        String sql = "CREATE TABLE IF NOT EXISTS questions(question STRING, rightAnswer STRING, optionalAnswer STRING);";
        String sql1 = "CREATE TABLE IF NOT EXISTS player(name STRING, points INTEGER);";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        PreparedStatement pstmt1 = connection.prepareStatement(sql1);
        pstmt.execute();
        pstmt1.execute();

        return connection;
    }

    /**
     * Metodi palauttaa tietokannasta kysymykset vastausvaihtoehtoineen listana.
     * Jos se onnistuu, tulostetaan lisäksi tekstiä. Muuten päädytään
     * poikkeukseen.
     *
     * @return Palauttaa kysymykset vastausvaihtoehtoineen listana
     */
    @Override
    public List<Question> getQuestions() {
        List<Question> allQuestions = new ArrayList();

        try {

            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from questions");
            while (rs.next()) {
                Question question = new Question(rs.getString("question"), rs.getString("rightAnswer"), rs.getString("optionalAnswer"));
                allQuestions.add(question);
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        return allQuestions;

    }

    /**
     * Metodi tallentaa tietokantaan kysymyksen vastausvaihtoehtoineen. os se
     * onnistuu, tulostetaan lisäksi tekstiä. Muuten päädytään poikkeukseen.
     *
     * @param question parametrinä annettu kysymys
     *
     */
    @Override
    public void insertNewQuestion(Question question) {

        String sql = "INSERT INTO questions(question,rightAnswer,optionalAnswer) VALUES(?,?,?)";

        PreparedStatement pstmt;
        try {
            Connection connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, question.ask());
            pstmt.setString(2, question.getRightAnswer());
            pstmt.setString(3, question.getOptionalAnswer());
            pstmt.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuestionDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Inserted question to database successfully");

    }

    /**
     * Metodi palauttaa tietokannasta pelaajat ja heidän edellisen kierroksen
     * pisteensä listana. Jos se onnistuu, tulostetaan lisäksi tekstiä. Muuten
     * päädytään poikkeukseen.
     *
     * @return Palauttaa pelaajat ja heidän pisteensä listana
     */
    @Override
    public List<Player> getPlayers() {
        List<Player> allPlayers = new ArrayList();

        try {

            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from player");
            while (rs.next()) {
                Player player = new Player(rs.getString("name"), rs.getInt("points"));
                allPlayers.add(player);
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        return allPlayers;
    }

    /**
     * Metodi kirjoittaa tietokantaan uuden pelaajan. Jos se onnistuu,
     * tulostetaan lisäksi tekstiä. Muuten päädytään poikkeukseen.
     *
     * @param player parametrinä annettu pelaaja
     *
     */
    @Override
    public void insertNewPlayer(Player player) {

        String sql = "INSERT INTO player(name,points) VALUES(?,?)";

        PreparedStatement pstmt;
        try {
            Connection connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, player.getName().toLowerCase());
            pstmt.setInt(2, player.getPoints());
            pstmt.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuestionDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Inserted data to database successfully");

    }

    /**
     * Metodi kirjoittaa tietokantaan uuden pelaajan. Jos se onnistuu,
     * tulostetaan lisäksi tekstiä. Muuten päädytään poikkeukseen.
     *
     * @param player parametrinä annettu pelaaja
     *
     */
    @Override
    public void updatePlayersPoints(Player player) {
        String sql = "Update player set points=? where name=?";

        PreparedStatement pstmt;
        try {
            Connection connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, player.getPoints());
            pstmt.setString(2, player.getName().toLowerCase());
            pstmt.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuestionDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Updated data to database successfully");

    }
}
