define('tlfrontend/tests/helpers/start-app', ['exports', 'ember', 'tlfrontend/app', 'tlfrontend/config/environment'], function (exports, _ember, _tlfrontendApp, _tlfrontendConfigEnvironment) {
  exports['default'] = startApp;

  function startApp(attrs) {
    var application = undefined;

    var attributes = _ember['default'].merge({}, _tlfrontendConfigEnvironment['default'].APP);
    attributes = _ember['default'].merge(attributes, attrs); // use defaults, but you can override;

    _ember['default'].run(function () {
      application = _tlfrontendApp['default'].create(attributes);
      application.setupForTesting();
      application.injectTestHelpers();
    });

    return application;
  }
});