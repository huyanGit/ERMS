<%--
  Created by IntelliJ IDEA.
  User: dyleaf
  Date: 2018/1/3
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 布局 -->
<div jobNumber="cc" class="easyui-layout" style="width:100%;height:600px;">
    <!-- 左侧导航 -->
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:15%; margin-left: auto">
        <!-- 导航菜单 -->
        <div jobNumber="aa" class="easyui-accordion" style="width:100%;height:100%;">
            <div title="基本信息/打卡" style="overflow:auto;">
                <a class="easyui-linkbutton" jobNumber="add_tab" href="#" style="width:100%" title="dakaMain.jsp">上下班打卡</a><br>
                <a class="easyui-linkbutton" href="#" style="width:100%" data-options="iconCls:'icon-search'" title="shangxiabanBiaoZhun.jsp">上下班标准</a><br>
            </div>
            <div title="查询考勤信息" style="overflow:auto;">
                <a class="easyui-linkbutton" href="rikaoqinxinxi.jsp" style="width:100%" data-options="iconCls:'icon-ok'" title="">日考勤信息</a><br>
                <a class="easyui-linkbutton" href="yuekaoqinxinxi.jsp" style="width:100%" data-options="iconCls:'icon-undo'" title="">月考勤信息</a><br>
                <a class="easyui-linkbutton" href="#" style="width:100%" data-options="iconCls:'icon-man'" title="jiabanxinxi.jsp">加班信息</a><br>
                <a class="easyui-linkbutton" href="#" style="width:100%" data-options="iconCls:'icon-add'" title="tongjiyuekaoqin.jsp">统计月考勤</a><br>
            </div>
            <div title="请假申请">
                <a class="easyui-linkbutton" href="#" style="width:100%" data-options="iconCls:'icon-tip'" title="qingjiaxinxi.jsp">请假信息</a><br>
                <a class="easyui-linkbutton" href="#" style="width:100%" data-options="iconCls:'icon-ok'" title="Qingjiashenqing.jsp">请假申请</a><br>
            </div>
        </div>

    </div>
    <!-- 中部内容显示 -->
    <div data-options="region:'center',title:'信息展示'" style="padding:5px;background:#eee;">
        <!-- 标签页 -->
        <div jobNumber="tt" class="easyui-tabs" style="width:100%;height:100%;background:url(images/background.png)"></div>
    </div>
</div>
</body>
</html>
