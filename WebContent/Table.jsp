
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%--         <% 
            String table=request.getParameter("abc");
            try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","production","12345");
            String q= "select * from "+table;
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(q);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();
           // out.println("<h4>Table column Count=" + numberOfColumns+"</h4>");
            out.print("<table class='tb'>");
            out.print("<tbody style='cursor:pointer'>");
            out.print("<tr>");
            int aa=1;
            for (int i=1; i<=numberOfColumns; i++) 
            {
                
                if(aa<=10)
                {
                out.print("<th >");
                out.print(rsMetaData.getColumnName(i));
                out.print("</th>");
                 aa++;
                }
            }
           out.print("</tr>");
            
            while(rs.next()) 
            { 
                int a=1;
                out.print("<tr class='tr'>");
                for(int i=1;i<=numberOfColumns;i++)
                {
                    
                    if(a<=10)
                    {
                    out.println("<td>"+rs.getString(i)+"</td>"); 
                    a++;
                    }
                }
                out.print("</tr>");
                
            }
            out.print("</tbody>");
            out.print("</table>");
            
            out.println("</body>");
            out.println("</html>");
        }
        catch(ClassNotFoundException ce)
        {
            System.out.println("ClassNotFound Error : "+ce);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Error : "+e);
        }
        %>
 --%>        
    </body>
</html>
