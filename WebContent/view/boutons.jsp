
<div id="boutonAjouter" class="col-sm-4 col-sm-offset-4 text-center">
    <button class="btn btn-primary btn-lg btn-block" type="button" data-toggle="modal" data-target="#modalInsert" title="Ajouter un livre dans la base de données"><span class="glyphicon glyphicon-book" aria-hidden="true"></span>&nbsp;&nbsp;Ajouter une BD</button>
</div>


<!-- Formulaire INSERT -->
<div class="modal fade" id="modalInsert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Ajouter un nouveau livre</h4>
            </div>
            
            <div class="modal-body">
                <form id="formInsert" method="post">
                    <div class="form-group">
                        <label for="inputTitre">Titre</label>
                        <input type="text" class="form-control input-lg" id="inputTitre" name="inputTitre" placeholder="Titre">
                    </div>
                    <div class="form-group">
                        <label for="inputTome">Tome</label>
                        <input type="number" class="form-control input-lg" id="inputTome" name="inputTome" placeholder="Tome">
                    </div>
                    <div class="form-group">
                        <label>Genre</label>
                        <select class="form-control input-lg" name="inputGenre">
                            <option value="1">BD</option>
                            <option value="2">Manga</option>
                            <option value="3">Comics</option>
                        </select>
                    </div>
                    <input type="hidden" name="hidden" value="ajouter">
                </form>
            </div>
            
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                <button type="submit" id="formInsertSubmit" class="btn btn-primary">Ajouter</button>
            </div>
        </div>
    </div>
</div>