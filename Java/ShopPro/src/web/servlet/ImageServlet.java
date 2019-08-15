package web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@WebServlet(name = "ImageServlet", urlPatterns = "/ImageServlet")
public class ImageServlet extends BaseServlet {

    public void upload(HttpServletRequest request , HttpServletResponse response) throws FileUploadException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = upload.parseRequest(request);
        FileItem fileItem = fileItems.get(0);
        String fileName = null;
        if (!fileItem.isFormField()){
//            String filePath = "D:\\TEST\\Java\\ShopPro\\web\\images";
            String filePath = this.getServletContext().getRealPath("images");
            File realPath = new File(filePath);
            if (!realPath.exists()){
                realPath.mkdirs();
            }
            fileName = fileItem.getName();
            File file = new File(realPath,fileName);
            IOUtils.copy(fileItem.getInputStream(),new FileOutputStream(file));
        }
        response.getWriter().write(fileName);
    }
}
