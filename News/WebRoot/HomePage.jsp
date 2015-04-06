<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
    
    <title>News</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta charset="UTF-8"/>
    
    <link rel="stylesheet" type="text/css" href="style/jquery-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="style/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="style/global.css?201502051700" />
    <link type="text/css" href="style/base.css" rel="stylesheet" />
    <link type="text/css" href="style/Spacetree.css" rel="stylesheet" />

	<script language="javascript" type="text/javascript" src="scripts/jquery-2.1.1.js"></script>
    <script language="javascript" type="text/javascript" src="scripts/excanvas.js"></script>
    <script language="javascript" type="text/javascript" src="scripts/jit.js"></script>
    <script language="javascript" type="text/javascript" src="scripts/example1.js"></script>
    <script language="javascript" type="text/javascript" src="scripts/show.js"></script>
    <script language="javascript" type="text/javascript" src="scripts/input.js"></script>

    <link rel="stylesheet" type="text/css" href="style/toggle-switch.min.css" />
    <link rel="stylesheet" type="text/css" href="style/demo-news.css?201502051700" />
</head>
<body >

<div id="content-page">
    <div id="sub-navbar">
        <div class="container">
            <ul>
                <li  class="selected" ><a href="/demo">多文本演示</a><span></span></li>
                <li style="display: none"><a href="#">多文本演示</a><span></span></li>
            </ul>
        </div>
    </div>
    <div id="demo-page">
        <div id="demo-container" class="container">
            <div class="breadcrumb breadcrumb-bottom">
                <span>您现在的位置:</span>
                <a href="/">首页</a>
                <span class="html-char">&gt;</span>
                <span>演示</span>
                <span class="html-char">&gt;</span>
                <span>多文本演示</span>
            </div>
            <div class="input-chunk chunk" style="height:450px">
                <textarea id="txt" class="input">新闻1|!|埃及南部阿斯旺省13日发生一起3辆面包车连环相撞事故，造成至少30人死亡、15人受伤。|!|2014年10月13日 17:51:20|#|
