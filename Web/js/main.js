$(document).ready(function () {

  let usernameError = true;
  let emailError = true;
  let phoneError = true;
  let sizeError = true;
  let periodError = true;
  let checkError = true;
  let wishesError = true;


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
      return;
    }
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
     return;
    }
    else
    if (regex.test(emailVal)) {
      emailError = true;
      return;
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
      return;
    }

  return;
}

function validatePhone() {
  var regex  = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;
  const phone = $("#Phone");
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
    return;
  }
  if(regex.test(phoneVal)){
    phoneError = true;
    return;
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
    return;
  }
  return
}

function validateSize() {
  let sizeVal = $("#size").val();
  if(sizeVal >= 1&&sizeVal<=3){
  sizeError = true;
  return;
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
   return;
  }
}
function validatePeriod() {
  let periodVal = $("#Period").val();
  if(periodVal >= 1&&periodError<=12){
  periodError = true;
  return;
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
   return;
  }
}
function validateCheck() {
  if($("#check").prop('checked') ){
  checkError = true;
  return;
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
   return;
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
   return;
  }
  else {
    wishesError = true;
    return;
  }
}


  // Submit button
  $("#submitbtn").click(function () {
    validateUsername();
    validateEmail();
    validatePhone();
    validateSize();
    validatePeriod();
    validateCheck();
    validateWishes();
    console.log(usernameError+" "+phoneError+" "+emailError+" "+sizeError+" "+periodError+" "+checkError+" "+wishesError)
    if (
      usernameError &&
      phoneError  &&
      emailError &&
      sizeError &&
      periodError &&
      checkError &&
      wishesError
    ) {
      console.log("form correct");
      return true;
    } else {
      console.log("form incorrect");
      return false;
    }
  });
});
