/**
 * Created by yin on 2016/9/29.
 */

angular.module('app')
    .controller('activeImgController', function ($rootScope,$scope,$log,$state,$filter,$modal,activeImgService) {
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
              imgType:"1"
          };
          $scope.imgSource=null
          $scope.arrayObj =  [];
          // 排序
          $scope.filterOptions = {
            filterText: "",
            useExternalFilter: true
          };
            // 行
            $scope.columnDefs = [
                {field: 'id', displayName: '序号', width:50,height:30},
                {field: 'activeName', displayName: '活动名', width:100,height:30},
                {field: 'imgSource', displayName: '活动图片', width:500,height:30},
                {
                    displayName: '操作',
                    width:100,
                    height:30,
                    cellTemplate: '<div class="operation-container">' +
                    '<button class="btn icon-social-dropbox btn-danger" ng-click="delete(row)" >删除</button>'+
                    '<button class="btn icon-eye btn-default" ng-click="detail(row)">查看图片</button>'+
                    '</div>'
                }
                ];
            // gird options
            $scope.gridOptions = {
                data: 'activeList',
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
      //删除
        $scope.delete = function (row) {
            deleteActiveImg(row.entity);
        }
        function deleteActiveImg(param) {
            activeImgService.deleteActiveImg(param).success(
                function(data){
                    if(data.errorCode==1){
                        alert('删除成功');
                        getAll(getQueryParam(), $scope.pagingOptions.currentPage, $scope.pagingOptions.pageSize);
                    }
                }
            )
        };
        //查看
        $scope.detail = function (row) {
            if($scope.gridOptions.$gridScope.selectedItems.length==0){
                alert('请选择一条数据');
                return
            }
            var modalInstance = $modal.open({
                templateUrl: 'changan/activeImg/activeImgDetail.html',
                controller: 'activeImgDetailController',
                size: 'lg',
                resolve: {
                    detail: function () {
                        return row.entity.imgSource;
                    }
                }
            });
            modalInstance.result.then(function () {
                $scope.btnQueryClick();
            })
        };
      function getQueryParam(){
            var param = {};
            param.id=$scope.id;
            param.activeName=$scope.activeName;
            return param;
        }

        //查询全部
        function getAll(param,pageIndex,pageSize) {
            param.page = pageIndex;
            param.rows = pageSize;
            $scope.arrayObj=[]
            activeImgService.getActiveImgList(param).success(
                function(data){
                  $scope.activeList = data.rows;
                  $scope.totalServerItems = data.count;
                    for(var i=0;i<data.count;i++){
                        $scope.activeList[i].id = Number(i+1) + Number($scope.pagingOptions.currentPage - 1) * Number($scope.pagingOptions.pageSize);
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
    .controller('activeImgDetailController',function($scope,activeImgService,$modalInstance,$state,detail){
        $scope.queryParam={
            imgSource:detail
        };
        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
    })
