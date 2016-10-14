import DS from 'ember-data';

export default DS.Model.extend({
  usuario:  DS.attr('string'),
  password:  DS.attr('string')
});
