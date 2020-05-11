<%@ page language="java" import="java.util.*,bean.*,dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考研参考书目</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="/PostGraduate/Style/bookstore.css">

  </head>
  <body>
  <div id="wrap">
  <%
  		BookDao book=new BookDao();
        List<Book> bookList = new ArrayList<>();
        List<Book> bookList2 = new ArrayList<>();
        List<Book> bookList3 = new ArrayList<>();
        List<Book> bookList4 = new ArrayList<>();
        
        String[] bookname=new String[4];
        Float[] bookprice=new Float[4];
        bookList =book.getByBookname("中国近代史纲要");
        bookname[0]=bookList.get(0).getBook_name();
        bookprice[0]=bookList.get(0).getPrice();
        bookList2 = book.getByBookname("马克思主义基本原理");
        bookname[1]=bookList2.get(0).getBook_name();
        bookprice[1]=bookList2.get(0).getPrice();
        
        bookList3 = book.getByBookname("毛泽东思想和马克思基本原理");
        bookname[2]=bookList3.get(0).getBook_name();
         bookprice[2]=bookList3.get(0).getPrice();
        
        bookList4 = book.getByBookname("思想道德修养与法律基础");
        bookname[3]=bookList4.get(0).getBook_name();
         bookprice[3]=bookList4.get(0).getPrice();
       
        System.out.println(bookname[1]);
    //    session.setAttribute("bookname",bookname);
     
        
   %>
    <div id="banner">
    <input type="hidden" name="bookname"  value=<%=bookname %>>
        <table>
            <tr>
                <td>政治</td>
                <td>英语</td>
                <td>数学</td>
                <td>专业</td>
            </tr>
        </table>
    </div>
    <div id="content">
        <div id="politics">
            <p class="kind">政治</p>
            <ul id="polit"></ul>
        </div>
        <div id="English">
            <p class="kind">英语</p>
            <ul id="Eng"></ul>
        </div>
        <div id="math">
            <p class="kind">数学</p>
            <ul id="mat"></ul>
        </div>
        <div id="major">
            <p class="kind">专业</p>
            <ul id="maj"></ul>
        </div>
    </div>
  </div>
</body>
<script>


var imgpolArr=["/PostGraduate/Images/book_politics1.jpg","/PostGraduate/Images/book_politics2.jpg",
    "/PostGraduate/Images/book_politics3.jpg","/PostGraduate/Images/book_politics4.jpg"];
    var namepolArr=new Array();
<%   for(int i=0;i <bookname.length;i++){   %> 
        namepolArr[ <%=i%> ]= " <%=bookname[i]%> "; 
<%   }   %> 
//alert(namepolArr[0]);
var moneypolArr=new Array();
<%   for(int i=0;i <bookprice.length;i++){   %> 
        moneypolArr[ <%=i%> ]= " <%=bookprice[i]%> "; 
<%   }   %> 
//alert(moneypolArr[0]);
//var moneypolArr=["¥29.90","¥49.90","¥31.60","¥21.90"];

var imgEngArr=["/PostGraduate/Images/book_English1.jpg","/PostGraduate/Images/book_English2.jpg",
    "/PostGraduate/Images/book_English3.jpg","/PostGraduate/Images/book_English4.jpg"];
var nameEngArr=["英语考研高分写作","考研英语词根词汇","历年考研英语2真题","恋恋有词-词汇"];
var moneyEngArr=["29.20","41.20","26.60","121.50"];

var imgmatArr=["/PostGraduate/Images/book_math1.jpg","/PostGraduate/Images/book_math2.jpg",
    "/PostGraduate/Images/book_math3.jpg","/PostGraduate/Images/book_math4.jpg"];
var namematArr=["高等数学习题讲解","概率论与数理统计","线性代数","微积分"];
var moneymatArr=["¥40.00","¥79.90","¥46.90","¥60.00"];

var imgmajArr=["/PostGraduate/Images/book_major1.jpg","/PostGraduate/Images/book_major2.jpg",
    "/PostGraduate/Images/book_major3.jpg","/PostGraduate/Images/book_major4.jpg"];
var namemajArr=["c语言从入门到精通","数据结构","计算机组成原理","计算机操作系统"];
var moneymajArr=["¥49.50","¥75.90","¥66.90","¥56.00"];


var polit=document.getElementById("polit");
var Eng=document.getElementById("Eng");
var mat=document.getElementById("mat");
var maj=document.getElementById("maj");
function create(majors,img,name,money) {
    for (var i=0;i<img.length;i++){
        var a=document.createElement("a");
        var lis=document.createElement("li");
        lis.className="pol";
        var imgs=document.createElement("img");
        var spas=document.createElement("span");
        var ps=document.createElement("p");
        spas.innerText=money[i];
        ps.innerText=name[i];
        ps.className="bookname";
        imgs.src=img[i];
        majors.appendChild(a);
        a.appendChild(lis);
        lis.appendChild(imgs);
        lis.appendChild(spas);
        lis.appendChild(ps);
        a.href="/PostGraduate/JSP/order.jsp?book_name="+ps.innerText+"&book_price="+spas.innerText;
    }
}
create(polit,imgpolArr,namepolArr,moneypolArr);
create(Eng,imgEngArr,nameEngArr,moneyEngArr);
create(mat,imgmatArr,namematArr,moneymatArr);
create(maj,imgmajArr,namemajArr,moneymajArr);

function onclick(){

}

</script> 
</html>
