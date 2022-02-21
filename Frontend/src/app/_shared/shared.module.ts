import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@NgModule({
    exports: [CommonModule, HttpClientModule, FormsModule, ReactiveFormsModule, FontAwesomeModule],
})
export class SharedModule {}
