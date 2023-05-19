//자바스크립트 객체 / jquery 객체 구분 필요

  //자바스크립트 버전
  // document.addEventListener('DOMContentLoaded',function(){
  //   let liTag = document.createElement('li'); //Document Object Model(DOM객체)
  //   liTag.innerText = 'Cherry';
  //   console.log(liTag);
  //   document.querySelector('#list').append(liTag);
  // })

  //jquery 버전
  //ready = DOMContentLoaded
  $(document).ready(function(){
    let elem = jQuery('<li / >') //jQuery 객체로 생성,변환
    let element = $('<li / >') //위와 같음
    console.log(elem) //출력 방식이 다름 / 제이쿼리의 함수만 사용가능(자바스크립트 함수 사용 X)
    //ex ) element.innerText 불가
    elem.text('Melon');
    console.log(elem);
    $('#list').append(elem); //append 와 같음

    $('#list').append($('<li / >').text('Cherry'),// 한줄로 요약
                      $('<li / >').text('Mango')) 
  })