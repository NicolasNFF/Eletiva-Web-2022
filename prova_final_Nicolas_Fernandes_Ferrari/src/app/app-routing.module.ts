import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CarrosComponent } from './carros/carros.component';
import { CarroSComponent } from './carros-s/carros-s.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'detail/:id', component: CarroSComponent },
  { path: 'estudantes', component: CarrosComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}