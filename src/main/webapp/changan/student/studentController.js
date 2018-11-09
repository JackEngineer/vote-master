/**
 * Created by yin on 2016/9/29.
 */

angular.module('app')
    .controller('studentController', function ($rootScope,$scope,$log,$state,$filter,$modal,studentService) {
      var initGrid;
      $scope.arrayObj =  [];
      initGrid = function () {
            // 分页
            $scope.pagingOptions = {
                pageSizes: [10, 20, 30],
                pageSize: 10,
                currentPage: 1
            };
          // 排序
          $scope.filterOptions = {
            filterText: "",
            useExternalFilter: true
          };
          $scope.sysImg={
              imgSource:'',
              imgParentid: "",
              imgType:"2"
          };
          $scope.imgSource=null
            // 行
            $scope.columnDefs = [
                {field: 'id', displayName: '序号', width:100},
                {field: 'studentName', displayName: '学生名', width:100},
                {field: 'studentAge', displayName: '学生年龄', width:100},
                {field: 'studentContext', displayName: '学生性别', width:100},
                {field: 'studentTicket', displayName: '学生票数', width:100},
                {field: 'studentNumb', displayName: '学生编号', width:100},
                {
                    displayName: '操作',
                    width:100,
                    cellTemplate: '<div class="operation-container">' +
                    '<button class="btn icon-social-dropbox btn-danger" ng-click="delete(row)" >删除</button>'+
                    '<button class="btn icon-cloud-upload btn-default" ng-click="uploadImg()">上传图片</button>'+
                    '<button class="btn icon-eye btn-default" ng-click="detail(row)">查看图片</button>'+
                    '<button class="btn icon-note btn-warning" ng-click="update(row)">修改</button>' +
                    '</div>'
                }
                ];
            // gird options
            $scope.gridOptions = {
                data: 'studentList',
                enablePaging: true,
                enableColumnResize:true,
                showFooter: true,
                enableHighlighting:true,
                totalServerItems: 'totalServerItems',
                pagingOptions: $scope.pagingOptions,
                columnDefs: $scope.columnDefs,
                rowHeight:50,
                multiSelect: false
            };
            // 分页 watch
            $scope.$watch('pagingOptions', function (newVal, oldVal) {
              getAll(getQueryParam(), $scope.pagingOptions.currentPage, $scope.pagingOptions.pageSize);
            }, true);
        };
      $scope.btnQueryClick = function(){
          getAll(getQueryParam(), $scope.pagingOptions.currentPage, $scope.pagingOptions.pageSize);
          $scope.pagingOptions.currentPage = 1;
          $scope.gridOptions.$gridScope.selectedItems.length=0;
         }
        //新增
        $scope.btnQueryAdd = function () {
            var modalInstance = $modal.open({
                templateUrl: 'changan/student/studentAdd.html',
                controller: 'StudentAddController',
                size: 'lg',
                resolve: {
                    detail: function () {
                        return $scope.arrayObj;
                    }
                }
            });
            modalInstance.result.then(function () {
                $scope.btnQueryClick();
            })
        };
        //上传
        $scope.uploadImg = function(){
            if($scope.gridOptions.$gridScope.selectedItems.length==0){
                alert('请选择一条数据');
                return
            }
            var modalInstance = studentService.uploadFile('图片上传','Student/upload');
            modalInstance.result.then(function (response) {
                if (response[0].errorCode == 0){
                    $scope.sysImg.imgParentid = $scope.gridOptions.$gridScope.selectedItems[0].studentId
                    $scope.sysImg.imgSource='/img/'+response[0].file
                    studentService.addImg($scope.sysImg).success(
                        function(data){
                            alert(data.errorMessage)
                        })
                }
                if(response[0].errorCode == 9){
                    alert(response[0].errorMessage)
                }
            }, function (data) {
                alert('错误'+data.errorMessage);
            });
        };
        //删除
        $scope.delete = function (row) {
            deleteActive(row.entity);
        }
        function deleteActive(param) {
            studentService.deleteStudent(param).success(
                function(data){
                    if(data.errorCode==1){
                        alert('删除成功');
                        getAll(getQueryParam(), $scope.pagingOptions.currentPage, $scope.pagingOptions.pageSize);
                    }
                }
            )
        };
        function getQueryParam(){
            var param = {};
            param.id=$scope.id;
            param.companyName=$scope.companyName
            return param;
        }
        //查看
        $scope.detail = function (row) {
            if($scope.gridOptions.$gridScope.selectedItems.length==0){
                alert('请选择一条数据');
                return
            }
            studentService.getImgUrl(row.entity.studentId).success(
                function(data){
                    if(data.errorCode==0){
                        $scope.imgSource=data.row.imgSource;
                        var modalInstance = $modal.open({
                            templateUrl: 'changan/student/studentImg.html',
                            controller: 'StudentImgController',
                            size: 'lg',
                            resolve: {
                                detail: function () {
                                    return $scope.imgSource;
                                }
                            }
                        });
                        modalInstance.result.then(function () {
                            $scope.btnQueryClick();
                        })
                    }
                    if(data.errorCode==9){
                        alert("请先上传图片")
                        return
                    }
                }
            )
        };
        //修改
        $scope.update = function (row) {
            var modalInstance = $modal.open({
                templateUrl: 'changan/student/studentAdd.html',
                controller: 'StudentUpdateController',
                size: 'lg',
                resolve: {
                    detail: function () {
                        return row.entity;
                    }
                }
            });
            modalInstance.result.then(function () {
                $scope.btnQueryClick();
            })
        };
        //查询全部
        function getAll(param,pageIndex,pageSize) {
            param.page = pageIndex;
            param.rows = pageSize;
            $scope.arrayObj=[];
            studentService.getStudentList(param).success(
                function(data){
                  $scope.studentList = data.rows;
                  $scope.totalServerItems = data.count;
                    for(var i=0;i<data.count;i++){
                        $scope.studentList[i].id = Number(i+1) + Number($scope.pagingOptions.currentPage - 1) * Number($scope.pagingOptions.pageSize);
                        if($scope.studentList[i].studentContext==1){
                            $scope.studentList[i].studentContext=="男"
                        }else{
                            $scope.studentList[i].studentContext=="女"
                        }
                    }
                    for(var i=0;i<data.ActiveRowscount;i++){
                        $scope.arrayObj.push(data.ActiveRows[i].activeName);
                    }
                }
            )
        };
        var inithis = function () {
            initGrid();
        }
        inithis();
    })

