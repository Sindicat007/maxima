package freemarker;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "StaticResourceServlet", urlPatterns = "/static/*")
public class StaticResourceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String resourcePath = request.getPathInfo();
        InputStream resourceStream = getClass().getResourceAsStream("/static" + resourcePath);

        if (resourceStream == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String mimeType = getServletContext().getMimeType(resourcePath);
        if (mimeType != null) {
            response.setContentType(mimeType);
        }

        try (resourceStream) {
            resourceStream.transferTo(response.getOutputStream());
        }
    }
}