;(()=> {

    let ordersRealizationTable = $('.orders_realization_table');

    ordersRealizationTable.DataTable({
      lengthChange: false,
      pageLength: 20,
      oLanguage: {
        sSearch: "Поиск:"
      },
      columnDefs: [
        { targets: '_all', className: "cells_border " }
      ],
      createdRow: function( row, data, dataIndex){
        // if( data[2] ==  `someVal`){
        //   $(row).addClass('redClass');
        // }
        switch($(row).data('state')) {
          case 'Awaiting' : $(row).addClass('awaiting'); break;
          case 'Transported' : $(row).addClass('transported'); break;
          case 'Arrived' : $(row).addClass('arrived'); break;
          default: console.log('YOOOOO'); break;
        }

      },

    });

  ordersRealizationTable.click(function (event) {
    let { target } = event;
    let td = target.closest('.order_number');
    if (!td) return;
    if (!this.contains(td)) return;
    let orderLink = td.querySelector('.link_order_inf').getAttribute('href');
    $.ajax({
      url: orderLink,
      cache: false,
      success: function(html) {
        let $doc = $('<div></div>').html(html);
        let $el = $doc.find('.orderInf_container');
        $('.content').html('').append($el);
      },
    });
    return false;
  });

})();