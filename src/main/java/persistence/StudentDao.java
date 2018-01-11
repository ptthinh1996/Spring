package persistence;

import org.springframework.stereotype.Repository;
import practice.sv.bai1.ReadFile;
import practice.sv.bai1.Student;
import utils.DatabaseUtils;

import java.util.ArrayList;

@Repository
public class StudentDao {
    DatabaseUtils databaseUtils = new DatabaseUtils();

    public void create(ArrayList<model.Student> students) {
        databaseUtils.insertInfo(students);
    }
}
