<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/24
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表页面</title>

    <!--
        某一页的当前页码是确定的, 在查询进入list页面上的时候, 根据当前页的值, 会计算出上一页和下一页的页码.
        翻页就是一个连接, 通过此链接, 来需要跳转到的页码值, 传到js goPage()函数中, 赋值给当前页码属性值, 也就是改变当页码的值,
        将改变当页码的值通过表单提交的操作, 传递到后台,根据传来的currentPage的值, 和pageSize的大小,查询出当前页的数据,
        之后封装起来, 在前台取出 .
        也就是说, 并不会一次性查询全部的数据, 而是根据currentPage的值和pageSize值的变化,不断发送SQL查询的到当前页的数据
        return new PageResult(list,totalCount,qo.getCurrentPage(),qo.getPageSize());
        -->

       <!--在script 里面, 不要加任何注释, 否则失效-->


    <script type="text/javascript" >
        function goPage(pageNum) {
            var form = document.getElementById("queryForm")
            form["currentPage"].value = pageNum;

            form.submit();
            <!--将currentPage传到后台, 查询出currentPage页面的数据-->
        }
    </script>

</head>
<body>



<form action="/user/query.do" method="post" id="queryForm">

   <table cellspacing="0" cellpadding="0" border="1" width="60%">

       <tr align="center">
           <td colspan="4">
               <a href="/user/input.do">增加数据</a>
           </td>
       </tr>


       <!--There is no getter for property named 'wkeyword' in 'class com._520it.query.UserQueryObject'
       页面提交的高级查询的关键字, 在后台,通过UserQueryObject类 将传来的属性封装到类中定义的查询字段中,
       在xml的模糊查询中,类中被设置了页面传来的值的字段,才能起到作用,
        也就是说:页面上的参数名字, 类中接收该参数数据的字段名称,xml中SQL中的关键字,三者必须保证相同,否则:不能接收到值,-->

         <tr align="center">
            <td colspan="4" align="center">
             姓名<input type="text" name="keyword"  value="${qo.keyword}" />
             年龄<input type="text" name="minAge"   value="${qo.minAge}"   />
              ~~<input type="text" name="maxAge"    value="${qo.maxAge}" />

                <input type="submit" value="查询"/>
            </td>
        </tr>


       <tr align="center">
           <td>编号</td>
           <td>姓名</td>
           <td>年龄</td>
           <td>编辑</td>
       </tr>


       <c:forEach var="user" items="${pageResult.list}" >
           <tr align="center" >
               <td>${user.id}</td>
               <td>${user.name}</td>
               <td>${user.age}</td>

               <td>
                   <!--注意: 不要忘记传递id, 否则无法回显编辑的数据-->

                   <a href="/user/input.do?id=${user.id}"/>编辑</a>
                   <a href="/user/delete.do?id=${user.id}"/>删除</a>
               </td>
           </tr>
       </c:forEach>

       <tr align="center">
           <td colspan="4">
               <a href="javascript:goPage(1)">首页</a>
               <a href="javascript:goPage(${pageResult.nextPage})">下一页</a>
               <a href="javascript:goPage(${pageResult.prevPage})">上一页</a>
               <a href="javascript:goPage(${pageResult.totalPage})">尾页</a>

               当前 ${pageResult.currentPage} /${pageResult.totalPage}页
               总共 ${pageResult.totalCount} 条

               每页显示 <select id="pageSize" name="pageSize" value= "${pageResult.pageSize}"
                            onchange="javascript:goPage(1)"/>
                            <option value="3">3</option>
                            <option value="5">5</option>
                            <option value="10">10</option>
                        </select>

               跳转:<input type="text" name="currentPage"  value="${pageResult.currentPage}" style="width: 40px" />
               <input type="submit" value="跳转"/>

           </td>
       </tr>
   </table>

</form>




</body>
</html>
