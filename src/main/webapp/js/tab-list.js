/**
 * Created by slipkinem on 7/7/2017 at 6:24 PM.
 */
'use strict'
angular.module('app')
  .config(function ($PkTabProvider) {
    $PkTabProvider
      .add({
        ref: 'app.company',
        tabName: '培训机构管理',
        templateUrl: 'changan/company/company.html',
        controller: 'companyController',
        deps: [
            'changan/company/companyController.js',
            'changan/company/companyService.js'
        ]
        })
        .add({
            ref: 'app.student',
            tabName: '学生管理',
            templateUrl: 'changan/student/student.html',
            controller: 'studentController',
            deps: [
                'changan/student/studentController.js',
                'changan/student/studentService.js',
                'changan/upload-file/upload-file.js'
            ]

        })
        .add({
            ref: 'app.active',
            tabName: '活动管理',
            templateUrl: 'changan/active/active.html',
            controller: 'activeController',
            deps: [
                'changan/active/activeController.js',
                'changan/active/activeService.js',
                'changan/upload-file/upload-file.js'
            ]

        })
        .add({
            ref: 'app.activeImg',
            tabName: '活动图片管理',
            templateUrl: 'changan/activeImg/activeImg.html',
            controller: 'activeImgController',
            deps: [
                'changan/activeImg/activeImgController.js',
                'changan/activeImg/activeImgService.js'
            ]

        })
        .add({
            ref: 'app.gift',
            tabName: '礼物管理',
            templateUrl: 'changan/gift/gift.html',
            controller: 'giftController',
            deps: [
                'changan/gift/giftController.js',
                'changan/gift/giftService.js',
                'changan/upload-file/upload-file.js'
            ]
        })
        .add({
            ref: 'app.prize',
            tabName: '奖品管理',
            templateUrl: 'changan/prize/prize.html',
            controller: 'prizeController',
            deps: [
                'changan/prize/prizeController.js',
                'changan/prize/prizeService.js',
                'changan/upload-file/upload-file.js'
            ]
        })
        .add({
            ref: 'app.weChat',
            tabName: '奖品管理',
            templateUrl: 'changan/weChat/weChat.html',
            controller:' weChatController',
            deps: [
                'changan/weChat/weChatController.js',
                'changan/weChat/weChatService.js'
            ]
        })
  });
