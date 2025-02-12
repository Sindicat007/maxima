package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    private Configuration cfg;

    @Override
    public void init() {
        cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(MainServlet.class, "/templates");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template template = cfg.getTemplate("mainPage.html");
        Map<String, Object> model = new HashMap<>();
        try (PrintWriter writer = resp.getWriter()) {
            template.process(model, writer);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
