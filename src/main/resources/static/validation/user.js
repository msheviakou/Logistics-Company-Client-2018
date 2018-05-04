$('#addUserForm').validate({
    rules:{
        "confirmPassword": {
            equalTo: "#password"
        },
    },

    messages:{
        "confirmPassword": {
            equalTo: "Пароли не совпадают."
        }
    },

    success: function(){
        $('#addUserButton').prop('disabled', false);
    },

    errorPlacement: function () {
        $('#addUserButton').prop('disabled', true);
    }
});