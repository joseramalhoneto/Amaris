$(document).ready(function() {
    $.ajax({
        type:"GET",
        dataType: "json",
        url: "http://localhost:8080/supply-chain",
        success: function(data) {
            $.each(data, function(index, element) {
                $('#table-instruments').append('<tr><th scope="row">' + element.id + '</th><td>' + element.name + '</td><td>' + element.price + '</td><td>' + element.quantity + '</td><td><button type="button" class="btn btn-light btn-sm" data-toggle="modal" data-target="#modalDelete" onclick="setIdDelete( ' + element.id + ')">Delete</button></td></tr>');
            });
        }
    });
});

function insertProduct(){
    $.ajax({
        type:"POST",
        processData: false,
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
          name: $("#name").val(),
          price: $("#price").val(),
          quantity: $("#quantity").val()
        }),
        url: "http://localhost:8080/supply-chain/",
        success: function(data) {
            location.reload(true);
        }
    });
}

function deleteProduct(){
    $.ajax({
        type:"DELETE",
        url: "http://localhost:8080/delete/" + $("#inputIdDelete").val(),
        success: function(data) {
            location.reload(true);
        }
    });
}

function setIdDelete(id){
    $("#inputIdDelete").val(id);
}
