define('tlfrontend/tests/test-helper', ['exports', 'tlfrontend/tests/helpers/resolver', 'ember-qunit'], function (exports, _tlfrontendTestsHelpersResolver, _emberQunit) {

  (0, _emberQunit.setResolver)(_tlfrontendTestsHelpersResolver['default']);
});