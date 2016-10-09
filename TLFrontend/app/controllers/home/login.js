import Ember from 'ember';

export default Ember.Controller.extend({
  actions: {
    loguearCliente: function(){
      var usuario = this.get("usuario")
      var password = this.get("password")
      alert(usuario)
    }
  }

});
