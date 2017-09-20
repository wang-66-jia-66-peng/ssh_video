<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="page" uri="http://zhiyou100.com/common/"%>
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
    <script type="text/javascript">
    function delcfm(url){
    	$('#url').val(url);
    	$('#delcfmModal').modal();
    }
    function urlSubmit(){
    	var url = $.trim($("#url").val());
    	window.location.href=url;
    } 
    
    </script>
      
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
        <li >
          <a href="${pageContext.request.contextPath }/adminSpeaker/speaker_speakerList.action" onclick="">主讲人管理</a>
        </li>
        <li  class="active">
          <a href="${pageContext.request.contextPath }/adminCourse/course_courseList.action" onclick="">课程管理</a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath }/adminStatistics/statistics_statisticsList.action" onclick="">统计分析</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <!-- <li><a href="http://mb.bootcss.com" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click', 'themes'])" target="_blank">主题/模板</a></li> -->
        <li><a href="" onclick="" class="glyphicon glyphicon-log-out">${ADMIN.loginName }</a></li>
      </ul>
    </nav>
  </div>
</header>



  <div class="jumbotron"  >
    <h2 style="padding-left: 400px;">课程列表--课程管理</h2>
  </div>                                                                                                                                         
   
            <div>
            	<label for="inputEmail3" class="col-sm-2 control-label"></label>
				<a class="btn btn-primary" 
				href="${pageContext.request.contextPath }/adminCourse/course_addCourse01.action">添加课程</a>
			</div>
   
   
     
   
    <div class="bs-example" data-example-id="hoverable-table">
    	<label for="inputEmail3" class="col-sm-2 control-label"></label>
    
    <table class="table table-hover  table-condensed"    style="width: 1000px; ">
      <thead>
        <tr>
          <th>序号</th>
          <th>标题</th>
          <th>学科</th>
          <th>简介</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
       <c:forEach items="${pageUtil.rows }"  var="course"  varStatus="status">
        <tr>
          <th scope="row">${ status.count}</th>
          <td>${course.courseName }</td>
          <td>${course.subject.subjectName }</td>
          <td>${course.courseDescr }</td>
          <td><a class="glyphicon glyphicon-pencil"   
           href="${pageContext.request.contextPath }/adminCourse/course_updateCourse01.action?id=${course.id}"></a></td>
          <td><a class="glyphicon glyphicon-trash"  
          <%--  onclick='return(confirm("确定删除?"));'  href="${pageContext.request.contextPath }/course/deleteCourse.action?id=${course.id}" --%>
                  onclick="delcfm('${pageContext.request.contextPath }/adminCourse/course_deleteCourse.action?id=${course.id}')"></a></td>
        </tr>
        </c:forEach>
       
      </tbody>
    </table>
     
       <!--模态框  -->
  <div class="modal fade" id="delcfmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">提示信息</h4>
			</div>
			
			<div class="modal-body">
			  你确定要删除吗?
			</div>
			<div class="modal-footer">
				<input type="hidden" id="url" />
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<a  class="btn btn-success"   data-dismiss= "modal"  onclick="urlSubmit()"  >确定</a>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->      
        
    
    
    
     <div>
       <label for="inputEmail3" class="col-sm-2 control-label"></label>
     <page:page url="${pageContext.request.contextPath }/adminCourse/course_courseList.action"></page:page>
     </div>
  </div>
   
   
   
   
   </body>
</html>                                                                                                                                    
      