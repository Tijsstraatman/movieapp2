var table;

$(document).ready(function() {
    var t = $('#dataTable').DataTable();
    var counter = 1;

    $('#addButton').on( 'click', function () {
       createMovie();
    } );

    // Automatically add a first row of data
    $('#addRow').click();
} );

function createMovie() {
    var obj = {
        title: $("#addTitle").val(),
        rating: $("#addRating").val(),
        watched: $("#addWatched").val()

    };

    makeAjaxRequest("POST", "/addMovie", obj, function(movie) {
        if (movie) {
            console.log(true);
            console.log(movie);
            $("#dataTable tbody").append("<tr><td>" + movie.id +
                "</td><td>" + movie.title +
                "</td><td>" + movie.rating +
                "</td><td>" + movie.watched +

                "</td><td>" + "<a href=\"javascript:del(" + movie.id + ")\" class=\"btn btn-danger\">Delete</a>" +
                "</td></tr>");
            refreshTable();
        } else {
            console.log(false);
            alert("some of your input is not correct, please verify your input");
        }

    })}

function refreshTable() {
    table.clear();
    populateTable();
    table.draw();
}


function populateTable() {
    var endpoint = "/getMovieList";
    makeGetRequest(endpoint, function (movie) {
        $.each(movie, function (key, movie) {
            $("#dataTable tbody").append(
                "<tr><td>" + "<a href=\"javascript:edit(" + movie.id + ")\" class=\"btn btn-danger\">Edit</a>" +
                "</td><td>" + movie.title +
                "</td><td>" + movie.rating +
                "</td><td>" + movie.watched +

                "</td><td>" + "<a href=\"javascript:del(" + guest.id + ")\" class=\"btn btn-danger\">Delete</a>" +
                "</td></tr>");

        });
    });
}