import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NouscontacterComponent } from './nouscontacter.component';

describe('NouscontacterComponent', () => {
  let component: NouscontacterComponent;
  let fixture: ComponentFixture<NouscontacterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NouscontacterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NouscontacterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
