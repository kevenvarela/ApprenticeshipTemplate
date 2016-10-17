import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('home', { path: '/' }, function() {
    this.route('login');
    this.route('news');
    this.route('registrar');
    this.route('carrito');
    this.route('libro', function() {
      this.route('carrito');
    });
  });
  this.route('cobrar');
  this.route('nuevoLibro');
});

export default Router;


