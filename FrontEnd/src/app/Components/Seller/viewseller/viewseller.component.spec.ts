import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewsellerComponent } from './viewseller.component';

describe('ViewsellerComponent', () => {
  let component: ViewsellerComponent;
  let fixture: ComponentFixture<ViewsellerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewsellerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewsellerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
