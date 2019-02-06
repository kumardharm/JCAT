import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { LocalStorageService } from '../../utility/service/localStorage.service';
import { UserModel } from '../../catlogin/Users';


@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
    userName : string;
    clientName : string;
    user: UserModel = new UserModel();

    constructor(public router: Router, private myStorage:LocalStorageService,private translate:TranslateService) {}

    ngOnInit() {
        this.user=JSON.parse(localStorage.getItem('user'));   
        this.userName=this.user.username;
    }
    changeLang(language:string){
        this.translate.use(language);
        localStorage.setItem('language',language);
    }
    onLoggedout()
    {
        this.myStorage.clearCurrentUser();
        this.myStorage.clearLoggedIn();
    }
    
}
