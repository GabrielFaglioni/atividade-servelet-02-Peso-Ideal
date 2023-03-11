package org.example;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "pesoIdealServlet", value = "/calculoPesoIdeal")
public class pesoIdealServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sexo = req.getParameter("sexo");
        Double altura = Double.parseDouble(req.getParameter("altura"));

        Double idealWeight = sexo.equals("M") ? ((72.7 * altura) - 58) : ((62.1 * altura) - 44.7);

        req.setAttribute("idealWeight", String.format("%.2f %%", idealWeight));
        resp.setHeader("idealWeight", String.format("%.2f", idealWeight));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}