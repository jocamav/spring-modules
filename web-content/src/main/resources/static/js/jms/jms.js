
function sendMail(to, body) {
	console.log("Sending mail <" + to + ">: "+body)
	
	var url = "/api/jms";
	
	var body = {
			to: to,
			body: body
	}
	var bodyAsStr = JSON.stringify(body);
	
	$.ajax({
			url:url,
			type:"POST",
			data:bodyAsStr,
			contentType:"application/json",
			dataType:"json",
			success: function(data) {
				$('#inlineFormInputTo').val("");
				$('#inlineFormInputBody').val("");
				$('#confirmationModal').modal('show')
				console.log("Mail has been sent");
			}
	});
}

$( document ).ready(function() {
	var $confirmButton = $('#confirmMailSending');
	
	$confirmButton.on( "click", function() {
		var to = $('#inlineFormInputTo').val();
		var body = $('#inlineFormInputBody').val();
		sendMail(to, body);
	});
	
});