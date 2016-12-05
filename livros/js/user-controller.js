angular.module('UserModule', ['CrudServiceModule'])

.controller('UserController', ['$http','$scope','CrudService', '$routeParams', function($http,$scope, CrudService, $routeParams) {

	$scope.url = 'http://localhost:8080/CL/ws/user';
	  
    $scope.objeto = { name: '' };

		
    $scope.resultados;
    $scope.idEdicao = $routeParams.id;
    
    $scope.pesquisar1 = function() {
        CrudService.pesquisarUser($scope.url, $scope.objeto.name, function(data) {
            $scope.resultados = data;
        });
    }
	
	 $scope.cadastrarNovoUser = function() {
		 $http.post('http://localhost:8080/CL/ws/user/add', $scope.pessoa,{headers: { 'Content-Type': 'application/json' }})
 
    }
}])

;
