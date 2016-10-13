define('tlfrontend/tests/helpers/module-for-acceptance', ['exports', 'qunit', 'ember', 'tlfrontend/tests/helpers/start-app', 'tlfrontend/tests/helpers/destroy-app'], function (exports, _qunit, _ember, _tlfrontendTestsHelpersStartApp, _tlfrontendTestsHelpersDestroyApp) {
  var Promise = _ember['default'].RSVP.Promise;

  exports['default'] = function (name) {
    var options = arguments.length <= 1 || arguments[1] === undefined ? {} : arguments[1];

    (0, _qunit.module)(name, {
      beforeEach: function beforeEach() {
        this.application = (0, _tlfrontendTestsHelpersStartApp['default'])();

        if (options.beforeEach) {
          return options.beforeEach.apply(this, arguments);
        }
      },

      afterEach: function afterEach() {
        var _this = this;

        var afterEach = options.afterEach && options.afterEach.apply(this, arguments);
        return Promise.resolve(afterEach).then(function () {
          return (0, _tlfrontendTestsHelpersDestroyApp['default'])(_this.application);
        });
      }
    });
  };
});