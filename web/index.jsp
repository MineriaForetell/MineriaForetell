<jsp:include page="header.jsp"></jsp:include>
   
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="images/slider-1.jpg" alt="First Slide">
            </div>

            <div class="item">
                <img src="images/slider-2.jpg" alt="First Slide">
            </div>

            <div class="item">
                <img src="images/slider-3.jpg" alt="First Slide">
            </div>

        </div>
        <!-- Left and right controls -->
        <a class="left carousel-control fabigfont" href="#myCarousel" role="button" data-slide="prev">
            <span class="fa fa-arrow-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control fabigfont" href="#myCarousel" role="button" data-slide="next">
            <span class="fa fa-arrow-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

   
    <div id="stripe-line"></div>

    <div class="tp-aboutus" id="aboutus">
        <div class="container">
            <div class="row">
                <div class="col-md-12 tp-heading-title pull-left" >
                    <!--tp-heading title start-->
                    <h1>Welcome to Mineria Foretell</h1>
                    <p>Mineria Foretell is a system that forecasts the quantity of minerals like iron ore, coal, bauxite and many others available in a mine. The system will show the results related to the efforts required for mining and cost of mining as output. The system will be helpful in predicting whether the land is suitable for mining and whether the client should buy that land or not.</p>
                    <p>The geologist can consult our system to evaluate a mining project. He can add Mining Engineers and can give access to them for some specific functionalities provided by over system. Mining Engineer can add Drill Rig Operators and they will generate sample files by sample drilling.</p>
                </div>
                <!--tp-heading title start--> 
            </div>
        </div>
    </div>

    <div id="stripe-line"></div>

  
    <div id="footer" class="footer-section">
        <div class="container">
            <div class="row">
                <div class="tp-ft-section-second  ">
                    <div class="col-md-12 " style="text-align: center"  >
                        <h2 id="servicesection">Services</h2>
                        <div class="col-md-4 fontbigger" style="text-align: center">
                            <ul>
                                <img src="images/effort.png" style="height:250px;width:250px;"/>
                                <li>Effort estimation</li>
                            </ul>
                        </div>
                        <div class="col-md-4 fontbigger" style="text-align: center">
                            <ul>
                                <img src="images/cost.jpg" style="height:250px;width:250px;"/>
                                <li>Cost estimation</li>
                            </ul>
                        </div>
                        <div class="col-md-4 fontbigger" style="text-align: center">
                            <ul>

                                <img src="images/graph.png" style="height:250px;width:250px;"/>
                                <li>Graphical representation</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-12 fontbigger" style="text-align: center">
                        <div class="col-md-6" style="text-align: center" id="servicesection">
                            <ul>
                                <img src="images/mineral.png" style="height:250px;width:250px;"/>
                                <li>Approximate type and quantity of expected mineral</li>

                            </ul>
                        </div>
                        <div class="col-md-6 fontbigger" style="text-align: center">
                            <ul>
                                <img src="images/Report.jpg" style="height:250px;width:250px;"/>
                                <li>Conclusive Report Generation</li>

                            </ul>
                        </div>

                    </div>




                </div>
            </div>
        </div>
    </div>
  
    <div id="stripe-line"></div>
 
    <div class="container">
        <div class="row">   
            <div class="tp-ft-section-second">

                <!--Location map image-->

                <div class="col-md-6" id="contactus">
                    <h2>Contact Us</h2>
                    <ul>
                        <li>NovOpsis Developer Group</li>
                        <li>address : 321 , Satyam Mall</li>
                        <li>Mansi Cross Road </li>
                        <li>Satellite</li>
                        <li>Ahmedabad-380015</li>
                        <li><i class="fa fa-envelope"></i>prashant@novopsis.com</li>
                        <li><i class="fa fa-phone"></i>+91 990 990 53970</li>
                    </ul>
                </div>
                <div class="col-md-6" id="contactus">
                    <h2>Want to use our service ? </h2>
                    <h3>Send us a message</h3>
                    <form action="SendMailSSL" method="post">
                        <input type="text" name="fullname" placeholder="Full Name" class="message-mail" size="20" required/>
                        <input type="text" name="user_contact_number" maxlength="10" onkeypress='validate(event)' placeholder="Contact No" class="message-mail" required/>
                        <input type="email" name="email" value="" placeholder="Email Address" class="message-mail" required/>
                        <label>Purpose to use application for...</label> <textarea name="content" rows="5" cols="40" class="message-mail" required="">
                        </textarea>
                        <input type="submit" name="submit-message" name="submit" value="submit" class="message-mail sub-btn"/>
                   
                </form>

            </div>
        </div>
    </div>
</div>


<div id="stripe-line"></div>

<jsp:include page="footer.jsp"></jsp:include>

