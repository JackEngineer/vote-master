/**
 * Created by yin on 2016/9/29.
 */

angular.module('app')
    .controller('weChatController', function ($rootScope,$scope,$log,$state,$filter,$modal,weChatService) {
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
                {field: 'weChatName', displayName: '账户名', width:100},
                {field: 'weChatType', displayName: '类型', width:100},
                {field: 'weChatCurrAmt', displayName: '金额', width:100},
                {field: 'weChatDate', displayName: '时间', width:100}
                ];
            // gird options
            $scope.gridOptions = {
                data: 'weChatList',
                enablePaging: true,
                enableColumnResize:true,
                showFooter: true,
                enableHighlighting:true,
                totalServerItems: 'totalServerItems',
                pagingOptions: $scope.pagingOptions,
                columnDefs: $scope.columnDefs,
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

      function getQueryParam(){
            var param = {};
            param.id=$scope.id;
            param.companyName=$scope.companyName
            return param;
        }


        //查询全部
        function getAll(param,pageIndex,pageSize) {
            param.page = pageIndex;
            param.rows = pageSize;
            weChatService.getWeChatList(param).success(
                function(data){
                  $scope.companyList = data.rows;
                  $scope.totalServerItems = data.count;
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
