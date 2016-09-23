PrimeFaces . locales ['pt'] = {
	closeText : 'Fechar',
	prevText : 'Anterior ',
	nextText : 'Pr�ximo ',
	currentText : 'Hoje ',
	monthNames : ['Janeiro ','Fevereiro ','Março ','Abril ','Maio ','Junho ', 'Julho ','Agosto ','Setembro ','Outubro ','Novembro ','Dezembro '],
	monthNamesShort : ['Jan ','Fev ','Mar ','Abr ','Mai ','Jun ', 'Jul ','Ago ','Set ','Out ','Nov ','Dez '],
	dayNames : ['Domingo ','Segunda ','Terça ','Quarta ','Quinta ','Sexta ','Sábado '],
	dayNamesShort : ['Dom ','Seg ','Ter ','Qua ','Qui ','Sex ','Sáb '],
	dayNamesMin : ['D','S','T','Q','Q','S','S'],
	weekHeader : 'Semana ',
	firstDay : 0,
	isRTL : false ,
	showMonthAfterYear : false ,
	yearSuffix : '',
	timeOnlyTitle : 'Só Horas ',
	timeText : 'Tempo ',
	hourText : 'Hora ',
	minuteText : 'Minuto ',
	secondText : 'Segundo ',
	ampm : false ,
	month : 'Mês ',
	week : 'Semana ',
	day : 'Dia ',
	allDayText : 'Todo o Dia '
 };

PrimeFaces.widget.DataTable.prototype.onRowClick = function() {};


function fechaModal(args, m) {
	if(!args.validationFailed) {
		if (m !== undefined) {
			m.hide();
		}
	}
}


function clearErrorState(){
	$('.ui-state-error').removeClass('ui-state-error');
}

function FileDragHover(e) {
	e.stopPropagation();
	e.preventDefault();
	e.target.className = (e.type == "dragover" ? "hover" : "");
}

function FileSelectHandler(e) {
	e.target.className = (e.type == "dragover" ? "hover" : "");
}

function getPathContext(){

	//Path
	return window.location.pathname.split('/')[1];
	
}


var navegadoresCompativeis =[{nome: "firefox", versao: 22},
                  {nome: "chrome", versao: 28},
                  {nome: "opera", versao: 15},
                  {nome: "safari", versao: 5}];

function validaNavegador(){
	
	var navegadorDoUsuario = obtemNavegadorDoUsuario();
	var isNavegadorCompativel = false;
	
	for(var i=0;i<navegadoresCompativeis.length;i++){
		if(navegadorDoUsuario.nome == navegadoresCompativeis[i].nome && navegadorDoUsuario.versao >= parseInt(navegadoresCompativeis[i].versao)){
			isNavegadorCompativel=true;
		} 
	}
}

/**
 * Obtem o Navegador utilizado [nome] / versao do Navegador utilizado [versao]
 */
function obtemNavegadorDoUsuario(){
	var tem;
    var M = navigator.userAgent.match(/(opera|chrome|safari|firefox)\/?\s*(\.?\d+(\.\d+)*)/i);
    if(M && (tem= navigator.userAgent.match(/version\/([\.\d]+)/i))!= null) M[2] = tem[1];
    M=M? [M[1], M[2]]: [navigator.appName, navigator.appVersion, '-?'];
    
    return { nome: M[0].toLowerCase(), versao: parseInt(M[1]) };
}


/**
 * Guarda e restaura o scroll dos datagrids quando ocorre um update em todo o form. 
 * Necessário usar no onstart e oncomplete do remotecommand ou do ajax.
 */
var scrollPosition = 0;

function saveScrollPosition(idComponenteJsf) {
	scrollPosition = $(idComponenteJsf).scrollTop();
}
function getScrollPosition(idComponenteJsf) {
	 $(idComponenteJsf).scrollTop(scrollPosition);
}

