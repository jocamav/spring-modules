
function getGreeting(name) {
	var $responseDiv = $('.response');
	var $spinerDiv = $('.spinner-border ');
	
	$spinerDiv.show();
	var url = "/api/greeting?name=" + name;
	
    $.getJSON( url, function( data ) {
    	var parsed_result = JSON.stringify(data);
    	$responseDiv.text(parsed_result);
    	$spinerDiv.hide();
    })
}

$( document ).ready(function() {

	var $spinerDiv = $('.spinner-border ');
	var $confirmButton = $('#confirmHello');
	
	$spinerDiv.hide();
	
	$confirmButton.on( "click", function() {
		var name = $('input#inputName').val();
		getGreeting(name);
	});
	
});