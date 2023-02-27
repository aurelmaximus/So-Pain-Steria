import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeGpComponent } from './employe-gp.component';

describe('EmployeGpComponent', () => {
  let component: EmployeGpComponent;
  let fixture: ComponentFixture<EmployeGpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeGpComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployeGpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
