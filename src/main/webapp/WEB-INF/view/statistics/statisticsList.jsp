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
        <li >
          <a href="${pageContext.request.contextPath }/adminVideo/video_videoList.action" onclick="">视频管理</a>
        </li>
        <li >
          <a href="${pageContext.request.contextPath }/adminSpeaker/speaker_speakerList.action" onclick="">主讲人管理</a>
        </li>
        <li >
          <a href="${pageContext.request.contextPath }/adminCourse/course_courseList.action" onclick="">课程管理</a>
        </li>
        <li  class="active">
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
    <h2 style="padding-left: 400px;">统计--统计分析</h2>
  </div>                       
  
  
  
                           <div style="margin-left: 700px;">
	                        <h2>课程平均播放次数</h2>
	                       </div>
	
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:500px;" ></div>
    
    <div id="main2" style="height:500px;" ></div>
    <!-- ECharts单文件引入 -->
    <script src="${pageContext.request.contextPath }/echarts/echarts.js"></script>
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: '${pageContext.request.contextPath }/echarts/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
            	
            	var theData = "${data}".split(",");
        		var theTimes = "${times}".split(",");
            	 //alert(theData);
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                
                var option = {
                    tooltip: {
                        show: true
                    },
                    legend: {
                          data:['课程平均播放次数']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            //data : ["JAVA基础入门","前端开发与Git入门","每天20分钟轻松入门React","UI基础入门","Python编程零基础入门","轻松进击PHP基础",]
                            data:theData
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"课程平均播放次数",
                            "type":"bar",
                           // "data":[239,218,211,237,199,342,]
                            "data": theTimes
                        }
                    ]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
        
        
    </script>
   
</body>
</html>
