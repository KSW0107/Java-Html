//basic 2번

$(document).ready(function(){
  //식별자
  console.log($('ul>li')); 
  console.log($('ul>li:nth-of-type(1)')); 

  $('ul>li:nth-of-type(1)').css('background','yellow') 
  $('ul>li:nth-of-type(2)').css('color','red') 

  //둘 다 가능
  // $('#show button')[0]
  $('#show button:eq(0)').css('background','yellow');
  $('#show2 span:eq(1)').text('월드'); // 태그 입력 X 
  $('#show2 span:eq(1)').html('<b>월드</b>'); // 태그 입력 O

  $('div span:eq(2)').css('color','blue');
  $('div>p:nth-of-type(1)>span').css('color','red');
  
  $('div#show>p:gt(0)>span').css('background','red')

  //not 안에 선택자
  $('#show2>p:not(:eq(1))>span').css('background','yellow')

  //contains
  $('span:contains(Good)').css('fontSize','20px')

  //has
  $('p:has(b)').css('background','green')
});