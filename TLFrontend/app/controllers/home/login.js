import Ember from 'ember';

export default Ember.Controller.extend({
  actions: {
    loguearCliente: function(){
      this.get('model').save();
    }
  }
});


