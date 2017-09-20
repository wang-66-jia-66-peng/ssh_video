<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pa"  uri="http://zhiyou100.com/common/"%>
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
  </head> 
  <script type="text/javascript">
/*  function checkAll() {
  for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
   document.getElementsByName("selectFlag")[i].checked = document.getElementById("ifAll").checked;
   }
 } */
 
 var p =0;
 function checkAll() {
   for (var i = 0; i <$("input[name='selectFlag']").length; i++) {
      $("input[name='selectFlag']")[i].checked = $("#ifAll")[0].checked;
   }
     
      if ($("#ifAll")[0].checked==true) {
          p=10;
      }else{ p=0;}
      
       $(".badge").text(p);
   
  }
 
 
function pl() { 
	var  $a =  $("input[name='selectFlag']");
	var  $b =  $("input[name='ifAll']");   
	
	var arr = new Array();
	 
	if($b[0].checked==true){
		
		for(var i = 0; i < $a.length;i++){
			arr[i] = $a[i].value;
		    
		}
	}
	
	 if($b[0].checked==false){
		for(var i = 0; i <$a.length;i++){
			if($a[i].checked==true){
				arr[i] = $a[i].value;
			  
			}
		}
	}
    alert(arr.toString())
    location.href="${pageContext.request.contextPath }/adminVideo/video_deteleVideoLarge.action?ids="+arr;
} 

function che(){
	
	var  $a =  $("input[name='selectFlag']");
	var  $b =  $("input[name='ifAll']");  
	 $b[0].checked = false;
	var p = 0;
	var arr = new Array();
	 
	/*if($b[0].checked==true){
		
		for(var i = 0; i < $a.length;i++){
			arr[i] = $a[i].value;
		     p=4;
		}
	}
	*/
	 if($b[0].checked==false){
		for(var i = 0; i <$a.length;i++){
			if($a[i].checked==true){
				arr[i] = $a[i].value;
			   p++;
			}
		}
	}
	
	$(".badge").text(p);
}


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
        <li class="active">
          <a href="${pageContext.request.contextPath }/adminVideo/video_videoList.action" onclick="">视频管理</a>
        </li>
        <li >
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
        <li><a href="" onclick=""  class="glyphicon glyphicon-log-out">${ADMIN.loginName }</a></li>
      </ul>
    </nav>
  </div>
</header>



  <div class="jumbotron"  >
    <h2 style="padding-left: 400px;">视频列表--视频管理</h2>
  </div>                                                                                                                                         
   
   
            <div>
            	 <label for="inputEmail3" class="col-sm-2 control-label"></label>
            	
				    <a class="btn btn-primary" href="${pageContext.request.contextPath }/adminVideo/video_addVideo01.action">添加视频</a>
				   
				    <button class="btn btn-primary" type="button"   onclick="pl()"  >批量删除 
  					 <span class="badge">0</span>
  			        </button> 
  			       
  			       
  			       
  			        <div style="float: right ; margin-right: 400px;">
  			        <form   action="${pageContext.request.contextPath }/adminVideo/video_videoList.action"  method="post">
  			        	<input type="text"    name="videoKeyWord"  value=""   placeholder="请输入搜索关键词"/>
  			        	 &nbsp;&nbsp;&nbsp;
  			             <select name="videoSearchSpeaker"      >
  			        		<option value="0">选择主讲人</option>
  			        		<c:forEach items="${speaker }" var="speaker">
  			        		  <option value="${speaker.id }"  <%--  ${videoSearchSpeaker == speaker.id ? "selected":""} --%> >${speaker.speakerName}</option>
  			        		</c:forEach>
  			        	 </select>
  			        	&nbsp;&nbsp;&nbsp;
  			        	<select name="videoSearchCourse"    >
  			        	<option value="0">选择课程</option>
  			        	<c:forEach  items="${course }" var="course">
  			        	    <option value="${course.id }" <%--  ${   ?"selected":""} --%>>${course.courseName }</option>
  			        	</c:forEach>
  			        	</select>
  			        	<input type="submit" class="btn btn-primary" value="搜索">
  			        </form>
  			        </div>
			</div>
       
            
            
        
   
    <div class="bs-example" data-example-id="hoverable-table">
    	<label for="inputEmail3" class="col-sm-2 control-label"></label>
   
    <table class="table table-hover  table-condensed"    style="width: 1200px; ">
      <thead>
        <tr>
          <th><input type="checkbox"   name="ifAll"   id="ifAll" onClick="checkAll()">全选</th>
          <th>序号</th>
          <th>名称</th>
          <th>介绍</th>
          <th>讲师</th>
          <th>课程</th>
          <th>时长</th>
          <th>播放次数</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
      
      	<c:forEach   items="${pageUtil.rows }"  varStatus="status" var="PackVO">
      	
        <tr>
         <td><input type="checkbox"     name="selectFlag"  value="${PackVO.id}"   onClick="che()"   ></td>
          <th scope="row">${ status.count + (pageUtil.page-1)*10}</th>
          <td>${PackVO.videoTitle }</td>
          <td>${PackVO.videoDescr }</td>
          <td>${PackVO.course.courseName } </td>
          <td>${PackVO.speaker.speakerName }</td>
          <td>${PackVO.videoLength }</td>
          <td>${PackVO.videoPlayTimes }</td>
          <td><a class="glyphicon glyphicon-pencil" 
                  href="${pageContext.request.contextPath }/adminVideo/video_updateVideo01.action?id=${PackVO.id}"></a></td>
          
          <td><a class="glyphicon glyphicon-trash"    
       <%--onclick='return(confirm("确定删除?"));'  href="${pageContext.request.contextPath }/video/deleteVideo.action?id=${PackVO.vid.id}" --%> 
                onclick="delcfm('${pageContext.request.contextPath }/adminVideo/video_deleteVideo.action?id=${PackVO.id}')"></a></td>
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
       <pa:page url="${pageContext.request.contextPath}/adminVideo/video_videoList.action"></pa:page>
     </div>
  </div>
   
   
   
   
   </body>
</html>                                                                                                                                    
