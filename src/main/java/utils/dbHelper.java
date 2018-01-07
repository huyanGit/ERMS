package utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.UUID;

public class dbHelper {

    private static dbHelper instince = null;
    private static JdbcTemplate jdbcTemplate = null;

    private dbHelper() {
        String xmlPath = "databaseInit.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }

    public static JdbcTemplate getJdbInstince(){
        if(instince==null){
            synchronized (dbHelper.class){
                if(instince == null){
                    instince = new dbHelper();
                }
            }
        }
        return jdbcTemplate;
    }

    /**
     * 获取32位的UUID作为主键
     * @return
     */
    public static String getUUID(){
        Date date = new Date();
        String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象
        uuid = uuid.replace("-", "");               //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
        return  uuid;

    }
}
