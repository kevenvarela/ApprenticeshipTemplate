define('tlfrontend/controllers/nuevo-libro', ['exports', 'ember'], function (exports, _ember) {
  exports['default'] = _ember['default'].Controller.extend({
    actions: {
      crearLibro: function crearLibro() {
        var _this = this;

        this.get('model').save().then(function () {
          _this.transitionToRoute('home.libro');
        }, function (unError) {
          alert(unError);
        });
      }
    }
  });
});