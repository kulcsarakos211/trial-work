import { CanActivateFn } from '@angular/router';

export const loggedInGuard: CanActivateFn = (route, state) => {
  return localStorage.getItem('username') !== null;
};
