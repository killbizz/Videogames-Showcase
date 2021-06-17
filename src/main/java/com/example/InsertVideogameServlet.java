package com.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.example.model.Videogame;
import java.util.UUID;


@WebServlet(
        name = "InsertVideogameServlet",
        urlPatterns = "/InsertVideogameServlet"
)
public class InsertVideogameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = UUID.randomUUID().toString();
        String name = req.getParameter("Name");
        String description = req.getParameter("Description");
        double price = Double.parseDouble(req.getParameter("Price"));
        Videogame v = new Videogame(id, name, description, price);

        VideogameService vService = new VideogameService();

        boolean inserted = vService.insertNewVideogameToDB(v);

        req.setAttribute("VideogameInserted", inserted);
        RequestDispatcher view = req.getRequestDispatcher("./index.jsp");
        view.forward(req, resp);

    }
}