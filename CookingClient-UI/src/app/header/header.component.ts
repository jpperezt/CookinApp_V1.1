import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username = sessionStorage.getItem('username');
  usertype = sessionStorage.getItem('usertype');
  userid = sessionStorage.getItem('userid');
  title = 'Cooking Application';
  constructor(public loginService:AuthenticationService) { 
  	
  }

  ngOnInit() {  
    
  }

}
