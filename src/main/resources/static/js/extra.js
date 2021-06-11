$(function() {
    // ------------------------------------------------------- //
    // Multi Level dropdowns
    // ------------------------------------------------------ //
    $("ul.dropdown-menu [data-toggle='dropdown']").on("click", function(event) {
        event.preventDefault();
        event.stopPropagation();

        $(this).siblings().toggleClass("show");


        if (!$(this).next().hasClass('show')) {
            $(this).parents('.dropdown-menu').first().find('.show').removeClass("show");
        }
        $(this).parents('li.nav-item.dropdown.show').on('hidden.bs.dropdown', function(e) {
            $('.dropdown-submenu .show').removeClass("show");
        });

    });
});

$( document.body ).on( 'click', '.dropdown-menu li', function( event ) {

    var $target = $( event.currentTarget );

    $target.closest( '.btn-group' )
        .find( '[data-bind="label"]' ).text( $target.text() )
        .end()
        .children( '.dropdown-toggle' ).dropdown( 'toggle' );

    return false;

});

$(document).ready( function () {
    $('#myTable').DataTable();
} );