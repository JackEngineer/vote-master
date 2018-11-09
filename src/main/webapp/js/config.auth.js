/**
 * Created by jason on 16/5/30.
 */

angular.module('app')
  .factory('locals', ['$window', function ($window) {
    return { //存储单个属性
      set: function (key, value) {
        $window.localStorage[key] = value;
      }, //读取单个属性
      get: function (key, defaultValue) {
        return $window.localStorage[key] || defaultValue;
      }, //存储对象，以JSON格式存储
      remove: function (key) {
        return $window.localStorage.removeItem(key);
      },
      setObject: function (key, value) {
        $window.localStorage[key] = JSON.stringify(value);
      }, //读取对象
      getObject: function (key) {
        return JSON.parse($window.localStorage[key] || '{}');
      }
    }
  }])
  .factory('AuthService', function ($http, Session) {
    var authService = {};
    authService.login = function (credentials) {
      return $http
        .post('/login', credentials)
        .then(function (res) {
          Session.create(res.data.id, res.data.user.id, res.data.user.role);
          return res.data.user;
        });
    };

    authService.isAuthenticated = function () {
      return !!Session.userId;
    };
    authService.isAuthorized = function (authorizedRoles) {
      if (!angular.isArray(authorizedRoles)) {
        authorizedRoles = [authorizedRoles];
      }
      return (authService.isAuthenticated() &&
      authorizedRoles.indexOf(Session.userRole) !== -1);
    };
    return authService;
  })
  .service('Session', function (locals) {
    this.create = function (sessionId, userId, userRole) {
      this.id = sessionId;
      this.userId = userId;
      this.userRole = userRole;
      locals.set('id', sessionId);
      locals.set('userName', userId);
      locals.set('userRole', userRole);
    };
    this.destroy = function () {
      this.id = null;
      this.userId = null;
      this.userRole = null;
      locals.remove('id');
      locals.remove('userName');
      locals.remove('userRole');
    };
    return this;
  })

  .factory('AuthInterceptor', function ($rootScope, $q, AUTH_EVENTS, Session) {
    return {
      responseError: function (response) {
        console.info('AuthInterceptor is running ...', response);
        $rootScope.$broadcast({
          401: AUTH_EVENTS.notAuthenticated,
          403: AUTH_EVENTS.notAuthorized,
          419: AUTH_EVENTS.sessionTimeout,
          440: AUTH_EVENTS.sessionTimeout
        }[response.status], response);
        return $q.reject(response);
      },
      // todo:测试用，发布时删除
      request: function (request) {
        if ('X-Requested-With' in request.headers) {
          // request.url = '/pkoperate/' + request.url
        }
        return request;
      }
    };
  });
