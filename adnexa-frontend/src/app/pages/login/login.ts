import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html'
})
export class LoginComponent {
  email = '';
  password = '';
  error = '';
  loading = false;

  constructor(private authService: AuthService, private router: Router) {}

  onLogin(): void {
    this.loading = true;
    this.error = '';

    this.authService.login({ email: this.email, password: this.password }).subscribe({
      next: (res) => {
        this.authService.saveToken(res.token);
        this.redirectByRole();
      },
      error: (err) => {
        this.error = err.error?.message || 'Invalid email or password.';
        this.loading = false;
      }
    });
  }

  goToRegister(): void {
    this.router.navigate(['/register']);
  }

  private redirectByRole(): void {
    const role = this.authService.getRole();
    if (role === 'INFLUENCER') this.router.navigate(['/campaigns']);
    else if (role === 'ADVERTISER') this.router.navigate(['/influencers']);
    else this.router.navigate(['/']);
  }
}