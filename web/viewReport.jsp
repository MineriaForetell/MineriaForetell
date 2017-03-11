<%--<jsp:include page="HeaderGeologist.jsp"></jsp:include>--%>
<%@page import="java.util.List"%>
<%@page import="Model.ProjectDetails"%>
<%@page import="Model.MineriaDetails"%>
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
        <title>
            <%
                HttpServletRequest request1 = (HttpServletRequest) request;
                String uri = request1.getRequestURI();
            %>
            <%=uri%> Mineria Foretell</title>

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
            ArrayList<MineriaDetails> md = (ArrayList<MineriaDetails>) request.getAttribute("mineria_details");
            ProjectDetails pd = (ProjectDetails) request.getAttribute("proj_det");
            List list = (List)request.getAttribute("graphData");
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
                            <li><a href="addMiningEngineer.jsp">Add Engineer</a></li>

                            <li><a href="addProject.jsp">Add Project</a></li>
                            <li class="activeclassic"><a href="viewReport.jsp">View Report</a></li>
                            <li><a href="GraphicalFormat.jsp">Graphical Format</a></li>

                        </ul>
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
        <div class="container">
            <div class="row">

                <div class="col-md-12" >            
                    <div class="col-md-2"  >
                    </div>
                    <div class="col-md-8 message-mail addUserForm ">
                        <%
                            if (pd != null) {
                        %>
                        <center><table border="1">
                                <tr>
                                    <td class="reporttext whitefontcolor">Company Name  </td>
                                    <td class="reporttext whitefontcolor"><%= pd.getCompanyName()%> </td>
                                </tr>
                                <tr>
                                    <td class="reporttext whitefontcolor">Project Name </td>
                                    <td class="reporttext whitefontcolor"><%= pd.getProjectName()%> </td>
                                </tr>
                                <tr>
                                    <td class="reporttext whitefontcolor">Location</td>
                                    <td class="reporttext whitefontcolor"><%= pd.getMineLocation()%> </td>
                                </tr>
                                <tr>
                                    <td class="reporttext whitefontcolor">Area </td>
                                    <td class="reporttext whitefontcolor"><%= pd.getMineArea()%> </td>
                                </tr>                                
                            </table>
                            <table border="3" id="point_table_DRO" class="table-bordered table-responsive padding-10" style="width:70%;text-align:center">
                                <tr>
                                    <th>Sr No.</th>
                                    <th>Expected Mineral</th>
                                    <th>Quantity</th>
                                    <th>Cost</th>
                                </tr>
                                <% if ((md != null)) {
                                        for (int i = 1; i < md.size(); i++) {%>
                                <tr>
                                    <td><%=i%></td>
                                    <td><%=md.get(i).getExpectedMineral()%></td>                                    
                                    <td><%=md.get(i).getQuantity()%></td>
                                    <td><%=md.get(i).getCost()%></td>
                                </tr>
                                <%}
                                    }%> 

                            </table>

                            <%
                                }
                            %>
                            <%{
                            %>
                            <a href="GraphicalFormat?mineId=<%=pd.getMineId()%>"><input type="button" value="View Graphical Format" class="message-mail sub-btn"></a>
                                <%}%>
                        </center>
                    </div>
                    <div class="col-md-2 fontbigger" >
                    </div>
                </div>

            </div>
        </div> 

        <!------------------------------->

        <jsp:include page="stickyfooter.jsp"></jsp:include>