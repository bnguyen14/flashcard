import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  hide = true;
  message : string;
  registerForm : FormGroup;
  email : FormControl;
  username : FormControl;
  password : FormControl;
  passConfirm : FormControl;
  constructor(private UserService:UserService, private router:Router) { }

  ngOnInit(): void {
    this.email = new FormControl('');
    this.username = new FormControl('');
    this.password = new FormControl('');
    this.passConfirm = new FormControl('');
    this.registerForm = new FormGroup({
      email : this.email,
      username : this.username,
      password : this.password,
      passConfirm : this.passConfirm
    });
  }

  register(){
    if(this.registerForm.value.password==this.registerForm.value.passConfirm){
      var user = new User();
      user.email = this.registerForm.value.email;
      user.userName = this.registerForm.value.username;
      user.passWord = this.registerForm.value.password;
      this.UserService.register(user).subscribe(
        (response) => {
          
        }
      )
    }else{

    }

  }

}
