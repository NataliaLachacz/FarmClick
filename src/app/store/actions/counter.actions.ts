import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';
import { Counter } from '../models/counter.model';

export const ADD_CLICK = '[COUNTER] Add';

export class AddClick implements Action {
  readonly type = ADD_CLICK;

  constructor(public payload: Counter) {}
}

export type Actions = AddClick;
