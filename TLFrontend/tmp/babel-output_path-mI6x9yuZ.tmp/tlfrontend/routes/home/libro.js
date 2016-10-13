define('tlfrontend/routes/home/libro', ['exports', 'ember'], function (exports, _ember) {
  exports['default'] = _ember['default'].Route.extend({
    model: function model() {
      var libros = this.get('store').findAll('libro'); // => GET /libro
      return libros;
    }
  });

  // return this.get('store').findAll('libro')
  //
  // return $.getJSON('/libros')   // JQUERY
});