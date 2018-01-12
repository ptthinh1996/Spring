package controller;

import org.springframework.ui.ModelMap;
import persistence.StudentDao;
import service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import model.Student;

@Controller
public class controller {

    StudentService studentService = new StudentService();

    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request) throws Exception {
        studentService.insertStudent(request);
        return "insert";
    }

    @RequestMapping(value = "/read",method = RequestMethod.POST)
    public String handleFileRead(ModelMap model) {
        ArrayList<Student> students = studentService.readStudent();
        model.addAttribute("students",students);
        return "show";
    }
}
