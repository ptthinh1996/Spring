package persistence;

import model.Student;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Repository;
import utils.DatabaseUtils;
import utils.FileUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {

    DatabaseUtils databaseUtils = new DatabaseUtils();
    ArrayList<model.Student> students;

    public void create(HttpServletRequest request) {
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
            students =  FileUtils.readFile(fileUrl);
        }
        databaseUtils.insertData(students);
    }

    public ArrayList<Student> read(){
        return DatabaseUtils.readData();
    }
}
