define('tlfrontend/models/cliente', ['exports', 'ember-data'], function (exports, _emberData) {
  exports['default'] = _emberData['default'].Model.extend({
    usuario: _emberData['default'].attr('string'),
    password: _emberData['default'].attr('string')
  });
});