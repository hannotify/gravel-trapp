import { Component } from '@angular/core';
import {MatDialog, MatDialogActions, MatDialogContent, MatDialogRef, MatDialogTitle} from '@angular/material/dialog';
import {FormsModule} from '@angular/forms';
import {MatFormField, MatLabel} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {MatButton} from '@angular/material/button';

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
  userName: string = '';
  password: string = '';

  constructor(public dialogRef: MatDialogRef<LoginDialog>) {
  }

  cancel() {
    this.dialogRef.close();
  }

  login() {
    console.log('Calling login endpoint with user name: ' + this.userName + ' and password: ' + this.password);
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
      data: {userName: '', password: ''}
    });
  }
}
