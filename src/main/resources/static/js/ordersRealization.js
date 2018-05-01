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
      dom: '<"tooltip_container">frtip',

    });

  $('div.tooltip_container').html(
    `<div class="tooltip_row">
           <a href="#" class="tooltip">
             <i class="fas fa-info-circle"></i>
             <span class="tooltip_text">статус заказа</span>
              <span class="tooltip-content">
                <ul class="orders_tips_list">
                  <li class="order_tip order_tip--awaiting">в ожидании загрузки</li>
                  <li class="order_tip order_tip--transported">транспортируется на склад</li>
                  <li class="order_tip order_tip--arrived">прибыл на склад</li>
                </ul>
              </span>
           </a>
         </div>`
  );

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