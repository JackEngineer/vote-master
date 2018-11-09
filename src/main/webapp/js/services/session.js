/**
 * Created by slipkinem on 2016/12/21.
 */
'use strict'

angular.module('app')
  .factory('Session', ["$window", "$base64", function ($window, $base64) {
    return {
      set: function (key, value) {
        $window.sessionStorage[$base64.encode(key)] = $base64.encode(value)
      },
      get: function (key, defaultValue) {
        if ($window.sessionStorage[$base64.encode(key)])
          return $base64.decode($window.sessionStorage[$base64.encode(key)]) || defaultValue
      },
      setObject: function (key, value) {
        $window.sessionStorage[$base64.encode(key)] = $base64.encode(JSON.stringify(value))
      },
      getObject: function (key) {
        if ($window.sessionStorage[$base64.encode(key)])
          return JSON.parse($base64.decode($window.sessionStorage[$base64.encode(key)] || '{}'))
      },
      clear: function () {
        $window.sessionStorage.clear()
      }
    }
  }])