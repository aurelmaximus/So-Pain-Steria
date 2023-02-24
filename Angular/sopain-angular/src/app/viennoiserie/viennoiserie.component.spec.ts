import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViennoiserieComponent } from './viennoiserie.component';

describe('ViennoiserieComponent', () => {
  let component: ViennoiserieComponent;
  let fixture: ComponentFixture<ViennoiserieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViennoiserieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViennoiserieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
