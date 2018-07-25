<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <meta http-equiv="X-UA-Compatible" content="ie=edge" />
 <title>游客界面</title>

<link href="/css/userindex.css" type="text/css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
<script type="text/javascript" src="/js/tourist.js"></script>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
</head>
<body>
	<iframe src="/tourist/banner.jsp" width="100%" height="50px" frameborder="0"></iframe>
	<div class="container" id="myCarousel">
		
	 <div id="carouselMenu" class="carousel slide">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#carouselMenu" data-slide-to="0" class="active"></li>
		<li data-target="#carouselMenu" data-slide-to="1"></li>
		<li data-target="#carouselMenu" data-slide-to="2"></li>
	</ol>   
	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		<div class="item active">
			<img src="/img/luo.jpg" alt="First slide">
			<div class="carousel-caption" id="biaoqian">  
                        <h1>新的管理方式</h1>
                        <p>科技的每一次进步,都会推动公平一步</p>  
                        <a id="anniu" href="#" class="btn btn-default" role="button"> <span class="glyphicon glyphicon-plus"></span> 点我上船</a> 
                        <a id="anniu" href="#" class="btn btn-default" role="button"> <span class="glyphicon glyphicon-film"></span> 观看完整视频</a>
                    </div>
			  </div>
		<div class="item">
			<img src="/img/aisi.jpg" alt="Second slide">
			<div class="carousel-caption" id="biaoqian">  
                        <h1>船船管理</h1>
                        <p>帮助各个船长管理员工</p>  <p>
                        <a id="anniu" href="#" class="btn btn-default" role="button">查看详情<span class="glyphicon glyphicon-chevron-right"></span> </a> 
                        <a id="anniu" href="#" class="btn btn-default" role="button"> <span class="glyphicon glyphicon-link"></span>船长加盟</a>
                    </div>
			  </div>
		<div class="item">
			<img src="/img/tongji.jpg" alt="Third slide">
			<div class="carousel-caption" id="biaoqian">  
                        <h1>船员登录</h1>
                        <p>方便快捷查询</p>  <p>
                        <a id="anniu" href="#" class="btn btn-default" role="button">查看详情<span class="glyphicon glyphicon-chevron-right"></span> </a> 
                        <a id="anniu" href="#" class="btn btn-default" role="button"> <span class="glyphicon glyphicon-phone"></span>投递简历</a>
                    </div>
		</div>
		
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="carousel-control left" href="#carouselMenu" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a>
	<a class="carousel-control right" href="#carouselMenu" role="button" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
	</div> 
	</div>
	<!-- 招聘信息 -->
	
</body>
</html>