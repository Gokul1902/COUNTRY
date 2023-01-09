<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESULT</title>

<link rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Anton&family=Noto+Serif:ital,wght@1,400;1,700&family=Oswald:wght@700&family=Rubik+Bubbles&family=Rubik+Marker+Hatch&family=Stylish&display=swap" rel="stylesheet">

  <link href="style.css" rel="stylesheet">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link
    href="https://fonts.googleapis.com/css2?family=Combo&family=Island+Moments&family=Lora&family=PT+Sans:ital@1&family=Roboto:ital,wght@1,700&display=swap"
    rel="stylesheet">
    <style>
    *{
    padding: 0%;
    margin: 0%;
    box-sizing: border-box;
}
#logbody{
    background-image: url("https://media.istockphoto.com/id/1138473714/vector/045-blue-green-gradient-no-text.jpg?b=1&s=612x612&w=0&k=20&c=61EeoHA548t3_JodmBCycdW_02rZBaKtkatWLQMjnu0=");
    background-repeat: no-repeat;
    background-size: 100% 100%;
    height: 100vh;
    display: flex;
    flex-direction:column;
    justify-content:center;
    align-items: center;
}
#logheader{
    border: 1px solid black;
    padding: 1%;
    text-align: center;
    position: fixed;
    top: 0%;
    right: 0%;
    left: 0%;
    font-family: 'Abril Fatface', cursive; 
    color: white;
    border-radius: 10px;
    background-color: rgba(255, 255, 255,0.1);    
   /* background-color: black; */
    box-shadow: rgba(0, 0, 0, 0.25) 0px 14px 28px, rgba(0, 0, 0, 0.22) 0px 10px 10px;
}


label{
    text-align: left;
    font-size: 30px;
    font-weight: bolder;
    margin: 20px 0px;
    width: 100%;
    padding-left:15%;
    /* font-family: 'Pacifico', cursive; */
    /* font-family: 'Abril Fatface', cursive; */
/* font-family: 'Anton', sans-serif; */
/* font-family: 'Lobster', cursive; */
/* font-family: 'Noto Serif', serif; */
/* font-family: 'Oswald', sans-serif; */
/* font-family: 'Rubik Bubbles', cursive; */
/* font-family: 'Rubik Marker Hatch', cursive; */
font-family: 'Stylish', sans-serif;
}
form{
    width:600px;
    border-radius: 10px;
    overflow: scroll;
    display: flex;
}
form::-webkit-scrollbar {
  display: none;
}
#result::-webkit-scrollbar {
  display: none;
}
button{
    font-size: 25px;
    font-weight: bolder;
    padding: 10px;
    border:none;
    color: white;
    background-color: rgba(0,0,0,0.9);
    transition: 0.5s;
    border-radius: 10px;
    font-family: 'Stylish', sans-serif;
    box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
}
#li{
	width:100%;
	font-size: 25px;
    font-weight: bolder;
    padding: 10px;
    border:none;
    color: white;
    background-color: rgba(0,0,0,0.7);
    transition: 0.5s;
    margin: 30px 0px;
    border-radius: 10px;
    font-family: 'Stylish', sans-serif;
    box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
	
}
button:hover{
    background-color: rgba(0,0,0,0.9);
}
#result{
    width:600px;
    height: 700px;
    margin: 50px;
    border-radius: 10px;
    background-color: rgba(255,255,255,0.5);
    overflow: scroll;
    padding:50px 10px;
    position:relative;
}
select{
    font-size: 30px;
    width: 100%;
    text-align: center;
    padding: 10px;
    border-radius: 10px;
    border: none;
    outline: none;
    color:black;
}
option{
    border-radius: 10px;
}
#top{
	position:absolute;
	left:0%;
	right:0%;
	top:0%;
	background-color:rgba(0,0,0,0.8);
	color:white;
	text-align:center;
	padding:10px;
}
    </style>

</head>
<body id="logbody">
    <div id="logheader">
        <h1 class="apptitle">Go World</h1>
    </div>
    <form action="statelist">
        <select name="tableget">
        <option name='tableName' value='" + c + "'  class='content-buttons' disabled>"select something"</option>
          <%
          
          ArrayList std2 = (ArrayList)request.getAttribute("data");
          if(std2!=null){
          for(Object c:std2){
          	out.println("<option name='tableName' value='" + c + "'  class='content-buttons'>" + c + "</option>");
          }
          }
          
          %> 
        </select>
        <button>ok</button>
    </form>
    <div id="result">
    <h1 id="top"><% 
    String country = (String)request.getAttribute("country");
    if(country!=null){
    	out.println(country);	
    }	
    	%></h1>
	<% 
	
	  ArrayList std3 = (ArrayList)request.getAttribute("statedata");
    if(std3!=null){
    for(Object c:std3){
    	out.println("<li id='li'>"+c+"</li>");
    }
    }
	%>
    </div>

    
</body>
</html>