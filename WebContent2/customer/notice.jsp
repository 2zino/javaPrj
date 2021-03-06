<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/JSPPrj/css/reset.css" type="text/css" rel="stylesheet" />
<link href="/JSPPrj/css/layout.css" type="text/css" rel="stylesheet" />
<link href="/JSPPrj/css/style.css" type="text/css" rel="stylesheet" />
<script src="../js/modernizr-custom.min.js">
	
</script>
</head>
<body>

	<!-- header 부분 -->
	<header id="header">
		<div class="content-container">
			<h1>
			<a href="/JSPPrj/index.html"><img src="/JSPPrj/images/logo.png" /></a>
		</h1>
		<section>
			<h1 class="hidden">머리말</h1>

			<nav id="main-menu">
				<h1 class="hidden">메인 메뉴</h1>
				<ul>
					<li><a href="">학습가이드</a></li>
					<li><a href="">뉴렉과정</a></li>
					<li><a href="">강좌선택</a></li>
				</ul>
			</nav>

			<section id="lecture-search">
				<h1 class="hidden">강좌검색 폼</h1>
				<form>
					<fieldset>
						<legend class="hidden">과정 검색 입력 필드들</legend>
						<label>과정검색</label> <input type="text" /> <input type="submit"
							value="검색" class = "button"/>
					</fieldset>
				</form>
			</section>

			<nav id="member-menu">
				<h1 class="hidden" id="h2">회원메뉴</h1>
				<ul>
					<li><a href="/JSPPrj/index.html">HOME</a></li>
					<li><a href="">로그아웃</a></li>
					<li><a href="/JSPPrj/account/join.html">회원가입</a></li>
				</ul>
			</nav>

			<nav id ="customer-menu">
				<h1 class="hidden">고객메뉴</h1>
				<ul >
					<li><a href="" class =button>마이페이지</a></li>
					<li><a href="/JSPPrj/customer/notice.html" class =button>고객센터</a></li>
				</ul>
			</nav>
		</section>
		</div>
	</header>

	<!-- visual 부분  -->
	<div id="visual">
		<div class="content-container"></div>
	</div>

	<!-- body 부분 -->
	<div id="body">
		<div class="content-container clearfix">
			<!-- aside 부분 -->
			<aside id="aside">
				<!-- <h1>고객센터</h1>

			<nav>
				<h1>고객센터 메뉴</h1>
				<ul>
					<li><a href="notice.html">공지사항</a></li>
					<li><a href="">1:1 고객문의</a></li>
					<li><a href="">학습안내</a></li>
				</ul>
			</nav>

			<nav>
				<h1>추천사이트</h1>
				<ul>
					<li><a href="">엔서이즈</a></li>
					<li><a href="http://www.microsoft.com"><img
							src="/JSPPrj/images/microsoft.png" alt="마이크로소프트" /></a></li>
					<li><a href="http://www.w3c.org"><img
							src="/JSPPrj/images/w3c.png" alt="W3C" /></a></li>
				</ul>
			</nav>-->
			</aside>



			<!-- main 부분 -->
			<main> <!-- <h2>공지사항</h2>
		<div>
			<h3>경로</h3>
			<ol>
				<li>home</li>
				<li>고객센터</li>
				<li>공지사항</li>
			</ol>
		</div>

		<div>
			<form>
				<h3>공지 검색 폼</h3>
				<fieldset>
					<legend>검색 필드</legend>
					<label>검색분류</label> <select>
						<option>분류선택</option>
						<option value="제목">제목</option>
						<option value="작성자">작성자</option>
					</select> <label>검색입력란</label> <input type="text" /> <input type="submit"
						value="검색" />

				</fieldset>
			</form>
		</div>

		<div>
			<h3>테이블</h3>
			<table>"C:/Users/sss/Desktop/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/work/Catalina/localhost/JSPPrj/org/apache/jsp/customer/notice_jsp.java"
				<thead>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>10</td>
						<td>동해물과 백두산</td>
						<td>백두산</td>
						<td>2016-04-21</td>
						<td>987</td>
					</tr>
					<tr>
						<td>9</td>
						<td>마르고 닳도록</td>
						<td>그만먹어</td>
						<td>2016-04-21</td>
						<td>10</td>
					</tr>
				</tbody>

			</table>
		</div>-->
		
			<aside id="quick-menu">
				<h1>퀵메뉴</h1>
				<ul>
					<li>마이페이지</li>
					<li>강의실</li>
					<li>강의실</li>
					<li>강의실</li>
				</ul>
			</aside>

			</main>
		</div>
	</div>


	<!-- footer 부분 -->
	<footer id="footer">
		<div class="content-container">

			<!-- <h2>뉴렉처 정보</h2>
		<div>
			<h3>회사정보</h3>

			<dl>
				<dt>주소 :</dt>
				<dd>경기도 수원시 장안구 천천동 547-8번지 402호</dd>
				<dt>메일 :</dt>
				<dd>nku0691@hanmail.net</dd>
				<dt>전화번호 :</dt>
				<dd>010-4153-5724</dd>
			</dl>
		</div>

		<div>
			<h3>저작권 정보</h3>
			<p>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
				Contact admin@newlecture.com for more information</p>
		</div> -->
		</div>
	</footer>

</body>
</html>