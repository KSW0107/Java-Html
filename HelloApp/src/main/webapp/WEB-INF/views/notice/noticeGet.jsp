<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#content {
	padding: 15px auto;
}
</style>
<h3>공지사항 상세페이지 (noticeGet.jsp)</h3>
<form action="modifyNotice.do" method="GET">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" name="nid" value="${noticeInfo.noticeId}"
				readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"
				value="${noticeInfo.noticeTitle }" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="20" name="subject" readonly>${noticeInfo.noticeSubject }</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"
				value="${noticeInfo.noticeWriter }" readonly></td>
		</tr>
		<tr>
			<th>첨부파일 : ${fileType}</th>
			<td><c:if test="${noticeInfo.attachFile != null}">
					<c:choose>
						<c:when test="${fileType=='image'}">
							<img src="images/${noticeInfo.attachFile }" width="200px">
						</c:when>
						<c:otherwise>
							<a href="images/${noticeInfo.attachFile }">${noticeInfo.attachFile }</a>
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><c:choose>
					<c:when test="${id == noticeInfo.noticeWriter}">
						<button type="submit">수정</button>
					</c:when>
					<c:when test="${id != noticeInfo.noticeWriter}">
						<button type="submit" disabled="disabled">수정</button>
					</c:when>
				</c:choose>
				<button type="button"
					onclick="location.href='noticeList.do?page=${pageNum}'">목록</button>

			</td>
		</tr>
	</table>
</form>

<div id="content">
	<input type="text" id="reply"> <span>${info.email}</span>
	<button type="button" id="addBtn">등록</button>
</div>

<!-- 댓글 정보 -->
<table class="table">
	<thead>
		<tr>
			<th>댓글번호</th>
			<th>글내용</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody id="tlist">

	</tbody>
</table>

<table style="display: none;">
	<tbody>
		<tr class="template">
			<td>10</td>
			<td><input type="text" class="reply"></td>
			<td>user01</td>
			<td><button>수정</button></td>
		</tr>
	</tbody>
</table>

