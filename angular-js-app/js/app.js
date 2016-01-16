var app = angular.module('blog', []);

app.controller('HomeController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/masina';

    $scope.masini = [];
    $scope.fields = [];
    $scope.masina = {};


    $scope.car = {};
    $scope.editCar = {};



    $http.get(url).then(function successCallback(response) {

        $scope.masini = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.masini);
        //console.log($scope.fields);

    });


    $scope.addMasina = function(masina) {
        masina.id = parseInt(masina.id);
        console.log(masina.id);
        $http({
            method: 'POST',
            url: url,
            data: masina
        }).then(function successCallback(response) {
            console.log(response);
            $scope.masini.push(masina);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteMasina = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.masini = $scope.masini.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateCar = function(car) {
        $scope.editCar = car;
    };


    $scope.updateCar = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editCar
        }).then(function successCallback(response) {
            $scope.editCar = {};
            console.log(response);
            // $scope.masini.push($scope.editcar);
            // done.
        }, function errorCallback(response) {
            $scope.editCar = {};
            console.log(response);
        });
    };

}]);

app.controller('HomController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/medicament';

    $scope.medicamente = [];
    $scope.fields = [];
    $scope.medicament = {};


    $scope.medic = {};
    $scope.editMedic = {};



    $http.get(url).then(function successCallback(response) {

        $scope.medicamente = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.medicamente);
        //console.log($scope.fields);

    });


    $scope.addMedicament = function(medicament) {
        medicament.id = parseInt(medicament.id);
        console.log(medicament.id);
        $http({
            method: 'POST',
            url: url,
            data: medicament
        }).then(function successCallback(response) {
            console.log(response);
            $scope.medicamente.push(medicament);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteMedicament = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.medicamente = $scope.medicamente.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateMedic = function(medic) {
        $scope.editMedic = medic;
    };


    $scope.updateMedic = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editMedic
        }).then(function successCallback(response) {
            $scope.editMedic = {};
            console.log(response);
            // $scope.masini.push($scope.editcar);
            // done.
        }, function errorCallback(response) {
            $scope.editMedic = {};
            console.log(response);
        });
    };

}]);

app.controller('HoController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/copil';

    $scope.copii = [];
    $scope.fields = [];
    $scope.copil = {};


    $scope.kid = {};
    $scope.editKid = {};



    $http.get(url).then(function successCallback(response) {

        $scope.copii = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.copii);
        //console.log($scope.fields);

    });


    $scope.addCopil = function(copil) {
        copil.id = parseInt(copil.id);
        console.log(copil.id);
        $http({
            method: 'POST',
            url: url,
            data: copil
        }).then(function successCallback(response) {
            console.log(response);
            $scope.copii.push(copil);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteCopil = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.copii = $scope.copii.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateKid = function(kid) {
        $scope.editKid = kid;
    };


    $scope.updateKid = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editKid
        }).then(function successCallback(response) {
            $scope.editKid = {};
            console.log(response);
            // $scope.copii.push($scope.editcar);
            // done.
        }, function errorCallback(response) {
            $scope.editKid = {};
            console.log(response);
        });
    };

}]);

