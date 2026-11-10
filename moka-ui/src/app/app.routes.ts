import { Routes } from '@angular/router';
import { HomePage } from './pages/home-page/home-page';
import { ProfilPage } from './pages/profil-page/profil-page';

export const routes: Routes = [
  { path: '', component: HomePage},
  { path: 'profil', component: ProfilPage },
  { path: '**', redirectTo: '' }
];
