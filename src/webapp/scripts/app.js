var app = angular.module('App', []);
app.config(["$routeProvider", "$locationProvider", function ($routeProvider, $locationProvider) {
        $routeProvider
                .when("/", {
                    templateUrl: "producten.html"
                })
                .when("/cart", {
                    templateUrl: "cart.html"
                })
                .when("/#/Klantgegevens/", {
                    templateUrl: "Klantgegevens.json"
                })
                ;
    }]);