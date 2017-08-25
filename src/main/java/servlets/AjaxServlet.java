package servlets;

import mb.ListOfProducts;
import org.primefaces.json.JSONArray;
import service.ws.ProductWSClient;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maria on 23.08.2017.
 */
@WebServlet("/getjson")
public class AjaxServlet extends HttpServlet {

    @Inject
    ListOfProducts listOfProducts;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        JSONArray ar=new JSONArray(listOfProducts.getListOfProducts());
        String json= ar.toString();
        System.out.println("AjaxServlet");
       response.getWriter().write(json);
    }



}
