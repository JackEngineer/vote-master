'use strict';

/**
 * Config for the router
 */
angular.module('app')
  .run(
    function ($rootScope, $state, $stateParams, USER_ROLES, AuthService, AUTH_EVENTS, locals, Session) {

      $rootScope.$state = $state;
      $rootScope.$stateParams = $stateParams
    }
  )
  .config(
    ['$stateProvider', '$urlRouterProvider', 'USER_ROLES',
      function ($stateProvider, $urlRouterProvider, USER_ROLES) {

        $urlRouterProvider
          .otherwise('/login');

        $stateProvider
            .state('app', {
                abstract: true,
                url: '/app',
                templateUrl: 'tpl/app.html'
            })

          .state('login', {
            url: '/login',
            templateUrl: 'changan/login/login.html',
            controller: 'LoginController',
            resolve: {
              deps: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['changan/login/login-controller.js'
                  , 'changan/login/login-service.js']);
              }]
            }
          })

          .state('app.capital', {
            url: '/capital',
          })
      }
    ]
  );