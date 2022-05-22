/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 19cse083
 */
@WebServlet(name = "BookDetails", urlPatterns = {"/BookDetails"})
public class BookDetails extends HttpServlet {

    bookdetailsinventory obj[] = new bookdetailsinventory[5];

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int flag = 0;
        obj[0] = new bookdetailsinventory("harrypotter", "rowling", 500, "rkpublications", 5);
        obj[1] = new bookdetailsinventory("twilight", "stephan", 1500, "jkpublications", 2);
        obj[2] = new bookdetailsinventory("2states", "bahat", 800, "rampublications", 15);
        obj[3] = new bookdetailsinventory("immortals", "amish", 200, "bhaipublications", 5);
        obj[4] = new bookdetailsinventory("divergent", "veronica", 900, "kgfpublications", 3);

        try {
            /* TODO output your page here. You may use following sample code. */
            String title = request.getParameter("title");
            String author = request.getParameter("auth");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookDetails</title>");
            out.println("</head>");
            out.println("<body>");

            int f = 0;
            for (int i = 0; i < 5; i++) {
                if (title.equalsIgnoreCase(obj[i].title) && author.equalsIgnoreCase(obj[i].author)) {
                    f = 1;
                    out.println("<h1>Book " + title + " found </h1>");
                    out.println("<h3> Title : " + obj[i].title + "</h3>");
                    out.println("<h3> Author : " + obj[i].author + "</h3>");
                    out.println("<h3> Price : " + obj[i].price + "</h3>");
                    out.println("<h3> Publisher : " + obj[i].publisher + "</h3>");

                    out.println("<br><br><br><form action='BookDetails' method='post' ><label >Number of Copies required </label><span><input type='text' name='count'></span><br><input type='hidden' name='posn' value=" + i + "><br><input type='submit' value='SEARCH'></form>");

                    out.println("</body>");
                    out.println("</html>");
                }
            }
            if (f == 0) {
                out.println("<html><body>");
                out.println("<h2> Book not found</h2>");
                out.println("</html></body>");

            }
        }
        finally {            
            out.close();
    }
}

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
            int count=Integer.parseInt(request.getParameter("count"));
            int pos=Integer.parseInt(request.getParameter("posn"));
            PrintWriter out = response.getWriter();
            if(count<obj[pos].stock || count==obj[pos].stock){
               out.println("<html><body>");
               out.println("<h1>Total Bill Amount : "+((obj[pos].price)*count)+"</h1>");
               out.println("</html></body>");   
            }
            else{
                out.println("<html><body>");
               out.println("<h2>Out of stock come again later</h2>");
               out.println("<h3>Requested Stocks - "+count+"</h3>");
               out.println("<h3>Only "+obj[pos].stock+" stock left</h3>");
               out.println("</html></body>");  
            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    

}// </editor-fold>
}
    class bookdetailsinventory {

    String title;
    String author;
    int price;
    String publisher;
    int stock;

    bookdetailsinventory(String t, String a, int pr, String pub, int st) {
        title = t;
        author = a;
        price = pr;
        publisher = pub;
        stock = st;
    }
}
