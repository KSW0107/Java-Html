$(document).ready(function() {
	//데이터 가져오기
	$.ajax({
		url: 'data.json',

		success:
		 function(data) {
			console.log(data)
			$(data.data).each(function(index, item) {
				console.log(index +"/"+item.content)
				getData(item.content)
			})
		},
		error: function() {
			console.log('Fail')
		}
	})

	//등록
	$('span.addBtn').attr('onclick', null)
	$('.addBtn').on('click', addToDo)

	//체크
	$('li').append($('<span />').text('X').attr('class', 'close').on('click', delToDo)).on('click', complete)
	
	//전부 체크
	$('#allCom').on('click',allComplete)
	
	//전체 삭제
	$('#allDel').on('click',allDelete)
	
	//완료 삭제
	$('#comDel').on('click', completeDelete)
	
	//수정 

});

//등록
function addToDo() {
	console.log($('#myInput').val())
	if ($('#myInput').val() != "") {
		let li = $('<li / >').text($('#myInput').val()).append($('<span />').text('X').attr('class', 'close').on('click', delToDo))
		$(li).on('click', complete)

		$('#myUL').append(li);
	} else {
		alert('입력값이 없음')
	}
}

//삭제
function delToDo(e) {
	console.log($(e.target).parent());
	$(e.target).parent().remove();
}

//체크처리
function complete(e) {
	if ($(e.target).attr('class') != 'checked') {
		$(e.target).attr('class', 'checked')
	} else if ($(e.target).attr('class') == 'checked') {
		$(e.target).attr('class', '')
	}
}

//기존 데이터 가져오기
function getData(content) {
	let li = $('<li / >').text(content).append($('<span />').text('X').attr('class', 'close').on('click', delToDo))
	$(li).on('click', complete)

	$('#myUL').append(li);
}

//전부 완료
function allComplete(){
	$('li').attr('class', 'checked');
}

//전부 삭제
function allDelete(){
	$('li').remove();
}

//완료 삭제
function completeDelete(){
	$('li.checked').remove()
}