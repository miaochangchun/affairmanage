<%@ page import="java.util.List" %>
<%@ page import="com.miao.bean.Message" %>
<%@ page import="com.miao.util.Page" %><%--
  Created by IntelliJ IDEA.
  User: 10048
  Date: 2017/5/9
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8"/>
    <link href="css.css" type="text/css" rel="stylesheet" media="all"/>
    <link href="css/channel.css" type="text/css" rel="stylesheet" media="all">
    <script src="menu.js" type="text/javascript"></script>
    <style type="text/css"></style>
    <title>企业日常事务管理系统-消息列表</title>
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
    <div id="place">当前位置：[<a href="index.jsp">首页</a>] - [消息列表]</div>
    <div id="channelcont">
        <div id="channelleft">
            <div class="channelinleft">
                <div class="channeltit"></div>
                <dl>
                    <%
                        List<Message> messages = (List<Message>) request.getAttribute("messageList");
                        for (Message message : messages) {
                    %>
                        <dt><a href="GetMessage?messageId=<%=message.getMessageId()%>">
                                <%=message.getMessageTitle()%>
                            </a>
                        </dt>

                        <dd>
                            <div align="right">
                                发布人Id：<%=message.getEmployeeId()%>
                                发布时间：<%=message.getPublishTime()%>
                            </div>
                        </dd>
                    <%
                        }
                    %>
                </dl>
                <div>
                    <div align="center">
                        <%
                            Page page2 = (Page) request.getAttribute("page");
                            if (page2.isHasPrePage()) {
                        %>
                        <a href="GetMessageList?currentPage=1">首页</a>
                        <a href="GetMessageList?currentPage=<%=page2.getCurrentPage() - 1%>">上一页</a>
                        <%
                            } else {
                        %>
                            首页 | 上一页
                        <%
                            }
                        %>

                        <%
                            if (page2.isHasNextPage()) {
                        %>
                            <a href="GetMessageList?currentPage=<%=page2.getCurrentPage() + 1%>">下一页</a>
                            <a href="GetMessageList?currentPage=<%=page2.getTotalPage()%>">尾页</a>
                        <%
                            } else {
                        %>
                            下一页 | 尾页
                        <%
                            }
                        %>

                        当前为第<%=page2.getCurrentPage()%>页，共<%=page2.getTotalPage()%>页
                    </div>
                </div>

            </div>
        </div>
        <div class="copyright"><ul><li></li>
            <li>企业日常事务管理系统 &nbsp;&copy;2009-2010</li>
        </ul>
        </div>
    </div>
        <div class="end"></div>

</body>
</html>
