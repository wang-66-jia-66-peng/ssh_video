<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>                                                                                                                          
<html lang="zh-CN">                                                                                                                        
  <head>                                                                                                                                   
    <meta charset="utf-8">                                                                                                                 
    <meta http-equiv="X-UA-Compatible" content="IE=edge">                                                                                  
    <meta name="viewport" content="width=device-width, initial-scale=1">                                                                   
    <title>视频管理系统</title>                                                                                                            
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">                                                                             
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>                                                                                     
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>   
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
    <script type="text/javascript"  src="${pageContext.request.contextPath }/js/messages_zh.min.js"></script>
    <script type="text/javascript">
    $(function() {
		$("#checkForm").validate({
			rules : {
				name : {
					required : true,
					minlength : 3
				},
				password : {
					required : true
				}
			},
			messages : {
				name : {
					required : "用户名不能为空",
					minlength : "长度不够"
				},
				password : {
					required : "密码不能为空"
				}
			}
		});
	});
      
    
    
    </script>
 
  </head> 
   <style>
    	.chuan{
    		text-align: center;
    		padding-top: 250px;
    	}
    	.form-group{
    		width: 300px;
    		hyphens: 200px;
    		margin: 0 auto;
    	}
    	.btn{
    		width: 300px;
    	}
    </style>
    
  </head>
  <body>
  	<div class="chuan">
  		<img src="${pageContext.request.contextPath }/img/logo.png" />
  <form action="${pageContext.request.contextPath }/adminUser/user_adminUserLogin.action" method="post"   id="checkForm">
  <div class="form-group" >
    <label for="exampleInputEmail1"></label>
    <input type="text" class="form-control"    id="exampleInputEmail1"   name="loginName"  placeholder="用户名"   value="admin"  >
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1"></label>
    <input type="password" class="form-control"  id="exampleInputPassword1"  name="loginPwd"   placeholder="密码" value="admin"   >
  </div>
  <br />
 <!-- <div class="checkbox">
    <label>
       <input type="checkbox"> 记住密码
    </label>
  </div> -->
  <input type="submit"  class="btn btn-success" value="登录"/>
 <!--<button type="button" class="btn btn-success">登录</button>-->
</form>
 <div>${message}</div>
</div>

  </body>
                                                                                                                   
</html>                            