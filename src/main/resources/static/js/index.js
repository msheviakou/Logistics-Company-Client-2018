;(() => {
  $( document ).ready(function() {
  showViewPage('ordersRealization');
  changeNavigationText('Транспортные заказы');
  changeBreadCrumbText('Заказы в реализации');
});

const showViewPage = (name) => {
  $.ajax({
    url: name,
    cache: false,
    success: function(html) {
      let $doc = $('<div></div>').html(html);
      let $el = $doc.find(`.${name}_container`);
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

const clearDynamicalField = () => {
  $('.content').html('');
};

// -------------EVENTS-------------------
$('.site_menu__list').click((event) => {
  let { target } = event;

while (target != this) {
  if (target.classList.contains('site_menu_item')) {
    clearDynamicalField();
    showViewPage(target.dataset.action);

    switch (target.dataset.action) {
      case 'ordersRealization':
        changeNavigationText('Транспортные заказы');
        changeBreadCrumbText('Заказы в реализации');
        break;
      case 'addOrder':
        changeBreadCrumbText('Добавить заказ');
        changeNavigationText('Заказ на загрузку');
        break;
      default: return;
    }
    return;
  }
  target= target.parentNode;
}

});

$('.site_menu_small').click((event) => {
  let { target } = event;

while (target != this) {
  if (target.classList.contains('menu_item_small')) {
    clearDynamicalField();
    let userLogin = $('.user_login').html();

    switch (target.dataset.action) {
      case 'statistics':
        changeBreadCrumbText('Статистика');
        changeNavigationText('Статистика заказов');
        showViewPage(target.dataset.action);
        break;
      case 'trucks':

        break;
      case 'administration':
        administration({pageName: target.dataset.action, userLogin,});
        break;
      case 'settings':
        break;
      default: return;
    }
    //showViewPage(target.dataset.action);
    return;
  }
  target= target.parentNode;
}
});

$('.home').click(function(event) {
  clearDynamicalField();
  showViewPage('ordersRealization');
});

const administration = ({pageName, userLogin}) => {
  $.ajax({
    url: `http://localhost:8080/user/login/${userLogin}`,
    type: 'GET',
    dataType: 'json',
    crossDomain: true,
    crossOrigin: true,
    success: function (user) {
      changeBreadCrumbText('Администрирование');
      changeNavigationText('Управление пользователями');
      console.log(user);
      if(user.post !== 'Админ') {
        $('.content').html(
          `<div class="privilege_error">
              <i class="fa fa-times-circle"></i>
               У вас недостаточно привелегий для управления пользователями
            </div>`
        );
      } else {
        showViewPage(pageName);
      }
    },
  });
  changeBreadCrumbText('Администрирование');
  changeNavigationText('Управление пользователями');
};

})();


