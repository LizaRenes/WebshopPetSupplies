app.controller('mainController', ['$scope', '$http', function ($scope, $http) {
        // GET DATA FROM JSON //
        $http.get('rest/producten').then(function (res) {
            console.log("Data fetch done.");
            $scope.productData = res.data;
        });
        
        // ADD ITEM TO CART AND CHECK IF THE PRODUCT ALREADY EXISTS //
        $scope.cart = [];
        $scope.counter = [];
        
        $scope.addProduct = function (product) {
            console.log("Product id " + product + " aan cart toe voegen.");
            var hasMatch = false;
            for (var index = 0; index < $scope.cart.length; ++index) {
                var productCart = $scope.cart[index];
                if (productCart.id === product.id) {
                    $scope.counter[index] += 1;
                    hasMatch = true;
                    break;
                }
            }
            if (!hasMatch) {
                $scope.cart.push(product);
                $scope.counter.push(1);
            }
            console.log("Cart is momenteel: " + $scope.cart);
        };
        $scope.getCount = function (index) {
            return $scope.counter[index];
        };
        $scope.incrementCount = function (index) {
            $scope.counter[index] += 1;
            return $scope.counter[index];
        };
        $scope.decrementCount = function (index) {
            $scope.counter[index] -= 1;
            if($scope.counter[index] === 0) {
                $scope.deleteProduct(index);   
            }
            return $scope.counter[index];
        };

        // REMOVE ITEM FROM CART //
        $scope.deleteProduct = function (index) { // myValue is json format
            $scope.cart.splice(index, 1);
            $scope.counter.splice(index,1);
        };

        // TOTAL PRICE //
        $scope.totalPrice = function (index) {
            var total = 0;
            angular.forEach($scope.cart, function (product, index) {
                total += product.price * $scope.counter[index];
            });
            return total;
        };

        // NG-HIDE / NG-SHOW //
        $scope.myNumber = 0;
        $scope.isZero = function (value) {
            if (value === 0)
                return true;
            else
                return false;
        };
        
// ALLE KLANTGEGEVENS VERZAMELEN IN 1 OBJECT (JSON FORMAAT)
  $scope.customerAll = {firstName: "", lastName: "", adress: "", postalcode: "", city: "", email: ""};
  $scope.customerAllLog = function(){
      console.log($scope.customerAll);
      JSON.stringify($scope.customerAll);
      console.log($scope.customerAll);
  };
  
  // ALLE SHOPPINGCART ID'S VERZAMELEN INCLUSIEF COUNT IN 1 OBJECT
//  $scope.cartIdCount = {cartId: $scope.cart.product, cartCount: $scope.counter};


 
 //HTTP POST METHODE NAAR KLANTGEGEVENS.JSON
   $scope.sendOrder = function(customerArg){
       newOrder = {};
       console.log("Methode sendOrder gestart");
       newOrder = JSON.stringify(customerArg);
       console.log(newOrder);
       $http.post('rest/orders', newOrder).success(function (data) {
                $scope.PostDataResponse = data;
            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<hr />status: " + status +
                    "<hr />headers: " + header +
                    "<hr />config: " + config;
       });
//    $scope.sendOrder = function(customerArg, cartArg) {
//        newOrder = {};
//        console.log("Methode sendOrder gestart");
//        newOrder.customerAll = JSON.stringify(customerArg);
//        console.log(newOrder);
//        newOrder.cartIdCount = JSON.stringify(cartArg);
//        console.log(newOrder);
//        
//        var newOrderTotal = newOrder.customerAll.concat(newOrder.cartIdCount);
//        console.log(newOrderTotal);
//        
//        $http.post('rest/producten', newOrder).success(function (data) {
//                $scope.PostDataResponse = data;
//            })
//            .error(function (data, status, header, config) {
//                $scope.ResponseDetails = "Data: " + data +
//                    "<hr />status: " + status +
//                    "<hr />headers: " + header +
//                    "<hr />config: " + config;
//            });
    }; 

    }]);













