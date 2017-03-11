function imagevalidation(){
var ext = $('#image').val().split('.').pop().toLowerCase();//give tag to image form > image - input type 
if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
    alert('invalid extension!');
}
}

$("#file").validate({ 
          onfocusout: function(e) {
              this.element(e);
            },
        rules:{

            resume:{
                required:true,
                extension: "docx|rtf|doc|pdf"
            }

        },
    resume:{
                required:"input type is required",                  
                extension:"select valied input file format"
            }


    });
