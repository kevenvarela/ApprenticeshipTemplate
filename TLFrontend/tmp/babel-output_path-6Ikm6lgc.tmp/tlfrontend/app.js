define('tlfrontend/app', ['exports', 'ember', 'tlfrontend/resolver', 'ember-load-initializers', 'tlfrontend/config/environment'], function (exports, _ember, _tlfrontendResolver, _emberLoadInitializers, _tlfrontendConfigEnvironment) {

  var App = undefined;

  _ember['default'].MODEL_FACTORY_INJECTIONS = true;

  App = _ember['default'].Application.extend({
    modulePrefix: _tlfrontendConfigEnvironment['default'].modulePrefix,
    podModulePrefix: _tlfrontendConfigEnvironment['default'].podModulePrefix,
    Resolver: _tlfrontendResolver['default']
  });

  (0, _emberLoadInitializers['default'])(App, _tlfrontendConfigEnvironment['default'].modulePrefix);

  exports['default'] = App;
});