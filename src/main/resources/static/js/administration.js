;(()=> {
  let table = $('#users_table').DataTable({
    dom: 'Bfrtip',
    lengthChange: false,
    pageLength: 2,
    oLanguage: {
      sSearch: "Поиск:"
    },
    columnDefs: [ {
        orderable: false,
        className: 'select-checkbox',
        targets: 0,
        width: "10%",
      },
      // {
      //   width: "15%",
      //   targets: 1,
      // },
      // {
      //   width: "15%",
      //   targets: 2,
      // }
    ],
    select: {
      style:    'os',
      selector: 'td:first-child'
    },
    order: [[ 1, 'asc' ]],
    buttons: [
      {
        text: 'Добавить',
        action: function ( e, dt, node, config ) {
          alert( 'Button activated' );
        },
      },
      {
        text: 'Изменить',
        action: function ( e, dt, node, config ) {
          alert( 'Button activated' );
        },
        enabled: false,
      },
      {
        text: 'Удалить',
        action: function ( e, dt, node, config ) {
          alert( 'Button activated' );
        },
        enabled: false,
      }
    ]
  });

  table.on( 'select deselect', function () {
    console.log('adasdsa');
    var selectedRows = table.rows( { selected: true } ).count();

    // table.button( 0 ).enable( selectedRows === 1 );
    // table.button( 1 ).enable( selectedRows > 0 );
    table.button( 1 ).enable( selectedRows === 1 );
    table.button( 2 ).enable( selectedRows > 0 );
  } );

})();