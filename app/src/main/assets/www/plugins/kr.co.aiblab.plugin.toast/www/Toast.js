cordova.define("kr.co.aiblab.cordova.plugin.toast.Toast", function(require, exports, module) {
    var exec = require('cordova/exec');
    exports.showToast = function (message, success, error) {
        exec(success, error, 'Toast', 'showToast', [message]);
    };
});
