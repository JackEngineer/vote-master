/**
 * Created by jason on 16/5/30.
 */
angular.module('app')
    .constant('PKO_CONFIG', {
        PKOperateServerIP: ''
    })
    .constant('AUTH_EVENTS', {
        loginSuccess: 'auth-login-success',
        loginFailed: 'auth-login-failed',
        logoutSuccess: 'auth-logout-success',
        sessionTimeout: 'auth-session-timeout',
        notAuthenticated: 'auth-not-authenticated',
        notAuthorized: 'auth-not-authorized'
    })
    .constant('USER_ROLES', {
        all: '*',
        admin: '',
        editor: 'editor',
        guest: 'guest'
    })
    ;
