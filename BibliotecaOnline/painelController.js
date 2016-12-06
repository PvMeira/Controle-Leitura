
 var app = angular.module('app', ["ngRoute"]);
   
   app.controller('painelInicialController', function($scope, $http) {
       $scope.showCadastro = false;
       $scope.pessoaWS = montarObjNoticia();
	  
	  
   
       $scope.abreCadastroNoticia = function() {
              $scope.showCadastro = true;
       }
   
       $scope.cadastrarNovaNoticia = function() {
              var string = $scope.pessoaWS.dataUltimoLogin;
              var month = string.substring(0,2);
              var day = string.substring(2,4);
              var year = string.substring(4,8);
              var data_final = month + '/' + day + '/' + year;
              
              $scope.pessoaWS.dataUltimoLogin = data_final;
			  $scope.pessoaWS.dataLoginAtual = data_final;
              
              $http.post('http://localhost:8080/CL/ws/user/add', $scope.pessoaWS)
                     .success(function(data) {
                           alert("Cadastro efetuado com sucesso!");
                           $scope.showCadastro = false;
                           $scope.noticia = montarObjNoticia();
                     }).error(function() {
                           alert("Falha ao cadastrar notícia!");
                     });
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