QUnit.module('JSHint | controllers/home/login.js');
QUnit.test('should pass jshint', function(assert) {
  assert.expect(1);
  assert.ok(false, 'controllers/home/login.js should pass jshint.\ncontrollers/home/login.js: line 8, col 9, Unexpected \')\'.\ncontrollers/home/login.js: line 8, col 9, Expected an identifier and instead saw \')\'.\ncontrollers/home/login.js: line 9, col 5, Expected \')\' and instead saw \'}\'.\ncontrollers/home/login.js: line 9, col 6, Missing semicolon.\ncontrollers/home/login.js: line 11, col 2, Expected \'}\' to match \'{\' from line 3 and instead saw \')\'.\ncontrollers/home/login.js: line 11, col 3, Expected \')\' and instead saw \';\'.\ncontrollers/home/login.js: line 11, col 4, Missing semicolon.\n\n7 errors');
});
