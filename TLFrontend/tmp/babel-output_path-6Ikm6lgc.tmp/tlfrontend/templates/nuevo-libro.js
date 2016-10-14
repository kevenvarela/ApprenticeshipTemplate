define("tlfrontend/templates/nuevo-libro", ["exports"], function (exports) {
  exports["default"] = Ember.HTMLBars.template((function () {
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
            "line": 20,
            "column": 0
          }
        },
        "moduleName": "tlfrontend/templates/nuevo-libro.hbs"
      },
      isEmpty: false,
      arity: 0,
      cachedFragment: null,
      hasRendered: false,
      buildFragment: function buildFragment(dom) {
        var el0 = dom.createDocumentFragment();
        var el1 = dom.createElement("div");
        dom.setAttribute(el1, "class", "container");
        var el2 = dom.createTextNode("\n    ");
        dom.appendChild(el1, el2);
        var el2 = dom.createElement("form");
        var el3 = dom.createTextNode("\n        ");
        dom.appendChild(el2, el3);
        var el3 = dom.createElement("div");
        dom.setAttribute(el3, "class", "form-signin col-md-5 col-lg-offset-3");
        var el4 = dom.createTextNode("\n            ");
        dom.appendChild(el3, el4);
        var el4 = dom.createElement("h2");
        dom.setAttribute(el4, "class", "form-signin-heading");
        var el5 = dom.createTextNode("Cargar nuevo libro");
        dom.appendChild(el4, el5);
        dom.appendChild(el3, el4);
        var el4 = dom.createTextNode("\n            ");
        dom.appendChild(el3, el4);
        var el4 = dom.createElement("label");
        var el5 = dom.createTextNode("Titulo");
        dom.appendChild(el4, el5);
        dom.appendChild(el3, el4);
        var el4 = dom.createTextNode("\n          ");
        dom.appendChild(el3, el4);
        var el4 = dom.createComment("");
        dom.appendChild(el3, el4);
        var el4 = dom.createTextNode("\n            ");
        dom.appendChild(el3, el4);
        var el4 = dom.createElement("label");
        var el5 = dom.createTextNode("ISBN");
        dom.appendChild(el4, el5);
        dom.appendChild(el3, el4);
        var el4 = dom.createTextNode("\n          ");
        dom.appendChild(el3, el4);
        var el4 = dom.createComment("");
        dom.appendChild(el3, el4);
        var el4 = dom.createTextNode("\n            ");
        dom.appendChild(el3, el4);
        var el4 = dom.createElement("label");
        var el5 = dom.createTextNode("Precio");
        dom.appendChild(el4, el5);
        dom.appendChild(el3, el4);
        var el4 = dom.createTextNode("\n          ");
        dom.appendChild(el3, el4);
        var el4 = dom.createComment("");
        dom.appendChild(el3, el4);
        var el4 = dom.createTextNode("\n            ");
        dom.appendChild(el3, el4);
        var el4 = dom.createElement("hr");
        dom.appendChild(el3, el4);
        var el4 = dom.createTextNode("\n            ");
        dom.appendChild(el3, el4);
        var el4 = dom.createElement("button");
        dom.setAttribute(el4, "class", "btn btn-lg btn-primary btn-block");
        dom.setAttribute(el4, "type", "submit");
        var el5 = dom.createTextNode("Agregar");
        dom.appendChild(el4, el5);
        dom.appendChild(el3, el4);
        var el4 = dom.createTextNode("\n            ");
        dom.appendChild(el3, el4);
        var el4 = dom.createElement("hr");
        dom.appendChild(el3, el4);
        var el4 = dom.createTextNode("\n            ");
        dom.appendChild(el3, el4);
        var el4 = dom.createElement("button");
        dom.setAttribute(el4, "class", "btn btn-lg btn-primary btn-danger col-md-12");
        dom.setAttribute(el4, "type", "reset");
        var el5 = dom.createTextNode("Reset");
        dom.appendChild(el4, el5);
        dom.appendChild(el3, el4);
        var el4 = dom.createTextNode("\n        ");
        dom.appendChild(el3, el4);
        dom.appendChild(el2, el3);
        var el3 = dom.createTextNode("\n    ");
        dom.appendChild(el2, el3);
        dom.appendChild(el1, el2);
        var el2 = dom.createTextNode("\n");
        dom.appendChild(el1, el2);
        dom.appendChild(el0, el1);
        var el1 = dom.createTextNode(" ");
        dom.appendChild(el0, el1);
        var el1 = dom.createComment(" /container ");
        dom.appendChild(el0, el1);
        var el1 = dom.createTextNode("\n\n\n");
        dom.appendChild(el0, el1);
        return el0;
      },
      buildRenderNodes: function buildRenderNodes(dom, fragment, contextualElement) {
        var element0 = dom.childAt(fragment, [0, 1, 1]);
        var element1 = dom.childAt(element0, [17]);
        var morphs = new Array(4);
        morphs[0] = dom.createMorphAt(element0, 5, 5);
        morphs[1] = dom.createMorphAt(element0, 9, 9);
        morphs[2] = dom.createMorphAt(element0, 13, 13);
        morphs[3] = dom.createElementMorph(element1);
        return morphs;
      },
      statements: [["inline", "input", [], ["type", "text", "class", "form-control", "id", "nomberLibro", "value", ["subexpr", "@mut", [["get", "model.nombreLibro", ["loc", [null, [6, 74], [6, 91]]], 0, 0, 0, 0]], [], [], 0, 0], "placeholder", "Titutlo"], ["loc", [null, [6, 10], [6, 115]]], 0, 0], ["inline", "input", [], ["type", "text", "class", "form-control", "id", "isbn", "minlength", "11", "value", ["subexpr", "@mut", [["get", "model.isbn", ["loc", [null, [8, 82], [8, 92]]], 0, 0, 0, 0]], [], [], 0, 0], "placeholder", "ISBN"], ["loc", [null, [8, 10], [8, 113]]], 0, 0], ["inline", "input", [], ["type", "number", "class", "form-control", "id", "precio", "value", ["subexpr", "@mut", [["get", "model.precio", ["loc", [null, [10, 71], [10, 83]]], 0, 0, 0, 0]], [], [], 0, 0], "placeholder", "Precio"], ["loc", [null, [10, 10], [10, 106]]], 0, 0], ["element", "action", ["crearLibro"], [], ["loc", [null, [12, 20], [12, 43]]], 0, 0]],
      locals: [],
      templates: []
    };
  })());
});