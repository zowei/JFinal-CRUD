<%--
  Created by IntelliJ IDEA.
  User: zouwei
  Date: 2019/4/16
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表页面</title>
    
    <%--引入标签库--%>
    <!--  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
    
    <%--${APP_PATH}本身以/开头--%>
    <!-- <%  pageContext.setAttribute("APP_PATH",request.getContextPath());%> -->
    
    <script type="text/javascript" src="#(ctx)/static/js/jquery-3.3.1.min.js"></script>
    <link href="#(ctx)/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="#(ctx)/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<%--搭建显示页面--%>
<div class="container">
    <%--第一行--%>
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <%--第二行--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button type="button" class="btn btn-primary">新增</button>
            <button type="button" class="btn btn-danger">删除</button>
        </div>
    </div>
    <%--第三行--%>
    <div class="row">
        <div class="col-md-10">
            <table class="table table-striped">
                <tr>
                    <th>#</th>
                    <th>name</th>
                    <th>sex</th>
                    <th>age</th>
                    <th>操作</th>
                </tr>
               <!-- <c:forEach items="${PageInfo.list}" var="emp"> 
                    <tr>
                        <th>${emp.id}</th>
                        <th>${emp.name}</th>
                        <th>${emp.sex}</th>
                        <th>${emp.age}</th>
                        <th>
                            <button type="button" class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
                                新增
                            </button>
                            <button type="button" class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
                                删除</button>
                        </th>
                    </tr>
                    --> 
               <!--  </c:forEach>--> 

            </table>
        </div>
    </div>
    <%--第四行--%>
    <div class="row">
        <%--分页信息--%>
        <!-- <div class="col-md-5">
            当前${PageInfo.pageNum}页，总${PageInfo.pages}页，总共${PageInfo.total}记录
        </div>
         -->
        
            <%--===分页条===--%>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="#">首页</a></li>

                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">上一页</span>
                        </a>
                    </li>
                   <!-- <c:forEach items="${PageInfo.navigatepageNums}" var="pageNum">
                        <li><a href="#">${pageNum}</a></li>
                    </c:forEach>  -->


                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">下一页</span>
                        </a>
                    </li>
                    <li><a href="#">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>

</div>

</body>
</html>
