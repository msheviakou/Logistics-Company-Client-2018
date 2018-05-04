;(() => {

  const statistics = () => {
    $.ajax({
      url: 'http://localhost:8080/orders',
      type: 'GET',
      dataType: 'json',
      crossDomain: true,
      crossOrigin: true,
      success: function (listOfOrders) {
        let counter = 0; // Количество заказов за месяц
        console.log(listOfOrders);
        let monthMap = new Map();
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
        });

        monthMap.forEach(function (key, value) {

        });

        /* Start Graphic */
        let data = {
          label: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
          series: [
            [1, 5, 7, 4, 3, 6, 7, 4, 9, 2, 11, 12]
          ]
        };

        let options = {
          width: '1100px',
          height: '500px'
        };

        new Chartist.Line('.ct-chart', data, options);
        /* End Graphic */
      },
    });
  };

  statistics();
})();