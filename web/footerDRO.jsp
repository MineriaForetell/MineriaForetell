
<!-- Tiny Footer start-->
<div id="tiny-footer" class="tiny-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <p class="copyright-ct whitefontcolor">Developers © 2016 Mineria Foretell | <a href="#" class="copyright-ct">Privacy policy</a></p>
            </div>
            <div class="col-md-6">
                <ul class="social-icon-ft pull-right">
                    <li><a href="#"><i class="fa fa-facebook-square"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter-square"></i></a></li>
                    <li><a href="#"><i class="fa fa-google-plus-square"></i></a></li>
                    <li><a href="#"><i class="fa fa-rss-square"></i></a></li>
                    <li><a href="#"><i class="fa fa-linkedin-square"></i></a></li>
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
<script type="text/javascript" src="js/bootstrap.min.js"></script> 

<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<!--Camera JS Script--> 
<script type="text/javascript" src="js/jquery.min.js"></script> 
<script type="text/javascript" src="js/jquery.mobile.customized.min.js"></script> 
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script> 
<script type="text/javascript">
    jQuery(function() {
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
    /* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
<!--login done-->