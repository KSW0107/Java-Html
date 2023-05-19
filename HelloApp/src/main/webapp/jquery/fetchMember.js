

$(function () {

  $('#list').remove();
  $('#show2').remove();
  $('#show').empty();
  $('#show').before('<h3>회원목록</h3>');

  fetch('MOCK_DATA.json')
    .then(function (resolve) {
      return resolve.json();
    })
    .then(makeList)
    .catch(function (err) {
      console.error(err)
    }) //end of fetch()

  //등록버튼 이벤트
  $('button:contains(등록)').on('click',addMember);  

  //변경버튼 이벤트
  $('button:contains(변경)').on('click', updateMember);  

  //선택된 tr로 이동
  $('button:contains(선택된)').on('click', moveTr);  

  //tr 마우스 오버 시
  //라이브 이벤트
  $('body').on('dblclick', '#memberList>tr',function(){
    console.log('tr click')
    let oldTr = $(this);
    let oldId = $(this).children().eq(0).text();
    let oldFname = $(this).children().eq(1).text()
    let oldLname = $(this).children().eq(2).text()
    let oldGender = $(this).children().eq(3).text()

    let newTr = $('<tr />').append(
      $('<td />').text(oldId),
      $('<td />').append($('<input />').val(oldFname)),
      $('<td />').html($('<input type="text" value="'+oldLname+'">')),
      $('<td />').html(oldGender),
      $('<td />').append($('<button />').text('수정').on('click', updateTr)),
    )
    console.log(oldTr)
    oldTr.replaceWith(newTr);
  })

  //tr 이동
  function moveTr(){
    let moveThing = $('input[type="checkbox"]:checked').parent().parent()
    $(moveThing).next().after(moveThing)
  } 

  //업데이트 멤버
  function updateMember(){
    let updateData = $(this).parent().parent().parent();

    let id = updateData.find('td:eq(0)>input').val();
    let fname = updateData.find('td:eq(1)>input').val();
    let lname = updateData.find('td:eq(2)>input').val();
    let gender = updateData.find('td:eq(3)>select').val();
   
    let changeTr = $('tr:contains('+id+')')[0]
    $(changeTr).find('td:eq(1)').text(fname);
    $(changeTr).find('td:eq(2)').text(lname);
    $(changeTr).find('td:eq(3)').text(gender);

    console.log(changeTr)
  }

  //업데이트
  function updateTr(){
    let oldTr =$(this).parentsUntil('tbody');
    let id = oldTr.find('td:eq(0)').text();
    let fname = oldTr.find('td:eq(1)>input').val();
    let lname = oldTr.find('td:eq(2)>input').val();
    let gender = oldTr.find('td:eq(3)').text();

    console.log(id)
    let newTr = $('.template').clone();
    newTr.find('td:eq(0)').text(id);
    newTr.find('td:eq(1)').text(fname);
    newTr.find('td:eq(2)').text(lname);
    newTr.find('td:eq(3)').text(gender);
    newTr.find('td:eq(4)>button').on('click', delMember)
    newTr.toggleClass('template')

    console.log(newTr)
    oldTr.replaceWith(newTr);
  }

  function makeList(result) {
      console.log(result)
      let tbl = $('<table border="1" />');
      let tbd = $('<tbody />').attr('id','memberList');
      result.forEach(function(member, index){
        if(index < 5){    
          let tr = $('<tr />').append($('<td />').text(member.id),
                                      $('<td />').text(member.first_name),
                                      $('<td />').text(member.last_name),
                                      $('<td />').text(member.gender),
                                      //버튼작성. on -> 이벤트 등록
                                      $('<td />').append($('<button>삭제</button>')).on('click', delMember), // on에는 함수에() X
                                      //체크박스
                                      $('<td />').append(
                                        $('<input />').attr('type','checkbox')
                                      )
                                      );
          
          tbd.append(tr);    
        }
      });
      tbl.append(tbd)
      $('#show').append(tbl); //<div id="show"><table border='1'>...</table></div>
      makeHead();
  } 

  //thead 등록  
  function makeHead(){
    $('table:eq(1)').prepend(
      $('<thead />').append($('<th />').text('ID'),
                            $('<th />').text('이름'),
                            $('<th />').text('성씨'),
                            $('<th />').text('성별'),
                            $('<th />').text('삭제'),
                            $('<th />').html('<input type="checkbox" />')
                            )                                                                      
    )
  }

  //한 라인 삭제 함수 / 매개변수 e -> event
  function delMember(e) {
    $(e.target).parentsUntil('tbody').remove();
  }

  //멤버 추가 함수
  function addMember(e) {
    let tbl1 = $('table:eq(1)');
    let tbd1 = $('#show tbody')
    let tr1 = $('<tr />').append($('<td />').text($('#id').val()),
                                $('<td />').text($('#fname').val()),
                                $('<td />').text($('#lname').val()),
                                $('<td />').text($('#gender').val()),
                                //버튼작성. on -> 이벤트 등록
                                $('<td />').append($('<button>삭제</button>')).on('click', delMember) // on에는 함수에() X
                                );
    tbd1.append(tr1) 
    tbl1.append(tbd1)          
    
    $('#id').val('')
    $('#fname').val('')
    $('#lname').val('')
    $('#gender').val('Male')
  }
})