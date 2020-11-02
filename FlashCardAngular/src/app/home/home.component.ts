import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  username : String;
  message : String;
  constructor(private UserService : UserService, private Router : Router) {
    if(UserService.user){
      
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
