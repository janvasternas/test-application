<!DOCTYPE html>
<html>
<head>
    <title>Lookup Movie</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    var search = function() {
        var title = $("#title").val();
        $.getJSON("/api/search/" + encodeURIComponent(title), function(data) {
            var container = $('#result');
            container.empty();
            $.each(data, function(key, val) {
                container.append('<div class="movie"><span>' + val.title + '</span><img src="' + val.poster+ '"/></div>');
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
        <p>Simple move search</p>
        <form id="search-form" class="form-search">
            <input type="text" class="input-medium search-query" id="title"
                pattern="Movie title">
            <button type="submit" class="btn">Search</button>
        </form>
        <div id="search" onclick="search();">Search</div>
        <div id="result"></div>
    </div>
</body>
</html>
