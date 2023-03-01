import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticlefavorisComponent } from './articlefavoris.component';

describe('ArticlefavorisComponent', () => {
  let component: ArticlefavorisComponent;
  let fixture: ComponentFixture<ArticlefavorisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArticlefavorisComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArticlefavorisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
