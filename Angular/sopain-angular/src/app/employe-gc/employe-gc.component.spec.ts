import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeGcComponent } from './employe-gc.component';

describe('EmployeGcComponent', () => {
  let component: EmployeGcComponent;
  let fixture: ComponentFixture<EmployeGcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeGcComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployeGcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
