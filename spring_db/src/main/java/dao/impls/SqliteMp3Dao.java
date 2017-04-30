package dao.impls;

import dao.interfaces.MP3Dao;
import entity.Mp3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

    public void insert(Collection<Mp3> mp3Collection) {
        mp3Collection.forEach(this::insert);
    }

    public void insertWithJdbc(Mp3 mp3){
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:spring_core_tutorial/spring_db/src/main/resources/db/db.db";
            conn= DriverManager.getConnection(url,"","");
        } catch (ClassNotFoundException | SQLException e) {
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
        String sqlQuery = "delete from mp3 where name=? and author=?";
        jdbcTemplate.update(sqlQuery, mp3.getName(), mp3.getAuthor());
    }


    public Mp3 getMp3ById(int id) {
        String sqlQuery = "select * from MP3 where id=?";
        return jdbcTemplate.queryForObject(sqlQuery,new Mp3RowMapper(),id);
    }

    public List<Mp3> getMp3ByName(String name) {
        String sqlQuery = "select * from MP3 where name=:name";
        return jdbcTemplate.query(sqlQuery,new Mp3RowMapper(),name);
    }

    public List<Mp3> getMp3ByAuthor(String author) {
        String sqlQuery = "select * from MP3 where author=:author";
        return jdbcTemplate.query(sqlQuery,new Mp3RowMapper(),author);
    }

    @Override
    public int getMp3Count() {
        String sqlQuery = "select count(*) from MP3";
        return jdbcTemplate.queryForObject(sqlQuery,Integer.class);
    }

    @Override
    public Map<String, Integer> getMp3CountForAuthors() {
        String sqlQuery = "select author, count(*) as COUNT from MP3 group by author";
        return jdbcTemplate.query(sqlQuery, new AuthorResultSetExtractor());
    }
}
