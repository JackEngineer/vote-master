/**
 * Created by slipkinem on 2016/12/20.
 */
;(function (window, angular) {
  'use strict';
  if (!Array.indexOf) {
    Array.prototype.indexOf = function (obj) {
      for (var i = 0; i < this.length; i++) {
        if (this[i] === obj)
          return i
      }
      return -1
    }
  }
  angular.module('ngPermission', ['ui.router'])

  /**
   * 权限事件
   * @type {String}
   */
    .constant('PERMISSION_EVENTS', {
      loginSuccess: 'auth-login-success',
      loginFailed: 'auth-login-failed',
      logoutSuccess: 'auth-logout-success',
      sessionTimeout: 'auth-session-timeout',
      notAuthenticated: 'auth-not-authenticated',
      notAuthorized: 'auth-not-authorized'
    })
    /**
     * http拦截器
     * @param  {[type]} $rootScope         [description]
     * @param  {[type]} $q                 [description]
     * @param  {[type]} PERMISSION_EVENTS) {                 return {                      response: function (response) {            console.info('AuthInterceptor is            running ...', response);          $rootScope.$broadcast({            401: PERMISSION_EVENTS.notAuthenticated,            403: PERMISSION_EVENTS.notAuthorized,            419: PERMISSION_EVENTS.sessionTimeout,            440: PERMISSION_EVENTS.sessionTimeout          }[response.status] [description]
     * @param  {[type]} response);                                       return response                                   }      }    }]                           [description]
     * @return {[type]}                    [description]
     */
    .factory('httpResponsePermissionInterceptor', ['$rootScope', '$q', 'PERMISSION_EVENTS', function ($rootScope, $q, PERMISSION_EVENTS) {
      return {
        response: function (response) {
          $rootScope.$broadcast({
            401: PERMISSION_EVENTS.notAuthenticated,
            403: PERMISSION_EVENTS.notAuthorized,
            419: PERMISSION_EVENTS.sessionTimeout,
            440: PERMISSION_EVENTS.sessionTimeout
          }[response.status], response)
          return response
        }
      }
    }])
    /**
     * 注入拦截器
     * @param  {String} $httpProvider) {                 console.log($httpProvider)      $httpProvider.defaults.headers.post['X-Requested-With'] [description]
     */
    .config(['$httpProvider', function ($httpProvider) {
      console.log($httpProvider)
      $httpProvider.defaults.headers.post['X-Requested-With'] = 'XMLHttpRequest'
      $httpProvider.interceptors.push('httpResponsePermissionInterceptor')
    }])
    /**
     * 监听事件
     * @param  {[type]} $rootScope        [description]
     * @param  {[type]} $state            [description]
     * @param  {[type]} angularPermission [description]
     * @param  {[type]} PERMISSION_EVENTS [description]
     * @param  {[type]} $window)          {                 $rootScope.$state [description]
     * @return {[type]}                   [description]
     */
    .run(['$rootScope','$state', 'angularPermission', 'PERMISSION_EVENTS', '$window',
      function ($rootScope, $state, angularPermission, PERMISSION_EVENTS, $window) {
        $rootScope.$state = $state

        /**
         * 401拦截
         * @param  {[type]} event [description]
         * @param  {[type]} data) {                   console.log(data)        event.preventDefault()        $rootScope.$state.go('access.signin')      } [description]
         * @return {[type]}       [description]
         */
        $rootScope.$on(PERMISSION_EVENTS.notAuthenticated, function (event, data) {
          console.log(data)
          event.preventDefault()
          $rootScope.$state.go('login')
        })
        /**
         * 路由权限拦截
         * @param  {[type]}   event    [description]
         * @param  {Function} next     [description]
         * @param  {[type]}   current) {                   console.log(next)        var permission [description]
         * @return {[type]}            [description]
         */
        $rootScope.$on('$stateChangeStart', function (event, next) {
          console.log(next)
          var permission = next.permission
          if (next.name === 'login') {
            $window.localStorage.clear()
            $window.sessionStorage.clear()
            return
          }
          console.log('angularPermission.getPermissions', angularPermission.getPermissions())
          if (angular.element.isEmptyObject(angularPermission.getPermissions())) {
            event.preventDefault()
            return $rootScope.$state.go('login')
          }

          if(angular.isString(permission) && !angularPermission.hasPermission(permission)){
            // 使用reload为了防止跳转失败卡死
            event.preventDefault()
            $rootScope.$state.reload()
          }
        })
      }])
    /**
     * [description]
     * @param  {String}  $rootScope)     {                               var userPermissionList [description]
     * @param  {[type]}  getPermissions: function      ()           {                                            return                          userPermissionList        } [description]
     * @param  {Boolean} hasPermission:  function      (permission) {                                            console.log(userPermissionList)                              if            (jQuery.isEmptyObject(userPermissionList)) {            return false          }                              return true        }      }    }] [description]
     * @return {[type]}                  [description]
     */
      .factory('angularPermission', ['$rootScope', function ($rootScope) {

        var userPermissionList = ''
        return {
          setPermissions: function(permissions) {

            userPermissionList = permissions || []
            $rootScope.$broadcast('permissionsChanged')
          },
          getPermissions: function () {
            return userPermissionList
          },
          hasPermission: function (permission) {
            if (!angular.element.isEmptyObject(userPermissionList))
              return userPermissionList.indexOf(permission.trim()) > -1
              //TODO: test
              // return true
          }
        }
      }])

    /**
     * hasPermission
     * @param  {[type]} angularPermission) {                 return {        link: function(scope, element, attrs) {          if(!angular.isString(attrs.hasPermission))            throw "hasPermission value must be a string! "          var value [description]
     * @return {[type]}                    [description]
     */
    .directive('hasPermission',['angularPermission',function(angularPermission) {

      return {
        link: function(scope, element, attrs) {
          if(!angular.isString(attrs.hasPermission))
            throw '权限值必须是一个字符串'
          var value = attrs.hasPermission.trim()
          var notPermissionFlag = value[0] === '!'
          if(notPermissionFlag) {
            value = value.slice(1).trim()
          }

          function toggleVisibilityBasedOnPermission() {
            var hasPermission = angularPermission.hasPermission(value);
            if(angularPermission.hasPermission("*:*")){
              hasPermission = true;
            }
            if(hasPermission && !notPermissionFlag || !hasPermission && notPermissionFlag){
              element.show()
            }else{
              element.remove()
              // TODO: test
              // element.show()
            }
          }
          toggleVisibilityBasedOnPermission()
          scope.$on('permissionsChanged', toggleVisibilityBasedOnPermission)
        }
      }
    }])

}(this, window.angular))