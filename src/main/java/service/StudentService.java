package service;


import model.Student;
import org.springframework.stereotype.Service;
import persistence.StudentDao;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Service
public class StudentService {

    StudentDao studentDao = new StudentDao();

    public void insertStudent(HttpServletRequest request){

        studentDao.create(request);
    }

    public ArrayList<Student> readStudent(){
        return studentDao.read();
    }

}
