import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';
import { NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';


import { JcatRoutingModule } from './jcat-routing.module';
import { JcatComponent } from './jcat.component';

@NgModule({
  imports: [
    CommonModule,
    JcatRoutingModule,
    TranslateModule,
    NgbDropdownModule,
    FormsModule
  ],
  declarations: [JcatComponent]
})
export class JcatModule { }
