/**
 * Created by KJA on 2016/9/29.
 */

angular.module('app')
    .service("activeImgService",function($http,PKO_CONFIG){
        this.getActiveImgList = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Active/getActiveImgList'),
                params : param
            });
        }
        this.deleteActiveImg = function (param) {
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Active/deleteActiveImg'),
                params : param
            });
        }
    })
