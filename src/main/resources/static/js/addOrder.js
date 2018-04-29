;(() => {
  $('.loading_time').wickedpicker({timeSeparator: ':', twentyFour: true, title: 'Время',});
  $('.unloading_time').wickedpicker({timeSeparator: ':', twentyFour: true,});
  $( ".loading_date" ).datepicker({dateFormat: "yy-mm-dd"});
  $(".unloading_date").datepicker({dateFormat: "yy-mm-dd"});

  $('.select_stock').change(function () {
    let stockID = this.value;
    if(stockID !== '-1') {
      $.ajax({
        url: `http://localhost:8080/stock/${stockID}`,
        type: 'GET',
        dataType: 'json',
        crossDomain: true,
        crossOrigin: true,
        success: function (stock) {
          $('.stock_name').val(stock.stockName);
          $('.stock_address').val(stock.stockAdress);
          $('.stock_postal_code').val(stock.stockPostalCode);
          $('.stock_city').val(stock.stockCity);
          $('.stock_country').val(stock.stockCountry);
        },
      });
    } else {
      $('.stock_name').val('');
      $('.stock_address').val('');
      $('.stock_postal_code').val('');
      $('.stock_city').val('');
      $('.stock_country').val('');
    }


  });

})();