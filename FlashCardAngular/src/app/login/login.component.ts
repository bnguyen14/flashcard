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

  constructor(private UserService:UserService, private router:Router) { }

  ngOnInit() {
    this.username = new FormControl('');
    this.password = new FormControl('');
    this.loginForm = new FormGroup({
      username : this.username,
      password : this.password
    });
  }

  login() {
    var user = new User();
    user.username = this.loginForm.value.username;
    user.password = this.loginForm.value.password;
    this.UserService.login(user);
  }

  register() {

  }

}
