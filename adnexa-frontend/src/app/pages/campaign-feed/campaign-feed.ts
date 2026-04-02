import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CampaignService } from '../../services/campaign';
import { AuthService } from '../../services/auth';
import { Campaign } from '../../models/campaign.model';

@Component({
  selector: 'app-campaign-feed',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './campaign-feed.html',
  styleUrl: './campaign-feed.css'
})
export class CampaignFeedComponent implements OnInit {
  campaigns: Campaign[] = [];
  loading = true;
  error = '';

  // Apply modal state
  showModal = false;
  selectedCampaign: Campaign | null = null;
  applyMessage = '';
  applying = false;
  applySuccess = '';
  applyError = '';

  // Track which campaigns already applied to (Step 4 will add backend enforcement)
  appliedIds = new Set<number>();

  constructor(
    private campaignService: CampaignService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadCampaigns();
  }

  loadCampaigns(): void {
    this.loading = true;
    this.campaignService.getOpenCampaigns().subscribe({
      next: (data) => {
        this.campaigns = data;
        this.loading = false;
      },
      error: () => {
        this.error = 'Failed to load campaigns. Please try again.';
        this.loading = false;
      }
    });
  }

  openApplyModal(campaign: Campaign): void {
    this.selectedCampaign = campaign;
    this.applyMessage = '';
    this.applySuccess = '';
    this.applyError = '';
    this.showModal = true;
  }

  closeModal(): void {
    this.showModal = false;
    this.selectedCampaign = null;
  }

  submitApplication(): void {
    if (!this.selectedCampaign || !this.applyMessage.trim()) return;

    this.applying = true;
    this.applyError = '';

    this.campaignService.applyToCampaign(
      this.selectedCampaign.id,
      this.applyMessage
    ).subscribe({
      next: () => {
        this.appliedIds.add(this.selectedCampaign!.id);
        this.applySuccess = 'Application submitted successfully!';
        this.applying = false;
        setTimeout(() => this.closeModal(), 1500);
      },
      error: (err) => {
        this.applyError = err.error?.message || 'Failed to apply. Please try again.';
        this.applying = false;
      }
    });
  }

  hasApplied(campaignId: number): boolean {
    return this.appliedIds.has(campaignId);
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/']);
  }

  getPlatformIcon(platform: string): string {
    const icons: Record<string, string> = {
      INSTAGRAM: '📸',
      YOUTUBE: '▶',
      TWITTER: '𝕏',
      TIKTOK: '♪',
      LINKEDIN: 'in'
    };
    return icons[platform?.toUpperCase()] ?? '🌐';
  }
}