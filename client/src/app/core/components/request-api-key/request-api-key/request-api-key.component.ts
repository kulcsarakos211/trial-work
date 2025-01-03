import { Component } from '@angular/core';
import { Apikey } from '../../../models/apikey/apikey';
import { NavbarService } from '../../../../shared/services/navbar-service/navbar.service';
import { Router } from '@angular/router';
import { ApikeyService } from '../../../services/apikey-service/apikey.service';

@Component({
  selector: 'app-request-api-key',
  standalone: false,
  
  templateUrl: './request-api-key.component.html',
  styleUrl: './request-api-key.component.css'
})
export class RequestApiKeyComponent {

  apikey: Apikey;

  constructor(private navbarService: NavbarService, private apikeyService: ApikeyService, private router: Router) {
    this.apikey = new Apikey();
  }

  ngOnInit() {
    this.navbarService.show();
  }

  async onSubmit() {
    await this.apikeyService.getApikey().forEach(key => this.apikey = key!);
  }
}
