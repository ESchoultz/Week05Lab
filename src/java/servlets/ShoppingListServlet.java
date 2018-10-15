/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 669385
 */
public class ShoppingListServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (request.getParameter("action") != null && request.getParameter("action").equals("logout")) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        if (session.getAttribute("user") != null) {
            request.setAttribute("shoppinglist", session.getAttribute("items"));
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String item = (String) request.getParameter("rbutton");
        String action = request.getParameter("action");

        switch (action) {
            case "register":
                String user = request.getParameter("user");
                session.setAttribute("user", request.getParameter("user"));
                if ((user != null) || !(user.equals(" "))) {
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                }
                break;

            case "add":
                if (session.getAttribute("shoppinglist") == null) {
                    ArrayList<String> items = new ArrayList<String>();
                    session.setAttribute("shoppinglist", items);
                    ((ArrayList<String>) session.getAttribute("shoppinglist")).add(request.getParameter("item"));
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                } else if ((request.getParameter("item") != null) || !(request.getParameter("item").equalsIgnoreCase(" "))) {
                    ((ArrayList<String>) session.getAttribute("shoppinglist")).add(request.getParameter("item"));
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                }
                break;

            case "delete":
                ((ArrayList<String>) session.getAttribute("shoppinglist")).remove(item);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                break;

            case "logout":
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                break;
        }

    }
}
