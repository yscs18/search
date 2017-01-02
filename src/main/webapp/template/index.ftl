<!DOCTYPE html>
<html>

<head lang="zh">
    <meta charset="UTF-8">
    <title>西大搜索</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="alternate icon" type="image/png" href="${request.contextPath}/assets/i/favicon.png">
    <link rel="stylesheet" href="${request.contextPath}/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${request.contextPath}/assets/css/app.css" />
</head>

<body>
   <div class="am-vertical-align" style="height:500px;">
        <div class="am-vertical-align-middle am-g">
            <div class="header am-g">
                <div class="am-u-lg-2 am-u-sm-4 am-u-lg-centered am-u-sm-centered am-u-md-centered">
                    <img src="${request.contextPath}/assets/images/logo.png">
                </div>
            </div>

            <div class="am-g">
                <div class="am-u-lg-6 am-u-md-8 am-u-sm-10 am-u-sm-centered">
                    <form method="post" class="am-form" action="${request.contextPath}/s">
                        <input type="hidden" name="page" value="0">
                        <div class="am-input-group">
                            <input type="text" class="am-form-field" name="k" placeholder="简单一点，更懂西大">
                            <span class="am-input-group-btn">
                              <button type="submit" class="am-btn am-btn-secondary">点我搜索</button>
                            </span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="am-footer am-footer-default am-topbar-fixed-bottom">
        <div class="am-footer-miscs">
        	<hr/>
            <p>由 <a href="" title="" target="_blank" class="">西大搜索</a> 提供技术支持</p>
            <p>CopyRight©2017 SWUSearch Inc.</p>
            <p>-</p>
        </div>
    </div>
        <!--[if lt IE 9]>
    <script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="assets/js/amazeui.ie8polyfill.min.js"></script>
    <![endif]-->

    <!--[if (gte IE 9)|!(IE)]><!-->
    <script src="${request.contextPath}/assets/js/jquery.min.js"></script>
    <!--<![endif]-->
    <script src="${request.contextPath}/assets/js/amazeui.min.js"></script>
</body>

</html>
