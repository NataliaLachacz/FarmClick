import { Action } from '@ngrx/store';
import { Counter } from '../models/counter.model';
import * as CounterActions from '../actions/counter.actions';

const initialState: Counter = {
  clicked: 0
};

export function counterReducer(
  state: Counter[] = [initialState],
  action: CounterActions.Actions
) {
  switch (action.type) {
    case CounterActions.ADD_CLICK:
      return [...state, action.payload];
    default:
      return state;
  }
}
