/**
 * Created by jason on 16/5/30.
 */

'use strict';

/* Controllers */
// signin controller
app.controller('LoginController', function($scope, $rootScope,$http, $state, LoginService,Session, locals) {
    $scope.user = {};
    $scope.user.userName = '';
    $scope.user.userPassword = '';
    $scope.authError = null;

    $scope.login = function() {
        $scope.authError = null;
        // Try to login
        LoginService.login($scope.user)
            .success(function(data){
                if (data.errorCode == 0){
                    $scope.app.userName = $scope.user.userName;
                    locals.setObject("userName",$scope.user.userName);
                    $state.go('app.capital');
                }else {
                    if(data.errorMessage){
                        $scope.authError =data.errorMessage;
                    }else
                    $scope.authError = "账号或密码错误！";
                }
            });
    };

});