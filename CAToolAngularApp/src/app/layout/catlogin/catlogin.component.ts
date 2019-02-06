import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { UsersService } from '../user/user.service';
import { Router } from '@angular/router';
import { ApplicationService } from '../application/application.service';
import { UserModel } from './Users';
import { CatloginService } from './catlogin.service';
import { LocalStorageService } from '../utility/service/localStorage.service';
@Component({
    selector: 'app-catlogin',
    templateUrl: './catlogin.component.html',
    styleUrls: ['./catlogin.component.scss'],
    animations: [routerTransition()]
})
export class CATloginComponent implements OnInit {
    message:String;
    users: UserModel = new UserModel();
    userId:string;
    client:any;
    
     constructor(private loginService :CatloginService,public router: Router,private myStorage:LocalStorageService) {}
 
     ngOnInit() {
         
 }
 
     onLoggedin(formValues) { 
         
          this.loginService.getUserByUserNamePassword(formValues.userName,formValues.password).subscribe((data)=>{
          this.users=data;
             if( this.users.username!=null)
             {
                 this.myStorage.setCurrentUserObject(this.users);
                 this.myStorage.setLoggedInTrue('true');
                 
                 if(this.users.isAdmin)
                 {
                     this.message="logged in successfully";
                     this.loginService.sendMsgtoOtherComponent(this.users);
                     this.router.navigate(['/dashboard']);
                 }
                 else{
                     this.loginService.sendMsgtoOtherComponent(this.users.userId);
                     this.loginService.sendMsgtoOtherComponent(this.users);
                     this.router.navigate(['/dashboard']);
                 }
             }
             else
             {
                 alert("Please enter correct username and Password");
             }
             
         }
         
         );
 }
 
 }