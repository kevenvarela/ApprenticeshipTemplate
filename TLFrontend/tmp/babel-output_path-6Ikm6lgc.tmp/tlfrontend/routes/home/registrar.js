define('tlfrontend/routes/home/registrar', ['exports', 'ember'], function (exports, _ember) {
  exports['default'] = _ember['default'].Route.extend({
    model: function model() {
      return this.get('store').createRecord('nuevo-cliente');
    }
  });
});