<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'HomePage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel=stylesheet type=text/css href="bootstrap/css/bootstrap.min.css" >

    <script type="text/javascript" src="jquery/jquery-2.1.1.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

  </head>
  
  <body>
	  <div class="navbar navbar-inverse navbar-fixed-top">
	    <div class="container">
	        <div class="navbar-header">
	            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
	                <span class="sr-only">Toggle navigation</span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	            </button>
	            <a class="navbar-brand hidden-sm" href="http://www.bootcss.com">Bootstrap中文网</a>
	        </div>
	        <div class="navbar-collapse collapse" role="navigation">
	            <ul class="nav navbar-nav">
	                <li class="dropdown">
	                    <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">Bootstrap2中文文档<b class="caret"></b></a>
	                    <ul class="dropdown-menu">
	                        <li>
	                            <a href="http://v2.bootcss.com/getting-started.html" target="_blank">起步</a>
	                        </li>
	                        <li>
	                            <a href="http://v2.bootcss.com/scaffolding.html" target="_blank">脚手架</a>
	                        </li>
	                        <li>
	                            <a href="http://v2.bootcss.com/base-css.html" target="_blank">基本CSS样式</a>
	                        </li>
	                        <li>
	                            <a href="http://v2.bootcss.com/components.html" target="_blank">组件</a>
	                        </li>
	                        <li>
	                            <a href="http://v2.bootcss.com/javascript.html" target="_blank">JavaScript插件</a>
	                        </li>
	                        <li>
	                            <a href="http://v2.bootcss.com/customize.html" target="_blank">定制</a>
	                        </li>
	                    </ul>
	                </li>
	                <li class="dropdown">
	                    <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">Bootstrap3中文文档<b class="caret"></b></a>
	                    <ul class="dropdown-menu">
	                        <li>
	                            <a href="http://v3.bootcss.com/getting-started/" target="_blank">起步</a>
	                        </li>
	                        <li>
	                            <a href="http://v3.bootcss.com/css/" target="_blank">CSS</a>
	                        </li>
	                        <li>
	                            <a href="http://v3.bootcss.com/components/" target="_blank">组件</a>
	                        </li>
	                        <li>
	                            <a href="http://v3.bootcss.com/javascript/" target="_blank">JavaScript插件</a>
	                        </li>
	                        <li>
	                            <a href="http://v3.bootcss.com/customize/" target="_blank">定制</a>
	                        </li>
	                    </ul>
	                </li>
	                <li><a href="/p/lesscss/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'less'])">Less 教程</a></li>
	                <li><a href="http://jquery.bootcss.com/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'jquery'])">jQuery API</a></li>
	                <li><a href="http://expo.bootcss.com" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'expo'])">网站实例</a></li>
	                <li><a href="http://job.bootcss.com" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'job'])">高薪工作</a></li>
	            </ul>
	            <ul class="nav navbar-nav navbar-right hidden-sm">
	                <li><a href="/about/" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'about'])">关于</a></li>
	            </ul>
	        </div>
	    	<div class="well row " style="background-color: #ffffff">
	    		<p style="font-size: 1.5em;font-family: '黑体';font-weight: 900">申请报名</p>
	    		<form class="form-horizontal" role="form">
	    			<div class="form-group">
	    				<label for="lastname" class="col-md-3 control-label">备注/Remark</label>
                        <div class="col-md-8">
                        	<textarea class="form-control" rows="8" placeholder="备注..."></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                    	<div class="col-md-offset-8 col-md-10" style="margin-top: 2%">
                    		<button type="submit" class=" btn-inverse" style="">确认报名/Submit</button>
                        </div>
                    </div>
               </form>
            </div>
	    </div>
	</div>
  </body>
</html>
