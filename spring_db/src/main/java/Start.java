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
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/context.xml");
        SqliteMp3Dao sqliteMp3Dao = context.getBean(SqliteMp3Dao.class);
        sqliteMp3Dao.insert(new Mp3("Deep purple","Smoke under water"));
    }
}
