var element = document.querySelector('#calculate');

element.addEventListener("click", function() {
	onChangeSubmitCallWebServiceAJAX();
});
function onChangeSubmitCallWebServiceAJAX() {
	var data = document.getElementById("data").value;

	if (document.querySelector('input[name="type"]:checked') != null && data != '') {
		var type = document.querySelector('input[name="type"]:checked').value;
		xhr = new XMLHttpRequest();
		xhr.open('POST', 'time');
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.onload = function() {
			if (xhr.status === 200 && xhr.readyState == 4) {
				document.getElementById('readTime').innerHTML = 'The read time of ' + JSON.parse(xhr.responseText).type + ' is ' + JSON.parse(xhr.responseText).minutes + ' minutes';
			}
			else if (xhr.status !== 200) {
				alert('Request failed.  Returned status of ' + xhr.status);
			}
		};

		xhr.send(JSON.stringify({
			text: data,
			type: type
		}));
	}
	else {
		if (document.querySelector('input[name="type"]:checked') === null)
			alert('Please select a type');
		else if(data === '')
			alert('Please enter text');
	}
}