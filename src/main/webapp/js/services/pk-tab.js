/**
 * Created by slipkinem on 7/5/2017 at 9:33 AM.
 */
;(function (global, document, angular, undefined) {
  'use strict'
  if (!angular) {
    throw new Error('angular is not defined, please import it')
  }
  angular
    .element(document)
    .find('head')
    .prepend('' +
      '<style type="text/css">' +
      '.pk-tab-visibility .lazy-container {overflow: hidden;height: 0;visibility: hidden}' +
      '</style>' +
      '')
  /**
   * 通过uuid找到对象所在数组的索引
   * @param item
   * @returns { number }
   */
  Array.prototype.objectOfArrayIndex = function (item) {
    if (!angular.isObject(item)) {
      throw new Error("item必须是一个对象")
    }
    var $index = 0
    for (var i = 0, j = this.length; i < j; i++) {
      if (item._uuid === this[i]._uuid) {
        $index = i
        break
      }
    }
    return $index
  }
  /**
   * 判断obj在不在Array中
   * @param item
   * @returns {boolean}
   */
  Array.prototype.isObjectInArray = function (item) {
    return this.objectOfArrayIndex(item) !== -1
  }
  /**
   * 删除Array中指定的obj
   * @param item
   */
  Array.prototype.deleteItem = function (item) {
    var index = this.objectOfArrayIndex(item)
    this.splice(index, 1)
  }

  function once (fn) {
    if (!once.called) {
      once.called = true
      fn && fn()
    }
  }

  var uuid = 0

  function nextUUID () {
    return uuid++
  }

  angular.module('pk.tab', ['oc.lazyLoad'])
    .provider('$PkTab', function () {
      var pkTabs = [],
        defaultTab = ''

      this.add = function (tab) {
        var _tab = Object.create(null)
        _tab._uuid = nextUUID()
        angular.extend(_tab, tab)
        pkTabs.push(_tab)
        return this
      }

      this.defaultTab = function (defaultTabName) {
        defaultTab = defaultTabName
        return this
      }

      this.$get = function ($rootScope) {
        var currentTab = Object.create(null)

        function getTabByRef (ref) {
          var tab = Object.create(null)
          angular.forEach(pkTabs, function (pkTab) {
            if (pkTab.ref === ref) {
              return tab = pkTab
            }
          })
          return tab
        }

        if (defaultTab) {
          currentTab = getTabByRef(defaultTab)
          if (angular.element.isEmptyObject(currentTab)) {
            throw new Error('defaultTab is not defined, Is not include it of your tab-list, please check it.')
          }
          currentTab.done = true
        }
        return {
          /**
           * 返回当前显示页面的内容
           * @returns { object }
           */
          getCurrentTab: function () {
            return currentTab
          },
          /**
           * 设置当前的tab
           * @param tabName
           * @param isDone
           * @param query
           */
          setCurrentTab: function (tabName, isDone, query) {
            angular.forEach(pkTabs, function (tab) {
              if (tab.ref === tabName) {
                currentTab = tab
                currentTab.done = angular.isDefined(isDone) ? isDone : true
                currentTab.query = query
                $rootScope.$broadcast('tabChanged', tab)
              }
            })
          },
          /**
           * 通过ref获取tab
           * @param ref
           * @returns {{}}
           */
          getTabByRef: getTabByRef,
          /**
           * 获取所有的tabs
           * @returns {Array}
           * @private
           */
          _getPkTabs: function () {
            return pkTabs
          },
          /**
           * 跳转到指定的tab
           * @param tab
           */
          go: function (tab) {
            // 这里启动异步为了防止angular循环震荡
            //
            setTimeout(function () {
              $rootScope.$broadcast('tabChange', tab)
            }, 0)
          },
          /**
           * 获取所有已加载的tab
           * @returns {Array}
           */
          allDoneTabs: function () {
            var allDoneTabs = []
            angular.forEach(pkTabs, function (tab) {
              if (tab.done) {
                allDoneTabs.push(tab)
              }
            })
            return allDoneTabs
          },
          /**
           * 关闭tab
           * @param tabName
           */
          destroy: function (tabName) {
            this.setCurrentTab(tabName, false)
          },
          /**
           * 卸载所有已经打开的组件
           */
          destroyAll: function () {
            angular.forEach(this.allDoneTabs(), function (doneTab) {
              this.destroy(doneTab.ref)
            }.bind(this))
          }
        }
      }
    })
    .directive('tabView', function ($rootScope, $PkTab) {
      /**
       * tab主视图
       */
      return {
        restrict: 'E',
        replace: true,
        template: '<div ng-repeat="content in tab.contentList">' +
        '<register-controller ' +
        'class="height-animation" ' +
        'ng-if="content.done" ' +
        'ng-class="{\'pk-tab-visibility\': tab.tabName !== content.ref}" ' +
        'content="content">' +
        '</register-controller> ' +
        '</div>',
        link: function ($scope, el, attr) {
          $scope.tab = {
            contentList: $PkTab._getPkTabs(),
            tabName: $PkTab.getCurrentTab().ref
          }

          $scope.$on('tabChange', function (e, tab) {
            var query = {},
              tabName = ''

            if (angular.isObject(tab)) {
              tabName = tab.ref
              query = tab.query
            } else if (angular.isString(tab)) {
              tabName = tab
            } else {
              tabName = $scope.tab.tabName
              throw new Error('tabName should be a string or object.ref is a string')
            }

            $scope.tab.tabName = tabName
            $PkTab.setCurrentTab(tabName, true, query)
            $scope.$digest()
          })
        }
      }
    })
    .directive('registerController', function ($ocLazyLoad, $compile, $http) {
      /**
       * 动态加载controller
       */
      return {
        restrict: 'E',
        scope: {
          content: '='
        },
        replace: true,
        link: function ($scope, el) {
          $http.get($scope.content.templateUrl)
            .then(function (res) {
              res = res.data
              $ocLazyLoad.load($scope.content.deps || [])
                .then(function (result) {
                  var div = document.createElement('div')
                  div.innerHTML = res

                  div.setAttribute('ng-controller', $scope.content.controller)
                  div.setAttribute('class', 'lazy-container')

                  el.append($compile(div)($scope))
                })
                .catch(function (e) {
                  throw new Error($scope.content.deps.join(' and ') +
                    ' initialize failure，please check your file url', e)
                })
            })
            .catch(function (e) {
              throw new Error($scope.content.templateUrl +
                ' initialize failure, please check your file url', e)
            })
        }
      }
    })
    .directive('pkGo', function ($rootScope, $PkTab) {
      /**
       * go方法
       */
      return {
        restrict: 'A',
        link: function (scope, el, attr) {
          el.on('click', function () {
            $PkTab.go(attr.pkGo)
          })

          function addClass (el, className) {
            if (!className || !el) return
            if (el.hasClass(className)) return
            el.addClass(className)
          }

          function removeClass (el, className) {
            if (!className || !el) return
            if (!el.hasClass(className)) return
            el.removeClass(className)
          }

          scope.$on('tabChanged', update)
          update()
          function update () {
            var tab = $PkTab.getTabByRef(attr.pkGo),
              parent = angular.element(el.parent()),
              currentTab = $PkTab.getCurrentTab(),
              parentActiveClass = parent.attr('pk-go-active')

            if (attr.pkGo === currentTab.ref && tab.done) {
              addClass(el, attr.pkGoActive)
              addClass(parent, parentActiveClass)
            } else {
              removeClass(el, attr.pkGoActive)
              removeClass(parent, parentActiveClass)
            }
          }

        }
      }
    })
    .directive('tabBar', function ($PkTab) {
      /**
       * tabBar视图
       */
      return {
        restrict: 'E',
        replace: true,
        template: '<li ' +
        'ng-repeat="tab in tabList" ' +
        'class="hide-animation tab-item" ' +
        'ng-if="tab.done" pk-go="{{tab.ref}}" ' +
        'pk-go-active="active" ' +
        '>' +
        '<i ' +
        'class="glyphicon glyphicon-remove" ' +
        'ng-click="close(tab, $event)">' +
        '</i>{{tab.tabName}}' +
        '</li>',

        link: function (scope) {
          scope.tabList = $PkTab._getPkTabs()

          scope.close = function (tab, $event) {
            $event.stopPropagation()

            var
              allDoneTabs = $PkTab.allDoneTabs(),
              $index = allDoneTabs.objectOfArrayIndex(tab),
              currentTab = $PkTab.getCurrentTab(),
              tabName = ''

            $PkTab.destroy(tab.ref)

            if (allDoneTabs.length === 1) {
              tabName = ''
            } else {
              if (tab.ref === currentTab.ref) {
                if ($index === 0) {
                  tabName = allDoneTabs[++$index].ref
                } else {
                  tabName = allDoneTabs[--$index].ref
                }
              } else {
                tabName = currentTab.ref
              }
            }
            $PkTab.go(tabName)
          }
        }
      }
    })
}(window, document, window.angular));