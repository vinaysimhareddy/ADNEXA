import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login';
import { RegisterComponent } from './pages/register/register';
import { CampaignFeedComponent } from './pages/campaign-feed/campaign-feed';
import { InfluencerSearchComponent } from './pages/influencer-search/influencer-search';


export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'influencers', component: InfluencerSearchComponent }
];
