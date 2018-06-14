
<div id="listeBD" class=" col-lg-10 col-lg-offset-1">


    <!-- LISTE DES LIVRES -->
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Titre</th>
                <th class="text-center">Tome</th>
                <th>Genre</th>
                <th></th>
            </tr>
        </thead>

        <tbody>
            
            <c:forEach items="${ biblio }" var="livre">
	            <tr>
	                <td id="titreListe${ livre.id }"><c:out value="${ livre.titre }">Titre par défaut</c:out></td>
	                <td id="tomeListe${ livre.id }" class="text-center"><c:out value="${ livre.tome }">00</c:out></td>
	                <td><c:out value="${ livre.genre }">Genre par défaut</c:out></td>
	                <td class="text-right">
	                    <button class="btn btn-sm btn-default btn-modifier" value="${ livre.id }" data-toggle="modal" data-target="#modalModifier" title="Modifier ce livre ?"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span></button>
	                    <button class="btn btn-sm btn-default btn-effacer" value="${ livre.id }" data-toggle="modal" data-target="#modalEffacer" title="Effacer ce livre ?"><i class="fas fa-times"></i></button></td>
	            </tr>
            </c:forEach>
            
       	</tbody>
    </table>
    
    
    <!-- FENETRE MODALE POUR MODIFIER -->
    <div class="modal fade" id="modalModifier" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Modifier</h4>
                </div>

                <div class="modal-body">
                    <form id="formModifier" method="post">
                        <input type="hidden" id="inputModifierId" name="inputId" value="">
                        <input type="number" class="form-control input-lg" id="inputModifierTome" name="inputTome" value="">
                        <input type="hidden" name="hidden" value="modifier">
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                    <button type="submit" id="formModifierSubmit" class="btn btn-danger">Modifier</button>
                </div>
            </div>
        </div>
    </div>


    <!-- FENETRE MODALE POUR EFFACEMENT -->
    <div class="modal fade" id="modalEffacer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Effacer</h4>
                </div>

                <div class="modal-body">
                    <div>
                        <p>Effacer de la base de données :<p>
                        <p><strong><span id="effacerTitre" class="text-bold">titre</span></strong>, T <strong><span id="effacerTome">tome</span></strong> ?? </p>
                        <div class="alert alert-danger text-center">
                            <p>Effacement définitif !</p>
                        </div>
                    </div>

                    <form id="formDelete" method="post">
                        <input type="hidden" id="inputId" name="inputId" value="">
                        <input type="hidden" name="hidden" value="effacer">
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                    <button type="submit" id="formDeleteSubmit" class="btn btn-danger">Effacer</button>
                </div>
            </div>
        </div>
    </div>
</div>
</html>