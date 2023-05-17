
let month = 8;
let days = ['Sun','Mon','Tue','Wen','Thr','Fri','Sat'];
let h2 = document.createElement('h2')
h2.innerText = month+'월'

document.getElementById('show').append(h2);
getCalendar(month)

function getCalendar(month){
  //테이블 생성
  let tbl = document.createElement('table',[border='1'])
  tbl.border = 1;
  tbl.style.textAlign ='center';

  let thead = document.createElement('thead')
  let tbody = document.createElement('tbody')
  let tr = document.createElement('tr')

  //요일
  for(let day of days){
    let th = document.createElement('th')
    th.style.width = '35px';
    th.innerText = day;
    tr.append(th);
  }
  thead.append(tr)
  tbl.append(thead)
  
  tr = document.createElement('tr')
 
  for (let i=0;i <getFirstDay(month); i++){
    tr.append(  document.createElement('td')) 
  }
  for(let i=1; i<=getLastDay(month);i++){
    //Dom을 활용해서 달력생성
    let td = document.createElement('td')
    td.innerText = i;
    tr.append(td)

    //일주일 단위 끊기
    if((i+getFirstDay(month))%7==0){
      tbody .append(tr)
      tr = document.createElement('tr');

      //일요일 색 지정
      td.style.backgroundColor = 'red';
      td.style.color = 'white'
    }
    //토요일 색 지정
    if((i+getFirstDay(month))%7==1){
      td.style.backgroundColor = 'blue';
      td.style.color = 'white'
    }
  }
  tbody.append(tr)
  tbl.append(tbody)

  // #show 하위 요소로 등록
  document.getElementById('show').append(tbl);
}

//월 시작 날짜
function getFirstDay(month){
  if(month==5){
    return 1;
  }else if(month==6){
    return 4;
  }else if(month==7){
    return 6;
  }else if(month ==8){
    return 2;
  }
}

//월 마지막 날짜
function getLastDay(month){
  if(month ==5){
    return 31;
  }else if(month ==6){
    return 30;
  }else if(month ==7){
    return 31;
  }else if(month ==8){
    return 31;
  }
}