import { CanActivateFn } from '@angular/router';

export const firstLoginGuard: CanActivateFn = (route, state) => {
  return localStorage.getItem('firstLogin') === 'true';
};
