$(document).ready(function() {


    // submit formulaire ajouter livre
    $("#formInsertSubmit").click(function() {
        
        $("#formInsert").submit();
        
    });

    
    
    // prépare le formulaire effacer
    $(".btn-effacer").click(function() {

        var value = this.value;
        var titre = $("#titreListe"+value).html();
        var tome = $("#tomeListe"+value).html();

        $("#effacerTitre").html(titre);
        $("#effacerTome").html(tome);
        $("#inputId").val(value);

    })

    
    
    // submit formulaire effacer livre
    $("#formDeleteSubmit").click(function() {
        
        $("#formDelete").submit();
        
    })
    
    
    // prépare le formulaire modifier
    $(".btn-modifier").click(function() {
        
        var value = this.value;
        var titre = $("#titreListe"+value).html();
        var tome = $("#tomeListe"+value).html();
        
        $("#inputModifierTome").val(tome);
        $("#inputModifierId").val(value);
        
    })
    
    
    // submit formulaire modifier livre
    $("#formModifierSubmit").click(function() {
        
        $("#formModifier").submit();
        
    })

})