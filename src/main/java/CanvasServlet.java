import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * Created by Nekochan on 25.09.2016.
 */
public class CanvasServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String img = req.getParameter("img").replaceAll(" ", "+");
        byte[] image = Base64.getDecoder().decode(img);

        FileOutputStream fos = new FileOutputStream(new File("image.png"));

        for (int i = 0; i < image.length; i++)
            fos.write(image[i]);

        resp.setContentType("text/plain");
        resp.getWriter().println("Готово");
    }
}
