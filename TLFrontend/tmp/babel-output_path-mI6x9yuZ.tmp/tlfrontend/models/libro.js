define('tlfrontend/models/libro', ['exports', 'ember-data'], function (exports, _emberData) {
  exports['default'] = _emberData['default'].Model.extend({
    nombreLibro: _emberData['default'].attr('string'),
    isbn: _emberData['default'].attr('string'),
    precio: _emberData['default'].attr('number')
  });

  //      {"id":1,"nombreLibro":"kevin","isbn":"12345","precio":45}

  // TODO: VOLAR O CAMBIAR NOMBRE AL CATALOGO
});