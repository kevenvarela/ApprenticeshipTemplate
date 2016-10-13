define('tlfrontend/tests/helpers/resolver', ['exports', 'tlfrontend/resolver', 'tlfrontend/config/environment'], function (exports, _tlfrontendResolver, _tlfrontendConfigEnvironment) {

  var resolver = _tlfrontendResolver['default'].create();

  resolver.namespace = {
    modulePrefix: _tlfrontendConfigEnvironment['default'].modulePrefix,
    podModulePrefix: _tlfrontendConfigEnvironment['default'].podModulePrefix
  };

  exports['default'] = resolver;
});