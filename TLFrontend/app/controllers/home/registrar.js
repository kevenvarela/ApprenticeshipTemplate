import Ember from 'ember';

export default Ember.Controller.extend({
  actions: {
    registrarCliente(){
      this.get('model').save();
    }
  }
});
