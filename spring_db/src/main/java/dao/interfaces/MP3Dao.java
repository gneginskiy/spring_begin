package dao.interfaces;

import entity.Mp3;

import java.util.List;

/**
 * Created by Greg on 30.04.2017.
 */
public interface MP3Dao {

    void insert(Mp3 mp3);

    void delete(Mp3 mp3);

    void getMp3ById(int id);

    List<Mp3> getMp3ByName(String name);

    List<Mp3> getMp3ByAuthor(String author);
}

