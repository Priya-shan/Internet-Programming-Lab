<%-- 
    Document   : first
    Created on : 18 May, 2022, 2:22:18 PM
    Author     : welcom
--%>

<%@page import="DB_Connection.ConnectionProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
        String uname=request.getParameter("uname");    
        String pw=request.getParameter("pw"); 
        //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        //Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/QuizDB","root","root");
        Cookie ck=new Cookie("uname",uname);
        response.addCookie(ck);
        String query="select password from authentication where username='"+uname+"'";
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            if(rs.getString(1).equals(pw)){
                out.println("<html><body>");
                out.println("<h1>Welcome "+uname+"</h1>");
                out.println("<h1>Sample Quiz</h1>");
                out.println("<form action='second.jsp'>");
                out.println("<label>What is the color of apple? </label><br><br><span><input type='radio' name='frstqn' value='green'></span><span><label>Green</label></span><span><input type='radio' name='frstqn' value='red'></span><span><label>Red</label></span><span><input type='radio' name='frstqn' value='violet'></span><span><label>Violet</label></span><br><br>");
                out.println("<label>What is the color of mango? </label><br><br>"
                        + "<span><input type='radio' name='scndqn' value='yellow'></span>"
                        + "<span><label>Yellow</label></span>"
                        + "<span><input type='radio' name='scndqn' value='blue'></span>"
                        + "<span><label>Blue</label></span>"
                        + "<span><input type='radio' name='scndqn' value='green'></span>"
                        + "<span><label>Green</label></span><br><br>");
                out.println("<label>What is the color of grapes? </label><br><br>"
                        + "<span><input type='radio' name='thirdqn' value='grey'></span>"
                        + "<span><label>Grey</label></span>"
                        + "<span><input type='radio' name='thirdqn' value='purple'></span>"
                        + "<span><label>Purple</label></span>"
                        + "<span><input type='radio' name='thirdqn' value='white'></span>"
                        + "<span><label>White</label></span><br><br>");
                out.println("<input type='submit' value='submit'>");
                out.println("</body></html>");
            }
            else{
                out.println("<html><body>");
                out.println("<h1>Login Failed...Retry </h1>");
                out.println("</body></html>");
            }
        }
        %>
    </body>
</html>
