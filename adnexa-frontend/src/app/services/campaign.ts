import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Campaign } from '../models/campaign.model';

@Injectable({ providedIn: 'root' })
export class CampaignService {
  private baseUrl = 'http://localhost:8080/api/influencer';

  constructor(private http: HttpClient) {}

  getOpenCampaigns(): Observable<Campaign[]> {
    return this.http.get<Campaign[]>(`${this.baseUrl}/campaigns`);
  }

  // ✅ matches POST /api/influencer/apply with { campaignId, message }
  applyToCampaign(campaignId: number, message: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/apply`, { campaignId, message });
  }
}