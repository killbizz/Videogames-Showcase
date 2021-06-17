package com.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.example.model.Videogame;
import java.util.Map;


@WebServlet(
        name = "CatalogServlet",
        urlPatterns = "/Catalog"
)
public class CatalogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        VideogameService vService = new VideogameService();

        Map<String, Videogame> videogames = vService.getVideogamesFromDB();

        req.setAttribute("videogames", videogames);
        RequestDispatcher view = req.getRequestDispatcher("./videogameList.jsp");
        view.forward(req, resp);

    }
}
