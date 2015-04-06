require.config({
    urlArgs: "",
    baseUrl: "http://static.bosonnlp.com/javascripts",
    paths: {
        jquery: "/News/scripts/jquery.min",
        "jquery-ui": "/News/scripts/jquery-ui.min",
        bowser: "/News/scripts/bowser.min",
        json2: "/News/scripts/json2.min",
        backbone: "/News/scripts/backbone.min",
        underscore: "/News/scripts/underscore.min",
        nunjucks: "/News/scripts/nunjucks.min",
        highcharts: "/News/scripts/highcharts.min",
        "bootstrap.affix": "/News/scripts/affix.min",
        "bootstrap.scrollspy": "/News/scripts/scrollspy.min",
        d3: "/News/scripts/d3.min",
        d3cloud: "/News/scripts/d3.layout.cloud.min",
        async: "/News/scripts/async.min",
        "jquery.validate": "/News/scripts/jquery.validate.min",
        "jquery.form": "/News/scripts/jquery.form.min",
        zeroClipboard: "/News/scripts/ZeroClipboard.min"
      
    },
    shim: {
        jquery: {
            exports: "jQuery"
        },
        "jquery-ui": {
            exports: "jQuery",
            deps: ["jquery"]
        },
        "jquery.validate": {
            deps: ["jquery"]
        },
        "jquery.form": {
            deps: ["jquery"]
        },
        backbone: {
            deps: ["underscore", "jquery"],
            exports: "Backbone"
        },
        underscore: {
            exports: "_"
        },
        highcharts: {
            deps: ["jquery"]
        },
        "bootstrap.affix": {
            deps: ["jquery"]
        },
        "bootstrap.scrollspy": {
            deps: ["jquery"]
        },
        zeroClipboard: {
            exports: "zeroClipboard"
        }
    }
});