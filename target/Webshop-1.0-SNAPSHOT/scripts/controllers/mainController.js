app.controller('mainController', ['$scope', '$http', function ($scope, $http) {
        // GET DATA FROM JSON //
        $http.get('rest/producten').then(function (res) {
            console.log("Data fetch done.");
            $scope.productData = res.data;
        });

        // ADD ITEM TO CART AND CHECK IF THE PRODUCT ALREADY EXISTS //
        $scope.cart = [];

        $scope.addProduct = function (productArg) {
            var hasMatch = false;
            for (i = 0; i < $scope.cart.length; i++) {
                var product = $scope.cart[i];
                console.log("bliep");
                if (product.id === productArg.id) {
                    console.log("de amount voor " + product.name + " is verhoogd naar " + product.amount);
                    product.amount++;
                    hasMatch = true;
                    break;
                }
            }
            if (!hasMatch) {
                $scope.cart.push(productArg);
                console.log(productArg.name + " toevoegd aan cart");
            }
        };

        $scope.removeProduct = function (productArg) { // myValue is json format
            for (i = 0; i < $scope.cart.length; i++) {
                var product = $scope.cart[i];
                if (product.id === productArg.id) {
                    product.amount--;
                    if (product.amount === 0) {
                        $scope.cart.splice(i, 1);
                    }
                    break;
                }

            }
        };
        $scope.deleteProduct = function (productArg) {
            for (i = 0; i < $scope.cart.length; i++) {
                var product = $scope.cart[i];
                if (product.id === productArg.id) {
                    $scope.cart.splice(i, 1);
                    break;
                }
            }
        }

        $scope.totalPrice = function (index) {
            var total = 0;
            angular.forEach($scope.cart, function (product, index) {
                total += product.price * product.amount;
            });
            return total;
            console.log(total);
        };

        // NG-HIDE / NG-SHOW //
        $scope.myNumber = 0;
        $scope.isZero = function (value) {
            if (value === 0)
                return true;
            else
                return false;
        };

        $scope.customerAll = {firstName: "", lastName: "", adress: "", postalcode: "", city: "", email: ""};
        $scope.customerAllLog = function () {
            console.log($scope.customerAll);
            JSON.stringify($scope.customerAll);
            console.log($scope.customerAll);
        };

        $scope.sendOrder = function (cartArg, customerArg) {
            newOrder = {};
            newOrder.firstName = $scope.customerAll.firstName;
            newOrder.lastName = $scope.customerAll.lastName;
            newOrder.adress = $scope.customerAll.adress;
            newOrder.postalcode = $scope.customerAll.postalcode;
            newOrder.city = $scope.customerAll.city;
            newOrder.email = $scope.customerAll.email;
            newOrder.prodAmount = "";

            for (i = 0; i < $scope.cart.length; i++) {
                var product = $scope.cart[i];
                newOrder.prodAmount += product.id + "~" + product.amount + "*";
            }

            console.log("De volgende bestelling is geplaatst: " + newOrder);

            $http.post('rest/orders', JSON.stringify(newOrder)).success(function (data) {
                $scope.PostDataResponse = data;
            }).error(function (data, status, header, config) {
                $scope.ResponseDetails =    "Data: " + data +
                                            "<hr />status: " + status +
                                            "<hr />headers: " + header +
                                            "<hr />config: " + config;
            });
            var bestellingGeplaatst = window.location = "http://localhost:8080/weshop10/#/producten2/";
            var bestellingGeplaats = location.reload("http://localhost:8080/weshop10/#/producten2/");
        };
            $scope.filters = {};
            
    }]);





//PROMPT FUNCTIE//
//   var bestellingGeplaatst = confirm("Bedankt voor uw bestelling!");
//            if (bestellingGeplaatst === true){
//                location.reload("http://localhost:8080/weshop10/#/");
//                 window.location = "http://localhost:8080/weshop10/#/";
//            }