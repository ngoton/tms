$(function () {
    setNavigation();
    var $loader = $('#ajax_loader'), timer;

    $loader.hide()
        .ajaxStart(function()
        {
            timer && clearTimeout(timer);
            timer = setTimeout(function()
                {
                    $loader.fadeIn(200);
                },
                1000);
        })
        .ajaxStop(function()
        {
            clearTimeout(timer);
            $loader.fadeOut(200);
        });
});

function setNavigation() {
    var path = window.location.pathname;
    path = path.replace(/\/$/, "");
    path = decodeURIComponent(path);

    $(".nav a").each(function () {
        var href = "/"+$(this).attr('data');
        if (path === href) {
            $(this).closest('li').addClass('active');
            $(this).closest('li').parents('li').addClass('active open');
        }
        if (window.location.hash == $(this).attr("data")) {
          var hrefval = $(this).attr("data");
          if(hrefval != "#") {
            $(this).closest('li').addClass('active');
            $(this).closest('li').parents('li').addClass('active');
          }
        }
        
    });
}
