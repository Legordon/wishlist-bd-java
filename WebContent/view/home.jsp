
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Description de la page -->
        <meta name="description" content="Wishlist des BD/comics/manga que je souhaite me procurer">

        <title>WishList BD</title>

        <!-- CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/wishlist.css" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    </head>

    <body>

        <div id="containerHome" class="container">
        
        	<%@ include file="navbar.jsp" %>
        	
        	<%@ include file="boutons.jsp" %>
        	<%@ include file="info.jsp" %>
        	<%@ include file="liste.jsp" %>
			
        </div>


        <!-- Javascript, Jquery, bootstrap -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.js"
                integrity="sha256-fNXJFIlca05BIO2Y5zh1xrShK3ME+/lYZ0j+ChxX2DA="
                crossorigin="anonymous"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/wishlist.js"></script>
    </body>
</html>