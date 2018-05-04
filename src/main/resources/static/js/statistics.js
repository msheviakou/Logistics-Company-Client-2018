;(() => {

  const statistics = () => {
    $.ajax({
      url: 'http://localhost:8080/orders',
      type: 'GET',
      dataType: 'json',
      crossDomain: true,
      crossOrigin: true,
      success: function (listOfOrders) {
        let numberOfOrdersPerMounth = 0; // Количество заказов за месяц
        const mounths = {
          1: 'Январь',
          2: "Февраль",
          3: "Март",
          4: "Апрель",
          5: "Май",
          6: "Июнь",
          7: "Июль",
          8: "Август",
          9: "Сентябрь",
          10: "Октябрь",
          11: "Ноябрь",
          12: "Декабрь",
        };

        let statistics =  {}; // Ключ: количество заказов, значение: месяц (цифры)

        listOfOrders.forEach(function (order) {
          let monthOfOrder = order.dateOfOrder.split('-')[1];
          if(monthOfOrder.charAt(0) === '0')
            monthOfOrder = monthOfOrder.charAt(1);

          if (statistics[monthOfOrder] === undefined) //если новый месяц
            numberOfOrdersPerMounth = 1;
          else numberOfOrdersPerMounth++;
          statistics[monthOfOrder] = numberOfOrdersPerMounth;
        });


        const series = [[]];
        let i = 0;
        for( let numberOfMonth in mounths) {
          if(statistics[numberOfMonth] === undefined) {
            series[0][i] = 0;
          } else {
            series[0][i] = statistics[numberOfMonth];
          }
          i++;
        }

        let data = {
          labels: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
          series,
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