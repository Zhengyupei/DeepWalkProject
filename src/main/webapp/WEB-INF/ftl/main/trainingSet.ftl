<!--traingSet Page-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>我们的训练集</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style type="text/css">
    #top{width: 100%;  height: 60px;}
    #mainBody{background-image: url(sky.gif) ;  width: 100%;  position: absolute;  top: 60px;  bottom: 0px;  left: 0px;}
    #detailsTable{opacity: 0.8}
    th{text-align: center}
    tr{height: 120px;font-size: 20px}
    td video{background-color: #00a7d0;height: 100px;width: 120px;}
</style>


<body>
<nav class="navbar navbar-inverse" id="top" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="color: #00a7d0">DeepWalk手语翻译</a>
        </div>
    </div>
</nav>
<!--end of nav above-->
<div id="mainBody">
    <div style="position: absolute;top: 0px;left: 110px;right: 110px;bottom: 50px;background-color: #2f3238;border-radius: 5px;overflow-y:auto" >
        <table id="detailsTable" class="table table-bordered table-striped" style="text-align: center;">
            <thead style="background-color: #00a7d0">
            <th class="col-lg-2"><h2>关键字</h2></th><th class="col-lg-10"><h2>我们的训练集</h2></th>
            </thead>
            <tbody style="color: red">
            <tr>
                <td>今天</td>
                <td><video src="" controls></video></td>
            </tr>
            <tr>
                <td>天气</td>
                <td></td>
            </tr>
            <tr>
                <td>很</td>
                <td></td>
            </tr>
            <tr>
                <td>好</td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>