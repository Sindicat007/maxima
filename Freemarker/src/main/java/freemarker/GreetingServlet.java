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

@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
    private Configuration cfg;

    @Override
    public void init() {
        cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(GreetingServlet.class, "/templates");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        Map<String, Object> model = new HashMap<>();
        model.put("name", name);

        Template template = cfg.getTemplate("greet.ftl");
        try (PrintWriter writer = resp.getWriter()) {
            template.process(model, writer);
        } catch (Exception e) {
            throw new ServletException("Error processing Freemarker template", e);
        }
    }
}