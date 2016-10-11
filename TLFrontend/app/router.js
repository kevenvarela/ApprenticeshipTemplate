import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('home', { path: '/' }, function() {
    this.route('catalogo');
    this.route('login');
    this.route('news');
  });
  this.route('cobrar');
});

export default Router;
