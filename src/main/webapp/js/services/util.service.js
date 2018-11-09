/**
 * Created by slipkinem on 10/25/2017 at 6:09 PM.
 */
'use strict'
angular.module('pk.util', [])
  .factory('Util', function ($q) {
    return {
      debouncePromise: function (fn, wait, immediate) {
        var timer = 0
        return function () {
          var deferred = $q.defer()
          var args = arguments
          var _this = this

          if (immediate && !timer) {
            deferred.resolve(fn.apply(_this, args))
          }

          timer && clearTimeout(timer)

          timer = setTimeout(function () {
            timer = 0
            if (!immediate) {
              deferred.resolve(fn.apply(_this, args))
            }
          }, wait)
          return deferred.promise
        }
      },
      isUndef: function (v) {
        return v === undefined || v === null
      },
      isDef: function (v) {
        return v !== undefined && v !== null
      },
      isURLSearchParams: function (val) {
        return !angular.isUndefined(window.URLSearchParams) && val instanceof window.URLSearchParams
      },
      includes: function (str, v) {
        return str.indexOf(v) !== -1
      },
      encode: function (val) {
        return encodeURIComponent(val)
          .replace(/%40/gi, '@')
          .replace(/%3A/gi, ':')
          .replace(/%24/g, '$')
          .replace(/%2C/gi, ',')
          .replace(/%20/g, '+')
          .replace(/%5B/gi, '[')
          .replace(/%5D/gi, ']')
      },
      buildURL: function (url, params) {
        var _this = this
        if (!params) {
          return url
        }

        var serializedParams = ''
        if (this.isURLSearchParams(params)) {
          serializedParams = params.toString()
        } else {
          var parts = []

          angular.forEach(params, function (val, key) {
            if (_this.isUndef(val)) return

            if (Array.isArray(val)) {
              key += '[]'
            }

            if (!Array.isArray(val)) {
              val = [val]
            }

            val.forEach(function (v) {
              if (v instanceof Date) {
                v = v.toISOString()
              } else if (angular.isObject(v)) {
                v = JSON.stringify(v)
              } else {
                v = v.toString()
              }
              parts.push(_this.encode(key) + '=' + _this.encode(v))
            })
          })

          serializedParams = parts.join('&')
        }

        if (serializedParams) {
          url += (_this.includes(url, '?') ? '&' : '?') + serializedParams
        }

        return url
      }
    }
  })