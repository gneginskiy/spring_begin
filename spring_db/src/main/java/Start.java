import dao.impls.SqliteMp3Dao;
import entity.Mp3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Greg on 30.04.2017.
 */
public class Start {
    public static void main(String[] args) {
        Mp3 mp3 = new Mp3("Deep purple","Smoke under water");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/context.xml");
        SqliteMp3Dao sqliteMp3Dao = context.getBean(SqliteMp3Dao.class);
        sqliteMp3Dao.insert(mp3);
        sqliteMp3Dao.insertWithJdbc(new Mp3("Ранетки", "Мы - ранетки!"));
        System.out.println();
        sqliteMp3Dao.delete(new Mp3("Ранетки","Мы - ранетки!"));
    }
}
