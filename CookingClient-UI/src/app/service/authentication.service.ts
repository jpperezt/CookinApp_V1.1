import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  authenticate(username, password) {
    if (username === "TEST1" && password === "123") {
      sessionStorage.setItem('username', username)
      sessionStorage.setItem('usertype', 'ADMIN')
      sessionStorage.setItem('userid', '1')
      console.log(sessionStorage.getItem('username'))
      return true;
    } 
     else if (username === "TEST2" && password === "123")
     {
      sessionStorage.setItem('username', username)
      sessionStorage.setItem('usertype', 'CHEF')
      sessionStorage.setItem('userid', '2')
      console.log(sessionStorage.getItem('username'))
      return true;
     }
     else if (username === "TEST3" && password === "123")
     {
      sessionStorage.setItem('username', username)
      sessionStorage.setItem('usertype', 'USER')
      sessionStorage.setItem('userid', '3')
      console.log(sessionStorage.getItem('username'))
      return true;
     }
     else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  getUserLoggedIn() {
    let user = sessionStorage.getItem('usertype')
    console.log(user)
    console.log(!(user === null))    
    return user
  }

  getChefLoggedIn() {
    let user = sessionStorage.getItem('userid')
    console.log(user)
    console.log(!(user === null))    
    return user
  }

  logOut() {
    sessionStorage.removeItem('username')
    sessionStorage.removeItem('usertype')
  }
}