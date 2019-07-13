var myApp = angular.module('root',[]);

myApp.controller('MyController',['$scope','$http','$log',
function($scope,$http,$log) {
    $http.get('restuser').success(function (result){
            $scope.users = result;
    }).error(function (data,status){
        $log.error(status+" "+data);
    });

    $scope.get = function(){
        $http.get('restuser').success(function (result){
                $scope.users = result;
        });
    }
    $scope.get();
    $scope.delete = function(id,name) {
        $http({
            method: "DELETE",
            url:'restuser',
            params:{"id":id,"name":name}
        }).success($scope.get);
     };

    $scope.insert = function(name) {
        if(name.length!==0)
        {
            $http({
                method: "POST",
                url:'restuser',
                params:{"name":name}
            }).success($scope.get);
            $scope.name = '';
        }
    };
}])