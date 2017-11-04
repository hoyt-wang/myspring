<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">查询</h3>
            </div>
            <div class="panel-body">
                <form action="" class="form-inline">
                    <input type="text" class="form-control" placeholder="商品名称"
                           name="productName" value="${param.productName}">
                    <select name="place" class="form-control">
                        <option value="">--选择产地--</option>
                        <c:forEach items="${placeList}" var="place">
                            <option value="${place}" ${param.place == place ? 'selected' : ''}>${place}</option>
                        </c:forEach>
                    </select>
                    <select name="typeId" class="form-control">
                        <option value="">--选择类型--</option>
                        <c:forEach items="${typeList}" var="type">
                            <option value="${type.id}" ${param.typeId == type.id ? 'selected' : ''}>${type.typeName}</option>
                        </c:forEach>
                    </select>
                    <button class="btn btn default">搜索</button>
                </form>
            </div>
        </div>
    </div>

    <div class="container">
        <c:if test="${not empty message}">
            <div class="alert alert-info">${message}</div>
        </c:if>
        <a href="/kaola/new" class="btn btn-primary pull-right">添加商品</a>
        <table class="table">
            <thead>
                <tr>
                    <th>商品名称</th>
                    <th>分类</th>
                    <th>产地</th>
                    <th>市场价</th>
                    <th>考拉价</th>
                    <th>评论数量</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pageInfo.list}" var="kaola">
                    <tr>
                        <td><a href="/kaola/${kaola.id}">${kaola.productName}</a></td>
                        <td>${kaola.kaolaType.typeName}</td>
                        <td>${kaola.place}</td>
                        <td>${kaola.marketPrice}</td>
                        <td>${kaola.price}</td>
                        <td>${kaola.commentNum}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <ul id="pagination-demo" class="pagination-sm"></ul>
    </div>

    <script src="/static/js/jquery.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/jquery.twbsPagination.min.js"></script>
    <script>
        $(function(){

            $('#pagination-demo').twbsPagination({
                totalPages: ${pageInfo.pages},
                visiblePages: 10,
                first:'首页',
                last:'末页',
                prev:'上一页',
                next:'下一页',
                href:"?productName="+ encodeURIComponent('${param.productName}') +""
                        +"&place="+ encodeURIComponent('${param.place}')+"&typeId=${param.typeId}&p={{number}}"
            });
        });
    </script>
</body>
</html>