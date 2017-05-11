<%@ page import="com.miao.bean.Message" %>
<%@ page import="com.miao.bean.Criticism" %>
<%@ page import="com.miao.bean.Reply" %>
<%@ page import="java.util.List" %>
<%@ page import="com.miao.util.Page" %>
<%@ page import="com.miao.bean.Employee" %><%--
  Created by IntelliJ IDEA.
  User: 10048
  Date: 2017/5/11
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="FCK" uri="http://java.fckeditor.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8"/>
    <title>企业日常事务管理系统-查看具体消息</title>
    <link href="css.css" type="text/css" rel="stylesheet" media="all">
    <link href="css/channel.css" type="text/css" rel="stylesheet" media="all">
    <script src="menu.js" type="text/javascript"></script>
    <style type="text/css"></style>
</head>
<body>
<div id="topexplain">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
<div id="topmenu"><img src="images/banner.jpg" width="970" height="147" /></div>
<div id="bookmunu">
    <div class="jsmenu" id="jsmenu">
        <ul>
            <li class="normal"><a href="index.jsp" urn="#jsmenu1" rel="conmenu">首页</a></li>
            <li class="active"><a urn="#default_Info" rel="conmenu" href="GetMessageList">消息列表</a></li>
            <li class="normal"><a urn="jsmenu2" rel="conmenu" href="publishNewMsg.jsp">发布新消息</a></li>
            <li class="normal"><a urn="jsmenu3" rel="conmenu" href="statusRecognise.jsp">身份识别</a></li>
        </ul>
    </div>
    <div id="conmenu"></div>
</div>
    <div id="place">当前位置：[<a href="index.jsp">首页</a>]-[消息列表]-[查看具体消息]</a> </div>
    <div id="channelcont">
        <div class="channelinleft">
            <br>
            <%
                Message message = (Message) request.getAttribute("message");
            %>
            <h2 align="center"><%=message.getMessageTitle()%></h2>
            <br>
            <%=message.getMessageContent()%>
            <div align="right">
                发布人Id：<%=message.getEmployeeId()%>
                发布时间：<%=message.getPublishTime()%>
            </div>

            <div>
                <%
                    Criticism criticism = (Criticism) request.getAttribute("criticism");
                    if (criticism.getCriticismContent() != null) {
                %>
                <h5 style="color:red">领导批复：<%=criticism.getCriticismContent()%></h5>
                <%
                    }
                %>
            </div>

            <div>
                <%
                    List<Reply> replies = (List<Reply>) request.getAttribute("replyList");
                    if (replies.size() == 0) {
                %>
                暂无回复！
                <%
                    } else {
                        for (Reply reply : replies) {
                %>
                        <%=reply.getReplyContent()%>
                    <div align="right">
                        回复人Id：<%=reply.getEmployeeId()%>
                        回复时间：<%=reply.getReplyTime()%>
                    </div>
                <%
                        }
                    }
                %>
            </div>

            <div>
                <%
                    Employee employee = (Employee) request.getSession().getAttribute("employee");
                    if (employee.isLead()) {
                %>
                <div align="left">
                    <p>批复：</p>
                    <form action="CommitCriticism" method="post">
                        <FCK:editor instanceName="criticismContent" toolbarSet="Basic" basePath="/fckeditor"
                                    width="100%" height="100"/>

                        <input type="hidden" name="messangeId" value="<%=message.getMessageId()%>">
                        <input type="submit" value="提交">
                        <input type="reset" value="重置">
                    </form>
                </div>
                <%
                    } else {
                %>
                <div align="left">
                <p>回复：</p>
                    <form action="CommitReply" method="post">
                        <FCK:editor instanceName="replyContent" basePath="/fckeditor" toolbarSet="Basic" height="100" width="100%"></FCK:editor>
                        <input type="hidden" name="messageId" value="<%=message.getMessageId()%>">
                        <input type="submit" name="提交">
                        <input type="reset" value="重置">
                    </form>
                </div>
                <%
                    }
                %>
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
