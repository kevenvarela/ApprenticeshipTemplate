import Ember from 'ember';

export default Ember.Route.extend({
  model: function(){
    var libros = this.get('store').findAll('libro'); // => GET /libro
    return libros;
  }
});



    // return this.get('store').findAll('libro')
    //
    // return $.getJSON('/libros')   // JQUERY