新闻2|!|8月9日，西藏尼木县发生3车连环相撞事故，造成44人遇难，11人受伤。目前已确认 14 名出险人员在中国人寿寿险安徽、浙江、山东和上海四家分公司共计投保 |!|2014年08月13日 13:46:23|#|
新闻3|!|哈尔滨发生面包车与货车相撞事故 致8人当场死亡。|!|2014年08月13日 09:44:34|#|
新闻4|!|10月9日，在南丹县吾隘镇鸳鸯桥路段，一辆客运中巴车翻下路外10米深的河沟，造成1人当场死亡，另6名乘客受伤。 交警提示：山区道路弯道多，行车须注意控制车速，如果车速过快，一旦遭遇险情，不易控制车辆，容易发生事故。 |!|2014年10月13日 16:43:43|#|
新闻5|!|成都，一辆商务车行驶途中左侧车轮突然爆胎，车辆失控撞坏护栏，窜到另一车道，与迎面开来的一辆出租车刮擦。尾随商务车后的一辆轿车不慎撞上损坏的护栏，所幸并未造成人员伤亡。蜀黍提醒：中秋小长假即将到来，出发前记得给爱车做个体检！ |!|2014年09月16日 11:37:17|#|
新闻6|!|高速快报：蒲庙站内广场发生1辆小车与货车刮碰事故已处理完毕，现场车流已恢复正常通行。@100.3@广西交通广播 |!|2014年10月12日 19:41:54|#|
新闻7|!|10月12日，西宁市民王先生驾车行驶到昆仑桥时，前车上有人将垃圾抛出车窗外，造成连环相撞的事故。王先生说：“车辆在路上正常行驶时，如果随便往车窗外丢垃圾，很容易遮挡后车或同车道司机的视线，酿成事故。希望驾驶员文明驾驶，并约束车内乘客，严禁向车窗外抛杂物。” |!|2014年10月13日 10:13:56|#|</textarea>
                <form class="form-inline" role="form">
	                <div class="form-group" style="padding:2%">
	                	<label class="sr-only " for="name">名称</label>
	      				<input type="text" class="form-control" id="timelinessWeight" 
	         				placeholder="请输入时效性权重">
	         		</div>
	         		<div class="form-group" style="padding:2%">
	                	<label class="sr-only" for="name">名称</label>
	      				<input type="text" class="form-control" id="sensitivenessWeight" 
	         				placeholder="请输入敏感性权重">
	         		</div>
	         		<div class="form-group" style="padding:2%">
	                	<label class="sr-only" for="name">名称</label>
	      				<input type="text" class="form-control" id="clarityWeight" 
	         				placeholder="请输入清晰性权重">
	         		</div>
	         		<div class="form-group" style="padding:2%">
	                	<label class="sr-only" for="name">名称</label>
	      				<input type="text" class="form-control" id="consequenceWeight" 
	         				placeholder="请输入严重性权重">
	         		</div>
                </form>
                <span>以上四项分别代表，时效性，敏感性，清晰性，严重性四项内容在整个新闻价值排名中所占权重比例</br></span>
                <span>如果置空，则默认为：0.25，0.25，0.25，0.25</br></span>
                <span>如若更改，请保证每项取值范围为：0——1之间，同时，保证四项之和为1</br></span>
   			

   				
   				
   				
                <a id="btn" class="btn btn-arrow btn-radius" ><span class="icon"></span>提交文本</a>
                <div class="warn-msg hide">
                    <span class="icon"></span>
                    <span class="txt">目前仅支持GBK字符集。分析结果已过滤暂不支持的语言或字符。</span>
                </div>
            </div>
            <div class="main-title">
                <span class="dot-line-gray"></span>
                <span class="title-new">分析结果</span>
            </div>
            <div class="demo-content">
                <div id="sideBar" class="col-xs-3 bs-sidebar" width="100%" role="complementary">
                    <div class="chunk bs-sidebar-chunk">
                      <ul class="nav">
                        <li class=" analysis">
                            <a class="hide" href="#overview-analysis"></a>
                            <div class="arrow"></div>
                            <div class="title">
                                <a href="#overview-analysis"><span class="icon"></span>价值排名</a>
                                
                            </div>
                            <div class="line"></div>

                        </li>
                        <li class=" ner">
                            <a class="hide" href="#overview-ner"></a>
                            <div class="arrow"></div>
                            <div class="title">
                                <a href="#overview-ner"><span class="icon"></span>词性分析</a>
                            </div>
                            <div class="line"></div>
                        </li>
                        <li class=" depend">
                            <a class="hide" href="#overview-depend"></a>
                            <div class="arrow"></div>
                            <div class="title">
                                <a href="#overview-depend"><span class="icon"></span>命名实体抽取</a>
                            </div>
                            <div class="line"></div>
                        </li>
                        <li class=" emotion">
                            <a class="hide" href="#overview-emotion"></a>
                            <div class="arrow"></div>
                            <div class="title">
                                <a href="#overview-emotion"><span class="icon"></span>敏感词抽取</a>
                            </div>
                            <div class="line"></div>
                        </li>
                        <li class=" info">
					    	<a class="hide" href="#overview-info"></a>
					    	<div class="arrow"></div>
					    	<div class="title">
					    		<a href="#overview-info"><span class="icon"></span>事故信息抽取</a>
					    	</div>
					    	<div class="line"></div>
					    </li>

                      </ul>
                    </div>
                </div>
                <div class="col-xs-9 main-content" role="main">
                    <div id="overview-analysis" class="chunk">
                        <div class="col-xs-12">
                            <div class="title-new">价值排名:
                            	<div class="switch-wrap switch-toggle switch-candy switch-5">
                                	<input id="rd-c1" name="viewner" value="1" type="radio">
                                	<label for="rd-c1">时效性</label>
                                	<input id="rd-c2" name="viewner" value="2" type="radio">
                                	<label for="rd-c2">敏感性</label>
                                	<input id="rd-c3" name="viewner" value="3" type="radio" checked="">
                                	<label for="rd-c3">价值</label>
                                	<input id="rd-c4" name="viewner" value="4" type="radio">
                                	<label for="rd-c4">清晰性</label>
                                	<input id="rd-c5" name="viewner" value="5" type="radio">
                                	<label for="rd-c5" class="last-label">严重性</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-12">
                            <table class="table" style="background-color: #f6f6f6;">
                                <caption id="rankname" style="font-size: 1.5em;margin-bottom: 2%">新闻价值排行榜</caption>
                                <thead>
                                <tr>
                                    <th>新闻</th>
                                    <th  id ="factor">价值指数</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr id="rank1" >
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">
                                        <span style="background-color: #f54545;color: #fff;padding: 1%">1</span>
                                        <a href="#">新闻example1</a>
                                    </td>
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">100</td>
                                </tr>
                                <tr id="rank2" >
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">
                                        <span style="background-color: #ff8547;color: #fff;padding: 1%">2</span>
                                        <a href="#">新闻example2</a>
                                    </td>
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">97</td>
                                </tr>
                                <tr id="rank3" >
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">
                                        <span style="background-color: #ffac38;color: #fff;padding: 1%">3</span>
                                        <a href="#">新闻example3</a>
                                    </td>
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">76</td>
                                </tr  >
                                <tr id="rank4">
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">
                                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">4</span>
                                        <a href="#">新闻example4</a>
                                    </td>
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">69</td>
                                </tr>
                                <tr id="rank5" >
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">
                                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">5</span>
                                        <a href="#">新闻example5</a>
                                    </td>
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">64</td>
                                </tr>
                                <tr id="rank6" >
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">
                                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">6</span>
                                        <a href="#">新闻example6</a>
                                    </td>
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">56</td>
                                </tr  >
                                <tr id="rank7">
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">
                                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">7</span>
                                        <a href="#">新闻example7</a>
                                    </td>
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">54</td>
                                </tr>
                                <tr id="rank8" >
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">
                                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">8</span>
                                        <a href="#">新闻example8</a>
                                    </td>
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">51</td>
                                </tr >
                                <tr id="rank9" >
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">
                                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">9</span>
                                        <a href="#">新闻example9</a>
                                    </td>
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">45</td>
                                </tr>
                                <tr id="rank10" >
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">
                                        <span style="background-color: #8eb9f5;color: #fff;padding: 1%">10</span>
                                        <a href="#">新闻example10</a>
                                    </td>
                                    <td style="border-left-color: #f6f6f6;border-right-color: #f6f6f6;text-align: left">32</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="loading"></div>

                    </div>

                    <div id="overview-ner" class="chunk">
                        <div class="col-xs-12">
                            <div class="title-new">词性分析:</div>
                        </div>
                        <div id="colorWord" class="col-xs-9">
                         
                        </div>
                        <div class="col-xs-3">
                            <dl class="word-mean">
                            	<dt>词性类别图示:</dt>
                            	<dd class="y">标点符号</dd>
                            	<dd class="v">动词</dd>
                            	<dd class="n">名词</dd>
                            	<dd class="p">介词</dd>
                            	<dd class="a">形容词</dd>
                            	<dd class="d">副词</dd>
                            	<dd class="r">代词</dd>
                            	<dd class="m">数词</dd>
                            	<dd class="s">处所词</dd>
                            	<dd class="f">方位词</dd>
                            	
                            
                            </dl>
                        </div>
                        <div class="loading"></div>

                    </div>

                    <div id="overview-depend" class="chunk">
                        <div class="title-new">命名实体抽取:</div>
                        <div id="colorNerWord" class="col-xs-9">
                         
                        </div>
                        <div class="col-xs-3">
                            <dl class="word-mean">
                            	<dt>命名实体类别图示:</dt>
                            	
                            	<dd class="n">地点</dd>
                            	
                            	
                            
                            </dl>
                        </div>
                        <div class="loading"></div>

                    </div>
                    
                    <div id="overview-emotion" class="chunk">
                        <div class="title-new">敏感词抽取:</div>
                        <div id="colorSenWord" class="col-xs-9">
                         
                        </div>
                        <div class="col-xs-3">
                            <dl class="word-mean">
                            	<dt>敏感程度级别图示:</dt>
                            	<dd class="w">0</dd>
                            	<dd class="n">1</dd>
                            	<dd class="v">1.5</dd>
                            	<dd class="a">2</dd>
                            	<dd class="d">2.5</dd>
                            	<dd class="m">3</dd>
                            	<dd class="p">3.5</dd>
                            	<dd class="f">4</dd>
                            	
                            	
                            
                            </dl>
                        </div>
                        <div class="loading"></div>

                    </div>

                    <div id="overview-info" class="chunk">
                        <div class="title-new">事故信息抽取:</div>
                        <div class="row">
                            <div id="container">
                                <div id="center-container">
                                    <div id="infovis"></div>
                                </div>
                                <div id="right-container" style="display: none">
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
                        </div>
                        <span class="loading"></span>

                    </div>

                </div>
            </div>
        </div>
        <div id="btn-back-top">
            <span class="icon"></span>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="scripts/require.min.js"></script>
<script type="text/javascript" src="scripts/require.config.js"></script>
<script>
	require(['demo'], function () {});
</script>
<script>
	
</script>
