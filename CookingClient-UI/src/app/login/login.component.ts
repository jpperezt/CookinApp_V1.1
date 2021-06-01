import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;
  username = '';
  password = '';
  invalidLogin = false;

  constructor(private router: Router,
    private loginservice: AuthenticationService,
    private userService: UserService) { }

  ngOnInit() {
  }

  checkLogin() {    	
    if (this.loginservice.authenticate(this.username, this.password)
    ) {
      this.router.navigate([''])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  } 
   

  getUser(userName: string) {
    this.userService.getUser(userName).subscribe(
      () => console.log('User with Name = ${userName}'),
      (err) => console.log(err)
    );    
  }

}