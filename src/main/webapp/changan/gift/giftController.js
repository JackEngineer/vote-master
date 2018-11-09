/**
 * Created by yin on 2016/9/29.
 */

angular.module('app')
    .controller('giftController', function ($rootScope,$scope,$log,$state,$filter,$modal,giftService) {
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
          $scope.imgSource=null;
          $scope.arrayObj =  [];
          // 排序
          $scope.filterOptions = {
            filterText: "",
            useExternalFilter: true
          };
            // 行
            $scope.columnDefs = [
                {field: 'id', displayName: '序号', width:100},
                {field: 'giftName', displayName: '礼物名', width:200},
                {field: 'giftPrice', displayName: '礼物价格', width:200},
                {
                    displayName: '操作',
                    width:400,
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
                data: 'giftList',
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
         };
        //删除
        $scope.delete = function (row) {
            row.entity.giftPrice=row.entity.giftPrice.substring(1)
            deleteActive(row.entity);
        }
        function deleteActive(param) {
            giftService.deleteGift(param).success(
                function(data){
                    if(data.errorCode==1){
                        alert('删除成功');
                        getAll(getQueryParam(), $scope.pagingOptions.currentPage, $scope.pagingOptions.pageSize);
                    }
                }
            )
        };
        //上传
        $scope.uploadImg = function(){
            if($scope.gridOptions.$gridScope.selectedItems.length==0){
                alert('请选择一条数据');
                return
            }
            var modalInstance = giftService.uploadFile('图片上传','Active/upload');
            modalInstance.result.then(function (response) {
                if (response[0].errorCode == 0){
                    $scope.sysImg.imgParentid = $scope.gridOptions.$gridScope.selectedItems[0].giftId
                    $scope.sysImg.imgSource='/img/'+response[0].file
                    giftService.addImg($scope.sysImg).success(
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
        $scope.btnQueryAdd = function () {
            var modalInstance = $modal.open({
                templateUrl: 'changan/gift/giftAdd.html',
                controller: 'giftAddController',
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
                templateUrl: 'changan/gift/giftAdd.html',
                controller: 'giftUpdateController',
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
            giftService.getImgUrl(row.entity.giftId).success(
                function(data){
                    if(data.errorCode==0){
                        $scope.imgSource=data.row.imgSource;
                        var modalInstance = $modal.open({
                            templateUrl: 'changan/gift/giftImg.html',
                            controller: 'giftImgController',
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
            param.giftName=$scope.giftName
            return param;
        }

        //查询全部
        function getAll(param,pageIndex,pageSize) {
            param.page = pageIndex;
            param.rows = pageSize;
            $scope.arrayObj=[]
            giftService.getGiftList(param).success(
                function(data){
                  $scope.giftList = data.rows;
                  $scope.totalServerItems = data.count;
                    for(var i=0;i<data.count;i++){
                        $scope.giftList[i].id = Number(i+1) + Number($scope.pagingOptions.currentPage - 1) * Number($scope.pagingOptions.pageSize);
                        $scope.giftList[i].giftPrice ="￥"+ $scope.giftList[i].giftPrice
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
    .controller('giftAddController',function($scope,giftService,$modalInstance,$state,detail){
        console.info(detail);
        $scope.detail=detail;
        $scope.queryParam={
            giftName:'',
            giftTicket:'',
            giftPrice:""
        };

        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.btnSaveClick = function () {
            if($scope.queryParam.giftName==null||$scope.queryParam.giftName==''){
                alert("请填入礼物名！");
                return;
            }
            if($scope.queryParam.giftPrice==null||$scope.queryParam.giftPrice==''){
                alert("请填入礼物价格！");
                return;
            }
            if($scope.queryParam.giftTicket==null||$scope.queryParam.giftTicket==''){
                alert("请填入礼物对应票数！");
                return;
            }
            giftService.addGift($scope.queryParam).success(function (data) {
                    alert(data.errorMessage);
                    $modalInstance.dismiss();
                    $state.reload();
            })
        };
    })

angular.module('app')
    .controller('giftImgController',function($scope,giftService,$modalInstance,$state,detail){
        $scope.queryParam={
            giftUrl:detail
        };
        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
    })

angular.module('app')
    .controller('giftUpdateController',function($scope,giftService,$modalInstance,$state,detail){
        $scope.queryParam={
            giftId:detail.giftId,
            giftName:detail.giftName,
            giftPrice:detail.giftPrice.substring(1)
        };

        $scope.cancel = function () {
            $modalInstance.dismiss();
        };
        $scope.btnSaveClick = function () {
            if($scope.queryParam.giftName==null||$scope.queryParam.giftName==''){
                alert("请填入礼物名！");
                return;
            }
            if($scope.queryParam.giftPrice==null||$scope.queryParam.giftPrice==''){
                alert("请填入礼物价格！");
                return;
            }
            giftService.UpdateGift($scope.queryParam).success(function (data) {
                alert(data.errorMessage);
                $modalInstance.dismiss();
                $state.reload();
            })
        };
    })
