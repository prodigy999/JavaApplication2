(function() {
	'use strict';

	var myModule = angular.module('myModule', []);

	myModule.service('hello', function ($window){
            return {
                welcome: function (name){
                    $window.alert('hello' + name + '!');
                }
            };
	});
        
        var app = angular.module('myApp', ['myModule']);
        app.controller('MyController', function ($scope, hello){
            $scope.sayHello = function (name) {
                hello.welcome(name);
                console.log(name);
            };
        });
})();