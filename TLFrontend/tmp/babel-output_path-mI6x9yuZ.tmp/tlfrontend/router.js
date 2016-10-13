define('tlfrontend/router', ['exports', 'ember', 'tlfrontend/config/environment'], function (exports, _ember, _tlfrontendConfigEnvironment) {

  var Router = _ember['default'].Router.extend({
    location: _tlfrontendConfigEnvironment['default'].locationType,
    rootURL: _tlfrontendConfigEnvironment['default'].rootURL
  });

  Router.map(function () {
    this.route('home', { path: '/' }, function () {
      this.route('catalogo');
      this.route('login');
      this.route('news');
      this.route('libro');
    });
    this.route('cobrar');
  });

  exports['default'] = Router;
});