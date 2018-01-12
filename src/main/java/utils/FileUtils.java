package utils;

import org.apache.commons.fileupload.FileItem;
import model.Student;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileUtils {
    public static String uploadFile(List<FileItem> fileItems, String dirUrl) {
        for (FileItem fileItem : fileItems) {
            if (!fileItem.isFormField()) {
                String fileName = fileItem.getName();
                if (!fileName.equals("")) {
                    File dir = new File(dirUrl);
                    if (!dir.exists()) {
                        dir.mkdir();
                    }
                    String fileImg = dirUrl + File.separator + fileName;
                    File file = new File(fileImg);

                    try {
                        fileItem.write(file);
                        System.out.println("Directory: \n" + dirUrl);
                        return fileName;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static ArrayList<model.Student> readFile(String filename) {
        ArrayList<Student> listSt = new ArrayList();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            fis = new FileInputStream(filename);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = br.readLine();

            while((line = br.readLine()) != null) {
                String[] st = line.split(",");
                listSt.add(new Student(st[0], st[1], st[2], st[3]));
            }

            ArrayList var8 = listSt;
            return var8;
        } catch (FileNotFoundException var18) {
            var18.printStackTrace();
        } catch (IOException var19) {
            var19.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
            } catch (IOException var17) {
                var17.printStackTrace();
            }

        }

        listSt = null;
        return null;
    }
}
