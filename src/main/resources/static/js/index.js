const sentReq = () => {
    let xhr = new XMLHttpRequest();
    xhr.open('GET','administration' , true);
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState != 4) return;


        if (xhr.status != 200) {
            // обработать ошибку
            alert(xhr.status + ': ' + xhr.statusText);
        } else {
            // вывести результат
            console.log(xhr.responseText);
            // let psrser = new DOMParser();
            // tryDOC = parser.parseFromString(xhr.responseText, "text/xml"v
            let x = document.createElement('div');
            x.innerHTML = xhr.responseText;
            document.body.appendChild(x.querySelector('.administration_content'));

        }

    }

}

sentReq();