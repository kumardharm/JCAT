import { Injectable } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, BehaviorSubject} from 'rxjs';
import { LocalStorageService } from '../utility/service/localStorage.service';

@Injectable({
  providedIn: 'root'
})
export class CatloginService {

  constructor(private http: HttpClient,private myStorage:LocalStorageService) {
     
  }

  ngOnInit() {
  }

  getUserByUserNamePassword(username : string,password : string):Observable<any>{
      return this.http.get(this.myStorage.getdomainURL()+`/login/`+username+`/`+password);  
  }

  private  comptransfer  =  new  BehaviorSubject("login");
  question  =  this.comptransfer.asObservable();

  sendMsgtoOtherComponent(messsage) {
      this.comptransfer.next(messsage);
  }
}
