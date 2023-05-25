import { Injectable } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Injectable()
export class LoginService {
    constructor(private readonly _formBuilder: FormBuilder) {}

    initLoginForm() {
        return this._formBuilder.nonNullable.group({
            email: '',
            password: '',
        });
    }
}
