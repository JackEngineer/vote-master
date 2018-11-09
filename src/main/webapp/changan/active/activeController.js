/**
 * Created by yin on 2016/9/29.
 */

angular.module('app')
    .controller('activeController', function ($rootScope,$scope,$log,$state,$filter,$modal,activeService) {
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
                {field: 'activeContext', displayName: '活动内容', width:100,height:30},
                {field: 'activePlace', displayName: '活动地点', width:100,height:30},
                {field: 'activeUrl', displayName: '活动链接', width:300,height:30},
                {field: 'activeEndtime', displayName: '结束时间', width:100,height:30},
                {
                    displayName: '操作',
                    width:400,
                    height:30,
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
         //上传
        $scope.uploadImg = function(){
            if($scope.gridOptions.$gridScope.selectedItems.length==0){
                alert('请选择一条数据');
                return
            }
            var modalInstance = activeService.uploadFile('图片上传','Active/upload');
            modalInstance.result.then(function (response) {
                if (response[0].errorCode == 0){
                    $scope.sysImg.imgParentid = $scope.gridOptions.$gridScope.selectedItems[0].activeId
                    $scope.sysImg.imgSource='/img/'+response[0].file
                    activeService.addImg($scope.sysImg).success(
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
            activeService.deleteActive(param).success(
                function(data){
                    if(data.errorCode==1){
                        alert('删除成功');
                        getAll(getQueryParam(), $scope.pagingOptions.currentPage, $scope.pagingOptions.pageSize);
                    }
                }
            )
        };
        //新增
        $scope.btnQueryAdd = function () {
            var modalInstance = $modal.open({
                templateUrl: 'changan/active/activeAdd.html',
                controller: 'activeAddController',
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
        $scope.update = function (row) {
            var modalInstance = $modal.open({
                templateUrl: 'changan/active/activeAdd.html',
                controller: 'activeUpdateController',
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
        //查看
        $scope.detail = function (row) {
            if($scope.gridOptions.$gridScope.selectedItems.length==0){
                alert('请选择一条数据');
                return
            }
            activeService.getImgUrl(row.entity.activeId).success(
                    function(data){
                        if(data.errorCode==0){
                            $scope.imgSource=data.row.imgSource;
                            var modalInstance = $modal.open({
                                templateUrl: 'changan/active/activeImg.html',
                                controller: 'activeImgController',
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
            activeService.getActiveList(param).success(
                function(data){
                  $scope.activeList = data.rows;
                  $scope.totalServerItems = data.count;
                    for(var i=0;i<data.CompanyRowscount;i++){
                        $scope.arrayObj.push(data.CompanyRows[i].companyName);
                    }
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
    .controller('activeAddController',function($scope,activeService,$modalInstance,$state,detail,$filter){

        $scope.detail=detail;
        $scope.queryParam={
            activeName:'',
            activeCompanyid: "",
            activeImg:"",
            activeContext:"",
            activePlace:"",
            activeBegintime:"",
            activeEndtime:""
        };
        $scope.format = 'yyyy-MM-dd';
        $scope.opener1 = function($event,index) {
            $event.preventDefault();
            $event.stopPropagation();
            if (index == 0){
                $scope.openedBegin = true;
            } else {
                 $scope.openedEnd = true;
            }

        };
        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.btnSaveClick = function () {
            if($scope.queryParam.activeName==null||$scope.queryParam.activeName==''){
                alert("请填入活动名！");
                return;
            }
            if($scope.queryParam.activePlace==null||$scope.queryParam.activePlace==''){
                alert("请填入活动地址！");
                return;
            }
            if($scope.queryParam.activeCompanyid==null||$scope.queryParam.activeCompanyid==''){
                alert("请选择机构！");
                return;
            }
            if($scope.queryParam.activeBegintime==null||$scope.queryParam.activeBegintime==''){
                alert("请填写开始时间！");
                return;
            }
            if($scope.queryParam.activeEndtime==null||$scope.queryParam.activeEndtime==''){
                alert("请填写结束时间！");
                return;
            }
            $scope.queryParam.activeBegintime = typeof($scope.queryParam.activeBegintime) == "undefined" ? '' : $filter('date')($scope.queryParam.activeBegintime, 'yyyy-MM-dd');
            $scope.queryParam.activeEndtime = typeof($scope.queryParam.activeEndtime) == "undefined" ? '' : $filter('date')($scope.queryParam.activeEndtime, 'yyyy-MM-dd        ');
            activeService.addActive($scope.queryParam).success(function (data) {
                    alert(data.errorMessage);
                    $modalInstance.dismiss();
                    $state.reload();
            })
        };
    })

angular.module('app')
    .controller('activeImgController',function($scope,activeService,$modalInstance,$state,detail){
        $scope.queryParam={
            activeUrl:detail
        };
        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
    })

angular.module('app')
    .controller('activeUpdateController',function($scope,activeService,$modalInstance,$state,detail,$filter){
        $scope.detail = ["系统提示：暂时无法修改"]
        $scope.queryParam={
            activeId:detail.activeId,
            activeName:detail.activeName,
            activeCompanyid:"系统提示：暂时无法修改",
            activeImg:detail.activeImg,
            activeContext:detail.activeContext,
            activePlace:detail.activePlace,
            activeBegintime:detail.activeBegintime,
            activeEndtime:detail.activeEndtime
        };
        $scope.format = 'yyyy-MM-dd';
        $scope.opener1 = function($event,index) {
            $event.preventDefault();
            $event.stopPropagation();
            if (index == 0){
                $scope.openedBegin = true;
            } else {
                $scope.openedEnd = true;
            }

        };
        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.btnSaveClick = function () {
            if($scope.queryParam.activeName==null||$scope.queryParam.activeName==''){
                alert("请填入活动名！");
                return;
            }
            if($scope.queryParam.activePlace==null||$scope.queryParam.activePlace==''){
                alert("请填入活动地址！");
                return;
            }
            if($scope.queryParam.activeCompanyid==null||$scope.queryParam.activeCompanyid==''){
                alert("请选择机构！");
                return;
            }
            if($scope.queryParam.activeBegintime==null||$scope.queryParam.activeBegintime==''){
                alert("请填写开始时间！");
                return;
            }
            if($scope.queryParam.activeEndtime==null||$scope.queryParam.activeEndtime==''){
                alert("请填写结束时间！");
                return;
            }
            $scope.queryParam.activeBegintime = typeof($scope.queryParam.activeBegintime) == "undefined" ? '' : $filter('date')($scope.queryParam.activeBegintime, 'yyyy-MM-dd');
            $scope.queryParam.activeEndtime = typeof($scope.queryParam.activeEndtime) == "undefined" ? '' : $filter('date')($scope.queryParam.activeEndtime, 'yyyy-MM-dd        ');
            delete $scope.queryParam.activeCompanyid
            activeService.UpdateActive($scope.queryParam).success(function (data) {
                alert(data.errorMessage);
                $modalInstance.dismiss();
                $state.reload();
            })
        };
    })

