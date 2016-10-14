define('tlfrontend/tests/controllers/nuevo-libro.jshint', ['exports'], function (exports) {
  'use strict';

  QUnit.module('JSHint | controllers/nuevo-libro.js');
  QUnit.test('should pass jshint', function (assert) {
    assert.expect(1);
    assert.ok(false, 'controllers/nuevo-libro.js should pass jshint.\ncontrollers/nuevo-libro.js: line 8, col 37, Missing semicolon.\ncontrollers/nuevo-libro.js: line 8, col 39, Missing semicolon.\n\n2 errors');
  });
});