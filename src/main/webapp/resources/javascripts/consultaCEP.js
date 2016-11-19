function consultarCEP(){
	var cep = $('#frm\\:cep').val();
	alert("Cep: "+cep);
	$.ajax({
		url: 'http://api.postmon.com.br/v1/cep/'+cep,
		type: 'GET'
	})
	.done(function(json) {
		$('#frm:logradouro').val(json['logradouro']);
		$('frm:bairro').val(json['bairro']);
		$('frm:cidade').val(json['cidade']);
		$('frm:estado').val(json['estado_info']['nome']);
	})
	.fail(function() {
		var cep = $('#cep').val();
		console.log('Erro au consultar o CEP ' + cep);
	});	
}