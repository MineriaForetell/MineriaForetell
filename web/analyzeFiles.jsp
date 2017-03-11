<%@page import="java.util.ArrayList"%>
<%@page import="Model.UserInfo"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="description" content="Industrial web templates for the mining company and service templates. Industrial web templates are designed with high standards and bootstrap framework.">
        <meta name="keywords" content="Industiral Templates, Service Templates, Bootstrap, Responsive">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Mineria Foretell</title>

        <!-- Bootstrap -->

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!--Custom templlate style.css-->
        <link href="css/style.css" rel="stylesheet">
        <!--Custom template style.css-->
        <link href="css/camera.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="css2/style2.css">

        <script type="text/javascript">

            var monthtext = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'];

            function populatedropdown(dayfield, monthfield, yearfield) {
                var today = new Date();
                var dayfield = document.getElementById(dayfield);
                var monthfield = document.getElementById(monthfield);
                var yearfield = document.getElementById(yearfield);
                for (var i = 1; i < 31; i++)
                    dayfield.options[i] = new Option(i, i + 1)
                dayfield.options[today.getDate()] = new Option(today.getDate(), today.getDate(), true, true) //select today's day
                for (var m = 1; m < 12; m++)
                    monthfield.options[m] = new Option(monthtext[m], monthtext[m])
                monthfield.options[today.getMonth()] = new Option(monthtext[today.getMonth()], monthtext[today.getMonth()], true, true) //select today's month
                var thisyear = today.getFullYear()
                for (var y = 0; y < 20; y++) {
                    yearfield.options[y] = new Option(thisyear, thisyear)
                    thisyear += 1
                }
                yearfield.options[0] = new Option(today.getFullYear(), today.getFullYear(), true, true) //select today's year
            }

        </script>
        <script type="text/javascript">

            //populatedropdown(id_of_day_select, id_of_month_select, id_of_year_select)
            window.onload = function () {
                populatedropdown("daydropdown", "monthdropdown", "yeardropdown")
            }
        </script>

    </head>

    <body>
        <%
            HttpSession hs = request.getSession();
            UserInfo ui = (UserInfo) hs.getAttribute("fname");            
            int number = Integer.parseInt(request.getParameter("mineId").toString());
            hs.setAttribute("number", number);
        %>
        <!--header start-->
        <div class="header-row" id="header-row">
            <div class="container">
                <div class="row"> 
                    <!--logo start-->
                    <div class="col-md-2"> 
                        <a class="navbar-brand logo" href="index.jsp"><img src="images/logo.png" alt="company logo"></a> </div>
                    <!--logo start close-->
                    <div class="col-md-8 contact-info">
                        <span class="call-number"></span>

                        <div id="navthing" >
                            <h4 class="pull-right whitefontcolor">Mining Engineer:<a href="#" id="loginform"><span class="pull-right" style="padding-left:5px;"><%=ui.getUserFirstName()%></a></h4>

                           
                    <div class="col-md-2">
                        <ul class="social-icon">

                           
                            <li class="dropdown"> 
                                <a href="#" class="paddingsetter-left dropdown-toggle fa fa-cogs" data-toggle="dropdown">
                                    <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="profileEditor/index.html">Edit Profile</a></li>
                           
                                    <li><a href="Logout.jsp">Logout</a></li>
                                </ul>
                            </li>
                           
                        </ul>
                    </div>


                </div>
               
            </div>
        </div>

        <!--header Close--> 
        <!--template navigation start-->
        <div class="tp-navigations">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container"> 
                    <!-- Brand and toggle get grouped for better mobile display -->

                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="IndexMiningEngineer.jsp">Home</a></li>
                            <li><a href="addDRO.jsp">Add DRO</a></li>
                            <li><a href="ProjectList?page=ViewProject">View Project</a></li>
                            <li><a href="ProjectList?page=assignWork">Assign Tasks</a></li>
                            <li class="activeclassic"><a href="ProjectList?page=ProcessHDFS">Analyze Files</a></li>


                            <!--                            <form class="navbar-form navbar-right" role="search" >
                                                            <div class="input-group">
                                                                <input type="text" class="form-control" placeholder="search here" >
                                                                <span class="input-group-btn">
                                                                    <button class="btn btn-default btn-yellow" type="button">Go!</button>
                                                                </span> </div>
                                                             /input-group 
                                                        </form>-->
                    </div>
                    <!-- /navbar-collapse --> 

                </div>
                <!-- /.container --> 
            </nav>
        </div>
        <!--template navigation close--> 
        <!--tp Heading End--> 

      
        <div id="footer" class="footer-section">
            <div class="container">
                <div class="row">

                    <div class="col-md-12 font-fade" style="text-align: center" >            


                        <div class="col-md-4 font-fade" style="text-align: center" >
                            <div class="col-md-12 menudivs">
                                <form action="ProcessHDFS" method="get">
                                    <input type="submit" id="btnProcess" class="roundbuttons" value="Create File"/>
                                </form>
                            </div>
                            <div class="col-md-5"></div>
                            <div class="col-md-2 roundbuttons1"><h3>Step<br> 1</h3></div>
                            <div class="col-md-5"></div>
                            <div class="col-md-12">
                                <p><%if (request.getAttribute("msg1") != null) {
                                            String message = (String) request.getAttribute("msg1");%>
                                    <%=message%><%}%></p>
                            </div>
                        </div>

                        <div class="col-md-4 font-fade" style="text-align: center" >
                            <div class="col-md-12 menudivs">
                                <input type="button" id="btnStart" class="roundbuttons" name="btnStart" value="Start Hadoop" onclick='ajaxSyncRequestStart("analyzeFiles")'/>
                                 <!--<input type="button" id="btnStart" name="btnStart" value="Start Hadoop" onclick='ajaxSyncRequestStart("ProcessData")'/>-->
                            </div>
                            <div class="col-md-5"></div>
                            <div class="col-md-2 roundbuttons1"><h3>Step<br> 2</h3></div>
                            <div class="col-md-5"></div>
                            <div class="col-md-12">
                                <p id="processMessage"></p>
                            </div>
                        </div>                                        

                        <div class="col-md-4 font-fade" style="text-align: center" >
                            <div class="col-md-12 menudivs">
                                <input type="button" id="btnProcess" class="roundbuttons" name="btnProcess" value="Process" onclick='ajaxSyncRequestProcess("analyzeFiles")' disabled/>
                                <!--<input type="button" id="btnProcess" name="btnProcess" value="Process" onclick='ajaxSyncRequestProcess("ProcessData")' disabled/>-->
                            </div>
                            <div class="col-md-5"></div>
                            <div class="col-md-2 roundbuttons1"><h3>Step<br> 3</h3></div>
                            <div class="col-md-5"></div>
                            <div class="col-md-12">
                                <p id="message"></p>
                            </div>
                        </div>

                    </div>



                </div>
            </div>
        </div>    


        <jsp:include page="commonstickyfooter.jsp"></jsp:include>