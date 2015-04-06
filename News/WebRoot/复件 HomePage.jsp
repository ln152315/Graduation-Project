<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
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
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="style/left.css" rel="stylesheet">
    <link type="text/css" href="style/base.css" rel="stylesheet" />
    <link type="text/css" href="style/Spacetree.css" rel="stylesheet" />

    <script language="javascript" type="text/javascript" src="scripts/excanvas.js"></script><![endif]-->
    <script language="javascript" type="text/javascript" src="scripts/jit.js"></script>
    <script language="javascript" type="text/javascript" src="scripts/example1.js"></script>
    <script type="text/javascript" src="scripts/jquery-2.1.1.js"></script>
    <script type="text/javascript" src="scripts/input.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>

  </head>
<body data-spy="scroll" data-target="#myScrollspy" ">

<div class="container" >
    <div class="row">
        <div class="col-xs-3" id="myScrollspy">
            <ul class="nav nav-tabs nav-stacked" data-spy="affix">
                <li class="active"><a href="#section-1">信息输入</a></li>
                <li><a href="#section-2">数据预处理</a></li>
                <li><a href="#section-3">信息抽取</a></li>
                <li><a href="#section-4">新闻价值排名</a></li>
                <li><a href="#section-5">第五部分</a></li>
            </ul>
        </div>
        <div class="col-xs-9">
            <h2 id="section-1">信息输入</h2>
            <div id="result"></div>
            <form class="form-inline" role="form" >
                <div class="form-group">
                    <label for="lastname" class="col-md-3 control-label">输入新闻</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" id="news"
                               placeholder="请输入新闻">
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-3 col-md-9">
                            <button id="btn" type="submit" class="btn btn-default">提交</button>
                        </div>
                    </div>
                </div>

            </form>
            <h2 id="section-2">数据预处理</h2>
            
            <hr>
            <h2 id="section-3">信息抽取</h2>
            <div id="container">
                <div id="center-container">
                    <div id="infovis"></div>
                </div>
                <div id="right-container">
                    <h4>Tree Orientation</h4>
                    <table>
                        <tr>
                            <td>
                                <label for="r-left">Left </label>
                            </td>
                            <td>
                                <input type="radio" id="r-left" name="orientation" checked="checked" value="left" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="r-top">Top </label>
                            </td>
                            <td>
                                <input type="radio" id="r-top" name="orientation" value="top" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="r-bottom">Bottom </label>
                            </td>
                            <td>
                                <input type="radio" id="r-bottom" name="orientation" value="bottom" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="r-right">Right </label>
                            </td>
                            <td>
                                <input type="radio" id="r-right" name="orientation" value="right" />
                            </td>
                        </tr>
                    </table>
                    <h4>Selection Mode</h4>
                    <table>
                        <tr>
                            <td>
                                <label for="s-normal">Normal </label>
                            </td>
                            <td>
                                <input type="radio" id="s-normal" name="selection" checked="checked" value="normal" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="s-root">Set as Root </label>
                            </td>
                            <td>
                                <input type="radio" id="s-root" name="selection" value="root" />
                            </td>
                        </tr>
                    </table>
                </div>
                <div id="log"></div>
            </div>
            <hr>
            <h2 id="section-4">新闻价值排名</h2>
            <table class="table">
                <caption>新闻价值排行榜</caption>
                <thead>
                <tr>
                    <th>新闻</th>
                    <th>价值指数</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <span style="background-color: #f54545;color: #fff;padding: 1%">1</span>
                        <a href="#">Tanmay</a>
                    </td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>
                        <span style="background-color: #ff8547;color: #fff;padding: 1%">2</span>
                        <a href="#">Tanmay</a>
                    </td>
                    <td>97</td>
                </tr>
                <tr>
                    <td>
                        <span style="background-color: #ffac38;color: #fff;padding: 1%">3</span>
                        <a href="#">Tanmay</a>
                    </td>
                    <td>76</td>
                </tr>
                <tr>
                    <td>
                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">4</span>
                        <a href="#">Tanmay</a>
                    </td>
                    <td>54</td>
                </tr>
                <tr>
                    <td>
                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">5</span>
                        <a href="#">Tanmay</a>
                    </td>
                    <td>54</td>
                </tr>
                <tr>
                    <td>
                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">6</span>
                        <a href="#">Tanmay</a>
                    </td>
                    <td>54</td>
                </tr>
                <tr>
                    <td>
                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">7</span>
                        <a href="#">Tanmay</a>
                    </td>
                    <td>54</td>
                </tr>
                <tr>
                    <td>
                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">8</span>
                        <a href="#">Tanmay</a>
                    </td>
                    <td>54</td>
                </tr>
                <tr>
                    <td>
                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">9</span>
                        <a href="#">Tanmay</a>
                    </td>
                    <td>54</td>
                </tr>
                <tr>
                    <td>
                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">10</span>
                        <a href="#">Tanmay</a>
                    </td>
                    <td>54</td>
                </tr>
                </tbody>
            </table>
            <hr>
            <h2 id="section-5">第五部分</h2>
            <p>Nam eget purus nec est consectetur vehicula. Nullam ultrices nisl risus, in viverra libero egestas sit amet. Etiam porttitor dolor non eros pulvinar malesuada. Vestibulum sit amet est mollis nulla tempus aliquet. Praesent luctus hendrerit arcu non laoreet. Morbi consequat placerat magna, ac ornare odio sagittis sed. Donec vitae ullamcorper purus. Vivamus non metus ac justo porta volutpat.</p>
            <p>Vivamus mattis accumsan erat, vel convallis risus pretium nec. Integer nunc nulla, viverra ut sem non, scelerisque vehicula arcu. Fusce bibendum convallis augue sit amet lobortis. Cras porta urna turpis, sodales lobortis purus adipiscing id. Maecenas ullamcorper, turpis suscipit pellentesque fringilla, massa lacus pulvinar mi, nec dignissim velit arcu eget purus. Nam at dapibus tellus, eget euismod nisl. Ut eget venenatis sapien. Vivamus vulputate varius mauris, vel varius nisl facilisis ac. Nulla aliquet justo a nibh ornare, eu congue neque rutrum.</p>
            <p>Suspendisse a orci facilisis, dignissim tortor vitae, ultrices mi. Vestibulum a iaculis lacus. Phasellus vitae convallis ligula, nec volutpat tellus. Vivamus scelerisque mollis nisl, nec vehicula elit egestas a. Sed luctus metus id mi gravida, faucibus convallis neque pretium. Maecenas quis sapien ut leo fringilla tempor vitae sit amet leo. Donec imperdiet tempus placerat. Pellentesque pulvinar ultrices nunc sed ultrices. Morbi vel mi pretium, fermentum lacus et, viverra tellus. Phasellus sodales libero nec dui convallis, sit amet fermentum sapien auctor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed eu elementum nibh, quis varius libero.</p>
            <p>Morbi sed fermentum ipsum. Morbi a orci vulputate tortor ornare blandit a quis orci. Donec aliquam sodales gravida. In ut ullamcorper nisi, ac pretium velit. Vestibulum vitae lectus volutpat, consequat lorem sit amet, pulvinar tellus. In tincidunt vel leo eget pulvinar. Curabitur a eros non lacus malesuada aliquam. Praesent et tempus odio. Integer a quam nunc. In hac habitasse platea dictumst. Aliquam porta nibh nulla, et mattis turpis placerat eget. Pellentesque dui diam, pellentesque vel gravida id, accumsan eu magna. Sed a semper arcu, ut dignissim leo.</p>
            <p>Sed vitae lobortis diam, id molestie magna. Aliquam consequat ipsum quis est dictum ultrices. Aenean nibh velit, fringilla in diam id, blandit hendrerit lacus. Donec vehicula rutrum tellus eget fermentum. Pellentesque ac erat et arcu ornare tincidunt. Aliquam erat volutpat. Vivamus lobortis urna quis gravida semper. In condimentum, est a faucibus luctus, mi dolor cursus mi, id vehicula arcu risus a nibh. Pellentesque blandit sapien lacus, vel vehicula nunc feugiat sit amet.</p>
        </div>
    </div>
</div>


</body>
</html>
