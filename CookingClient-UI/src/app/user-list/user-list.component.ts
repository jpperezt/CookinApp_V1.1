import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) { 
  }

  ngOnInit(): void {
  	this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }

  deleteUser(user: User) {
    this.userService.deleteUser(user.userId).subscribe(
      () => console.log('User with ID = ${user.userId} deleted'),
      (err) => console.log(err)
    );    
  }

  editUser(user: User) {
    console.log('Calling Edit User ' + user.userId);      
  }


}
