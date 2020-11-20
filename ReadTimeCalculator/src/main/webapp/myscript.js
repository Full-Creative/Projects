$(document).ready(function() {
	$("#calculate").click(function() {
		getReadTimeFromServlet();
	});

});
function getReadTimeFromServlet() {
	var obj = {
		'text': $('#data').val(),
		'type': $('input[name="type"]:checked').val()
	};
	$.ajax({
		type: "POST",
		url: "time",
		contentType: "application/json",
		data: JSON.stringify(obj),
		success: function(response) {
			printReadTime(response);
		}

	});
};
function printReadTime(response) {
	$('#readTime').html('The read time of ' + response.type + ' is ' + response.minutes + ' minutes');

}