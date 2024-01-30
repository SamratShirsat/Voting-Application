<html>
<head>
    <title>Voting Page</title>
</head>
<body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <div class="d-flex justify-content-center">
        <form action = "/Final" method = "post">
          <h1>Welcome To Voting Application</h1>
          <br>

          <hr>1. Select Your Favorite Language</hr>
          <br>
          <input type="radio" id="html" name="fav_language" value="html">
          <label for="html">html</label><br>
          <input type="radio" id="css" name="fav_language" value="CSS">
          <label for="css">CSS</label><br>
          <input type="radio" id="javascript" name="fav_language" value="JavaScript">
          <label for="javascript">JavaScript</label>
          <br>
          <button type="submit" class="btn btn-primary">Primary</button>
          <br>
          <br>
        </form>
    </div>
</body>
</html>
