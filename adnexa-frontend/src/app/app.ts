import { Component } from '@angular/core';
import { InfluencerSearchComponent } from './pages/influencer-search/influencer-search';
import { CommonModule } from '@angular/common';
import {CampaignFeedComponent } from "./pages/campaign-feed/campaign-feed";
import { LoginComponent } from "./pages/login/login";
import { RouterOutlet } from "@angular/router";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  template: `<router-outlet></router-outlet>`
})
export class AppComponent {}