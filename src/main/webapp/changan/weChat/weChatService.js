/**
 * Created by KJA on 2016/9/29.
 */

angular.module('app')
    .service("weChatService",function($http,PKO_CONFIG){
        this.getWeChatList = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('WeChat/getWeChatList'),
                params : param
            });
        }
    })
