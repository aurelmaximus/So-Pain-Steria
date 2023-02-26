import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteclientComponent } from './compteclient.component';

describe('CompteclientComponent', () => {
  let component: CompteclientComponent;
  let fixture: ComponentFixture<CompteclientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompteclientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompteclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
