<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="/css/index.css">
  </head> 
  <body>
  	 
  
   
  <header class="navbar navbar-static-top bs-docs-nav  navbar navbar-inverse" id="top">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#bs-navbar" aria-controls="bs-navbar" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="../" class="navbar-brand">视频管理</a>
    </div>
    <nav id="bs-navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li>
          <a href="${pageContext.request.contextPath }/adminVideo/video_videoList.action" onclick="">视频管理</a>
        </li>
        <li class="active">
          <a href="${pageContext.request.contextPath }/adminSpeaker/speaker_speakerList.action" onclick="">主讲人管理</a>
        </li>
        <li >
          <a href="${pageContext.request.contextPath }/adminCourse/course_courseList.action" onclick="">课程管理</a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath }/adminStatistics/statistics_statisticsList.action" onclick="">统计分析</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <!-- <li><a href="http://mb.bootcss.com" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click', 'themes'])" target="_blank">主题/模板</a></li> -->
        <li><a href="" onclick=""  class="glyphicon glyphicon-log-out">用户名</a></li>
      </ul>
    </nav>
  </div>
  
  
  
  
  
</header>
  <div class="jumbotron"  >
    <h2 style="padding-left: 400px;">添加课程</h2>
  </div>                                                                                                                                         
   
   
   
   <div style="margin-left: 380px;">
  <form class="form-horizontal"   action="${pageContext.request.contextPath }/adminCourse/course_updateCourse02.action">
  	
   <div class="form-group">
      <label for="inputEmail3" class="col-sm-2 control-label">所属学科</label>
        <div class="col-sm-10" style="width: 600px;">
        	<select class="form-control" id="inputPassword3"  name="subjectId"> 
        	  <option>选择所属学科</option>
        	  <c:forEach items="${subject }" var="subject" varStatus="status">
        	  <option value="${subject.id }"  ${Course.subject.id== subject.id ? "selected":""} >${subject.subjectName }</option>
        	  </c:forEach>
        	</select>
        </div>
        </div>
 
      
     
 
    	
   <div class="form-group">
  	 <label for="inputEmail3" class="col-sm-2 control-label">标题</label>
   		<div class="col-sm-10" style="width: 600px;">
          <input type="text" class="form-control" id="inputPassword3" name="courseName"   
           value="${Course.courseName }"  placeholder="职业">
        </div>
  	</div>
 
  
   
 
  
    <div class="form-group">
  	 <label for="inputEmail3" class="col-sm-2 control-label">课程简介</label>
   		<div class="col-sm-10" style="width: 600px ;  height: 30px;">
   			<textarea  class="form-control" id="inputPassword3" placeholder="视频简介"  name="courseDescr">${Course.courseDescr}</textarea>
        </div>
  	</div>
     <br />
     <div class="form-group">
  	 <label for="inputEmail3" class="col-sm-2 control-label"></label>
   		<div class="col-sm-10" style="margin-bottom: 30px;">
   			<div class="buttons" style="margin-bottom: 30px;">
   			   <input type="hidden"    name="id"   value="${Course.id }">
				<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
        </div>
  	</div>
 
    
  
</form>       
     </div>    

  </body>
</html>                                                                                                                                    
                                                                                                                                           
                                                                                                                                           
                                                        
 
    