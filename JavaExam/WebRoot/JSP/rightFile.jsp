<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="/PostGraduate/Style/table_admin.css">
	<style>
	#wrap{
            margin:100px 200px;
            padding:0px;
        }
	#reset,#submit{
            margin:20px 50px 0px 0px;            
            padding: 5px 10px;
            font-size:16px;
            background: #85ff80;
            border-radius: 5px;
            outline: none;
        }
         a{
         color:blue;
         text-decoration: none;
       
	    }
	    a:hover{
	    	text-decoration: underline;
	    }
        </style>

  </head>
  
  <body>
    <h2>文件上传</h2>
  <div id="wrap">

		<%FileDao fd=new FileDao();
			List<Files> fileList=new ArrayList<>();
			fileList=fd.query();
			if(fileList==null){
	       		out.println("还没有上传文件哟~");
	       	}else{%> 
		<table align='center'>
			<tr>
				<th>文件id</th>
				<th>文件名</th>
				<th>上传时间</th>
				<th>删除</th>
			</tr>
	   <%        
		   for (int i=0;i<fileList.size();i++){%>
			 	<tr>
					<td> <%=fileList.get(i).getFile_id()%> </td>
					<td  style="width:500px"> <a><%=fileList.get(i).getFile_name()%> </a></td>
					<td style="width:500px"> <%=fd.getTime(fileList.get(i).getFile_id())%></td>
	            <td><a href="<%=basePath %>AdminServlet.do?str=deleteFile&del_file=<%=fileList.get(i).getFile_id()%>" target="_parent" 
	          			  onclick="if(confirm('确定删除?')==false)return false;">删除</a></td>	
				</tr>
	   <%}}%>
	</table>
	
	    <form action="/PostGraduate/FileLoadServlet.do?symbol=upload" method="post" enctype="multipart/form-data">
		    <input type="file" id="uploadFile" name="uploadFile"><br>
		    <input type="reset" value="重置" id="reset">
		    <input type="submit" value="上传"  id="submit">
	    </form>
	    <p style="color:red" class="errorMessage"></p>
  </div>
	    
  </body>
  <script type="text/javascript" src="/PostGraduate/JS/jquery-1.4.2.js"></script>
  <script type="text/javascript">
 	 $("#submit").click(function () {
       // console.log($("#phone_number").val())
        if(!$("#uploadFile").val()){
            $(".errorMessage").text("请选择文件上传")
        }else{
            $(".errorMessage").text("");
        }
        console.log($(".errorMessage").text());
        if($(".errorMessage").text()==""){
            $(".errorMessage").css({
                display:'none',
            })
           if(confirm('确定上传?')==true)
            return true;
        }else{
            return false;
        }
    })
		
</script>
</html>
