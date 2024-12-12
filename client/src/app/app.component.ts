import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  @HostListener("window:beforeunload", ["$event"])
  clearLocalStorage() {
    localStorage.clear();
  }
}
