var app = angular.module ('mobileStore', []);

app.controller('StoreController',['$http', function ($http) {
    var store = this;
    store.products =[];

  //  $http.get('store-products.json').success (function (data) {
    $http.get('http://localhost:7777/intbuffetproject/rs/json/products').success (function (data) {

        store.products = data;
        console.log(data);
    })

}])

//sozdaem derectivu

app.directive ("productGallery", function () {
    return {
        restrict: "E",
        templateUrl: "product-gallery.html",
        controller: function () {
            this.current = 0;
            this.setCurrent = function (imageNumber) {
                this.current = imageNumber || 0;
            };
        },

        controllerAs: "gallery"
    };
});