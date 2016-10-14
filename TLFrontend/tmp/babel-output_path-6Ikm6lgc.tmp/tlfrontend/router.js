define('tlfrontend/router', ['exports', 'ember', 'tlfrontend/config/environment'], function (exports, _ember, _tlfrontendConfigEnvironment) {

  var Router = _ember['default'].Router.extend({
    location: _tlfrontendConfigEnvironment['default'].locationType,
    rootURL: _tlfrontendConfigEnvironment['default'].rootURL
  });

  Router.map(function () {
    this.route('home', { path: '/' }, function () {
      this.route('login');
      this.route('news');
      this.route('libro');
      this.route('registrar');
      this.route('carrito');
    });
    this.route('cobrar');
    this.route('nuevoLibro');
  });

  exports['default'] = Router;
});