<%-- 
    Document   : listaresult
    Created on : 12 de ago. de 2021, 15:16:28
    Author     : alkaw
--%>
<%@page import="entidades.Produto"%>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
        
        <h2 style="text-align: center">Lista de Produtos</h2>
        <ul style="text-align:center">
        <%
            
              List<Produto> result=(List)request.getAttribute("lista");
             if (result.size() != 0) {
                for (int i = 0; i < result.size(); i++) {
                    out.println("<li>" + result.get(i).getNome() + "</li>");
                }
            
            }
            %>
        </ul>
    </body>
</html>
