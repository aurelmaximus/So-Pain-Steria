import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatisserieComponent } from './patisserie.component';

describe('PatisserieComponent', () => {
  let component: PatisserieComponent;
  let fixture: ComponentFixture<PatisserieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatisserieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatisserieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
