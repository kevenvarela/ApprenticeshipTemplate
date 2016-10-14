define('tlfrontend/controllers/home/login', ['exports', 'ember'], function (exports, _ember) {
  exports['default'] = _ember['default'].Controller.extend({
    actions: {
      loguearCliente: function loguearCliente() {
        var _this = this;

        this.get('model').save().then(function () {
          _this.transitionToRoute('home.carrito');
        });
      }
    }
  });
});