angular.module('app')
    .controller('StudentAddController',function($scope,studentService,$modalInstance,$state,detail){
        $scope.detail=detail;
        $scope.sex=["男","女"]
        $scope.queryParam={
            studentName:'',
            studentAge:'',
            studentContext:"",
            studentActiveid:""
        };

        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.btnSaveClick = function () {
            if($scope.queryParam.studentName==null||$scope.queryParam.studentName==''){
                alert("请填入学生名！");
                return;
            }
            if($scope.queryParam.studentAge==null||$scope.queryParam.studentAge==''){
                alert("请填入学生年龄！");
                return;
            }
            if($scope.queryParam.studentContext==null||$scope.queryParam.studentContext==''){
                alert("请填入学生性别！");
                return;
            }
            if($scope.queryParam.studentActiveid==null||$scope.queryParam.studentActiveid==''){
                alert("请填入学生报名的活动！");
                return;
            }
            studentService.addStudent($scope.queryParam).success(function (data) {
                    alert(data.errorMessage);
                    $modalInstance.dismiss();
                    $state.reload();
            })
        };
    })

angular.module('app')
    .controller('StudentImgController',function($scope,studentService,$modalInstance,$state,detail){
        $scope.queryParam={
            activeUrl:detail
        };
        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
    })

angular.module('app')
    .controller('StudentUpdateController',function($scope,studentService,$modalInstance,$state,detail){
        $scope.detail=["系统提示，暂时无法修改"]
        $scope.queryParam={
            studentId:detail.studentId,
            studentName:detail.studentName,
            studentAge:detail.studentAge,
            studentContext:detail.studentContext,
            studentActiveid:'系统提示：暂时无法修改'
        };
        if(detail.studentContext=="男"){
           $scope.sex=[detail.studentContext,"女"]
        }
        if(detail.studentContext=="女"){
            $scope.sex=[detail.studentContext,"男"]
        }
        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.btnSaveClick = function () {
            if($scope.queryParam.studentName==null||$scope.queryParam.studentName==''){
                alert("请填入学生名！");
                return;
            }
            if($scope.queryParam.studentAge==null||$scope.queryParam.studentAge==''){
                alert("请填入学生年龄！");
                return;
            }
            if($scope.queryParam.studentContext==null||$scope.queryParam.studentContext==''){
                alert("请填入学生性别！");
                return;
            }
            if($scope.queryParam.studentActiveid==null||$scope.queryParam.studentActiveid==''){
                alert("请填入学生报名的活动！");
                return;
            }
            delete $scope.queryParam.studentActiveid
            studentService.UpdateStudent($scope.queryParam).success(function (data) {
                alert(data.errorMessage);
                $modalInstance.dismiss();
                $state.reload();
            })
        };
    })

