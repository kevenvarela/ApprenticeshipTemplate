define('tlfrontend/controllers/home/login', ['exports', 'ember'], function (exports, _ember) {
  exports['default'] = _ember['default'].Controller.extend({
    actions: {
      loguearCliente: function loguearCliente() {
        this.get('model').save();
      }
    }
  });
});