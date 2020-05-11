<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="UTF-8">
    <title>欢迎进入研究生招生系统</title>
    <style>
    html, body {padding:0; margin:0;}
    body {font:12px/normal Verdana, Arial, Helvetica, sans-serif;}
    *{
	    text-decoration: none;
	    list-style: none;
		}
		#wrap{
		    margin:0px auto;
		    background:#a1e0ba69;;
		    background-size:100% 100%;
		}
    	#content #signup a:hover{
		    text-decoration: underline;
		}
		#content{
		    width:1333px;
		    height:650px;
		}
		#content #signup{
		    width:30%;
		    float:left;
		}
		#signup p{
		    border-left:2px solid #61ff60;
		    font:22px 楷体;
		    font-weight: bold;
		}
		#signup a{
		    color:gray;
		    font:17px 楷体
		}
		#content #information{
		    float:left;
		    width:40%;
		    font-size:16px;
		}
		#information #transpic{
		    position: relative;
		    margin:10px -50px;
		    width:530px;
		    height:330px;
		    overflow: hidden;
		}
		#transpic img{
		    width:100%;
		    height:100%;
		}
		#transpic ul{
		    position: absolute;
		    top:88%;
		    left:50%;
		    margin-left:30px;
		
		}
		#transpic ul li{
		    width:10px;
		    height:10px;
		    border:1px solid #fff;
		    border-radius:50%;
		    background: gray;
		    float:left;
		    margin-left:15px;
		    cursor:pointer;
		}
		#transpic .active{
		    background: deepskyblue;
		}
		#information p,#hotspot p{
		    border-left:2px solid #61ff60;
		    font:25px 华文宋体;
		    font-weight: bold;
		}
		#information li{
		    margin-left: -30px;
		    list-style: disc inside;
		    color: gray;
		    width:500px;
		    white-space:nowrap;
		    overflow: hidden;
		    text-overflow:ellipsis;
		}
		#information a,#hotspot a{
		    color:black;
		}
		#information a:hover,#hotspot #date a:hover,#hotspot #tool a:hover{
		    text-decoration: underline;
		}
		#content #hotspot{
		    float:left;
		    width:30%;
		}
		#hotspot #date li{
		    margin-left:-30px;
		
		}
		#hotspot #hot tr td{
		    background: #dddddd;
		    padding:2px;
		}
		#hotspot #hot tr td:hover{
		    background: rgba(37, 255, 44, 0.3);
		}
		#hotspot #tool span{
		    float:left;
		    display:inline-block;
		    margin-left:-30px;
		    width:28px;
		    line-height: 30px;
		    text-align: center;
		    color:white;
		    background:rgba(30, 255, 97, 0.66);
		}
		
		#hotspot #tool li table{
		    padding: 8px;
		}
		
    </style>
</head>
<body>
<div id="wrap">
    <div id="content">
        <div id="signup">
            <ul>
                <li>
                    <p>报名入口</p>
                    <a href="">硕士统考</a>
                    <a href="">推荐免试</a>
                </li>
                <li>
                    <p>录取公示</p>
                    <a href="">全国硕士信息招生平台</a><br>
                    <a href="">推免录取信息公开</a>
                </li>
                <li>
                    <p>诚信考试</p>
                    <a href="">国家教育考试违规处理办法</a><br>
                    <a href="">普通高等学校招生违规处理办法</a>
                </li>
                <li>
                    <p>学习形式</p>
                    <a href="">全日制</a>
                    <a href="">非全日制</a>

                </li>
                <li>
                    <p>考试方式</p>
                    <a href="">全国统一考试</a>
                    <a href="">推荐免试</a>
                </li>
                <li>
                    <p>参考书籍</p>
                    <a href="/PostGraduate/JSP/bookOrder.jsp"  target="contentFrame">政治</a>
                    <a href="/PostGraduate/JSP/bookOrder.jsp"  target="contentFrame">英语</a>
                    <a href="/PostGraduate/JSP/bookOrder.jsp"  target="contentFrame">数学</a>
                    <a href="/PostGraduate/JSP/bookOrder.jsp"  target="contentFrame">专业</a>
                </li>
            </ul>
        </div>
        <div id="information">
            <div id="transpic">
                <img src="/PostGraduate/Images/homepage_1.jpg" alt="">
                <ul>
                    <li class="active"></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
            <div>
                <p>院校政策</p>
                <ul id="college">
                    <li><a href="">欢迎报考山东财经大学</a></li>
                    <li><a href="">清华大学硕士研究生招生简章及招生专业目录</a></li>
                    <li><a href="">浙江大学2019年专业学位硕士研究生招生</a></li>
                </ul>
                <p>国家政策</p>
                <ul id="country">
                    <li><a href="">2019年全国硕士研究生招生公告</a></li>
                    <li><a href="">教育部关于印发《2019年全国硕士研究生招生工作管理规定》的通知</a></li>
                    <li><a href="">教育部办公厅关于下达2019年少数民族高层次骨干人才研究生招生计划的通知</a></li>
                </ul>

            </div>

        </div>
        <div id="hotspot">
            <p>考研日程</p>
            <ul id="date">
                <li><a href="">现场确认：时间由各省招办安排</a></li>
                <li><a href="">初试：时间从2018年12月22日至12月24日</a></li>
                <li><a href="">2014-2018考研分数线趋势图</a></li>
            </ul>
            <p>考研热点</p>
            <table id="hot">
                <tr>
                    <td><a href="/PostGraduate/JSP/show985_211.jsp"  target="contentFrame">211、985院校</a></td>
                    <td><a href="">全国科研院所</a></td></tr>
                <tr>
                    <td><a href="">MBA专栏</a></td>
                    <td><a href="">澳门高校研究生招生</a></td></tr>
                <tr>
                    <td><a href="">山东省招生单位</a></td>
                    <td><a href="">河北省招生单位</a></td>
                </tr>
            </table>
            <p>考研工具箱</p>
            <ul id="tool">
                <span>查询</span>
                <li>
                    <table>
                        <tr>
                            <td><a href="/PostGraduate/JSP/showCollege.jsp"  target="contentFrame">院校库</a></td>
                            <td><a href="/PostGraduate/JSP/showMajor.jsp"  target="contentFrame">专业库</a></td></tr>
                        <tr>
                            <td><a href="">硕士目录</a></td>
                            <td><a href="">帮助中心</a></td></tr>
                    </table>
                </li>
                <span>统考</span>
                <li>
                    <table>
                        <tr>
                            <td><a href="">报名条件</a></td>
                            <td><a href="">网上报名</a></td></tr>
                        <tr>
                            <td><a href="">现场确认</a></td>
                            <td><a href="">分数线</a></td></tr>
                    </table>
                </li>
                <span>推免</span>
                <li>
                    <table>
                        <tr>
                            <td><a href="">推荐条件</a></td>
                            <td><a href="">申请指南</a></td></tr>
                        <tr>
                            <td><a href="">推免流程</a></td>
                            <td><a href="">填报志愿</a></td></tr>
                    </table>
                </li>
            </ul>
        </div>
    </div>
</div>
<script src="/PostGraduate/JS/homepage.js"></script>
</body>
</html>
