<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.stream.IntStream"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <%
    int a = 0;
    int b = 0;
    int c = 0;
    int total=0;
    String[] Aa = {"00","33","66","99","CC","FF"};
    String[] Bb = {"00","33","66","99","CC","FF"};
    String[] Cc = {"00","33","66","99","CC","FF"};
    String A ="";
    String B ="";
    String C ="";
    String D ="";
    while (a < 6) {
        out.println("<table>");
            while (b < 6) {
                out.println("<tr>");
                    while (c < 6) { 
                        A = Aa[a];
                        B = Bb[b];
                        C = Cc[c];
                        D = "<td style='text-align: center; width: 100px;' bgcolor='#"+A+B+C+"'>"+A + B + C +"</td>";
                        c++;
                        out.println(D); 
                    }
                if (c==6){
                    c=0;
                }
                b++;
                out.println("</tr>");
            }
        if (b==6){
            b=0;
        }
        a++;
        out.println("</table>");
    }
    %>
    

