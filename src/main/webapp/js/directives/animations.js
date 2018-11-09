/**
 * Created by slipkinem on 2017/1/19.
 */
'use strict'
angular.module('app')
  .animation('.hide-animation', function () {
    return {
      beforeAddClass: function (element, className, done) {
        if (className === 'ng-hide') {
          element.animate({
            opacity: 0
          }, 500, done);
        } else {
          done();
        }
      },
      removeClass: function (element, className, done) {
        if (className === 'ng-hide') {
          element.css('opacity', 0);
          element.animate({
            opacity: 1
          }, 500, done);
        } else {
          done();
        }
      }
    };
  });
angular.module('app')
  .animation('.repeat-animation', function () {
    return {
      enter: function (element, done) {
        console.log("entering...");
        var width = element.width();
        element.css({
          position: 'relative',
          left: -10,
          opacity: 0
        });
        element.animate({
          left: 0,
          opacity: 1
        }, done);
      },
      leave: function (element, done) {
        element.css({
          position: 'relative',
          left: 0,
          opacity: 1
        });
        element.animate({
          left: -10,
          opacity: 0
        }, done);
      },
      move: function (element, done) {
        element.css({
          left: "2px",
          opacity: 0.5
        });
        element.animate({
          left: "0px",
          opacity: 1
        }, done);
      }
    };
  });
angular.module('app')
  .animation('.height-animation', function () {
    return {
      beforeAddClass: function (element, className, done) {
        if (className === 'pk-tab-visibility') {
          element = element.find('.lazy-container')
          element.animate({
            opacity: 0
          }, 300, done);
        } else {
          done();
        }
      },
      removeClass: function (element, className, done) {
        if (className === 'pk-tab-visibility') {
          element = element.find('.lazy-container')
          element.css({
            position: 'relative',
            opacity: 0,
            left: "20px"
          });
          element.animate({
            position: 'static',
            opacity: 1,
            left: "0px"
          }, 300, done);
        } else {
          done();
        }
      }
    }
  })