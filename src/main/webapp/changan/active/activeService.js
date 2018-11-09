/**
 * Created by KJA on 2016/9/29.
 */

angular.module('app')
    .service("activeService",function($http,PKO_CONFIG,$rootScope,$modal){
        this.getActiveList = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Active/getActiveList'),
                params : param
            });
        }
        this.addActive = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Active/addActive'),
                params : param
            });
        }
        this.addImg = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Active/addImg'),
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
        this.deleteActive = function (param) {
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Active/deleteActive'),
                params : param
            });
        }
        this.getImgUrl = function (param) {
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Active/getImgUrl'),
                params : { activeId:param}
            });
        }
        this.UpdateActive =function (param) {
            return $http({
                method: 'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Active/UpdateActive'),
                params: param
            });
        }
    })
