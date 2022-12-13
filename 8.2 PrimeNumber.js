function checkPrime(number) {

    if (number == 1){
        return number+" is neither Prime or Composite";
    }
    else{
    for (var i = 2; i < number; i++) {
      if (number % i === 0) {
        return number+" is not a Prime Number";
      }
    }
    return number+ " is Prime Number";
    }
  }

  console.log(checkPrime(11));
