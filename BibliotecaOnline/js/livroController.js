
 var app = angular.module('app', ["ngRoute"]);
   
   app.controller('painelLivroController', function($scope, $http) {
	    $scope.allLivros = {};
	    $scope.listarLivros = function(){
				 $http.get('http://localhost:8080/CL/ws/livros')
					   .success(function(data){
							  $scope.allLivros = data;
					   })
					   .error(function(){
							  alert("Falha em obter lista de Livros");
					   });
  };
   $scope.listarLivros();

  
   })
