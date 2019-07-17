function init(p,nav_id,article_title) {
    $.ajax({
        type:'post',
        dataType:'json',
        data:{p:p,nav_id:nav_id,article_title:article_title}, //传接收到的参数id
        url:'/api/queryArticleByPage',
        success:function(data){
            $("#nav_id").html("");
            $("#nav_id").append("<option >==请选择新闻类别==</option>");
            for (var i=0;i<data.navList.length;i++){
                $("#nav_id").append("<option value="+data.navList[i].nav_id+">"+data.navList[i].nav_name+"</option>")
            }
            $("#rows").html("总共"+data.rows+"条记录");
            $("#nowPage").html("");
            $("#previousPage").html("");
            $("#nextPage").html("");
            $("#lastPage").html("");
            $("#pageCount").html("");

        }
    })
}