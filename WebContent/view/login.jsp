
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Description de la page -->
        <meta name="description" content="Wishlist des BD/comics/manga que je souhaite me procurer">

        <title>WishList BD - Login</title>

        <!-- CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/wishlist.css" rel="stylesheet">
    </head>


    <body>

        <!-- Jumbotron formulaire connection -->
        <div class="container">
               
            <div class="jumbotron">
                <h1>WishList BD</h1>
                <p>Un site personnel pour faire une liste de BD !</p>
                <div class="alert alert-success">
                	<c:out value="${ info }">Valeur par défaut</c:out>
                </div>
                <form method="post">
                    <div class="form-group">
                        <label for="inputPseudo">Pseudo</label>
                        <input id="inputPseudo" class="form-control" type="pseudo" name="pseudo" placeholder="Pseudo">
                    </div>
                    <div class="form-group">
                        <label for="inputMotDePasse">Mot de passe</label>
                        <input id="inputMotDePasse" class="form-control" type="motDePasse" name="MDP" placeholder="Mot de passe">
                    </div>
                    <input type="hidden" name="login">
                    <button type="submit" class="btn btn-primary btn-lg" href="#" role="button">Se connecter</button>
                </form>
            </div>
        </div>

        <!-- Javascript, Jquery, bootstrap -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.js"
                integrity="sha256-fNXJFIlca05BIO2Y5zh1xrShK3ME+/lYZ0j+ChxX2DA="
                crossorigin="anonymous"></script>
        <script src="js/bootstrap.js"></script>
    </body>
</html>

