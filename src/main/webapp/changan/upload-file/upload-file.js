/**
 * Created by jason on 16/6/2.
 * upload shop list dialog controller
 */

angular.module('app')
  .controller('UploadFileController', function ($scope, $log, $modalInstance, FileUploader, PKO_CONFIG) {

    // file uploader
    var uploader = $scope.uploader = new FileUploader({
      url: PKO_CONFIG.PKOperateServerIP.concat($scope.url),
      formData: $scope.params,
      withCredentials: true,
      removeAfterUpload: true
    });

    $scope.response = [];

    $scope.btnSendClick = function () {
      try {
        $scope.uploader.uploadAll();
      } catch (err) {
        console.info(err);
      }
    };

    $scope.btnCancelClick = function () {
      if ($scope.uploader.isUploading) {
        $scope.uploader.cancelAll();
      }
      $modalInstance.close('cancel');
    }

    // CALLBACKS
    uploader.onWhenAddingFileFailed = function (item /*{File|FileLikeObject}*/, filter, options) {
      console.info('onWhenAddingFileFailed', item, filter, options);
    };

    uploader.onAfterAddingFile = function (fileItem) {
      console.info('onAfterAddingFile', fileItem);
    };

    uploader.onAfterAddingAll = function (addedFileItems) {
      console.info('onAfterAddingAll', addedFileItems);
    };

    uploader.onBeforeUploadItem = function (item) {
      console.info('onBeforeUploadItem', item);
    };

    uploader.onProgressItem = function (fileItem, progress) {
      console.info('onProgressItem', fileItem, progress);
    };

    uploader.onProgressAll = function (progress) {
      $log.debug('onProgressAll', progress);
      //$modalInstance.close('ok');
    };

    uploader.onSuccessItem = function (fileItem, response, status, headers) {
      $scope.response.push({
        file: fileItem._file.name,
        errorCode: response.errorCode,
        errorMessage: response.errorMessage
      });
    };

    uploader.onErrorItem = function (fileItem, response, status, headers) {
      console.info('onErrorItem', fileItem, response, status, headers);
    };

    uploader.onCancelItem = function (fileItem, response, status, headers) {
      console.info('onCancelItem', fileItem, response, status, headers);
    };

    uploader.onCompleteItem = function (fileItem, response, status, headers) {
      console.info('onCompleteItem', fileItem, response, status, headers);
    };

    uploader.onCompleteAll = function () {
      $modalInstance.close($scope.response);
    };

  });


angular.module('app')
  .controller('PKUploadFileGetAllResponseController', function ($scope, $log, $modalInstance, FileUploader, PKO_CONFIG) {

    // file uploader
    var uploader = $scope.uploader = new FileUploader({
      url: PKO_CONFIG.PKOperateServerIP.concat($scope.url),
      formData: $scope.params,
      withCredentials: true,
      removeAfterUpload: true
    });

    $scope.response = [];

    $scope.btnSendClick = function () {
      try {
        $scope.uploader.uploadAll();
      } catch (err) {
        console.info(err);
      }
    };

    $scope.btnCancelClick = function () {
      if ($scope.uploader.isUploading) {
        $scope.uploader.cancelAll();
      }
      $modalInstance.close('cancel');
    }

    // CALLBACKS
    uploader.onWhenAddingFileFailed = function (item /*{File|FileLikeObject}*/, filter, options) {
      console.info('onWhenAddingFileFailed', item, filter, options);
    };

    uploader.onAfterAddingFile = function (fileItem) {
      console.info('onAfterAddingFile', fileItem);
    };

    uploader.onAfterAddingAll = function (addedFileItems) {
      console.info('onAfterAddingAll', addedFileItems);
    };

    uploader.onBeforeUploadItem = function (item) {
      console.info('onBeforeUploadItem', item);
    };

    uploader.onProgressItem = function (fileItem, progress) {
      console.info('onProgressItem', fileItem, progress);
    };

    uploader.onProgressAll = function (progress) {
      $log.debug('onProgressAll', progress);
      //$modalInstance.close('ok');
    };

    uploader.onSuccessItem = function (fileItem, response, status, headers) {
      $scope.response.push({
        file: fileItem._file.name,
        errorCode: response.errorCode,
        errorMessage: response.errorMessage,
        response: response
      });
    };

    uploader.onErrorItem = function (fileItem, response, status, headers) {
      console.info('onErrorItem', fileItem, response, status, headers);
    };

    uploader.onCancelItem = function (fileItem, response, status, headers) {
      console.info('onCancelItem', fileItem, response, status, headers);
    };

    uploader.onCompleteItem = function (fileItem, response, status, headers) {
      console.info('onCompleteItem', fileItem, response, status, headers);
    };

    uploader.onCompleteAll = function () {
      $modalInstance.close($scope.response);
    };

  });
