$(document).ready(function () {
		$('form').on('submit', function (e) {
			e.preventDefault(); // 전송 차단
			$.ajax({
				url: 'addNotice.do',
				data: $(this).serialize(),
				mathod: 'post',
				dataType: 'json', //받아오는 데이터 타입
				error: function (jqxhr, textStatus, error) { //error 떴을 때의 옵션
					console.log(jqxhr, textStatus, error);
				},
				success: function (data, textStatus, jqxhr) { //성공 했을 때의 옵션
					console.log(data, textStatus, jqxhr)
					
					let ul = $('<ul />').append($('<li />').text('작성자 : '+data.retVal.noticeWriter),
									   $('<li />').text('제목 : '+data.retVal.noticeTitle),
									   $('<li />').text('내용 : '+data.retVal.noticeSubject))	
					$('form').after(ul);
				}
			})
			/* .done(function(result){
				console.log(result)
			}) */
			/* .fail(function(err){
				console.log(err)
			}) */
			.always(function(){
				console.log('final.')
			})

		})
	});