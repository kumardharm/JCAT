import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserRoutingModule } from '../router/user-routing.module';
import { UserComponents } from '../component/user.component';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [UserComponents]
})
export class UserModule { }
