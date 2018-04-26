$('#addOrderForm input').on('keyup blur', function () {
    if ($('#addOrderForm').valid()) {
        $('#add_order_submit_btn').prop('disabled', false);
    } else {
        $('#add_order_submit_btn').prop('disabled', 'disabled');
    }
});

$('#addOrderForm').validate({
    rules:{
        "carrier.carrierTelephone": {
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
        }
    },

    messages:{
        "carrier.carrierTelephone": {
            digits: "Контактный телефон должен содержать только цифры",
            minlength: "Контактный телефон должен содержать хотя бы 7 символов",
            maxlength: "Контактный телефон не должен превышать 7 символов"
        },
        "cargo.cargoWeight": {
            digits: "Вес груза должен содержать только цифры"
        },
        "loading.loadingPostalCode": {
            digits: "Почтовый индекс должен содержать только цифры",
            minlength: "Почтовый индекс должен содержать хотя бы 6 символов",
            maxlength: "Почтовый индекс не должен превышать 6 символов"
        },
        "unloading.stock.stockPostalCode": {
            digits: "Почтовый индекс должен содержать только цифры",
            minlength: "Почтовый индекс должен содержать хотя бы 6 символов",
            maxlength: "Почтовый индекс не должен превышать 6 символов"
        }
    },

    errorPlacement: function(error, element) {
        $(element).filter(':not(.valid)').addClass("invalid");
        error.appendTo($('.error_output'))
    },
    success: function(error) {
        $("#addOrderForm").find('.valid').removeClass("invalid").addClass("success");
    }
});