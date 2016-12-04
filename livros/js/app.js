angular.module('AppModule', ['ngRoute', 
    'LivroModule','UserModule'
])

.controller('AppController', ['$scope', function($scope) {

}])

/* **************************************************
 * Configuração das rotas
 */
.config(['$routeProvider', function ($routeProvider) {        
    $routeProvider.
        /* ********** LOGON/LOGOFF ****************** */
        when('/logon', {
            templateUrl: 'partials/logon.html',
            controller: 'AutenticacaoController'
        }).
		 when('/user-pesquisar', {
            templateUrl: 'partials/user-pesquisar.html',
            controller: 'UserController'
        }).
        when('/logoff', {
            templateUrl: 'partials/logoff.html',
            controller: 'AutenticacaoController'
        })./* ********** LIVRO ****************** */
        when('/livro-pesquisar', {
            templateUrl: 'partials/livro-pesquisar.html',
            controller: 'LivroController'
        })./* ********** PADRÃO ****************** */
        when('/', {
            templateUrl: 'partials/principal.html',
            controller: 'AppController'
        }).
        
        otherwise({
            redirectTo: '/'
        });
}])



.directive('conteudoInterno', function () {
    return {
        restrict: 'E',
        transclude: true,
        templateUrl: 'templates/conteudo-interno.html'
    };
})

.directive('avaliacaoSeriado', function() {
    return {
        restrict: 'E',
        scope: {
            valorNota: '@nota'
        },
        templateUrl: 'templates/avaliacao-seriado.html'
    }
})

;       