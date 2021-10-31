import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthLoginInfo } from './login-info';
import { Observable } from 'rxjs';
import { JWTResponse } from './jwt-response';
import { SignupInfo } from './signup-info';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = 'http://localhost:8081/api/auth/login';
  private signupUrl = 'http://localhost:8081/api/auth/signup';

  constructor(private http: HttpClient) { }

  attemptAuth(credentials: AuthLoginInfo): Observable<JWTResponse> {
    return this.http.post<JWTResponse>(this.loginUrl, credentials, httpOptions);
  }

  signUp(info: SignupInfo): Observable<string> {
    return this.http.post<string>(this.signupUrl, info, httpOptions);
  }
}
