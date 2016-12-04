angular.module('UserModule', ['CrudServiceModule'])

.controller('UserController', ['$scope', 'CrudService', '$routeParams', function($scope, CrudService, $routeParams) {

	$scope.url = 'http://localhost:8080/CL/ws/user';
	  
    $scope.objeto = { name: '' };
    $scope.resultados;
    $scope.idEdicao = $routeParams.id;
    
    $scope.pesquisar1 = function() {
        CrudService.pesquisarUser($scope.url, $scope.objeto.name, function(data) {
            $scope.resultados = data;
        });
    }
}])

;
