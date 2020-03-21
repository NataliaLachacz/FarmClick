import { Counter } from './models/counter.model';

export interface AppState {
  readonly counter: Counter[];
}
