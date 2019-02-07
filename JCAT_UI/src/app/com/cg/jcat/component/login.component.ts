import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../../../router.animations';


@Component({
  selector: 'app-login',
  templateUrl: '../view/login.component.html',
  styleUrls: ['../view/login.component.scss'],
  animations: [routerTransition()]
})
export class JCATLoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    
  }

}
