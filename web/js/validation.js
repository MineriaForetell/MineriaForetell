function validate(evt) {
  var theEvent = evt || window.event;
  var key = theEvent.keyCode || theEvent.which;
  key = String.fromCharCode( key );
  var regex = /[0-9]/;
  if( !regex.test(key) ) {
    theEvent.returnValue = false;
    if(theEvent.preventDefault) theEvent.preventDefault();
  }
}

function formValidation()
{
    var frm = document.forms["registration"];
    var letters = /^[A-Za-z]+$/;
    var password = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
    var email = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var number = /^\d{10}$/;

    var zip = $('frm.pincode').val();

    var zipRegex = /^\d{6}$/;
    var specialKeys = new Array();
    specialKeys.push(8); //Backspace
    

    if (letters.test(frm.fname.value) == false)
    {
        alert("First name should contain alphabets only !");
        frm.fname.focus();
        return false;
    }
    if (letters.test(frm.lname.value) == false)
    {
        alert("Last name should contain alphabets only!!");
        frm.lname.focus();
        return  false;
    }
    if (email.test(frm.email.value) == false)
    {
        alert("Invalid email address!!");
        frm.email.focus();
        return false;
    }
    if (password.test(frm.pwd1.value) == false)
    {
        alert("Password should be between 6 to 20 characters which contain at least one numeric digit, one uppercase and one lowercase letter!!");
        frm.pwd1.focus();
        return false;
    }
    if (frm.pwd1.value != frm.pw2.value)
    {
        alert("Passwords do not match!!");
        frm.pwd1.focus();
        return false;
    }
    


    if (number.test(frm.contact.value) == false)
    {
        alert("Mobile number should contain 10 digits!!");
        frm.contact.focus();
        return false;
    }
    if (!zipRegex.test(zip))
    {
        alert("Zip code should contain 6 digit only !");
        frm.pincode.focus();
        return false;
    }

    return true;
}
//function numberAllowance() {
//        $(".numeric").bind("keypress", function(e) {
//            var keyCode = e.which ? e.which : e.keyCode
//            var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
//            $(".error").css("display", ret ? "none" : "inline");
//            return ret;
//        });
//        $(".numeric").bind("paste", function(e) {
//            return false;
//        });
//        $(".numeric").bind("drop", function(e) {
//            return false;
//        });
//    }
