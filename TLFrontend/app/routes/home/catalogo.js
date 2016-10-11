import Ember from 'ember';

export default Ember.Route.extend({
  model: function () {
    return [{id: 1, titulo: "El principito", isbn:"12345", precio: "$50", cantidad: 46},
      {id: 2, titulo: "Nacidos de la bruma", isbn:"54321", precio: "$70", cantidad: 100}]
  }
});
