<%@ page language="java" contentType="text/html; charset=ISO-8859-9″ pageEncoding=”ISO-8859-9″ %"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Doktorlar</title>
<style>
#text {
width:600px;
height:400px;
border: 8px solid;
font-size: 40px;
overflow: auto;
position: absolute; 
top: 250px; 
left: 400px;
background:white;
margin: auto;
}
.image { 
   position: relative; 
   width: 100%; 
   overflow: auto;
 
}
table {
    border-collapse: collapse;
    overflow: auto;
   
}
table, th, td {
    border: 1px solid black;
    align-content: center;
}
</style>
</head>

<body  >


<table width=100%  height=100% border="5" align="center" bgcolor="black">
<tr>
<td colspan="5" height=100%><center><font size=20 color="white">Berhayat Hastanesi</font></center></td>
</tr>
</table>
<table width=100% height=100% border="1" align="center" bgcolor="white">
<tr height="5" >

<td><b><a href="index.jsp">Anasayfa</a></b></td>
<td><b><a href="Doktorlar.jsp">Doktorlar</a></b></td>
<td><b><font><a href="iletisim.jsp">İletişim</a></b></td>

</tr>
</table >

<hr />
<marquee><font style="font-family: times, serif; font-size:14pt; font-style:italic">#BerhayatHastahanesi</font></marquee>
<hr />

 <div class="image" >
  <img src="resimler/Berhayat.jpg"  height=100% width=100% border="8"/>
 </div>
 <div id='text'>
<table align="center">
 <tr >
  <td>Dr.Ali Vefa</td>
  <td> Aile Hekimliği</td>
 </tr>
 <tr>
   <td>Dr.Feyzullah Durmuş</td>
  <td> Aile Hekimliği</td>
 </tr>
 <tr>
    <td>Dr.Hüsamettin Erdoğan</td>
  <td> Çocuk Hastalıkları</td>
 </tr>
 <tr>
   <td>Dr.Mert Kızılkaya</td>
  <td> Çocuk Hastalıkları</td>
 </tr>
 <tr>
   <td>Dr.Fevziye Durmuş</td>
  <td> Dermatoloji</td>
 </tr>
 <tr>
   <td>Dr.Hüseyin Korkut</td>
  <td> Dermatoloji</td>
 </tr>
  <tr>
   <td>Dr.Ahmet Serkan Fidancı</td>
  <td> Dermatoloji</td>
 </tr>

</table>
</div>


</body>

</html> 