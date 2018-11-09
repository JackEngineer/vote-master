/**
 * Created by yin on 2016/9/29.
 */

angular.module('app')
    .controller('companyController', function ($rootScope,$scope,$log,$state,$filter,$modal,companyService) {
      var initGrid;


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
            // 行
            $scope.columnDefs = [
                {field: 'id', displayName: '序号', width:100},
                {field: 'companyName', displayName: '培训机构名', width:200},
                {field: 'companyPlace', displayName: '培训机构地址', width:200},
                {field: 'companyCreatetime', displayName: '创建时间', width:200},
                {
                    field: '',
                    displayName:'操作',
                    width:200,
                    cellTemplate: '<div class="operation-container">' +
                                  '<button class="btn icon-social-dropbox btn-danger" ng-click="delete(row)" >删除</button>'+
                                  '<button class="btn icon-note btn-warning" ng-click="update(row)">修改</button>' +
                                  '</div>'
                }
            ];
            // gird options
            $scope.gridOptions = {
                data: 'companyList',
                enablePaging: true,
                enableColumnResize:true,
                showFooter: true,
                enableHighlighting:true,
                totalServerItems: 'totalServerItems',
                pagingOptions: $scope.pagingOptions,
                filterOptions: $scope.filterOptions,
                columnDefs: $scope.columnDefs,
                multiSelect: false,
                rowHeight:50
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
                templateUrl: 'changan/company/companyAdd.html',
                controller: 'companyAddController',
                size: 'lg',
                resolve: {
                    detail: function () {
                        return null;
                    }
                }
            });
            modalInstance.result.then(function () {
                $scope.btnQueryClick();
            })
        };
        $scope.update = function (row) {
            var modalInstance = $modal.open({
                templateUrl: 'changan/company/companyAdd.html',
                controller: 'companyUpdateController',
                resolve: {
                    detail: function () {
                        return row.entity;
                    }
                }
            });
            modalInstance.result.then(function(){
                $scope.btnQueryClick();
            });
        };
        function getQueryParam(){
            var param = {};
            param.id=$scope.id;
            param.companyName=$scope.companyName;
            return param;
        }
        $scope.delete=function (row) {
            deleteCompany(row.entity);
        }
        //查询全部
        function deleteCompany(param) {
            companyService.deleteCompany(param).success(
                function(data){
                  if(data.errorCode==1){
                      alert('删除成功');
                      getAll(getQueryParam(), $scope.pagingOptions.currentPage, $scope.pagingOptions.pageSize);
                  }
                }
            )
        };

        //查询全部
        function getAll(param,pageIndex,pageSize) {
            param.page = pageIndex;
            param.rows = pageSize;
            companyService.getCompanyList(param).success(
                function(data){
                  $scope.companyList = data.rows;
                  $scope.pagingOptions.totalServerItems = data.count;
                    for(var i=0;i<data.count;i++){
                        $scope.companyList[i].id = Number(i+1) + Number($scope.pagingOptions.currentPage - 1) * Number($scope.pagingOptions.pageSize);
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
    .controller('companyAddController',function($scope,companyService,$modalInstance,$state){
        $scope.queryParam={
            companyName:'',
            companyPlace:''
        };

        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.btnSaveClick = function () {
            if($scope.queryParam.companyName==null||$scope.queryParam.companyName==''){
                alert("请填入培训机构名！");
                return;
            }
            if($scope.queryParam.companyPlace==null||$scope.queryParam.companyPlace==''){
                alert("请填入地址！");
                return;
            }
            companyService.addCompany($scope.queryParam).success(function (data) {
                    alert(data.errorMessage);
                    $modalInstance.dismiss();
                    $state.reload();
            })
        };
    })

angular.module('app')
    .controller('companyUpdateController',function($scope,companyService,$modalInstance,$state,detail){
        $scope.queryParam={
            companyId:detail.companyId,
            companyName:detail.companyName,
            companyPlace:detail.companyPlace
        };

        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.btnSaveClick = function () {
            if($scope.queryParam.companyName==null||$scope.queryParam.companyName==''){
                alert("请填入培训机构名！");
                return;
            }
            if($scope.queryParam.companyPlace==null||$scope.queryParam.companyPlace==''){
                alert("请填入地址！");
                return;
            }
            companyService.updateCompany($scope.queryParam).success(function (data) {
                alert(data.errorMessage);
                $modalInstance.dismiss();
                $state.reload();
            })
        };
    })