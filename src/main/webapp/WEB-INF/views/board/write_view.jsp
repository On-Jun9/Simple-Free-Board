<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Table V04</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="resources/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">글쓰기</th>
									<th class="cell100 column2"></th>
									<th class="cell100 column3"></th>
									<th class="cell100 column5"></th>
								</tr>
							</thead>
						</table>
					</div>
					
					
					
					<div class="table100-body js-pscroll">
					<form action="write" method="post" id="input">
						<table>
							<tbody>
								<tr class="row100 body">
									<td class="cell100 column1">제목</td>
								</tr>
								<tr class="row100 body">
									<td class="cell100 column1"><input type="text" name="b_subject" size = "60"></td>
								</tr>
								<tr class="row100 body">
									<td class="cell100 column1">작성자</td>
								</tr>
								<tr class="row100 body">
									<td class="cell100 column1"><input type="text" name="b_name" size = "60"></td>
								</tr>
								<tr class="row100 body">
									<td class="cell100 column1">내용</td>
								</tr>
								<tr class="row100 body">									
									<td class="cell100 column1"><textarea name="b_content" rows="10" style="width: 1000px"></textarea></td>
								</tr>
								<tr class="row100 body">									
									<td class="cell100 column1"><a href="#" onclick="document.getElementById('input').submit();">작성</a></td>
								</tr>
								<tr class="row100 body">
									<td class="cell100 colomn1"><a href="list">목록보기</a></td>
								</tr>
							</tbody>
						</table>
					</form>
					
					</div>
				</div>
			</div>
		</div>
	</div>


<!--===============================================================================================-->	
	<script src="resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/vendor/bootstrap/js/popper.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="resources/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			var ps = new PerfectScrollbar(this);

			$(window).on('resize', function(){
				ps.update();
			})
		});
			
		
	</script>
<!--===============================================================================================-->
	<script src="resources/js/main.js"></script>

</body>
</html>
