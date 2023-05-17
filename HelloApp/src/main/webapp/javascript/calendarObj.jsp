// {} => 오브젝트
    //오브젝트로 달력 생성
    const obj = {
      days: ['Sun', 'Mon', 'Tue', 'Wen', 'Thr', 'Fri', 'Sat'],
      makeThead: function () {
        let thead = document.createElement('thead')
        let tr = document.createElement('tr')
        for (let day of this.days) {
          let th = document.createElement('th')
          th.style.backgroundColor ='lightgrey';
          th.innerText = day;
          tr.append(th)
        }
        thead.append(tr)
        return thead;
      },
      makeTBody: function (month) {
        let tbody = document.createElement('tbody');
        let tr = document.createElement('tr')
        for (let i = 0; i < this.getStartDay(month); i++) {
          let td = document.createElement('td');
          tr.append(td)
        }
        for (let i = 1; i <= this.getLastDay(month); i++) {
          let td = document.createElement('td');
          td.innerText = i;
          tr.append(td);
          if ((i + this.getStartDay(month)) % 7 == 0) {
            tbody.append(tr);
            tr = document.createElement('tr')
            td.style.backgroundColor = 'red';
            td.style.color = 'white'
          }
          if ((i + obj.getStartDay(month)) % 7 == 1) {
            td.style.backgroundColor = 'blue';
            td.style.color = 'white'
          }
        }
        tbody.append(tr);
        return tbody;
      },
      makeTable: function (month, element) {
        let table = document.createElement('table');
        table.border = '1';
        table.append(this.makeThead()) //this. / obj. 둘 다 가능!
        table.append(obj.makeTBody(month))
        element.append(table);
      },
      getStartDay: function (month) {
        if (month == 5) {
          return 1;
        } else if (month == 6) {
          return 4;
        } else if (month == 7) {
          return 6;
        } else if (month == 8) {
          return 2;
        }
      },
      getLastDay: function (month) {
        if (month == 5) {
          return 31;
        } else if (month == 6) {
          return 30;
        } else if (month == 7) {
          return 31;
        } else if (month == 8) {
          return 31;
        }
      }
    }
    //show의 하위요소로 
    obj.makeTable(6, show); // show > 요소를 넣을 element 넣음