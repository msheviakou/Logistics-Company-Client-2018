;(() => {
  $('.navigation_panel').remove();

  $('.change_order_btn').click(function (event) {
    let url = document.querySelector('.change_order_btn').getAttribute('href');
    $.ajax({
      url,
      cache: false,
      success: function(html) {
        let $doc = $('<div></div>').html(html);
        let $el = $doc.find('.editOrder_container');

        $('.content').html('').append($el);
      },
    });

    return false;
  });
})();