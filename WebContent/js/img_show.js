// 主体部分图片轮播
$(function(){
                //手动控制轮播图
    $('.gird_img li').eq(0).show();

    $('.circle li').mouseover(function(){
        $(this).addClass('current').siblings().removeClass('current');
        var index=$(this).index();
        i=index;
        $('.gird_img li').eq(index).stop().fadeIn(300).siblings().stop().fadeOut(300);
    })
    //自动播放
    var i=0;
    var t=setInterval(move,5000);
    //自动播放核心函数
    function move(){
        i++;
        if(i==8){
            i=0;
        }
        $('.circle li').eq(i).addClass('current').siblings().removeClass('current');
        $('.gird_img li').eq(i).fadeIn(300).siblings().fadeOut(300);
    }

    //向右播放核心函数
    function moveL(){
        i--;
        if(i==-1){
            i=7;
        }
        $('.circle li').eq(i).addClass('current').siblings().removeClass('current');
        $('.gird_img li').eq(i).fadeIn(300).siblings().fadeOut(300);
    }
    $('.arr_l').click(function(){
            moveL();
    })
    $('.arr_r').click(function(){
        move();
    })
    //鼠标移入移除
    $('.gird_mb').hover(function(){
        clearInterval(t);
    },function(){
        t=setInterval(move,5000);
    })
    
});