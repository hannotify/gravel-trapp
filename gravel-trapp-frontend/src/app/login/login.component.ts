import { Component } from '@angular/core';
import {MatDialog, MatDialogActions, MatDialogContent, MatDialogRef, MatDialogTitle} from '@angular/material/dialog';
import {FormsModule} from '@angular/forms';
import {MatFormField, MatLabel} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {MatButton} from '@angular/material/button';
import {LoginService, User} from '../services/login.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'login-dialog',
  templateUrl: 'login-dialog.html',
  imports: [
    MatDialogTitle,
    MatDialogContent,
    MatFormField,
    MatLabel,
    MatInput,
    FormsModule,
    MatDialogActions,
    MatButton
  ]
})
export class LoginDialog {
  user: User = {username: '', password: ''};

  constructor(
    public dialogRef: MatDialogRef<LoginDialog>,
    private loginService: LoginService,
    private snackBar: MatSnackBar) {
  }

  cancel() {
    this.dialogRef.close();
  }

  login() {
    console.log('Calling login endpoint with user name: ' + this.user.username + ' and password: ' + this.user.password);
    this.loginService.postLogin(this.user).subscribe({
      next: (jwt) => {
        localStorage.setItem('gravel-trapp-jwt', jwt);
        this.dialogRef.close();
      },
      error: (response) => {
        this.snackBar.open("Login failed.", "Close", {duration: 3000});
      }
    });
  }
}

@Component({
  selector: 'app-login',
  imports: [
    FormsModule,
  ],
  template: '',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(private dialog: MatDialog) {
    const dialogRef = this.dialog.open(LoginDialog, {
      data: {user: {username: '', password: ''}}
    });
  }
}
