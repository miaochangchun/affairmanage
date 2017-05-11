<%@ page import="com.miao.bean.Employee" %><%--
  Created by IntelliJ IDEA.
  User: 10048
  Date: 2017/5/9
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>企业日常事务管理系统-发布新消息</title>
    <link href="css.css" type="text/css" rel="stylesheet" media="all" />
    <link href="css/channel.css" type="text/css" rel="stylesheet" media="all" />
    <script src="menu.js" type="text/javascript"></script>
</head>

<body>
<div id="topexplain">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
<div id="topmenu"><img src="images/banner.jpg" width="970" height="147" /></div>
<div id="bookmunu">
    <div class="jsmenu" id="jsmenu">
        <ul>
            <li class="normal"><a href="index.jsp" urn="jsmenu1"  rel="conmenu">首页</a></li>
            <li class="normal"><a urn="jsmenu2" rel="conmenu" href="GetMessageList">消息列表</a></li>
            <li class="active"><a urn="#default_Info" rel="conmenu" href="publishNewMsg.jsp">发布新消息</a></li>
            <li class="normal"><a urn="jsmenu3" rel="conmenu" href="statusRecognise.jsp">身份识别</a></li>
        </ul>
    </div>
    <div id="conmenu"></div>
</div>
    <div id="place">当前位置：[<a href="index.jsp">首页</a>] - [发布新消息]</div>
    <div id="channelcont">
        <div id="channelleft">
            <div class="channelinleft">
                <div id="messageBox">
                    <p>
                        <%--<font color="red">${requestScope.error}</font>--%>
                        <%
                            Employee employee = (Employee) request.getSession().getAttribute("employee");
                            if (employee == null) {
                        %>
                    <h4><font color="red" align="center">发布消息之前必须登录！</font></h4>
                        <%
                            }
                            String error = (String) request.getSession().getAttribute("error");
                            if (error != null) {
                        %>
                            <font color="red">error</font>
                        <%
                            }
                        %>
                    </p>
                    <form action="MsgPublish" method="post">
                        <p>消息标题：
                            <input type="text" name="title" size="50"/>
                        </p>
                        <p>消息内容：</p>
                        <p>
                            <FCK:editor instanceName="content" basePath="/fckeditor" height="400" width="750"></FCK:editor>
                        </p>
                        <p align="center">
                            <input type="submit" value="提交" />
                            <input type="reset" value="重置" />
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="copyright"><ul><li></li>
        <li>企业日常事务管理系统 &nbsp;&copy;2009-2010</li>
    </ul>
    </div>
    <div class="end"></div>
</body>
</html>
