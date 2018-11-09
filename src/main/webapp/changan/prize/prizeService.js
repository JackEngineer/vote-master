/**
 * Created by KJA on 2016/9/29.
 */

angular.module('app')
    .service("prizeService",function($http,PKO_CONFIG,$rootScope,$modal){
        this.getPrizeList = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Prize/getPrizeList'),
                params : param
            });
        }
        this.addPrize = function(param,activeName){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Prize/addPrize'),
                params: {prizeName:param.prizeName,prizeContext:param.prizeContext,activeName:activeName},
            });
        }
        this.addImg = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Prize/addImg'),
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
        this.deletePrize = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Prize/deletePrize'),
                params : param
            });
        }
        this.UpdatePrize =function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Prize/UpdatePrize'),
                params : param
            });
        }
    })
