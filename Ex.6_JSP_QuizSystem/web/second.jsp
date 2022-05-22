<%-- 
    Document   : second
    Created on : 18 May, 2022, 2:22:33 PM
    Author     : welcom
--%>

<%@page import="DB_Connection.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String firstqn = request.getParameter("frstqn");
            String scndqn = request.getParameter("scndqn");
            String thirdqn = request.getParameter("thirdqn");
            int score1 = 0;
            if (firstqn.equalsIgnoreCase("red")) {
                score1++;
            }
            if (scndqn.equalsIgnoreCase("yellow")) {
                score1++;
            }
            if (thirdqn.equalsIgnoreCase("purple")) {
                score1++;
            }
            //String sc=score.toString();
            Cookie ck[] = request.getCookies();
           // ck[1].getName();
            String uuname=ck[1].getValue();
            String query = "insert into score values('"+uuname+"','"+score1+"')";
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            st.executeUpdate(query);

            String query1 = "select * from score";
            //Connection con=ConnectionProvider.getCon();
            // Statement st=con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            out.println("<html><body>");
            out.println("<head><style>table, th, td {border: 1px solid black;}</style><head>");
            out.println("<h1>Hello "+uuname+" your Score is &nbsp;" + score1 + "</h1>");
            out.println("<h2>----All Results----</h2>");
            out.println("<table><tr><th>Name</th><th>Score</th></tr>");
            
            while (rs.next()) {
                out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td></tr>");
            }
            out.println("</body></html>");
        %>
    </body>
</html>
