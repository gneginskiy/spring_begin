package dao.impls;

import dao.interfaces.MP3Dao;
import entity.Mp3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * Created by Greg on 30.04.2017.
 */
@Component("sqliteDAO")
public class SqliteMp3Dao implements MP3Dao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert mp3SimpleJdbcInsert;
    private DataSource dataSource;
    private SimpleJdbcInsert authorSimpleJdbcInsert;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
        this.mp3SimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("MP3")
                                                                   .usingColumns("NAME", "AUTHOR_ID")
                                                                   .usingGeneratedKeyColumns("ID");
        this.authorSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("AUTHOR")
                                                                      .usingColumns("NAME")
                                                                      .usingGeneratedKeyColumns("ID");
    }


    @Override
    public void insert(Mp3 mp3) {
        //assuming that the author doesn't exist already
        KeyHolder authorKeyHolder = authorSimpleJdbcInsert.executeAndReturnKeyHolder(new HashMap<String, Object>() {{
            put("name", mp3.getAuthor());
            put("author_id", mp3.getAuthor());
        }});

        mp3SimpleJdbcInsert.execute(new HashMap<String, Object>() {{
            put("name", mp3.getName());
            put("author_id", authorKeyHolder.getKey());
        }});
    }

    public void insert(Collection<Mp3> mp3Collection) {
        mp3Collection.forEach(this::insert);
    }

    //---------------------------------------The code below isn't so good-----------------------------------------------


    @Deprecated
    public void batchInsert(Collection<Mp3> mp3Collection) {
        mp3Collection.forEach(this::insert);
    }

    @Deprecated
    public void insertWithQuery(Mp3 mp3) {
        String sqlQuery = "INSERT INTO mp3 (name, author) VALUES (?,?)";
        jdbcTemplate.update(sqlQuery, mp3.getName(), mp3.getAuthor());
    }

    @Deprecated
    public void insertWithJdbc(Mp3 mp3) {
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:spring_core_tutorial/spring_db/src/main/resources/db/db.db";
            conn = DriverManager.getConnection(url, "", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        String sqlQuery = "INSERT INTO mp3 (name, author) VALUES (?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, mp3.getName());
            ps.setString(2, mp3.getAuthor());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Deprecated
    @Override
    public void update(Collection<Mp3> mp3Collection) {
        String sqlQuery = "UPDATE mp3 SET name = ?, author = ?  WHERE id = ?";
        BatchPreparedStatementSetter pss = new Mp3BatchPreparedStatementSetter(mp3Collection);
        jdbcTemplate.batchUpdate(sqlQuery, pss);
    }

    @Deprecated
    @Override
    public void update(Mp3 mp3) {
        jdbcTemplate.update(
                "UPDATE mp3 SET name = ? AND author = ? WHERE id = ?",
                mp3.getName(), mp3.getAuthor(), mp3.getId());
    }

    @Deprecated
    public void delete(Mp3 mp3) {
        String sqlQuery = "DELETE FROM mp3 WHERE name=? AND author=?";
        jdbcTemplate.update(sqlQuery, mp3.getName(), mp3.getAuthor());
    }

    @Deprecated
    public Mp3 getMp3ById(int id) {
        String sqlQuery = "SELECT * FROM MP3 WHERE id=?";
        return jdbcTemplate.queryForObject(sqlQuery, new Mp3RowMapper(), id);
    }

    @Deprecated
    public List<Mp3> getMp3ByName(String name) {
        String sqlQuery = "SELECT * FROM MP3 WHERE name=:name";
        return jdbcTemplate.query(sqlQuery, new Mp3RowMapper(), name);
    }

    @Deprecated
    public List<Mp3> getMp3ByAuthor(String author) {
        String sqlQuery = "SELECT * FROM MP3 WHERE author=:author";
        return jdbcTemplate.query(sqlQuery, new Mp3RowMapper(), author);
    }

    @Deprecated
    @Override
    public int getMp3Count() {
        String sqlQuery = "SELECT count(*) FROM MP3";
        return jdbcTemplate.queryForObject(sqlQuery, Integer.class);
    }

    @Deprecated
    @Override
    public Map<String, Integer> getMp3CountForAuthors() {
        String sqlQuery = "SELECT author, count(*) AS COUNT FROM MP3 GROUP BY author";
        return jdbcTemplate.query(sqlQuery, new AuthorResultSetExtractor());
    }
}
