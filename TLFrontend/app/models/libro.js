import DS from 'ember-data';

export default DS.Model.extend({
  nombre: DS.attr('string'),
  isbn:  DS.attr('string'),
  precio: DS.attr('integer')
});
