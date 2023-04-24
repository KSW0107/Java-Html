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
			<th>작성자</th>
			<th>글내용</th>
		</tr>
	</thead>
	<tbody id="tlist">

	</tbody>
</table>



<script>
    let showFields = ['replyId', 'replyWriter', 'reply'];
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', 'replyList.do?nid=${noticeInfo.noticeId}');
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
	function makeTrFunc(reply = {}){
		let tr = document.createElement('tr')
		for(let prop of showFields){
			let td = document.createElement('td')
			td.innerText = reply[prop];
			tr.append(td);
		}
	
	//삭제버튼
	let btn = document.createElement('button');
	btn.addEventListener('click', function(e){
		let rid = btn.parentElement.parentElement.children[0].innerText;
		//db에서 삭제 후 화면에서 삭제.
		let xhtp = new XMLHttpRequest();
		xhtp.open('post', 'removeReply.do');
		xhtp.setRequestHeader('Content-Type' , 'application/x-www-form-urlencoded');
		xhtp.send('rid='+rid);
		
		xhtp.onload = function () {
			let result = JSON.parse(xhtp.response);
			console.log(result);
			if(result.retCode == 'Success'){
				console.log('Success');
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
	//등록 버튼 이벤트
	document.querySelector("#addBtn").addEventListener('click', addReplyFnc);
	function addReplyFnc(e){
		//로그인 여부 체크해서 정보가 없으면 로그인 화면으로
		let id = document.querySelector('#content span').innerText;
		if(id==null || id==''){
			alert("로그인 후에 처리하세요");
			location.href = 'loginForm.do'
			return;
		}
		console.log('click', e.target); //e = 자동으로 넘어가는 매개변수 event 약어
		console.log('reply', document.querySelector("#reply").value)
		console.log('id', "${info.email}")//댓글 내용
		let reply =  document.querySelector("#reply").value;
		
		//AJAX 호출
		let xhtp = new XMLHttpRequest();
		xhtp.open('post', 'addReply.do'); //post는 url에 데이터 X
		xhtp.setRequestHeader('Content-Type' , 'application/x-www-form-urlencoded'); // key value 형식으로 데이터 넣기
		xhtp.send('id=${info.email}&reply='+reply+"&notice_id=${noticeInfo.noticeId}"); //post는 send에 데이터 입력
		xhtp.onload = function() {
			console.log(xhtp.response); 
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