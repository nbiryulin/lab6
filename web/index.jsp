<%--
  Created by IntelliJ IDEA.
  User: nbiryulin
  Date: 10.12.2021
  Time: 01:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/autocomplete.js"></script>

    <SCRIPT language="JavaScript" type="text/javascript">



      $(document).ready(function () {
        // $('#bttHello').click(function () {
          var fullname = $('#fullname').val();
          console.log("dddddd");
          $.ajax({
            type:'POST',
            data: {fullname: fullname},
            url:'AjaxController',
            success: function (result) {
              console.log(result);
              // result.map( item => item.toString);
              let value = eval(result);
              console.log(value)
              autocomplete(document.getElementById("myInput"), value );
              autocomplete(document.getElementById("myInput1"), value );
              //$('#result1').html(result);
            }
          });
        // });
      });

    </SCRIPT>

    <script>

    </script>
</head>
<body>
<%--<form method="get" action="/lab6_war_exploded/save">--%>
<%--    <input type="text" name="name">--%>
<%--    <input type="submit" name="add" value="add">--%>
<%--    <input type="submit" name="showAll" value="showAll">--%>
<%--    <br>--%>
<%--    <input type="text" name="album_name">--%>
<%--    <input type="text" name="type">--%>

<%--</form>--%>
<form method="get" action="/lab6_war_exploded/save_all">
    <input type="text" name="name" placeholder="name">
    <input type="submit" name="add" value="addArtist">
    <input type="submit" name="showAll" value="showAll">
    <br>
    <input type="text" name="track_name" placeholder="track name">
    <input type="number" name="time" placeholder="time">
    <input type="text" name="artist_id" placeholder="artist id">
    <input type="text" name="album_id" placeholder="album id">
    <input type="submit" name="add" value="addTrack">
    <br>
    <input type="text" name="album_name" placeholder="album name">
    <input type="text" name="type" placeholder="type">
    <input type="text" name="artists_id" placeholder="artist id">
    <input type="submit" name="add" value="addAlbum">
</form>

<%--<form method="get" action="/lab6_war_exploded/album">--%>
<%--    <input type="text" name="name">--%>
<%--    <input type="submit" name="add" value="find">--%>
<%--    <br>--%>
<%--</form>--%>

<form autocomplete="off" method="get" action="/lab6_war_exploded/album">
    <div class="autocomplete" style="width:300px;">
        <input id="myInput1" type="text" name="name" placeholder="Artist name">
        <input type="submit" name="add" value="find">
        <br>
    </div>
</form>

<%--<form method="get" action="/lab6_war_exploded/track">--%>
<%--    <input type="text" name="name">--%>
<%--    <input type="submit" name="add" value="find">--%>
<%--    <br>--%>
<%--</form>--%>

<%--<label for="frmNameA">Name</label>--%>
<%--<input type="text" name="name" id="frmNameA" placeholder="Full name" required autocomplete="name">--%>
<form autocomplete="off" method="get" action="/lab6_war_exploded/track">
    <div class="autocomplete" style="width:300px;">
        <input id="myInput" type="text" name="name" placeholder="Artist name">
        <input type="submit" name="add" value="find">
        <br>
    </div>
</form>

<%--<form>--%>
<%--    Name <input type="text" id="fullname">--%>
<%--    <input type="button" value="Hello" id="bttHello">--%>
<%--    <br>--%>
<%--    <span id="result1"></span>--%>
<%--</form>--%>
</body>


</html>
