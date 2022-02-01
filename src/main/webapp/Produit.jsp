<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Page Produit</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <body>
        <div class="container col-md-10">
            <div class="panel panel-primary">
                <div class="panel-heading">Recherche Produit</div>
                <div class="panel-body">
                    <form action="chercher.do" method="get">
                        <label> Mot cle</label>
                        <input type="text" name="motCle">
                        <button type="submit" class="btn btn-primary">Chercher</button>

                    </form>
                    
                    <table class="table">
                       <tr>
                           <th>
                           ID
                           </th>
                           <th>
                           DESIGNATION
                           </th>
                           <th>
                           PRIX
                           </th>
                           <th>
                           QUANTITE
                           </th>
                       </tr>
                       <c:forEach items="${model.pds}" var="p">
                         
                         <tr>
                            <td> ${p.id} </td>
                            <td> ${p.designation} </td>
                            <td> ${p.prix} </td>
                            <td> ${p.quantite} </td>
                            
                         </tr>
                       
                       </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>

    </html>