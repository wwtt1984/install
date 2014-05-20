var Install = function () {};
/**
 * 设置提示值
 * @param src
 * @returns {*}
 */
Install.prototype.InstallApk = function (src,onSuccess, onFail) {
    return cordova.exec(onSuccess, onFail,"InstallPlugin","Install",[src]);
};

Install.prototype.OpenApp = function (src,onSuccess, onFail) {
    return cordova.exec(onSuccess, onFail,"InstallPlugin","OpenApp",[src]);
};
module.exports = (new Install());
