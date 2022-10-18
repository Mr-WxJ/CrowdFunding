<%--
  Created by IntelliJ IDEA.
  User: wj
  Date: 2022/10/18 0018
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试mvc环境</title>
    <base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"/>
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">

        $(function(){
            $("#btn3").click(function(){

                // 准备好要发送到服务器端的数组
                var array = [5, 8, 12];
                console.log(array.length);

                // 将JSON数组转换为JSON字符串
                var requestBody = JSON.stringify(array);
                // "['5','8','12']"
                console.log(requestBody.length);

                $.ajax({
                    "url": "send/array/three.html",			// 请求目标资源的地址
                    "type": "post",						// 请求方式
                    "data": requestBody,				// 请求体
                    "contentType": "application/json;charset=UTF-8",	// 设置请求体的内容类型，告诉服务器端本次请求的请求体是JSON数据
                    "dataType": "text",					// 如何对待服务器端返回的数据
                    "success": function(response) {		// 服务器端成功处理请求后调用的回调函数，response是响应体数据
                        alert(response);
                    },
                    "error":function(response) {		// 服务器端处理请求失败后调用的回调函数，response是响应体数据
                        alert(response);
                    }
                });

            });

        });

    </script>
</head>
<body>
    <a href="test/ssm.html">测试SSM整合环境</a>

    <br/>
    <br/>

    <button id="btn3">Send [5,8,12]</button>

</body>
</html>
