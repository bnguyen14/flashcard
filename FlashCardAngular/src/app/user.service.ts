import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { User } from './user';
import { Router } from '@angular/router';
import { Subject, BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  loggedIn : boolean = false;
  username : string;
  userchange : Subject<string> = new Subject<string>();
  constructor(private httpClient : HttpClient, private router : Router) { 
    this.userchange.subscribe((value => {
      this.username = value;
    }));
  }

  get getLoggedInStatus() : boolean {
    return this.loggedIn;
  }

  login(user:User) {
    if(user.username=='admin' && user.password=='password'){
      this.loggedIn = true;
      this.userchange.next(user.username);
      this.router.navigate(['/Home']);
    }
  }

  logout(){
    this.loggedIn = false;
    this.userchange.next('');
  }

  register(user:User){
    console.log(user.username);
    console.log(user.password);
  }
}
