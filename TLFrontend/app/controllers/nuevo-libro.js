import Ember from 'ember';

export default Ember.Controller.extend({
  actions:{
    crearLibro () {
      var nuevoLibro = this.get('store').createRecord('libro', this.get('model'));
      nuevoLibro.save().then(() => {
        this.transitionToRoute('home.libro');
      },(unError) => {alert(unError)});
    }

  }
});

