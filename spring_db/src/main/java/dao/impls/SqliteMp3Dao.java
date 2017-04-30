package dao.impls;

import dao.interfaces.MP3Dao;
import entity.Mp3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Greg on 30.04.2017.
 */
@Component("sqliteDAO")
public class SqliteMp3Dao implements MP3Dao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(Mp3 mp3) {
        String sqlQuery = "insert into mp3 (name, author) VALUES (?,?)";
        jdbcTemplate.update(sqlQuery, mp3.getName(), mp3.getAuthor());
    }

    public void insertWithJdbc(Mp3 mp3){
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:spring_core_tutorial/spring_db/src/main/resources/db/db.db";
            conn= DriverManager.getConnection(url,"","");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlQuery = "insert into mp3 (name, author) VALUES (?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1,mp3.getName());
            ps.setString(2,mp3.getAuthor());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void delete(Mp3 mp3) {

    }

    public void getMp3ById(int id) {

    }

    public List<Mp3> getMp3ByName(String name) {
        return null;
    }

    public List<Mp3> getMp3ByAuthor(String author) {
        return null;
    }
}
