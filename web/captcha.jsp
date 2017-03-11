<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="description" content="ron ore, coal, bauxite and many others available in a mine. The system will show the results related to the efforts required for mining and cost of mining as output. The system will be helpful in predicting whether the land is suitable for mining and whether the client should buy that land or not.">
        <meta name="keywords" content="Mineria foretell,predict cost of Mine,mineral expectation">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Mineria Foretell</title>

        <!-- Bootstrap -->

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!--Custom template style.css-->
        <link href="css/style.css" rel="stylesheet">
        <!--Custom template style.css-->
        <link href="css/camera.css" rel="stylesheet">
        <!--Google web font css-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700,500' rel='stylesheet' type='text/css'>
        <!--font awesome icon css-->
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="css2/style2.css">
        <style>
            .carousel-inner > .item > img,
            .carousel-inner > .item > a > img {
                width: 100%;
                margin: auto;
            }
        </style>


    </head>

    <body>

        <!--header start-->
        <div class="header-row fullwidth" id="header-row">
            <div class="container">
                <div class="row" id="home"> 
                    <!--logo start-->
                    <div class="col-md-2"> 
                        <a class="navbar-brand logo" href="index.jsp">
                            <img src="images/logo.png" alt="company logo"></a>
                    </div>
                    <!--logo start close-->
<!--                    <div class="col-md-8 contact-info">
                        <span class="call-number"></span>
                        <div id="navthing">
                            <h2 class="whitefontcolor">
                                <a href="#" id="loginform">Login</a></h2>
                            <div class="login">
                                <div class="arrow-up"></div>
                                <div class="formholder">
                                    <div class="randompad">
                                        <form action="LoginServ" method="post">
                                            <fieldset>
                                                <label name="email">Email</label>
                                                <input type="email" placeholder="abc@example.com" name="username" required/>
                                                <label name="password">Password</label>
                                                <input type="password" placeholder="********" name="password" required/>
                                                <input type="submit" class="pull-left" value="Login" />
                                                <a href="reset.jsp"><span class="pull-right reporttext"  style="margin: 0;padding-top: 13px;font-size: 16px;color:#fac11b">Forgot Password?</span></a>
                                            </fieldset>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>-->
                    <div class="col-md-2 pull-right">
                        <ul class="social-icon pull-right">
                            <!--social icon start-->
                            <li><a href="#"><i class="fa fa-facebook-square"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter-square"></i></a></li>
                            <li><a href="#"><i class="fa fa-google-plus-square"></i></a></li>
                        </ul>
                        <!--social icon end--> 
                    </div>
                </div>
            </div>
        </div>
        <!--header Close--> 
        <!--template navigation start-->
        <div class="tp-navigations">
            <nav class="navbar navbar-default fullwidth" role="navigation">
                <div class="container"> 
                    <!-- Brand and toggle get grouped for better mobile display -->

                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<!--                        <ul class="nav navbar-nav">
                            <li class="activeclassic"><a href="#home">Home</a></li>

                            <li><a href="#aboutus">About us</a></li>
                            <li><a href="#servicesection">Service</a></li>
                            <li><a href="#contactus">Contact us</a></li>
                        </ul>-->
                        <span style="background-color: green">
                        <%
                            if (request.getAttribute("msg1") != null) {
                                String message = (String) request.getAttribute("msg1");

                        %>
                        <%=message%>
                        <%}%>
                        </span>

                    </div>
                    <!-- /navbar-collapse --> 

                </div>
                <!-- /.container --> 
            </nav>
        </div>

        <!--template navigation close--> 

        <!--tp Heading End--> 

       
<div class="col-md-12 "> 
        <div class="col-md-4 ">

        </div>

    <div class="col-md-4 message-mail ">
<%@ page import="net.tanesha.recaptcha.ReCaptcha"%> 
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>    
         <form action="CaptchaServ" method="post" class="fullwidth addUserForm">
            <%
                ReCaptcha captcha = ReCaptchaFactory.newReCaptcha("6LfjRxoTAAAAABJ_vrZjUWZuN30zLOLpDvf2Q7Sb", "6LfjRxoTAAAAAEMC45NHX7hB-1hy3FMcG7FgEFRC", false);
                out.print(captcha.createRecaptchaHtml(null, null));
            %>  
                    <input type="submit" value="Verify Captcha" class="sub-btn message-mail fullwidth"/>
        </form>

    </div>
    <div class="col-md-4">

    </div>
</div>
<jsp:include page="stickyfooter.jsp"></jsp:include>
