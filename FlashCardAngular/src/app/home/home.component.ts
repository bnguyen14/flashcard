import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  username : string;
  constructor(private UserService : UserService, private Router : Router) {
    if(UserService.user){
      this.username = this.UserService.user.userName;
    }else{
      // this.Router.navigate(['']);
    }
    
    
  }

  ngOnInit(): void {
  }

  study(){

  }

  manage(){
    
  }
}
