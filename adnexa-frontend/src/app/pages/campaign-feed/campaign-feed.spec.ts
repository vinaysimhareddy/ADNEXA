import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CampaignFeedComponent } from './campaign-feed';

describe('CampaignFeedComponent', () => {
  let component: CampaignFeedComponent;
  let fixture: ComponentFixture<CampaignFeedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CampaignFeedComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CampaignFeedComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
