define('tlfrontend/controllers/home/registrar', ['exports', 'ember'], function (exports, _ember) {
  exports['default'] = _ember['default'].Controller.extend({
    actions: {
      registrarCliente: function registrarCliente() {
        this.get('model').save();
      }
    }
  });
});