import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class InfluencerService {

  private baseUrl = 'http://localhost:8080/api/advertiser/influencers';

  constructor(private http: HttpClient) { }

  applyToCampaign(data: any) {
    return this.http.post('http://localhost:8080/api/influencer/apply', data);
  }

  getCampaigns() {
    return this.http.get('http://localhost:8080/api/influencer/campaigns');
  }

  searchInfluencers(filters: any) {

    let params = new HttpParams();

    if (filters.category) {
      params = params.set('category', filters.category);
    }

    if (filters.minFollowers) {
      params = params.set('minFollowers', filters.minFollowers);
    }

    if (filters.maxPrice) {
      params = params.set('maxPrice', filters.maxPrice);
    }

    if (filters.location) {
      params = params.set('location', filters.location);
    }

    params = params.set('page', filters.page);
    params = params.set('size', filters.size);
    params = params.set('sortBy', filters.sortBy);
    params = params.set('direction', filters.direction);

    return this.http.get(`${this.baseUrl}/search`, { params });
  }

}