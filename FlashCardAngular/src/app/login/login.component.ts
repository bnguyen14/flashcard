import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  hide = true;
  loginForm : FormGroup;
  username : FormControl;
  password : FormControl;
  message : string;
  constructor(private UserService:UserService, private router:Router) { }

  ngOnInit() {
    this.message = "Welcome to Flash Cards!"
    this.username = new FormControl('');
    this.password = new FormControl('');
    this.loginForm = new FormGroup({
      username : this.username,
      password : this.password
    });
  }

  login() { 
    var user = new User();
    user.userName = this.loginForm.value.username;
    user.passWord = this.loginForm.value.password;
    //console.log("at login method: " + user.userName + ", " + user.passWord);
    this.UserService.login(user).subscribe(
      (response) => {
        if(response.status==200){
          console.log(response);
          this.UserService.loggedIn = true;
          this.UserService.user = response.body;
          // this.UserService.userchange.next(user.userName);
          this.router.navigate(['/Home']);
        }else{
          this.message = "Incorrect Username/Password!";
        }
      }
    );
  }

  register() {

  }

}
