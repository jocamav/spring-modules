
var CUSTOMER_URL = "/api/customer/";

function getSingleCustomer(id) {
	var $responseDiv = $('#customerResponse');
	
	var url = CUSTOMER_URL + id;
	
    $.getJSON( url, function( data ) {
    	var parsed_result = JSON.stringify(data);
    	$responseDiv.text(parsed_result);
    })
}

function getAllCustomers() {
	var $responseDiv = $('#listCustomerResponse');
	
	var url = CUSTOMER_URL;
	
    $.getJSON( url, function( data ) {
    	var parsed_result = JSON.stringify(data);
    	$responseDiv.text(parsed_result);
    	getSingleCustomer(data[0].id)
    })
}

$( document ).ready(function() {

	getAllCustomers();
	
});