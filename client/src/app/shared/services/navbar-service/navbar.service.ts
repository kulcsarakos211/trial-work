import { Injectable } from '@angular/core';

@Injectable()
export class NavbarService {
  private visible: boolean;

  constructor() {
    this.visible = false;
   }

   hide() {
    this.visible = false;
   }

   show() {
    this.visible = true;
   }

   isVisible(): boolean {
    return this.visible;
   }

   isAdmin(): boolean {
    return localStorage.getItem("admin") === "true";
   }
}
