
 var app = angular.module('app', ["ngRoute"]);
   
   app.controller('painelInicialController', function($scope, $http) {
       $scope.showCadastro = false;
	   $scope.showLista = false;
       $scope.pessoaWS = montarObjNoticia();
	   $scope.idDelete = '';
	  
	  
   
       $scope.abreCadastroNoticia = function() {
              $scope.showCadastro = true;
       }
	   
	   $scope.fechaCadastroNoticia = function() {
              $scope.showCadastro = false;
       }
	    $scope.abrirListagem = function() {
              $scope.showLista = true;
       }
	     $scope.fecharListagem = function() {
              $scope.showLista = false;
       }
   
       $scope.cadastrarNovaNoticia = function() {                    
              $http.post('http://localhost:8080/CL/ws/user/add', $scope.pessoaWS)
                     .success(function(data) {
                           alert("Cadastro efetuado com sucesso!");
						   $scope.pessoaWS = montarObjNoticia();
                           $scope.showCadastro = false;
						   $scope.listarUsers();
                     }).error(function() {
                           alert("Falha ao cadastrar notícia!");
                     });
       };
	   
	   $scope.deletar = function(idPessoa) {    
              $http.post('http://localhost:8080/CL/ws/user/delete/'+idPessoa ,{params: {'Content-type': 'text/plain'}})
                     .success(function(data) {
						 $scope.listarUsers();
                           alert("Cadastro deletado com  com sucesso!");                            
                     }).error(function() {	  
                           alert("Falha ao deletar usuario!");
                     });
       };
	   $scope.editar = function(pessoa){
		   $scope.pessoaWS = pessoa		   
		   $scope.showCadastro = true;
	   };
	   
	    $scope.allUsers = {};
	    $scope.listarUsers = function(){
				 $http.get('http://localhost:8080/CL/ws/user')
					   .success(function(data){
							  $scope.allUsers = data;
					   })
					   .error(function(){
							  alert("Falha em obter lista de Usuarios");
					   });
  };
   $scope.listarUsers();
   


  
   });
   
   function montarObjNoticia() {
       return {
              idPessoa : -1,
              nome : "",
              cpf : "",
              telefone : "",
              mail : "",
			  username :"",
			  password : "",
			  dataUltimoLogin :"",
			  dataLoginAtual : ""
       };
   }
   
     function montarObjEdicao(pessoa) {
       return {
              idPessoa : pessoa.idPessoa,
              nome : pessoa.nome,
              cpf : pessoa.cpf,
              telefone : pessoa.telefone,
              mail : pessoa.mail,
			  username :pessoa.username,
			  password : pessoa.username,
			  dataUltimoLogin :pessoa.dataUltimoLogin,
			  dataLoginAtual : pessoa.dataLoginAtual
       };
   }