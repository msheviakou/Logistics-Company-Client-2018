$('#addOrderForm input').on('keyup blur', function () {
    if ($('#addOrderForm').valid()) {
        console.log(1);
        $('#add_order_submit_btn').prop('disabled', false);
    } else {
        console.log(2);
        $('#add_order_submit_btn').prop('disabled', 'disabled');
    }
});

$.validator.setDefaults({
   highlight: function (element) {
       $(element)
           .closest('.label_text')
           .addClass('has-error');
   },
   unhighlight: function (element) {
       $(element)
           .closest('.label_text')
           .removeClass('has-error');
    }
});

$('#addOrderForm').validate({
    rules:{
        "carrier.carrierTelephone": {
            digits: true,
            minlength: 7,
            maxlength: 7
        },
        "carrier.carrierElMail": {
            email: {goodEmail: true}
        },
        "carrier.driver.phoneNumber": {
            digits: true,
            minlength: 7,
            maxlength: 7
        },
        "cargo.cargoWeight": {
            digits: true
        },
        "cargo.cargoCount": {
            digits: true
        },
        "loading.loadingPostalCode": {
            digits: true,
            minlength: 6,
            maxlength: 6
        },
        "unloading.stock.stockPostalCode": {
            digits: true,
            minlength: 6,
            maxlength: 6
        },
        "freightCost": {
            digits: true
        },
        "loading.loadingDate": {
            date : {goodDate: true}
        },
        "unloading.unloadingDate": {
            date : {goodDate: true}
        }
    },

    messages:{
        "carrier.carrierTelephone": {
            digits: "Контактный телефон должен содержать только цифры.",
            minlength: "Контактный телефон должен содержать хотя бы 7 символов.",
            maxlength: "Контактный телефон не должен превышать 7 символов."
        },
        "cargo.cargoWeight": {
            digits: "Вес груза должен содержать только цифры."
        },
        "cargo.cargoCount": {
            digits: "Количество груза должно содержать только цифры."
        },
        "carrier.driver.phoneNumber": {
            digits: "Телефон водителя должен содержать только цифры.",
            minlength: "Телефон водителя должен содержать хотя бы 7 символов.",
            maxlength: "Телефон водителя не должен превышать 7 символов."
        },
        "carrier.carrierElMail": {
            email: "Введите правильный email адрес."
        },
        "loading.loadingPostalCode": {
            digits: "Почтовый индекс должен содержать только цифры.",
            minlength: "Почтовый индекс должен содержать хотя бы 6 символов.",
            maxlength: "Почтовый индекс не должен превышать 6 символов."
        },
        "unloading.stock.stockPostalCode": {
            digits: "Почтовый индекс должен содержать только цифры.",
            minlength: "Почтовый индекс должен содержать хотя бы 6 символов.",
            maxlength: "Почтовый индекс не должен превышать 6 символов."
        },
        "freightCost": {
            digits: "Сумма оплаты должна содержать только цифры."
        },
        "loading.loadingDate": {
            required: "Необходимо задать дату загрузки."
        },
        "unloading.unloadingDate": {
            required: "Необходимо задать дату разгрузки."
        }
    }
});



$.validator.addMethod('goodEmail', function (value) {
    return /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/.test(value);
});

$.validator.addMethod("goodDate", function(value) {
        return value.match(/^[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])$/);
    },
);