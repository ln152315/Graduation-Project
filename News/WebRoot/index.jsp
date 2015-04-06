<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>My JSP 'index.jsp' starting page</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <script type="text/javascript" src="scripts/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="scripts/input.js"></script>
        <!--     <s:head theme="ajax" />这句话好像没影响哦    -->
        <!-- <s:head theme="ajax" />-->
        <!--在jsp页面上加入<s:head theme="ajax" />会报如下异常：java.io.FileNotFoundException: 
            Template /template/ajax/head.ftl not found.     
              解决办法：在struts2-core-2.1.8.jar/template目录下加入ajax文件夹，ajax文件夹所在目录为
            struts2-core-2.1.8.jar/template/archive。
              注意：ajax文件夹下要包含head.ftl，否则还是会抛异常。head.ftl请在template目录搜索然后放到ajax文件夹里
         -->
    </head>

    <body>
        <!-- 显示User实体对象 -->
        <div id="result"></div>
        <s:form name="userForm" action="/jsonAction.do" method="post">
            编号：<input name="user.id"/><br/>
            用户名：<input name="user.username"/><br/>
            密码：<input name="user.pwd"/><br/><br/>
            <input id="btn" type="button" value=" 提 交 "/>
        </s:form>

    </body>
</html>