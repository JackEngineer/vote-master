/**
 * Created by jason on 16/5/30.
 */
angular.module('app')
    .service('LoginService', function ($http, PKO_CONFIG) {
        var loginService = {};
        loginService.login =  function(user){
            var methodName = 'login';
            console.log(methodName,user);
            return $http({
                method: 'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('login'),
                params: {userName:user.userName,userPassword:user.userPassword},
            });
        };

        loginService.logoutOut = function(user){
            var methodName = 'logout';
            console.log(methodName,user);
            return $http({
                method: 'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('logout'),
                params: {userName:user.userName,userPassword:user.userPassword},
            });
        };
        return loginService;
    });