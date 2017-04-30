package entity;

/**
 * Created by Greg on 30.04.2017.
 */
public class Mp3 {
    private String name;
    private String author;
    private int id;

    public Mp3(String author, String name, int id) {
        setName(name);
        setAuthor(author);
        setId(id);
    }

    public Mp3(String author, String name) {
        setName(name);
        setAuthor(author);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
