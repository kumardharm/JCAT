import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { JcatComponent } from './jcat.component';

const routes: Routes = [
  {
      path: '',
      component: JcatComponent,
      children: [
          { path: '', redirectTo: 'login', pathMatch: 'prefix' },
          { path: 'login', loadChildren: './module/login.module#LoginModule' },    
          { path: 'user', loadChildren: './module/user.module#UserModule' }
      ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class JcatRoutingModule { }
