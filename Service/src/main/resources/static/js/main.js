$(document).ready(function () {

  let usernameError = true;
  let userSurnameError = true;
  let emailError = true;
  let phoneError = true;
  let sizeError = true;
  let periodError = true;
  let checkError = true;
  let wishesError = true;
  let bookingData ={};



  function validateUsername() {
    let usernameValue = $("#userName").val();
    if (usernameValue.length == "") {

      usernameError = false;
      SnackBar({
       message:"Ім'я не вказано",
       timeout:5000,
       position:'br',
       fixed:true,
       width:"20vw",
       status:"error"
     });
      return false;
    } else if (usernameValue.length < 2) {
      SnackBar({
       message:"Ім'я занадто коротке",
       timeout:5000,
       position:'br',
       fixed:true,
       width:"20vw",
       status:"error"
     });
      usernameError = false;
      return false;
    } else if(usernameValue.length > 15) {

      SnackBar({
       message:"Ім'я занадто довге",
       timeout:5000,
       position:'br',
       fixed:true,
       width:"20vw",
       status:"error"
     });
      usernameError = false;
      return false;
    } else {
      usernameError = true;

    }
    bookingData.name=usernameValue;
  }


    function validateUserSurname() {
        let userSurnameValue = $("#userSurname").val();
        if (userSurnameValue.length == "") {

            userSurnameError = false;
            SnackBar({
                message:"Прізвище не вказано",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"error"
            });
            return false;
        } else if (userSurnameValue.length < 2) {
            SnackBar({
                message:"Прізвище занадто коротке",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"error"
            });
            userSurnameError = false;
            return false;
        } else if(userSurnameValue.length > 15) {

            SnackBar({
                message:"Прізвище занадто довге",
                timeout:5000,
                position:'br',
                fixed:true,
                width:"20vw",
                status:"error"
            });
            userSurnameError = false;
            return false;
        } else {
            userSurnameError = true;

        }
        bookingData.surname=userSurnameValue;
    }





    // Validate Email
  function validateEmail(){
  const email = $("#email");

    let regex = /^([_\-\.0-9a-zA-Z]+)@([_\-\.0-9a-zA-Z]+)\.([a-zA-Z]){2,7}$/;
    let emailVal = email.val();
    if(emailVal.length==" "){
      SnackBar({
       message:"Email не вказаний",
       timeout:5000,
       position:'br',
       fixed:true,
       width:"20vw",
       status:"error"
     });
     emailError = false;
    }
    else
    if (regex.test(emailVal)) {
      emailError = true;
      bookingData.email=emailVal;
    }
    else{
      SnackBar({
       message:"Неправильний email",
       timeout:5000,
       position:'br',
       fixed:true,
       width:"20vw",
       status:"error"
     });
      emailError = false;
    }


}

function validatePhone() {
    const regex = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;
    let phone = $("#Phone");
  let phoneVal=phone.val();
  if(phoneVal.length == ""){
    SnackBar({
     message:"Номер телефону не вказаний",
     timeout:5000,
     position:'br',
     fixed:true,
     width:"20vw",
     status:"error"
   });
    phoneError = false;
  }
  if(regex.test(phoneVal)){
    phoneError = true;
    bookingData.phone=phoneVal;
  } else  {
    SnackBar({
     message:"Неправильний номер телефону",
     timeout:5000,
     position:'br',
     fixed:true,
     width:"20vw",
     status:"error"
   });
    phoneError = false;
  }

}

function validateSize() {
  let sizeVal = $("#size").val();
  if(sizeVal >= 1&&sizeVal<=3){
  sizeError = true;
  bookingData.size=sizeVal;
  }
  else {
    SnackBar({
     message:"Розмір боксу не вибраний",
     timeout:5000,
     position:'br',
     fixed:true,
     width:"20vw",
     status:"error"
   });
   sizeError = false;

  }

}
function validatePeriod() {
  let periodVal = $("#Period").val();
  if(periodVal >= 1&&periodError<=12){
  periodError = true;
  bookingData.period=periodVal;
  }
  else {
    SnackBar({
     message:"Період бронювання не вибраний",
     timeout:5000,
     position:'br',
     fixed:true,
     width:"20vw",
     status:"error"
   });
   periodError = false;
  }
}
function validateCheck() {
  if($("#check").prop('checked') ){
  checkError = true;
  bookingData.check=true;
  }
  else {
    SnackBar({
     message:"Не надано згоду на обробку персональних данних",
     timeout:5000,
     position:'br',
     fixed:true,
     width:"20vw",
     status:"error"
   });
  checkError = false;
  }
}
function validateWishes() {
  let wishesVal = $("#wishes").val();

  if(wishesVal.length > 200 ){
    SnackBar({
     message:"Побажання завеликі",
     timeout:5000,
     position:'br',
     fixed:true,
     width:"20vw",
     status:"error"
   });
   wishesError = false;
  }
  else {
    wishesError = true;
    bookingData.wishes=wishesVal;
  }
}

function requestBooking(bookingData){
      console.log(bookingData);
  let request = $.ajax({
    url: "http://localhost:8080/api/newBooking",
    type: "POST",
    contentType:"application/json",
    dataType: "json",
    data: JSON.stringify(bookingData),
    success: function(response) {
        SnackBar({
            message:"Ваш запит прийнятий",
            timeout:5000,
            position:'br',
            fixed:true,
            width:"20vw",
            status:"Success"
        });
      },
      error: function(xhr, status, error) {
          console.log(xhr.responseText);
      }
  });


}
  $("#submitbtn").click(function () {
    validateUsername();
    validateUserSurname();
    validateEmail();
    validatePhone();
    validateSize();
    validatePeriod();
    validateCheck();
    validateWishes();
    console.log(usernameError+" "+phoneError+" "+emailError+" "+sizeError+" "+periodError+" "+checkError+" "+wishesError)
    if (
      usernameError &&
      userSurnameError &&
      phoneError  &&
      emailError &&
      sizeError &&
      periodError &&
      checkError &&
      wishesError
    ) {
      console.log("form correct");

    } else {
      console.log("form incorrect");
      return false;
    }

    requestBooking(bookingData);
    return true;
  });

});
