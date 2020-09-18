cordova.define('cordova/plugin_list', function(require, exports, module) {
  module.exports = [
    {
      "id": "kr.co.aiblab.cordova.plugin.toast.Toast",
      "file": "plugins/kr.co.aiblab.plugin.toast/www/Toast.js",
      "pluginId": "kr.co.aiblab.cordova.plugin.toast",
      "clobbers": [
        "cordova.plugins.Toast"
      ]
    }
  ];
  module.exports.metadata = {
    "cordova-plugin-whitelist": "1.3.4",
    "kr.co.aiblab.cordova.plugin.toast": "1.0.0"
  };
});