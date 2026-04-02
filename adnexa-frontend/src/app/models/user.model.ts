export type Role = 'INFLUENCER' | 'ADVERTISER' | 'ADMIN';

export interface User {
  id: number;
  name: string;
  email: string;
  role: Role;
}