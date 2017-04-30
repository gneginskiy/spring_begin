package dao.impls;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Greg on 30.04.2017.
 */
public class AuthorResultSetExtractor implements ResultSetExtractor<Map<String, Integer>> {
    @Override
    public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<String, Integer> resultMap = new TreeMap<>();
        while (rs.next()) {
            resultMap.put(rs.getString("AUTHOR"), rs.getInt("COUNT"));
        }
        return resultMap;
    }
}
