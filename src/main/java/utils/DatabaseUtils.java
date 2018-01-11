package utils;

import sv.practice.mysql.JDBCConectionMysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseUtils {
    public DatabaseUtils() {
    }

    public static void insertInfo(ArrayList<model.Student> students) {
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
}
