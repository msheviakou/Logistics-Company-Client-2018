;(() => {
  $('.navigation_panel').remove();

  $('.change_order_btn').click(function (event) {
    let url = document.querySelector('.change_order_btn').getAttribute('href');
    $.ajax({
      url,
      cache: false,
      async: false,
      success: function(html) {
        let $doc = $('<div></div>').html(html);
        let $el = $doc.find('.editOrder_container');
        $('.content').html('').append($el);
        changeBreadCrumbText('Изменение заказа');
      },
    });

    let userLogin = $('.user_login').html();
    console.log(userLogin);
    $.ajax({
      url: `http://localhost:8080/user/login/${userLogin}`,
      type: 'GET',
      dataType: 'json',
      crossDomain: true,
      crossOrigin: true,
      success: function (user) {
        console.log(user);
        if(user.post !== 'Управляющий складом') {
          $('.cargo_status').remove();
        }

        let freightCost = $('.freight_cost').val();
        console.log(freightCost);
        $('.freight_cost').val(freightCost.slice(0,freightCost.indexOf('.')));
      },
    });

    return false;
  });
})();