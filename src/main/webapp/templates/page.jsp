<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Newsfeed</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5 mb-5">

    <div style="width:70%;display: block;margin: auto;margin-bottom: 50px;">
        <form class="row g-3" action="/" method="post" style="width: 100%">
            <div class="col">
                <input class="form-control" id="exampleDataList" placeholder="Type to search..." name="topic" >
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">Search</button>
            </div>
        </form>

    </div>
    <div class="mb-5">
        <h3>${batchsize} result found on topic : ${query}</h3>
    </div>

    <div style="display: flex; justify-content: space-around; flex-wrap: wrap;width:100%">
        <c:forEach items="${datas}" var="data">

            <div class="card m-2" style="width: 24rem;">
                <img src="${data.imageurl}" class="card-img-top" alt="">
                <div class="card-body">
                    <h5 class="card-title">${data.title}</h5>

                    <p class="card-text">${data.desc}</p>
                    <a href="${data.url}" class="card-link">Read in details.</a>

                </div>
            </div>

        </c:forEach>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
<script>
    if (window.history.replaceState) {
        window.history.replaceState(null, null, window.location.href);
    }
</script>
</body>
</html>
