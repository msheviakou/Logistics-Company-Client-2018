;(()=> {
  //
  let tableUsers = $('#users_table').DataTable({
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
        className: 'MyBtnClass',
      },
      {
        text: 'Изменить',
        action: function ( e, dt, node, config ) {
          alert( 'Button activated' );
        },
        enabled: false,
        className: 'MyBtnClass',
      },
      {
        text: 'Удалить',
        action: function ( e, dt, node, config ) {
          document.querySelector('.modal_window--user_delete').dataset.state = 'run';
          document.body.classList.add('modal-active');
        },
        className: 'MyBtnClass',
        enabled: false,
      }
    ]
  });

  tableUsers.on( 'select deselect', function () {
    let selectedRows = tableUsers.rows( { selected: true } ).count();

    tableUsers.button( 1 ).enable( selectedRows === 1 );
    tableUsers.button( 2 ).enable( selectedRows > 0 );
  } );

  tableUsers.on( 'select', function ( e, dt, type, indexes ) {
    let k = document.querySelector('.custom-selected');
    if( document.querySelector('.custom-selected') !== null) {
      k.classList.remove('custom-selected');
    }
    tableUsers[ type ]( indexes ).nodes().to$().addClass( 'custom-selected' );
  } );
//

  $('.accept_delete_user_btn').click((event)=> {
    let userId = document.querySelector('.custom-selected').dataset.userId;
    console.log(userId);
    $.ajax({
      url: `/deleteUser/${userId}`,
      method: 'DELETE',
      cache: false,
    });
    return false;
  });

  const closeUserDeleteModalWindow = () => {
    document.querySelector('.modal_window--user_delete').dataset.state = "";
    document.querySelector('.modal_window--user_delete').dataset.state = 'away';
    document.body.classList.remove('modal-active');
  }

  $('.close_btn').click(closeUserDeleteModalWindow);

  $('.decline_delete_user_btn').click(closeUserDeleteModalWindow);




})();