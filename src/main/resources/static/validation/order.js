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
            required: true
        },
        "unloading.unloadingDate": {
            required: true
        }
    },

    messages:{
        "carrier.carrierTelephone": {
            digits: "Контактный телефон должен содержать только цифры.",
            minlength: "Контактный телефон должен содержать хотя бы 7 символов.",
            maxlength: "Контактный телефон не должен превышать 7 символов."
        },
        "carrier.driver.phoneNumber": {
            digits: "Телефон водителя должен содержать только цифры.",
            minlength: "Телефон водителя должен содержать хотя бы 7 символов.",
            maxlength: "Телефон водителя не должен превышать 7 символов."
        },
        "carrier.carrierElMail": {
            email: "Введите правильный email адрес."
        },
        "cargo.cargoWeight": {
            digits: "Вес груза должен содержать только цифры."
        },
        "cargo.cargoCount": {
            digits: "Количество груза должно содержать только цифры."
        },
        "loading.loadingPostalCode": {
            digits: "ПИ содержит только цифры.",
            minlength: "Введите 6 символов ПИ.",
            maxlength: "Введите 6 символов ПИ."
        },
        "loading.loadingDate": {
            required: "Необходимо задать дату загрузки."
        },
        "unloading.unloadingDate": {
            required: "Необходимо задать дату разгрузки."
        },
        "unloading.stock.stockPostalCode": {
            digits: "ПИ содержит только цифры.",
            minlength: "Введите 6 символов ПИ.",
            maxlength: "Введите 6 символов ПИ."
        },
        "freightCost": {
            digits: "Сумма оплаты должна содержать только цифры."
        }
    },

    success: function(){
        $('#add_order_submit_btn').prop('disabled', false);
    },

    errorPlacement: function (error, element) {
        if (element.attr("name") == "carrier.carrierTelephone" || element.attr("name") == "carrier.driver.phoneNumber" || element.attr("name") == "carrier.carrierElMail") {
            $('.carrier_text').html("Перевозчик: " + "<span class='error_text'>" + error.text() + "</span>");
        } else if (element.attr("name") == "cargo.cargoWeight" || element.attr("name") == "cargo.cargoCount") {
            $('.cargo_text').html("Груз " + "<span class='error_text'>" + error.text() + "</span>");
        } else if (element.attr("name") == "loading.loadingPostalCode" || element.attr("name") == "loading.loadingDate") {
            $('.loading_text').html("Адрес загрузки: " + "<span class='error_text'>" + error.text() + "</span>");
        } else if (element.attr("name") == "unloading.stock.stockPostalCode" || element.attr("name") == "unloading.unloadingDate") {
            $('.unloading_text').html("Адрес выгрузки: " + "<span class='error_text'>" + error.text() + "</span>");
        } else if (element.attr("name") == "freightCost") {
            $('.payment_text').html("Ставка/Фрахт: " + "<span class='error_text'>" + error.text() + "</span>");
        } else if (element.attr("name") == "unloading.stock.stockPostalCode") {
            $('.unloading_text').html("Адрес разгрузки: " + "<span class='error_text'>" + error.text() + "</span>");
        }

        $('#add_order_submit_btn').prop('disabled', true);
    }
});



$.validator.addMethod('goodEmail', function (value) {
    return /^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$/.test(value);
});