<script>
	//댓글 조회
    let showFields = ['replyId','reply','replyWriter'];
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', 'replyList.do?nid=${noticeInfo.noticeId}'); //요청방식, 요청페이지
	xhtp.send(); 
	xhtp.onload = function() {
		let data = JSON.parse(xhtp.response);
		let tlist = document.querySelector('#tlist')
		for(let reply of data) {
			let tr = makeTrFunc(reply);
			tlist.append(tr);
		}
	}

	//tr 생성함수 선언
	function makeTrFunc(reply = {}){ //reply가 object라는 뜻
		let tr = document.createElement('tr')
		// tr.id = reply.replyId; // tr.id속성추가 (댓글번호)
		
		//tr 더블클릭 시 수정으로 이동
		tr.addEventListener('dblclick', function(){ 
			let writer = this.children[2].innerText;
			
			console.log(writer,'${info.email}');
			if(writer != '${info.email}'){
				alert('권한이 없습니다')
				return;
			}
			
			let template = document.querySelector('.template').cloneNode(true); //노드 복제 (true면 하위노드까지 복제)
			console.log(template);
			console.log(document.getElementById('tlist'));
			//방법1
		/* 	template.children[0].innerText = reply.replyId;
			template.children[1].children[0].value= reply.reply;
			template.children[2].innerText = reply.replyWriter; */
			//방법2
			template.querySelector('td:nth-of-type(1)').innerText = reply.replyId;// 첫번째 td
			template.querySelector('td:nth-of-type(2)>input').value = reply.reply;// 두번째 td 안에 input
			template.querySelector('td:nth-of-type(3)').innerText = reply.replyWriter;
			template.querySelector('button').addEventListener('click', function (e) { //수정버튼 클릭 시
				//Ajax 호출
				let replyId = reply.replyId;
				let replyCon = this.parentElement.parentElement.children[1].children[0].value  //수정해서 바뀐 후의 값
				//JSP this 1) object 안에서 사용되면 object 자체
				//			let obj ={name: "hong", showInfo: functiony() {this.name}}	
				//		   2) function 선언 안에서 this는 window 전역객체 (<-> 지역객체)
				//			function add() {console.log(this)}
				//		   3) event 안에서 사용되는 this -> 이벤트를 받는 대상
				//			document.getElementById('tlist').addEventListner('click',function(e) {console.log(this) = tlist})
				// 위의 this는 3번에 해당 (button)
				console.log(replyId, replyCon);
				
				let xhtp = new XMLHttpRequest();
				xhtp.open('post','modifyReply.do');
				xhtp.setRequestHeader('Content-Type' , 'application/x-www-form-urlencoded');
				xhtp.send('rid='+replyId+'&reply='+replyCon);
				xhtp.onload = function() {
					let result = JSON.parse(xhtp.response);
					console.log(result);
					if (result.retCode == 'Success'){
						//화면을 변경
						//let newTr = makeTrFunc(result.data);
						//oldTr = document.querySelector('.template')
						//document.getElementById('tlist').replaceChild(newTr, oldTr);
						let data = result.data;
						tr.children[1].innerText = data.reply;
						document.getElementById('tlist').replaceChild(tr,template);
					} else if (result.retCode == 'Fail'){
						alert('처리 중 에러')	
					}else {
						alert('알 수 없는 반환값')
					}
				}
				
				let replyWriter = reply.replyWriter;
			})
			//화면 전환
			document.getElementById('tlist').replaceChild(template, tr); // 부모요소에서 사용 (tr를 template를 바꿈)
		})
		
		for(let prop of showFields){
			let td = document.createElement('td')
			td.innerText = reply[prop];
			tr.append(td);
		}
	
	//댓글 삭제
	//삭제버튼
	let btn = document.createElement('button');
	btn.addEventListener('click', function(e){
		
		let writer = btn.parentElement.previousElementSibling.innerText; // td의 형제.innerText
		
		//작성자 != 로그인 아이디일 때
		console.log(writer, '${info.email}'); //session 사용가능
		if(writer != '${info.email}'){
			alert('권한이 없습니다');
			return;
		}
		
		let rid = btn.parentElement.parentElement.children[0].innerText; //[0]텍스트 노드
		//let rid = btn.parentElement.parentElement.id; // id 속성을 추가했다면 이렇게도 사용 가능
		//db에서 삭제 후 화면에서 삭제.
		let xhtp = new XMLHttpRequest();
		xhtp.open('post', 'removeReply.do');
		xhtp.setRequestHeader('Content-Type' , 'application/x-www-form-urlencoded');
		xhtp.send('rid='+rid); //post 방식일 때 parameter send()에 기재
		
		xhtp.onload = function () {
			let result = JSON.parse(xhtp.response);
			console.log(result);
			if(result.retCode == 'Success'){
				console.log('Success');
				alert('댓글 삭제 완료')
				//화면에서 지우기
				/* let rm = btn.parentElement.parentElement;
				rm.remove(); */
				btn.parentElement.parentElement.remove();
			}else if(result.retCode == 'Fail'){
				alert('처리중 에러발생');
			}else {
				alert('알 수 없는 결과값입니다');
			}
		}
		
	})
	
	btn.innerText='삭제';
	let td = document.createElement('td');
	td.append(btn);
	tr.append(td)
	
	return tr;
	}
	
	
	//댓글 등록
	//등록 버튼 이벤트
	document.querySelector("#addBtn").addEventListener('click', addReplyFnc);
	function addReplyFnc(e){
		//로그인 여부 체크해서 정보가 없으면 로그인 화면으로
		let id = document.querySelector('#content span').innerText;
		if(id==null || id==''){
			alert("로그인 후에 작성가능합니다");
			location.href = 'loginForm.do'
			return;
		}
	/* 	console.log('click', e.target); //e = 자동으로 넘어가는 매개변수 event 약어
		console.log('reply', document.querySelector("#reply").value)
		console.log('id', "${info.email}")//댓글 내용 */
		let reply =  document.querySelector("#reply").value;
		
		//AJAX 호출
		let xhtp = new XMLHttpRequest();
		xhtp.open('post', 'addReply.do'); //post는 url에 데이터 X
		xhtp.setRequestHeader('Content-Type' , 'application/x-www-form-urlencoded'); // key value 형식으로 데이터 넣기
		xhtp.send('id=${info.email}&reply='+reply+"&notice_id=${noticeInfo.noticeId}"); //post는 send에 데이터 입력
		xhtp.onload = function() {
			/* console.log(xhtp.response);  */
			let result = JSON.parse(xhtp.response);
			if(result.retCode=='Success'){
				//값을 활용해 tr 생성
				let tr = makeTrFunc(result.data);
				tlist.append(tr);
				
				//입력값 초기화
				document.getElementById("reply").value='';
				document.getElementById("reply").focus();
			}else if(result.retCode == 'Fail'){
				alert('처리 중 에러.')
			}
		}
		
	}
	
	
</script>