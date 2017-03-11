<%-- 
    Document   : addProject
    Created on : 9 Jan, 2016, 9:50:59 PM
    Author     : raxton
--%>
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
        <!--Custom template style.css-->
        <link href="css/style.css" rel="stylesheet">
        <!--Custom template style.css-->
        <link href="css/camera.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
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
            ArrayList<UserInfo> MEList = (ArrayList<UserInfo>) hs.getAttribute("MEList");
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
                            <h4 class="pull-right whitefontcolor reporttext">Geologist:<a href="#" id="loginform"><span class="pull-right" style="padding-left:5px;"><%=ui.getUserFirstName()%></span></a></h4>
                          
                            <img class="profile-shape" height="30px" width="30px" src="images/Rax.jpg">
                          
                        </div>
                    </div>
                    
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
                            <li><a href="IndexGeologist.jsp">Home</a></li>
                            <li ><a href="addMiningEngineer.jsp">Add Engineer</a></li>

                            <li class="activeclassic"><a href="addProject.jsp">Add Project</a></li>
                            <li><a href="viewReport.jsp">View Report</a></li>
                            <li><a href="GraphicalFormat.jsp">Graphical Format</a></li>

                        </ul>
                        
                    </div>
                    <!-- /navbar-collapse --> 

                </div>
                <!-- /.container --> 
            </nav>
        </div>
        <!--template navigation close--> 
        <!--tp Heading End--> 

      
        <div class="container container-fluid">
            <div class="row">

                <div class="col-md-12 fontbigger" >            
                    <div class="col-md-2 fontbigger"  >
                    </div>
                    <div class="col-md-8 fontbigger message-mail addUserForm ">
                        <form action="addProject" id="registration" method="post"  onsubmit="return(formValidation());">
                            <center><div class="col-md-12 fontbigger message-mail">

                                    <ul>        
                                        <li><input type="text" name="company_name" placeholder="Company Name" class="register message-mail" required/></li>
                                        <li><input type="text" name="project_name" placeholder="Project Name" class="register message-mail" required/></li>
                                        <li><input type="text" name="mine_location" placeholder="Location" class="register message-mail" required/></li>
                                        <li><input type="text" name="mine_area" placeholder="Area" value="" class="register message-mail" required/></li>                              
                                        <li><input type="number" name="points" placeholder="Number of points" class="register message-mail" required/></li>
                                        <li><input type="number" name="tasks" placeholder="Number of Tasks" class="register message-mail" required/></li>                                                             
                                        <li><select name="userIdTo" class="register message-mail" required>
                                                <option selected>Select a Mining Engineer</option>                                                    
                                        <% for(int i=0;i<MEList.size();i++)
                                        {%>
                                        <option value="<%=MEList.get(i).getUserId().getUserId() %>"><%=MEList.get(i).getUserFirstName()%></option>
                                        <%}%></select></li>
                                        
                                        <legend class="addUserForm message-mail2" style="width:74%">
                                            <span style="text-align: center;">Due date for the project</span><br>
                                            <li>
                                                <select id="daydropdown" class="message-mail2 register" name="dayfield">
                                                </select> 
                                                <select id="monthdropdown" class="message-mail2 register" name="monthfield">
                                                </select> 
                                                <select id="yeardropdown" class="message-mail2 register" name="yearfield">
                                                </select> 
                                            </li>
                                        </legend>

                                        <!--<button class="marginsetter-left pull-left" onclick="addToListFunction()">Add</button> <br>-->

                                        <!--<button class="marginsetter-left pull-left">Remove</button>-->

                                    </ul>
                                </div>


                                <input type="submit" name="submit-message" name="submit" value="Assign Work" class="message-mail2 sub-btn"/>
                            </center> </div>

                    <!--==================half part finished==========================-->
                    </form>


                </div>
                <div class="col-md-2 fontbigger" >
                </div>
            </div>

        </div>
    </div>

    

    <jsp:include page="footerGeologist.jsp"></jsp:include>