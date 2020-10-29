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
  user : User;
  // userchange : Subject<string> = new Subject<string>();
  constructor(private httpClient : HttpClient, private router : Router) { 
    // this.userchange.subscribe((value => {
    //   this.username = value;
    // }));
  }

  get getLoggedInStatus() : boolean {
    return this.loggedIn;
  }

  login(user:User) {
    // console.log("front end: " + user.userName + "," + user.passWord);
    return this.httpClient.post<User>('http://localhost:8088/user/login',user,{observe: 'response'});
    // this.httpClient.post('http://localhost:8088/user/login',user).subscribe(
    //   (data : number) => {
    //     console.log(data);
    //     if(data==1){
    //       this.loggedIn = true;
    //       this.userchange.next(user.userName);
    //       this.router.navigate(['/Home']);
    //     }
    //   }, error => {
    //     console.log(error)
    //   }
    // );
  }

  logout(){
    this.loggedIn = false;
    this.user = null;
    // this.userchange.next('');
  }

  register(user:User){
    console.log("front end: " + user.userName + "," + user.passWord);
    return this.httpClient.post<User>('http://localhost:8088/user/register',user,{observe: 'response'});
  }
}
