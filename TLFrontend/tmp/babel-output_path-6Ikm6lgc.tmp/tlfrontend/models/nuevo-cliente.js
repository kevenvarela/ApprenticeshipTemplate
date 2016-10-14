define('tlfrontend/models/nuevo-cliente', ['exports', 'ember-data'], function (exports, _emberData) {
  exports['default'] = _emberData['default'].Model.extend({
    password: _emberData['default'].attr('string')
  });
});