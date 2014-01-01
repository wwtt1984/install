var Install = function () {};
/**
 * 设置提示值
 * @param src
 * @returns {*}
 */
Install.prototype.InstallApk = function (src) {
    return cordova.exec(null, null,"InstallPlugin","Install",[src]);
};
module.exports = (new Install());
