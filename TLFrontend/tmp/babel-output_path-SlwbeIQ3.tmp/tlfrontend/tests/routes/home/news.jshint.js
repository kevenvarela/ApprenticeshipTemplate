define('tlfrontend/tests/routes/home/news.jshint', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | routes/home/news.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'routes/home/news.js should pass jshint.');
  });
});