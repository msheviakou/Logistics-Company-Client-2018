;(() => {
    $(document).ready(function () {
        showViewPage('ordersRealization');
        changeNavigationText('Транспортные заказы');
        changeBreadCrumbText('Заказы в реализации');
    });

    const showViewPage = (name) => {
        $.ajax({
            url: name,
            cache: false,
            success: function (html) {
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
        let {target} = event;

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
                    default:
                        return;
                }
                return;
            }
            target = target.parentNode;
        }

    });

    $('.site_menu_small').click((event) => {
        let {target} = event;

        while (target != this) {
            if (target.classList.contains('menu_item_small')) {
                clearDynamicalField();
                showViewPage(target.dataset.action);

                switch (target.dataset.action) {
                    case 'statistics':
                        $.ajax({
                            url: 'http://localhost:8080/orders',
                            type: 'GET',
                            dataType: 'json',
                            crossDomain: true,
                            crossOrigin: true,
                            success: function (listOfOrders) {
                                let counter = 0; // Количество заказов за месяц

                                var monthMap = new Map();
                                monthMap.set("01", "Январь");
                                monthMap.set("02", "Февраль");
                                monthMap.set("03", "Март");
                                monthMap.set("04", "Апрель");
                                monthMap.set("05", "Май");
                                monthMap.set("06", "Июнь");
                                monthMap.set("07", "Июль");
                                monthMap.set("08", "Август");
                                monthMap.set("09", "Сентябрь");
                                monthMap.set("10", "Октябрь");
                                monthMap.set("11", "Ноябрь");
                                monthMap.set("12", "Декабрь");

                                let orderMap = new Map(); // Ключ: количество заказов, значение: месяц (цифры)

                                listOfOrders.forEach(function (element) {
                                    let monthOfOrder = element.dateOfOrder.split('-')[1];

                                    if (orderMap.get(monthOfOrder) !== 0)
                                        counter = counter + 1;
                                    else counter = 0;
                                    orderMap.set(monthOfOrder, counter);
                                })

                                monthMap.forEach(function (key, value) {

                                })

                                /* Start Graphic */
                                var data = {
                                    label: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
                                    series: [
                                        [1, 5, 7, 4, 3, 6, 7, 4, 9, 2, 11, 12]
                                    ]
                                };

                                var options = {
                                    width: '1100px',
                                    height: '500px'
                                }

                                new Chartist.Line('.ct-chart', data, options);
                                /* End Graphic */
                            },
                        });
                        break;
                    case 'trucks':

                        break;
                    case 'administration':
                        changeBreadCrumbText('Администрирование');
                        changeNavigationText('Управление пользователями');
                        break;
                    case 'settings':

                        break;
                    default:
                        return;
                }
                return;
            }
            target = target.parentNode;
        }
    });


})();


