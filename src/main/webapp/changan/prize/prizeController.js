/**
 * Created by yin on 2016/9/29.
 */

angular.module('app')
    .controller('prizeController', function ($rootScope,$scope,$log,$state,$filter,$modal,prizeService) {
      var initGrid;

      initGrid = function () {
            // 分页
            $scope.pagingOptions = {
                pageSizes: [10, 20, 30],
                pageSize: 10,
                currentPage: 1
            };
          $scope.sysImg={
              imgSource:'',
              imgParentid: "",
              imgType:"2"
          };
          $scope.arrayObj =  [];
          // 排序
          $scope.filterOptions = {
            filterText: "",
            useExternalFilter: true
          };
            // 行
            $scope.columnDefs = [
                {field: 'id', displayName: '序号', width:100},
                {field: 'prizeName', displayName: '奖品名', width:200},
                {field: 'prizeContext', displayName: '奖品内容', width:200},
                 {
                     displayName: '操作',
                     width:100,
                     cellTemplate: '<div class="operation-container">' +
                     '<button class="btn icon-social-dropbox btn-danger" ng-click="delete(row)" >删除</button>'+
                     '<button class="btn icon-cloud-upload btn-default" ng-click="uploadImg()">上传图片</button>'+
                     '<button class="btn icon-note btn-warning" ng-click="update(row)">修改</button>' +
                     '</div>'
                 }
                ];
            // gird options
            $scope.gridOptions = {
                data: 'prizeList',
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
         $scope.uploadImg = function(){
             if($scope.gridOptions.$gridScope.selectedItems.length==0){
                 alert('请选择一条数据');
                 return
             }
             var modalInstance = prizeService.uploadFile('图片上传','Prize/upload');
             modalInstance.result.then(function (response) {
                 if (response[0].errorCode == 0){
                     $scope.sysImg.imgParentid = $scope.gridOptions.$gridScope.selectedItems[0].prizeId
                     $scope.sysImg.imgSource='/img/'+response[0].file
                     prizeService.addImg($scope.sysImg).success(
                         function(data){
                            alert(data.errorMessage)
                         })
                 }
                 if(response[0].errorCode == 9){
                     alert(response[0].errorMessage)
                 }
             }, function (data) {
                 alert('错误'+'未知错误:\r\n'+data);
             });
         };
        //新增
        $scope.btnQueryAdd = function () {
            var modalInstance = $modal.open({
                templateUrl: 'changan/prize/prizeAdd.html',
                controller: 'prizeAddController',
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
        //修改
        $scope.update = function (row) {
            var modalInstance = $modal.open({
                templateUrl: 'changan/prize/prizeAdd.html',
                controller: 'prizeUpdateController',
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
        //删除
        $scope.delete = function (row) {
            deleteActive(row.entity);
        }
        function deleteActive(param) {
            prizeService.deletePrize(param).success(
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
            param.prizeName=$scope.prizeName
            return param;
        }

        //查询全部
        function getAll(param,pageIndex,pageSize) {
            param.page = pageIndex;
            param.rows = pageSize;
            $scope.arrayObj=[]
            prizeService.getPrizeList(param).success(
                function(data){
                  $scope.prizeList = data.rows;
                  $scope.totalServerItems = data.count;
                    for(var i=0;i<data.count;i++){
                        $scope.prizeList[i].id = Number(i+1) + Number($scope.pagingOptions.currentPage - 1) * Number($scope.pagingOptions.pageSize);
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
    .controller('prizeAddController',function($scope,prizeService,$modalInstance,$state,detail){
        console.info(detail);
        $scope.detail=detail;
        $scope.queryParam={
            prizeName:'',
            prizeContext:"",
            activeid:""
        };

        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.btnSaveClick = function () {
            if($scope.queryParam.prizeName==null||$scope.queryParam.prizeName==''){
                alert("请填入奖品名！");
                return;
            }
            if($scope.queryParam.activeid==null||$scope.queryParam.activeid==''){
                alert("请选择活动！");
                return;
            }
            var activeName=$scope.queryParam.activeid
            prizeService.addPrize($scope.queryParam,activeName).success(function (data) {
                    alert(data.errorMessage);
                    $modalInstance.dismiss();
                    $state.reload();
            })
        };
    })

angular.module('app')
    .controller('prizeUpdateController',function($scope,prizeService,$modalInstance,$state,detail){
        $scope.detail = ["系统提示:暂时无法修改"]
        $scope.queryParam={
            prizeName:detail.prizeName,
            prizeContext:detail.prizeContext,
            prizeId:detail.prizeId,
            activeid:"系统提示:暂时无法修改"
        };
        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.btnSaveClick = function () {
            if($scope.queryParam.prizeName==null||$scope.queryParam.prizeName==''){
                alert("请填入奖品名！");
                return;
            }
            delete $scope.queryParam.activeid
            prizeService.UpdatePrize($scope.queryParam).success(function (data) {
                alert(data.errorMessage);
                $modalInstance.dismiss();
                $state.reload();
            })
        };
    })