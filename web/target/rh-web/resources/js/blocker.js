var inicio = function() {
	$.blockUI({
		message : 'Processando <blink>...</blink>'
	});
};

var fim = function() {
	$.unblockUI();
};