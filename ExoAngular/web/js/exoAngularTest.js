(function() {
    
    var module1 = angular.module('module1', []);
        module1.factory('$customHTTP', function ($http){
            return {
                execute : function(url, data, callback){
                    $http.post(url, data).success(function(data){
                        callback(data)
                })
            }
        }
    });
	
    var app = angular.module('myModule', ['module1']);
        app.controller('MyController', function ($scope, $customHTTP){
            $scope.url = angular.element(myForm).attr('action');
            $scope.test = "";
                $scope.soumettre = function () {
                    $customHTTP.execute(
                        $scope.url,
                        {'test': $scope.test},
                        function (data){
                            $scope.resultat = data;
                        })
                }
        });
        
})();