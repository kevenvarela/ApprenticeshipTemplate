export default Ember.HTMLBars.template((function() {
  var child0 = (function() {
    return {
      meta: {
        "revision": "Ember@2.8.2",
        "loc": {
          "source": null,
          "start": {
            "line": 12,
            "column": 6
          },
          "end": {
            "line": 12,
            "column": 46
          }
        },
        "moduleName": "tlfrontend/templates/home/login.hbs"
      },
      isEmpty: false,
      arity: 0,
      cachedFragment: null,
      hasRendered: false,
      buildFragment: function buildFragment(dom) {
        var el0 = dom.createDocumentFragment();
        var el1 = dom.createTextNode("Registrarse");
        dom.appendChild(el0, el1);
        return el0;
      },
      buildRenderNodes: function buildRenderNodes() { return []; },
      statements: [

      ],
      locals: [],
      templates: []
    };
  }());
  return {
    meta: {
      "revision": "Ember@2.8.2",
      "loc": {
        "source": null,
        "start": {
          "line": 1,
          "column": 0
        },
        "end": {
          "line": 21,
          "column": 0
        }
      },
      "moduleName": "tlfrontend/templates/home/login.hbs"
    },
    isEmpty: false,
    arity: 0,
    cachedFragment: null,
    hasRendered: false,
    buildFragment: function buildFragment(dom) {
      var el0 = dom.createDocumentFragment();
      var el1 = dom.createElement("div");
      dom.setAttribute(el1,"class","container");
      var el2 = dom.createTextNode("\n  ");
      dom.appendChild(el1, el2);
      var el2 = dom.createElement("form");
      var el3 = dom.createTextNode("\n    ");
      dom.appendChild(el2, el3);
      var el3 = dom.createElement("div");
      dom.setAttribute(el3,"class","form-signin col-md-5 col-md-offset-3 ");
      var el4 = dom.createTextNode("\n        ");
      dom.appendChild(el3, el4);
      var el4 = dom.createElement("h2");
      dom.setAttribute(el4,"class","form-signin-heading");
      var el5 = dom.createTextNode("Identificarse");
      dom.appendChild(el4, el5);
      dom.appendChild(el3, el4);
      var el4 = dom.createTextNode("\n        ");
      dom.appendChild(el3, el4);
      var el4 = dom.createElement("label");
      var el5 = dom.createTextNode("Usuario");
      dom.appendChild(el4, el5);
      dom.appendChild(el3, el4);
      var el4 = dom.createTextNode("\n        ");
      dom.appendChild(el3, el4);
      var el4 = dom.createComment("");
      dom.appendChild(el3, el4);
      var el4 = dom.createTextNode("\n        ");
      dom.appendChild(el3, el4);
      var el4 = dom.createElement("label");
      var el5 = dom.createTextNode("Password");
      dom.appendChild(el4, el5);
      dom.appendChild(el3, el4);
      var el4 = dom.createTextNode("\n        ");
      dom.appendChild(el3, el4);
      var el4 = dom.createComment("");
      dom.appendChild(el3, el4);
      var el4 = dom.createTextNode("\n      ");
      dom.appendChild(el3, el4);
      var el4 = dom.createElement("hr");
      dom.appendChild(el3, el4);
      var el4 = dom.createTextNode("\n        ");
      dom.appendChild(el3, el4);
      var el4 = dom.createElement("button");
      dom.setAttribute(el4,"class","btn btn-lg btn-primary btn-block");
      dom.setAttribute(el4,"type","submit");
      var el5 = dom.createTextNode("Ingresar");
      dom.appendChild(el4, el5);
      dom.appendChild(el3, el4);
      var el4 = dom.createTextNode("\n       ");
      dom.appendChild(el3, el4);
      var el4 = dom.createElement("h1");
      dom.appendChild(el3, el4);
      var el4 = dom.createTextNode("\n      ");
      dom.appendChild(el3, el4);
      var el4 = dom.createComment("");
      dom.appendChild(el3, el4);
      var el4 = dom.createTextNode("\n    ");
      dom.appendChild(el3, el4);
      dom.appendChild(el2, el3);
      var el3 = dom.createTextNode("\n  ");
      dom.appendChild(el2, el3);
      dom.appendChild(el1, el2);
      var el2 = dom.createTextNode("\n");
      dom.appendChild(el1, el2);
      dom.appendChild(el0, el1);
      var el1 = dom.createTextNode(" ");
      dom.appendChild(el0, el1);
      var el1 = dom.createComment(" /container ");
      dom.appendChild(el0, el1);
      var el1 = dom.createTextNode("\n\n\n\n\n\n");
      dom.appendChild(el0, el1);
      return el0;
    },
    buildRenderNodes: function buildRenderNodes(dom, fragment, contextualElement) {
      var element0 = dom.childAt(fragment, [0, 1, 1]);
      var element1 = dom.childAt(element0, [13]);
      var morphs = new Array(4);
      morphs[0] = dom.createMorphAt(element0,5,5);
      morphs[1] = dom.createMorphAt(element0,9,9);
      morphs[2] = dom.createElementMorph(element1);
      morphs[3] = dom.createMorphAt(element0,17,17);
      return morphs;
    },
    statements: [
      ["inline","input",[],["type","text","class","form-control","id","id","value",["subexpr","@mut",[["get","model.usuario",["loc",[null,[6,63],[6,76]]],0,0,0,0]],[],[],0,0],"placeholder","Usuario"],["loc",[null,[6,8],[6,100]]],0,0],
      ["inline","input",[],["type","password","class","form-control","minlength","6","id","password","value",["subexpr","@mut",[["get","model.password",["loc",[null,[8,87],[8,101]]],0,0,0,0]],[],[],0,0],"placeholder","Password"],["loc",[null,[8,8],[8,126]]],0,0],
      ["element","action",["loguearCliente"],[],["loc",[null,[10,16],[10,43]]],0,0],
      ["block","link-to",["home.registrar"],[],0,null,["loc",[null,[12,6],[12,58]]]]
    ],
    locals: [],
    templates: [child0]
  };
}()));