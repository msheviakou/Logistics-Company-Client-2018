;(()=> {

    $('.orders_realization_table').DataTable({
      lengthChange: false,
      pageLength: 2,
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

})();