import Ember from 'ember';

export default Ember.Controller.extend({
  actions: {
    loguearCliente(){
      this.get('model').save().then(() => {
        this.transitionToRoute('home.carrito');
      },)
    }
  }
});


