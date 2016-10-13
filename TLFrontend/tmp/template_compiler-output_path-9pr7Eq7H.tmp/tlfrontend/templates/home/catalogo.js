export default Ember.HTMLBars.template((function() {
  var child0 = (function() {
    return {
      meta: {
        "revision": "Ember@2.8.2",
        "loc": {
          "source": null,
          "start": {
            "line": 19,
            "column": 14
          },
          "end": {
            "line": 30,
            "column": 14
          }
        },
        "moduleName": "tlfrontend/templates/home/catalogo.hbs"
      },
      isEmpty: false,
      arity: 1,
      cachedFragment: null,
      hasRendered: false,
      buildFragment: function buildFragment(dom) {
        var el0 = dom.createDocumentFragment();
        var el1 = dom.createTextNode("            ");
        dom.appendChild(el0, el1);
        var el1 = dom.createElement("tr");
        var el2 = dom.createTextNode("\n                ");
        dom.appendChild(el1, el2);
        var el2 = dom.createElement("td");
        var el3 = dom.createComment("");
        dom.appendChild(el2, el3);
        dom.appendChild(el1, el2);
        var el2 = dom.createTextNode("\n                ");
        dom.appendChild(el1, el2);
        var el2 = dom.createElement("td");
        var el3 = dom.createComment("");
        dom.appendChild(el2, el3);
        dom.appendChild(el1, el2);
        var el2 = dom.createTextNode("\n                ");
        dom.appendChild(el1, el2);
        var el2 = dom.createElement("td");
        var el3 = dom.createComment("");
        dom.appendChild(el2, el3);
        dom.appendChild(el1, el2);
        var el2 = dom.createTextNode("\n                ");
        dom.appendChild(el1, el2);
        var el2 = dom.createElement("td");
        var el3 = dom.createElement("button");
        dom.setAttribute(el3,"type","submit");
        dom.setAttribute(el3,"class","btn btn-success");
        var el4 = dom.createTextNode("+1");
        dom.appendChild(el3, el4);
        dom.appendChild(el2, el3);
        var el3 = dom.createTextNode("\n                    ");
        dom.appendChild(el2, el3);
        var el3 = dom.createElement("button");
        dom.setAttribute(el3,"type","submit");
        dom.setAttribute(el3,"class","btn btn-danger");
        var el4 = dom.createTextNode("-1");
        dom.appendChild(el3, el4);
        dom.appendChild(el2, el3);
        var el3 = dom.createTextNode("\n                ");
        dom.appendChild(el2, el3);
        dom.appendChild(el1, el2);
        var el2 = dom.createTextNode("\n                ");
        dom.appendChild(el1, el2);
        var el2 = dom.createElement("td");
        var el3 = dom.createElement("h4");
        var el4 = dom.createElement("span");
        dom.setAttribute(el4,"class","label label-info");
        var el5 = dom.createTextNode("0");
        dom.appendChild(el4, el5);
        dom.appendChild(el3, el4);
        dom.appendChild(el2, el3);
        dom.appendChild(el1, el2);
        var el2 = dom.createTextNode("\n                ");
        dom.appendChild(el1, el2);
        var el2 = dom.createElement("td");
        var el3 = dom.createElement("h4");
        var el4 = dom.createElement("form");
        dom.setAttribute(el4,"class","label label-info");
        var el5 = dom.createComment("");
        dom.appendChild(el4, el5);
        dom.appendChild(el3, el4);
        dom.appendChild(el2, el3);
        dom.appendChild(el1, el2);
        var el2 = dom.createTextNode("\n            ");
        dom.appendChild(el1, el2);
        dom.appendChild(el0, el1);
        var el1 = dom.createTextNode("\n");
        dom.appendChild(el0, el1);
        return el0;
      },
      buildRenderNodes: function buildRenderNodes(dom, fragment, contextualElement) {
        var element0 = dom.childAt(fragment, [1]);
        var element1 = dom.childAt(element0, [7]);
        var element2 = dom.childAt(element1, [0]);
        var element3 = dom.childAt(element1, [2]);
        var element4 = dom.childAt(element0, [11, 0, 0]);
        var morphs = new Array(7);
        morphs[0] = dom.createMorphAt(dom.childAt(element0, [1]),0,0);
        morphs[1] = dom.createMorphAt(dom.childAt(element0, [3]),0,0);
        morphs[2] = dom.createMorphAt(dom.childAt(element0, [5]),0,0);
        morphs[3] = dom.createElementMorph(element2);
        morphs[4] = dom.createElementMorph(element3);
        morphs[5] = dom.createAttrMorph(element4, 'id');
        morphs[6] = dom.createMorphAt(element4,0,0);
        return morphs;
      },
      statements: [
        ["content","libro.titulo",["loc",[null,[21,20],[21,36]]],0,0,0,0],
        ["content","libro.isbn",["loc",[null,[22,20],[22,34]]],0,0,0,0],
        ["content","libro.precio",["loc",[null,[23,20],[23,36]]],0,0,0,0],
        ["element","action",["sumarUnItem"],[],["loc",[null,[24,28],[24,52]]],0,0],
        ["element","action",["restarUnItem"],[],["loc",[null,[25,28],[25,53]]],0,0],
        ["attribute","id",["concat",[["get","catalogo.cantidad",["loc",[null,[28,36],[28,53]]],0,0,0,0]],0,0,0,0,0],0,0,0,0],
        ["content","catalogo.cantidad",["loc",[null,[28,82],[28,103]]],0,0,0,0]
      ],
      locals: ["libro"],
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
          "line": 39,
          "column": 0
        }
      },
      "moduleName": "tlfrontend/templates/home/catalogo.hbs"
    },
    isEmpty: false,
    arity: 0,
    cachedFragment: null,
    hasRendered: false,
    buildFragment: function buildFragment(dom) {
      var el0 = dom.createDocumentFragment();
      var el1 = dom.createElement("hr");
      dom.appendChild(el0, el1);
      var el1 = dom.createTextNode("\n");
      dom.appendChild(el0, el1);
      var el1 = dom.createElement("div");
      dom.setAttribute(el1,"class","panel panel-default");
      var el2 = dom.createTextNode("\n    ");
      dom.appendChild(el1, el2);
      var el2 = dom.createComment(" Default panel contents ");
      dom.appendChild(el1, el2);
      var el2 = dom.createTextNode("\n    ");
      dom.appendChild(el1, el2);
      var el2 = dom.createElement("div");
      dom.setAttribute(el2,"class","panel-heading");
      var el3 = dom.createTextNode("Catalogo");
      dom.appendChild(el2, el3);
      dom.appendChild(el1, el2);
      var el2 = dom.createTextNode("\n\n    ");
      dom.appendChild(el1, el2);
      var el2 = dom.createComment(" Table ");
      dom.appendChild(el1, el2);
      var el2 = dom.createTextNode("\n    ");
      dom.appendChild(el1, el2);
      var el2 = dom.createElement("table");
      dom.setAttribute(el2,"class","table");
      var el3 = dom.createTextNode("\n        ");
      dom.appendChild(el2, el3);
      var el3 = dom.createElement("thead");
      var el4 = dom.createTextNode("\n            ");
      dom.appendChild(el3, el4);
      var el4 = dom.createElement("tr");
      var el5 = dom.createTextNode("\n                ");
      dom.appendChild(el4, el5);
      var el5 = dom.createElement("th");
      var el6 = dom.createTextNode("Titulo");
      dom.appendChild(el5, el6);
      dom.appendChild(el4, el5);
      var el5 = dom.createTextNode("\n                ");
      dom.appendChild(el4, el5);
      var el5 = dom.createElement("th");
      var el6 = dom.createTextNode("Isbn");
      dom.appendChild(el5, el6);
      dom.appendChild(el4, el5);
      var el5 = dom.createTextNode("\n                ");
      dom.appendChild(el4, el5);
      var el5 = dom.createElement("th");
      var el6 = dom.createTextNode("Precio");
      dom.appendChild(el5, el6);
      dom.appendChild(el4, el5);
      var el5 = dom.createTextNode("\n                ");
      dom.appendChild(el4, el5);
      var el5 = dom.createElement("th");
      var el6 = dom.createTextNode("Agregar/Quitar");
      dom.appendChild(el5, el6);
      dom.appendChild(el4, el5);
      var el5 = dom.createTextNode("\n                ");
      dom.appendChild(el4, el5);
      var el5 = dom.createElement("th");
      var el6 = dom.createTextNode("Cantidad");
      dom.appendChild(el5, el6);
      dom.appendChild(el4, el5);
      var el5 = dom.createTextNode("\n                ");
      dom.appendChild(el4, el5);
      var el5 = dom.createElement("th");
      var el6 = dom.createTextNode("Disponibilidad");
      dom.appendChild(el5, el6);
      dom.appendChild(el4, el5);
      var el5 = dom.createTextNode("\n            ");
      dom.appendChild(el4, el5);
      dom.appendChild(el3, el4);
      var el4 = dom.createTextNode("\n        ");
      dom.appendChild(el3, el4);
      dom.appendChild(el2, el3);
      var el3 = dom.createTextNode("\n        ");
      dom.appendChild(el2, el3);
      var el3 = dom.createElement("tbody");
      var el4 = dom.createTextNode("\n");
      dom.appendChild(el3, el4);
      var el4 = dom.createComment("");
      dom.appendChild(el3, el4);
      var el4 = dom.createTextNode("        ");
      dom.appendChild(el3, el4);
      dom.appendChild(el2, el3);
      var el3 = dom.createTextNode("\n    ");
      dom.appendChild(el2, el3);
      dom.appendChild(el1, el2);
      var el2 = dom.createTextNode("\n");
      dom.appendChild(el1, el2);
      dom.appendChild(el0, el1);
      var el1 = dom.createTextNode("\n\n\n");
      dom.appendChild(el0, el1);
      var el1 = dom.createElement("input");
      dom.setAttribute(el1,"type","month");
      dom.setAttribute(el1,"id","inputUsuario");
      dom.setAttribute(el1,"class","form-control");
      dom.setAttribute(el1,"placeholder","Usuario");
      dom.setAttribute(el1,"required","");
      dom.setAttribute(el1,"autofocus","");
      dom.appendChild(el0, el1);
      var el1 = dom.createTextNode("\n\n\n");
      dom.appendChild(el0, el1);
      return el0;
    },
    buildRenderNodes: function buildRenderNodes(dom, fragment, contextualElement) {
      var morphs = new Array(1);
      morphs[0] = dom.createMorphAt(dom.childAt(fragment, [2, 7, 3]),1,1);
      return morphs;
    },
    statements: [
      ["block","each",[["get","model",["loc",[null,[19,22],[19,27]]],0,0,0,0]],[],0,null,["loc",[null,[19,14],[30,23]]]]
    ],
    locals: [],
    templates: [child0]
  };
}()));