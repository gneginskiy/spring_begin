package dao.impls;

import entity.Mp3;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Greg on 30.04.2017.
 */
public class Mp3BatchPreparedStatementSetter implements BatchPreparedStatementSetter {
    private final Iterator<Mp3> iterator;
    private final int batchSize;

    Mp3BatchPreparedStatementSetter(Collection<Mp3> collection) {
        this.iterator = collection.iterator();
        this.batchSize = collection.size();
    }

    @Override
    public void setValues(PreparedStatement ps, int i) throws SQLException {
        Mp3 mp3 = (Mp3) iterator.next();
        ps.setString(1,mp3.getName());
        ps.setString(2,mp3.getAuthor());
        ps.setInt(3,mp3.getId());
    }

    @Override
    public int getBatchSize() {
        return batchSize;
    }
}
