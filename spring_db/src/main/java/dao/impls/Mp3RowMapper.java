package dao.impls;

import entity.Mp3;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Greg on 30.04.2017.
 */
public class Mp3RowMapper implements RowMapper<Mp3> {

    @Override
    public Mp3 mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("NAME");
        String author = rs.getString("AUTHOR");
        int id = rs.getInt("ID");
        return new Mp3(author, name,id);
    }
}
