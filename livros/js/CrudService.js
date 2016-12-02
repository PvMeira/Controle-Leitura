angular.module('CrudServiceModule', [])

.service('CrudService', ['$http', function($http) {
                        
    this.consultar = function(serviceURL, id, fn) {
        console.log(id);
        
        $http.get(serviceURL + id)
            .then(function successCallback(response) {
                console.log(response);
                fn(response.data);
            }, function errorCallback(response) {
                console.log(response);
                geraMensagem("Ooops! " + (response.statusText===""?OOPS:response.statusText));
            });
    }
    
    this.pesquisar = function(serviceURL, value, fn) {
        console.log(value);

        $http.get(serviceURL + value)
            .then(function successCallback(response) {
                console.log(response);
                fn(response.data);
            }, function errorCallback(response) {
                console.log(response);
                geraMensagem("Ooops! " + (response.statusText===""?OOPS:response.statusText));
            });
    };
	    this.pesquisarUser = function(serviceURL, value, fn) {
        console.log(value);

        $http.get(serviceURL + value)
            .then(function successCallback(response) {
                console.log(response);
                fn(response.data);
            }, function errorCallback(response) {
                console.log(response);
                geraMensagem("Ooops! " + (response.statusText===""?OOPS:response.statusText));
            });
    };
        
    this.geraMensagemDefault = function() {
        $('#myModalMessage').text("Ação executada com sucesso!");
        $('#myModal').modal();        
    };    

    var geraMensagem = function(mensagem) {
        $('#myModalMessage').text(mensagem);
        $('#myModal').modal();        
    };    

        // http://www.mikezilla.com/exp0012.html
    var OOPS = "\u00AF\\_(\u30C4)_/\u00AF";
        
}]);