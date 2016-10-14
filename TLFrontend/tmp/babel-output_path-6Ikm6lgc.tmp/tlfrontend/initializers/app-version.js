define('tlfrontend/initializers/app-version', ['exports', 'ember-cli-app-version/initializer-factory', 'tlfrontend/config/environment'], function (exports, _emberCliAppVersionInitializerFactory, _tlfrontendConfigEnvironment) {
  exports['default'] = {
    name: 'App Version',
    initialize: (0, _emberCliAppVersionInitializerFactory['default'])(_tlfrontendConfigEnvironment['default'].APP.name, _tlfrontendConfigEnvironment['default'].APP.version)
  };
});