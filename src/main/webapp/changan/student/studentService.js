/**
 * Created by KJA on 2016/9/29.
 */

angular.module('app')
    .service("studentService",function($http,PKO_CONFIG,$rootScope,$modal){
        this.getStudentList = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Student/getStudentList'),
                params : param
            });
        }
        this.addStudent = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Student/addStudent'),
                params : param
            });
        }
        this.deleteStudent = function (param) {
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Student/deleteStudent'),
                params : param
            });
        }
        this.addImg = function(param){
            return $http({
                method :'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Student/addImg'),
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
                url: PKO_CONFIG.PKOperateServerIP.concat('Student/getImgUrl'),
                params : { studentId:param}
            });
        }
        this.UpdateStudent=function (param) {
            return $http({
                method: 'post',
                url: PKO_CONFIG.PKOperateServerIP.concat('Student/UpdateStudent'),
                params: param
            });
        }
    })
