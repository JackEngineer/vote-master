/**
 * Created by KJA on 2016/9/29.
 */

angular.module('app')
    .service("giftService",function($http,PKO_CONFIG,$rootScope,$modal){
        this.getGiftList = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Gift/getGiftList'),
                params : param
            });
        }
        this.addGift = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Gift/addGift'),
                params : param
            });
        }
        this.addImg = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Gift/addImg'),
                params : param
            });
        }
        this.uploadFile = function(title,url,params){
            var scope = $rootScope.$new();
            scope.url = url;
            scope.title = title;
            scope.params = params;
            return $modal.open({
                templateUrl: PKO_CONFIG.PKOperateServerIP.concat('changan/upload-file/upload-file.html'),
                controller: 'UploadFileController',
                size: 'lg',
                scope: scope
            });
        }
        this.deleteGift = function (param) {
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Gift/deleteGift'),
                params : param
            });
        }
        this.uploadFile = function(title,url,params){
            var scope = $rootScope.$new();
            scope.url = url;
            scope.title = title;
            scope.params = params;
            return $modal.open({
                templateUrl: PKO_CONFIG.PKOperateServerIP.concat('changan/upload-file/upload-file.html'),
                controller: 'UploadFileController',
                size: 'lg',
                scope: scope
            });
        }
        this.getImgUrl = function (param) {
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Gift/getImgUrl'),
                params : { giftId:param}
            });
        }
        this.UpdateGift = function (param) {
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Gift/UpdateGift'),
                params : param
            });
        }
    })
