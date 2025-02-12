package task2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/submit")
public class SubmitServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.setContentType("text/html; charset=UTF-8");
        if (name == null || name.isEmpty()) {
            name = "Гость";
        }

        PrintWriter writer = response.getWriter();
        writer.write(String.format("<h1>Добро пожаловать, %s</h1>", name));
    }
}
