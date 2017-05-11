<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.miao.dao.MessageDAO"%>
<%@page import="com.miao.factory.MessageDAOFactory"%>
<%@page import="com.miao.util.Page"%>
<%@page import="com.miao.util.PageUtil"%>
<%@page import="com.miao.bean.Message"%>
<%@ page import="com.miao.bean.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>企业日常事务管理系统-首页</title>
    <link href="css.css" type="text/css" rel="stylesheet" media="all" />
    <script src="menu.js" type="text/javascript"></script>
</head>

<body>
<div id="topexplain">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
<div id="topmenu"><img src="images/banner.jpg" width="970" height="147" /></div>
<div id="bookmunu">
    <div class="jsmenu" id="jsmenu">
        <ul>
            <li class="active"><a href="index.jsp" urn="#default_Info" rel="conmenu">首页</a></li>
            <li class="normal"><a urn="jsmenu1" rel="conmenu" href="GetMessageList">消息列表</a></li>
            <li class="normal"><a urn="jsmenu2" rel="conmenu" href="publishNewMsg.jsp">发布新消息</a></li>
            <li class="normal"><a urn="jsmenu3" rel="conmenu" href="statusRecognise.jsp">身份识别</a></li>
        </ul>
    </div>
    <div id="conmenu"></div>

</div>
<div id="indexfirst">
    <div id="thenew">
        <div class="tit">
            <h1>最新消息</h1>
        </div>
        <div class="STYLE1" id="therecom">
            <%
                MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
                Page pageX = PageUtil.createPage(6, messageDAO.findAllCount(), 1);
                java.util.List<Message> messages = messageDAO.findAllMessage(pageX);
                for(Message message : messages) {
            %>
            <p>
                <a href="GetMessage?messageId=<%=message.getMessageId()%>"><%=message.getMessageTitle()%></a>
                <span class="STYLE2"><%=message.getPublishTime() %></span>
            </p>
            <p>&nbsp;</p>
            <%
                }
            %>
        </div>
    </div>
    <div id="menunav">
        <div class="tit">
            <h1>员工信息</h1>
        </div>
        <div id="employee">
            <%
                Employee employee = (Employee) request.getSession().getAttribute("employee");
                if (employee == null) {
            %>
            没有进行身份识别，请先进行身份识别！
            <%
                } else {
            %>
            <ul>
                <li>员工编号：<%=employee.getEmployeeId()%></li>
                <li>员工姓名：<%=employee.getEmployeeName()%></li>
                <li>员工性别：<%=employee.isEmployeeSex() ? "男" : "女"%></li>
                <li>出生日期：<%=employee.getEmployeeBirth()%></li>
                <li>办公室电话：<%=employee.getEmployeePhone()%></li>
                <li>住址：<%=employee.getEmployeePlace()%></li>
                <li>管理层领导：<%=employee.isLead() ? "是" : "否"%></li>
            </ul>
            <%
                }
            %>
        </div>
    </div>
</div>
<div id="indexsec"></div>
<div class="copyright"><ul><li></li>
    <li>企业日常事务管理系统 &nbsp;&copy;2009-2010</li>
</ul>
</div>
<div class="end"></div>
</body>
</html>

