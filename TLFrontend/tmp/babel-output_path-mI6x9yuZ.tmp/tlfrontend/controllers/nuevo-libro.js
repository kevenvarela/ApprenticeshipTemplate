define('tlfrontend/controllers/nuevo-libro', ['exports', 'ember'], function (exports, _ember) {
  exports['default'] = _ember['default'].Controller.extend({
    actions: {
      crearLibro: function crearLibro() {
        this.get('model').save();
      }
    }
  });
});