<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#testJson").click(function(){
			//通过ajax请求springmvc
			$.post(
				"handler/testJson",//服务器地址	
				{"name":"zs"},//{"name":"zs",age:"22"}//带参数的写法
				function(result){//服务端处理完毕后返回的回调函数
					for(var i=0;i<result.length;++i){
						alert(result[i].id+"-"+result[i].name+"-"+result[i].age);
					} 
				}
			);
		});
	});
</script>
<body>
	<input type="button" value="testJson" id="testJson">

	<a href="handler/welcome">first handler</a><br>	
	<a href="handler/welcome3/xyz/abcz/asb/test">33333333get - welcome</a>
	<br/>
	<a href="handler/welcome4/xyz/abcz44444/asb/test">444444get - welcome</a>
	<br/>
	<a href="handler/welcome5/axb/test">5555get - welcome</a>
	<br/>
	
	<form action="handler/welcome" method="post">
		name:<input type="text" name="name">
		age:<input type="text" name="age">
		<input type="submit" value="post" >
	</form>
	
	<form action="handler/testPost/1234" method="post">
		<input type="submit" value="增">
	</form>
	
	<form action="handler/testDelete/1234" method="post">
		<input type="hidden"  name="_method" value="DELETE"/>
		<input type="submit" value="删">
	</form>
	
		<form action="handler/testPut/1234" method="post">
			<input type="hidden"  name="_method" value="PUT"/>
		<input type="submit" value="改">
	</form>
	
	<form action="handler/testGet/1234" method="get">
		<input type="submit" value="查">
	</form>
	------------<br/>
	<form action="handler/testParam">
		name:<input name="uname" type="text" />
		age:<input name="uage" type="text" />
		<input type="submit" value="查">
	</form>
	<br/>
	<a href="handler/testRequestHeader">testRequestHeader</a>
	<a href="handler/testCookieValue">testCookieValue</a>
	
	<form action="handler/testObjectProperties" method="post">
		id:<input name="id" type="text">
		name:<input name="name" type="text">
		homeAddress:<input name="address.homeAddress" type="text">
		schoolAddress:<input name="address.schoolAddress" type="text">
		<input type="submit" value="提交">
	</form>
	<br><hr>
	<a href="handler/testModelAndView">testModelAndView</a><br>
	<a href="handler/testModelMap">testModelMap</a><br/>
	<a href="handler/testMap">testMap</a><br/>
	<a href="handler/testModel">testModel</a><br/>
	<form action="handler/testModelAttribute" method="post">
		编号:<input name="id" type="hidden" value="31" />
		姓名:<input name="name" type="text" />
		<input type="submit" value="修改">
	</form>
	
	<br/>
		<a href="handler/testMvcViewController">testMvcViewController</a>
	<br/>
	<form action="handler/testConverter" method="post">
		学生信息:<input name="studentInfo" type="text" />
		<input type="submit" value="提交">
	</form><br>
	
	<form action="handler/testDateTimeFormat" method="post">
		编号:<input name="id" type="text" value="31" />
		姓名:<input name="name" type="text" />
		出生日期:<input name="time" type="text" />
		<input type="submit" value="提交">
	</form>
	
	<form action="handler/testUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		描述：<input type="text" name="desc">
		
		<input type="submit" value="上传">
	</form>
	
	<a href="second/testExceptionHandler">testExceptionHandler</a>
</body>
</html>