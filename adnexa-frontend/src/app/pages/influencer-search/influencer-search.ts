import { Component, OnInit } from '@angular/core';
import { InfluencerService } from '../../services/influencer';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-influencer-search',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './influencer-search.html',
  styleUrls: ['./influencer-search.css']
})
export class InfluencerSearchComponent implements OnInit {

  influencers: any[] = [];

  filters = {
    category: '',
    minFollowers: '',
    maxPrice: '',
    location: ''
  };
  categories = ['Fitness', 'Fashion', 'Tech', 'Travel', 'Food'];
  sortOptions = [
    { label: 'Price: Low to High', value: 'asc' },
    { label: 'Price: High to Low', value: 'desc' }
  ];

  sortDirection = 'desc';

  page = 0;
  size = 5;
  totalPages = 0;

  constructor(private influencerService: InfluencerService) { }

  ngOnInit(): void {
    this.search();
  }

  search() {
    this.page = 0;
    const params = {
      ...this.filters,
      page: this.page,
      size: this.size,
      sortBy: 'pricePerPost',
      direction: this.sortDirection
    };

    this.influencerService.searchInfluencers(params)
      .subscribe((res: any) => {
        this.influencers = res.data;
        this.totalPages = res.totalPages;
      });
  }
  apply(campaignId: number) {

    const body = {
      campaignId: campaignId,
      message: "I am interested in this campaign"
    };

    this.influencerService.applyToCampaign(body)
      .subscribe({
        next: () => {
          alert('Applied successfully');
        },
        error: () => {
          alert('Failed to apply');
        }
      });
  }
  nextPage() {
    if (this.page < this.totalPages - 1) {
      this.page++;
      this.search();
    }
  }

  prevPage() {
    if (this.page > 0) {
      this.page--;
      this.search();
    }
  }
}