/**
 * Created by KJA on 2016/9/29.
 */

angular.module('app')
    .service("companyService",function($http,PKO_CONFIG){
        this.getCompanyList = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Company/getCompanyList'),
                params : param
            });
        }
        this.addCompany = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Company/addCompany'),
                params : param
            });
        }
        this.deleteCompany = function (param) {
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Company/deleteCompany'),
                params : param
            });
        }
        this.updateCompany =  function (param) {
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Company/updateCompany'),
                params : param
            });
        }
    })
