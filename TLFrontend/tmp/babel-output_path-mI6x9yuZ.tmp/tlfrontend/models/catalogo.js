define('tlfrontend/models/catalogo', ['exports', 'ember-data'], function (exports, _emberData) {
  exports['default'] = _emberData['default'].Model.extend({
    titulo: _emberData['default'].attr('string'),
    isbn: _emberData['default'].attr('string'),
    precio: _emberData['default'].attr('string')
  });
});