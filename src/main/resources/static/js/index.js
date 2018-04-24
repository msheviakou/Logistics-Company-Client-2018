;(() => {
  $( document ).ready(function() {
    showViewPage('addOrder');
    changeBreadCrumbText('Добавить заказ');
    changeNavigationText('Заказ на загрузку');
  });

  const showViewPage = (name) => {
    $.ajax({
      url: name,
      cache: false,
      success: function(html) {
        let $doc = $('<div></div>').html(html);
        let $el = $doc.find(`.${name}_container`);
        console.log($el);
        $('.content').append($el);
      },
    });
  };

  const changeNavigationText = (text) => {
    $('.navigation_panel__text').text(text);
  };

  const changeBreadCrumbText = (text) => {
    $('.current_place_on_site').text(text);
  };

})();


