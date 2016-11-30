angular.module('LivroModule', ['CrudServiceModule'])

.controller('LivroController', ['$scope', 'CrudService', '$routeParams', function($scope, CrudService, $routeParams) {

    //$scope.url = 'http://smary-g5senacads.rhcloud.com/ws/clientes';
	$scope.url = 'http://localhost:8080/CL/ws/livros/';
	  
    $scope.objeto = { name: '' };
    $scope.resultados;
    $scope.idEdicao = $routeParams.id;
    
    $scope.pesquisar = function() {
        CrudService.pesquisar($scope.url, $scope.objeto.name, function(data) {
            $scope.resultados = data;
        });
    }

    $scope.consultar = function(id) {
        CrudService.consultar($scope.url, id, function(obj) {
            $scope.objeto = obj;
        });
    }

    $scope.buscaLivro = function (id, obj) {
        for(var i=0; i<obj.length; i++) {
            if(obj[i].id === id) {
                return true;
            }
        }
        return false;
    }
}])

;
