import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowcaregiverComponent } from './showcaregiver.component';

describe('ShowcaregiverComponent', () => {
  let component: ShowcaregiverComponent;
  let fixture: ComponentFixture<ShowcaregiverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowcaregiverComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowcaregiverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
