function  init(){
    $.ajax({
        type:'post',
        dataType:'json',
        url:'/api/queryManagerAll',
        success:function(data) {
            $("#t_content").html("");
            for (var i = 0; i < data.length; i++) {

            $("#t_content").append("<tr>\n" +
                "                        <td><input type='radio' name='rad' value="+data[i].manager_id+" autocomplete='off'/></td>\n" +
                "                        <td class='text-center'>"+i+"</td>\n" +
                "                        <td class='text-center'>"+data[i].manager_id+"</td>\n" +
                "                        <td class='text-center'>"+data[i].manager_name+"</td>\n" +
                "                    </tr>")


            }
        }
    })
}