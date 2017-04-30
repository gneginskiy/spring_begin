package dao.interfaces;

import entity.Mp3;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Greg on 30.04.2017.
 */
public interface MP3Dao {

    void insert(Mp3 mp3);

    void insert(Collection<Mp3> mp3Collection);

    void delete(Mp3 mp3);

    Mp3 getMp3ById(int id);

    List<Mp3> getMp3ByName(String name);

    List<Mp3> getMp3ByAuthor(String author);

    int getMp3Count();

    Map<String, Integer> getMp3CountForAuthors();
}


