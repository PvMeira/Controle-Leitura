angular.module('LivroModule', ['CrudServiceModule'])

.controller('LivroController', ['$scope', 'CrudService', '$routeParams', function($scope, CrudService, $routeParams) {

	$scope.url = 'http://localhost:8080/CL/ws/livros/';
	  
    $scope.objeto = { name: '' };
    $scope.resultados;
    $scope.idEdicao = $routeParams.id;
    
    $scope.pesquisar = function() {
        CrudService.pesquisar($scope.url, $scope.objeto.name, function(data) {
            $scope.resultados = data;
        });
    }

}])

;
