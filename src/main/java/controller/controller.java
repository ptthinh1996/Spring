package controller;

import org.springframework.ui.ModelMap;
import persistence.StudentDao;
import practice.sv.bai1.Student;
import service.StudentService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sv.practice.mysql.JDBCStatement;
import utils.FileUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

import java.util.ArrayList;
import java.util.List;

@Controller
public class controller {

    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        StudentService studentService = new StudentService();
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        String dirUrl = request.getServletContext().getRealPath("") + "files";
        String fileName = FileUtils.uploadFile(fileItems, dirUrl);
        if (fileName.endsWith(".csv") && fileName!=null) {
            String fileUrl = dirUrl + File.separator + fileName;
            studentService.process(fileUrl);
        }
        return "insert";
    }

    @RequestMapping(value = "/read",method = RequestMethod.POST)
    public String handleFileRead(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Student> students;
        students = (ArrayList<Student>) JDBCStatement.readData();
        ModelMap model = new ModelMap();
        model.addAttribute("students",students);
        System.out.println(students);
        return "show";
    }
}
