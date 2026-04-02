import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfluencerSearchComponent } from './influencer-search';

describe('InfluencerSearchComponent', () => {
  let component: InfluencerSearchComponent;
  let fixture: ComponentFixture<InfluencerSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InfluencerSearchComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfluencerSearchComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
