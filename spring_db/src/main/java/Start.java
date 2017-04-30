import dao.impls.SqliteMp3Dao;
import entity.Mp3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Created by Greg on 30.04.2017.
 */
public class Start {
    public static void main(String[] args) {
        Mp3 mp3 = new Mp3("Deep purple","Smoke under water");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/context.xml");
        SqliteMp3Dao sqliteMp3Dao = context.getBean(SqliteMp3Dao.class);
        sqliteMp3Dao.getMp3ById(1);
        sqliteMp3Dao.insert(mp3);
        sqliteMp3Dao.insertWithJdbc(new Mp3("Ранетки", "Мы - ранетки!"));
        System.out.println();
        ArrayList<Mp3> mp3s = new ArrayList<Mp3>() {{
            add(new Mp3("artist11", "trackUpdddaaated11111",21));
            add(new Mp3("artist22", "trackUpdddaaated22222",22));
            add(new Mp3("artist33", "trackUpdddaaated33333",23));
            add(new Mp3("artist44", "trackUpdddaaated44444",24));
            add(new Mp3("artist55", "trackUpdddaaated55555",25));
        }};
        sqliteMp3Dao.delete(new Mp3("Ранетки","Мы - ранетки!"));
        sqliteMp3Dao.update(mp3s);
    }
}
