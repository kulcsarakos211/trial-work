import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestApiKeyComponent } from './request-api-key.component';

describe('RequestApiKeyComponent', () => {
  let component: RequestApiKeyComponent;
  let fixture: ComponentFixture<RequestApiKeyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RequestApiKeyComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RequestApiKeyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
