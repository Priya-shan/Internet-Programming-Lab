
package newpackage;

import DB_Connection.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String roll=request.getParameter("roll").toString();
        PrintWriter out = response.getWriter();
            try{
        String query="select * from studentdetails where rollnumber='"+roll+"'";
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student Portal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Student Detail</h1>");
            out.println("<h4>Name :" + rs.getString(2) + "</h4>");
            out.println("<h4>Roll Number :" + rs.getString(1) + "</h4>");
            out.println("<h4>Department :" + rs.getString(3) + "</h4>");
            out.println("<h4>CGPA :" + rs.getString(4) + "</h4>");
            out.println("<h4>Average :" + rs.getString(5) + "</h4>");
            out.println("</body>");
            out.println("</html>");
        }
        }
        catch(SQLException e){
        out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rollnum=request.getParameter("stroll");
        String name=request.getParameter("name");
        String dept=request.getParameter("dept");
        String cgpa=request.getParameter("cgpa");
        String avg=request.getParameter("avg");
        PrintWriter out = response.getWriter();
        try{
        String query="insert into studentdetails values('"+rollnum+"','"+name+"','"+dept+"','"+cgpa+"','"+avg+"')";
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        st.executeUpdate(query);
        }
        catch(SQLException e){
            out.println(e.getMessage());
        }
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add Student Detail</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Student Added Successfully...</h2>");
        out.println("</body ></html>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
