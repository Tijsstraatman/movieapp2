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
        firstName: $("#addFirstName").val(),
        lastName: $("#addLastName").val(),
        address: $("#addAddress").val(),
        postalCode: $("#addPostalCode").val(),
        city: $("#addCity").val(),
        country: $("#addCountry").val(),
        phoneNumber: $("#addPhoneNumber").val(),
        email: $("#addEmail").val()
    };
    makeAjaxRequest("POST", "/addGuest", obj, function(guest) {
        if (guest) {
            console.log(true);
        console.log(guest);
        $("#dataTable tbody").append("<tr><td>" + guest.id +
            "</td><td>" + guest.firstName +
            "</td><td>" + guest.lastName +
            "</td><td>" + guest.address +
            "</td><td>" + guest.postalCode +
            "</td><td>" + guest.city +
            "</td><td>" + guest.country +
            "</td><td>" + guest.phoneNumber +
            "</td><td>" + guest.email +
            "</td><td>" + "<a href=\"javascript:del(" + guest.id + ")\" class=\"btn btn-danger\">Delete</a>" +
            "</td></tr>");
        refreshTable();
        } else {
            console.log(false);
             alert("some of your input is not correct, please verify your input");
        }

function refreshTable() {
    table.clear();
    populateTable();
    table.draw();
}