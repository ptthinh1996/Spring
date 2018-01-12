package utils;

import org.springframework.stereotype.Component;
import sv.practice.mysql.JDBCConectionMysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Student;

@Component
public class DatabaseUtils {
    public DatabaseUtils() {
    }

    public static void insertData(ArrayList<model.Student> students) {
        Connection connection = JDBCConectionMysql.getJDBCConnection();

        try {
            students.stream().forEach((st) -> {
                Statement statement = null;

                try {
                    statement = connection.createStatement();
                } catch (SQLException var6) {
                    var6.printStackTrace();
                }

                String sql = "Insert into student(last_name,first_name,birth_day,email) values('" + st.getFirstName() + "','" + st.getLastName() + "','" + st.getBirthDay() + "','" + st.getEmail() + "')";

                try {
                    statement.executeUpdate(sql);
                } catch (SQLException var5) {
                    var5.printStackTrace();
                }

            });
        } finally {
            try {
                connection.close();
            } catch (SQLException var7) {
                var7.printStackTrace();
            }

        }

    }

    public static ArrayList<model.Student> readData() {
        try {
            ArrayList<Student> listS = new ArrayList();
            Statement statement = JDBCConectionMysql.getJDBCConnection().createStatement();
            String sql = "SELECT * FROM internship.student";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()) {
                String lname = rs.getString("last_name");
                String fname = rs.getString("first_name");
                String bd = rs.getString("birth_day");
                String email = rs.getString("email");
                listS.add(new Student(lname, fname, bd, email));
            }

            return listS;
        } catch (SQLException var8) {
            var8.printStackTrace();
            return null;
        }
    }
}
