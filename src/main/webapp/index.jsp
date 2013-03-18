<!DOCTYPE html>
<html>
<head>
    <title>Lookup Movie</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
    <link href="/example.css" rel="stylesheet">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    var search = function() {
        var title = $("#title").val();
        $.getJSON("/api/search/" + encodeURIComponent(title), function(data) {
            var container = $('#result');
            container.empty();
            $.each(data, function(key, val) {
                var newMovie = $("#movie-template li").clone();
                $("h3", newMovie).text("title");
                if (val.poster) {
                    $("img", newMovie).attr('src', "imgurl");
                }
                container.append(newMovie);
                });
            });
        }
    $(document).ready(function() {
        $('#search-form').submit(function() {
            search();
            return false;
        });
    });
    </script>
</head>

<body>
    <div class="container">
        <h1>Movie Lookup</h1>
        <p>Simple movie search. Enter a movie title (or part of a title). Of course you can improve on information shown and styling.</p>
        <form id="search-form" class="form-search">
            <input type="text" class="input-medium search-query" id="title" pattern="Movie title">
            <button type="submit" class="btn">Search</button>
        </form>
        <ul id="result" class="thumbnails">
        </ul>
    </div>
    <ul id="movie-template" style="display: none">
      <li class="movie span4">
        <div class="thumbnail">
          <img src="http://l.yimg.com/os/mit/media/m/entity/images/movie_placeholder-103642.png" alt="" 
            onError="this.onerror=null;this.src='http://l.yimg.com/os/mit/media/m/entity/images/movie_placeholder-103642.png'"/>
          <h3></h3>
        </div>
      </li>
    </ul>
</body>
</html>
