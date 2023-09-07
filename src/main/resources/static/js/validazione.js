$(document).ready(function() {
	$('#corsistaForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			nome: {
				container: '#infoNome',
				validators: {
					notEmpty: {
						message: 'Il campo nome non può essere vuoto'
					},
					regexp: {
						regexp: /^[a-zA-Z ,.'-]{2,30}$/,
						message: 'Da 2 a 30 caratteri (Solo lettere)'
					}
				}
			},
			cognome: {
				container: '#infoCognome',
				validators: {
					notEmpty: {
						message: 'Il campo cognome non può essere vuoto'
					},
					regexp: {
						regexp: /^[a-zA-Z ,.'-]{2,30}$/,
						message: 'Da 2 a 30 caratteri (Solo lettere)'
					}
				}
			},
			dataInizio: {
				container: '#infoDataInizio',
				validators: {
					notEmpty: {
						message: 'Il campo inizio non può essere vuoto'
					},
					date: {
						format: 'DD/MM/YYYY',
						message: 'Inserire una data valida. Formato DD/MM/YYYY'
					}
				}
			},
			dataFine: {
				container: '#infoDataFine',
				validators: {
					notEmpty: {
						message: 'Il campo fine non può essere vuoto'
					},
					date: {
						format: 'DD/MM/YYYY',
						message: 'Inserire una data valida. Formato DD/MM/YYYY'
					}
				}
			},
			costoCorso: {
				container: '#infoCosto',
				validators: {
					notEmpty: {
						message: 'Il campo del prezzo non può essere vuoto'
					},
				}
			},
			nomeCorso: {
				container: '#infoNomeCorso',
				validators: {
					notEmpty: {
						message: 'Il campo nome corso non può essere vuoto'
					},
					regexp: {
						regexp: /^[a-zA-Z ,.'-]{2,30}$/,
						message: 'Da 2 a 30 caratteri (Solo lettere)'
					}
				}
			},
			aulaCorso: {
				container: '#infoAulaCorso',
				validators: {
					notEmpty: {
						message: 'Il campo aula corso non può essere vuoto'
					},
					regexp: {
						regexp: /^[a-zA-Z0-9 ,.'-]{2,30}$/,
						message: 'Da 2 a 30 caratteri'
					}
				}
			},
			cv: {
				container: '#infoCv',
				validators: {
					notEmpty: {
						message: 'Il campo dell esperienza non può essere vuoto'
					},
				}
			},
			precedentiFormativi: {
				container: '#infoPrecedentiFormativi',
				validators: {
					notEmpty: {
						message: 'Selezionare una delle opzioni'
					}
				}
			}
		}
	});
});