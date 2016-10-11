import DS from 'ember-data';

export default DS.Model.extend({
  titulo: DS.attr('string'),
  isbn: DS.attr('string'),
  precio: DS.attr('string'),
});




