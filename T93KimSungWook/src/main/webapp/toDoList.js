$(document).ready(function() {
	//데이터 가져오기
	$.ajax({
		url: 'todoList.json',

		success:
			function(ToDoVO) {
				console.log(ToDoVO)
				$(ToDoVO).each(function(index, item) {
					console.log(index + "/" + item.todoTitle)
					getData(item)
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


});

//등록
function addToDo() {
	console.log($('#myInput').val())
	if ($('#myInput').val() != "") {
		$.ajax({
			url: 'addtodo.json',
			data: {title : $('#myInput').val()},
			success:
				function(result) {
					console.log(result)
					if (result.boolean) {
						let li = $('<li />').text($('#myInput').val())
						                    .on('click', complete)
						                    .attr('id','no'+result.vo.todoNo)
						                    .append($('<span />').text('X').attr('class', 'close').on('click', delToDo))
						//$(li).on('click', complete)

						$('#myUL').append(li);
						$('#myInput').val('')
					}
				},
			error: function() {
				console.log('Fail')
				alert('처리 오류')
			}
		})
	}else{
		alert('값을 입력하시오')
	}
}

//삭제
function delToDo(e) {
	console.log($(e.target).parent().attr('id').substring(2));
	let no = $(e.target).parent().attr('id').substring(2)
	
	$.ajax({
		url : 'deltodo.json',
		data : {no : no},
		success: function(result){
			console.log(result)
			if(result){
				$(e.target).parent().remove();
			}
		},
		error: function() {
				console.log('Fail')
				alert('처리 오류')
			}
		
	})
	
}

//체크처리
function complete(e) {
	let no = $(e.target).attr('id').substring(2)
	console.log('no')
	
	$.ajax({
		url:'modifytodo.json',
		data : {no : no},
		sucess: function(result){
			console.log(result)
		},
		error: function() {
				console.log('Fail')
				alert('처리 오류')
			}
	})
	
	if ($(e.target).attr('class') != 'checked') {
		$(e.target).attr('class', 'checked')
	} else if ($(e.target).attr('class') == 'checked') {
		$(e.target).attr('class', '')
	}
}

//기존 데이터 가져오기
function getData(todo) {
	
	let li = $('<li / >').text(todo.todoTitle).attr('id','no'+todo.todoNo).append($('<span />').text('X').attr('class', 'close').on('click', delToDo))
	$(li).on('click', complete)
	
	if(todo.todoStatus == 'Y'){
		$(li).attr('class','checked')
	}
	
	$('#myUL').append(li);
}
