<!-- Tiny Footer start-->
<div id="tiny-footer" class="stickyfooter tiny-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <p class="copyright-ct whitefontcolor">Developers � 2016 Mineria Foretell | <a href="PrivacyPolicy.doc" class="copyright-ct">Privacy policy</a></p>
            </div>
            <div class="col-md-6">
                <ul class="social-icon-ft pull-right">
                    <li><a href="#"><i class="fa fa-facebook-square"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter-square"></i></a></li>
                    <li><a href="#"><i class="fa fa-google-plus-square"></i></a></li>
                    <li><a href="#"><i class="fa  fa-rss-square"></i></a></li>
                    <li><a href="#"><i class="fa  fa-linkedin-square"></i></a></li>
                    <li><a href="addGeologist.jsp"><i class="fa fa-sign-in"></i></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Tiny Footer End--> 
</body>
</html>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="js/jquery-1.11.1.min.js"></script> 
<!-- Include all compiled plugins (below), or include individual files as needed --> 

<script type="text/javascript" src="js/jquery.dataTables.js"></script> 

<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script> 
<script type="text/javascript" src="js/jquery.min.js"></script> 
<script type="text/javascript" src="js/jquery.mobile.customized.min.js"></script> 
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script> 
<script type="text/javascript" src="js/camera.js"></script> 

<script type="text/javascript">
    jQuery(function () {
        jQuery('#camera_wrap_1').camera({
            fx: 'simpleFade',
            time: 5000,
            loader: 'bar',
            hover: false,
            playPause: false,
            height: '30%'

        });
    });</script>


<script>
    $('input[type="submit"]').mousedown(function () {
        $(this).css('background', '#2ecc71');
    });
    $('input[type="submit"]').mouseup(function () {
        $(this).css('background', '#1abc9c');
    });

    $('#loginform').click(function () {
        $('.login').fadeToggle('slow');
        $(this).toggleClass('green');
    });
    $(document).mouseup(function (e) {
        var container = $(".login");

        if (!container.is(e.target) // if the target of the click isn't the container...
                && container.has(e.target).length === 0) // ... nor a descendant of the container
        {
            container.hide();
            $('#loginform').removeClass('green');
        }
    });
</script>
<!--login done-->

<script>
    $(window).scroll(function () {
        var sticky = $('.tp-navigations'),
                scroll = $(window).scrollTop();

        if (scroll >= 82)
            sticky.addClass('fixed');
        else
            sticky.removeClass('fixed');
    });
</script>


<script type="text/javascript">
$(document).ready(function(){
  $('ul li').click(function(){
    $('ul li').removeClass("activeclassic");
    $(this).addClass("activeclassic");
});
});
</script>



