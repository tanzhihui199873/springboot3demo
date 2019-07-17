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
            var rows=data.rows;
            $("#rows").html("总共"+data.rows+"条记录");
            $("#nowPage").html("当前为第"+(p+1)+"页");
            if(p>0){

                $("#firstPage").html("第一页");
                $("#previousPage").html("上一页");
                $("#firstPage").click(function(){
                    init(p,nav_id,article_title);
                })
                $("#previousPage").click(function(){
                    init(p-1,nav_id,article_title);
                })
            }
            var  totalPages = parseInt((rows%10==0?rows/10:(rows / 10 +1)));
            if(p<totalPages-1){
                $("#nextPage").html("下一页");
                $("#lastPage").html("最后一页");
                $("#nextPage").click(function(){
                    init(p+1,nav_id,article_title);
                })
                $("#lastPage").click(function(){
                    init(totalPages-1,nav_id,article_title);
                })}

            $("#pageCount").html("共"+totalPages +"页");
            if(totalPages>1){

            }

        }
    })
}