package service;

import model.Student;
import org.apache.commons.fileupload.FileItem;
import persistence.StudentDao;
import practice.sv.bai1.ReadFile;
import utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    StudentDao studentDao = new StudentDao();
    public void process(String filename){
        ArrayList<Student> students;
        students =  FileUtils.readFile(filename);
        studentDao.create(students);
    }

}
