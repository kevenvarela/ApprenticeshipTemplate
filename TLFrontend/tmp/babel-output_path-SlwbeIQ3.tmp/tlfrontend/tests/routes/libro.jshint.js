define('tlfrontend/tests/routes/libro.jshint', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | routes/libro.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(true, 'routes/libro.js should pass jshint.');
  });
});