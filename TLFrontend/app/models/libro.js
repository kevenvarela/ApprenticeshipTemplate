import DS from 'ember-data';

export default DS.Model.extend({
  nombreLibro: DS.attr('string'),
  isbn:  DS.attr('string'),
  precio: DS.attr('number')
});

//      {"id":1,"nombreLibro":"kevin","isbn":"12345","precio":45}

// TODO: VOLAR O CAMBIAR NOMBRE AL CATALOGO
