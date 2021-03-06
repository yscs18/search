<!DOCTYPE html>
<html>

<head lang="zh">
    <meta charset="UTF-8">
    <title>西大搜索-${k}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
    <link rel="stylesheet" href="${request.contextPath}/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${request.contextPath}/assets/css/app.css" />
</head>

<body>
    <header class="am-topbar am-topbar-fixed-top">
        <h1 class="am-topbar-brand"><a href="${request.contextPath}/" class="am-text-middle">SWUSearch</a></h1>
        <form method="post" class="am-topbar-form am-topbar-left am-form am-u-lg-6" action="${request.contextPath}/s">
            <input type="hidden" name="page" value="0">
            <div class="am-input-group">
                <input type="text" class="am-form-field" name="k" placeholder="简单一点，更懂西大" value="${k}">
                <span class="am-input-group-btn">
                  <button type="submit" class="am-btn am-btn-secondary">搜索</button>
                </span>
            </div>
        </form>
    </header>
    <div class="am-g ">
        <div class="am-u-lg-8 am-u-lg-offset-1">
            <#if webPages>
                <div data-am-widget="list_news" class="am-list-news am-list-news-default">
                    <!--列表标题-->
                    <div class="am-list-news-hd am-cf">
                        <h2>${k}-搜索结果</h2>
                    </div>
                    <div class="am-list-news-bd">
                        <ul class="am-list">

                            <#list webPages as webpage>
                                <li class="am-g am-list-item-desced">
                                    <a href="${webpage.url}" target="_blank" class="am-list-item-hd ">${webpage.title}</a>
                                    <div class="am-list-item-text">${webpage.text}</div>
                                </li>
                            </#list>

                        </ul>
                    </div>
                </div>
            </#if>
        </div>
    </div>
    <div class="am-g pagination" id="pagination">

    </div>

 	<#include "/common/footer.ftl"/>
 	
    <script src="${request.contextPath}/assets/js/handlebars.min.js"></script>
    <script src="${request.contextPath}/assets/js/amazeui.widgets.helper.js"></script>
    <script type="text/javascript">
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "${request.contextPath}/p?k=${k}&nowPage=${nowPage}&count=${count}",
            success: function(data) {
                var template = Handlebars.compile('{{>pagination}}');
                var html = template(data);
                $('#pagination').append(html);
            },
            error: function() {

            }
        });
    </script>
</body>

</html>
